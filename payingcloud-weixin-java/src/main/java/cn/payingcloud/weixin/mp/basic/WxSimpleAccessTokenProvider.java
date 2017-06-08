package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.mp.WxException;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

/**
 * 一种简单的WxAccessTokenProvider实现
 * 只在过期时请求，建议只在简单场景下使用
 *
 * @author YQ.Huang
 */
public class WxSimpleAccessTokenProvider implements WxAccessTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(WxSimpleAccessTokenProvider.class);
    private final WxBasicApi baseApi;
    private WxAccessToken current;
    private Instant expiredAt;
    private int offset;

    public WxSimpleAccessTokenProvider(WxBasicApi baseApi) {
        this(baseApi, 5);
    }

    public WxSimpleAccessTokenProvider(WxBasicApi baseApi, int offset) {
        Validate.notNull(baseApi);
        this.baseApi = baseApi;
        this.offset = offset;
    }

    @Override
    public synchronized String getAccessToken() throws WxException {
        if (isCurrentValid())
            return current.getAccessToken();
        return refreshAccessToken();
    }

    @Override
    public String getAppId() {
        return baseApi.getAppId();
    }

    private boolean isCurrentValid() {
        return current != null && expiredAt.isAfter(Instant.now());
    }

    private String refreshAccessToken() throws WxException {
        logger.debug("Refreshing accessToken");
        current = baseApi.getAccessToken();
        expiredAt = Instant.now().plusSeconds(current.getExpiresIn() - offset);
        logger.debug("AccessToken has been refreshed successfully");
        return current.getAccessToken();
    }
}

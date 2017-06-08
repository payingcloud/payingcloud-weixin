package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.mp.WxException;
import org.apache.commons.lang3.Validate;

/**
 * 基本WxAccessTokenProvider实现
 * 每次都重新请求，建议仅作测试用
 *
 * @author YQ.Huang
 */
public class WxBasicAccessTokenProvider implements WxAccessTokenProvider {

    private final WxBasicApi baseApi;

    public WxBasicAccessTokenProvider(WxBasicApi baseApi) {
        Validate.notNull(baseApi);
        this.baseApi = baseApi;
    }

    @Override
    public String getAccessToken() throws WxException {
        return baseApi.getAccessToken().getAccessToken();
    }

    @Override
    public String getAppId() {
        return baseApi.getAppId();
    }
}

package cn.payingcloud.weixin.mp.jssdk;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

/**
 * @author ZM.Wang
 */
public class WxJsApi extends WxApi {

    private final static Logger logger = LoggerFactory.getLogger(WxJsApi.class);
    private WxJsapiTicket wxJsapiTicket;
    private Instant expiredAt;
    private int offset;

    public WxJsApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        this(client, accessTokenProvider, 5);
    }

    public WxJsApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider, int offset) {
        super(client, accessTokenProvider);
        this.offset = offset;
    }

    public WxJsSign getSign(String url) throws WxException {
        String nonceStr = RandomStringUtils.randomAlphanumeric(16);
        String ticket = getJsapiTicket();
        long timestamp = System.currentTimeMillis();
        String preSignStr = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        String sign = DigestUtils.sha1Hex(preSignStr);
        return new WxJsSign(accessTokenProvider.getAppId(), timestamp, nonceStr, sign);
    }

    private String getJsapiTicket() throws WxException {
        if (isCurrentValid())
            return wxJsapiTicket.getTicket();
        refreshJsapiTicket();
        return wxJsapiTicket.getTicket();
    }

    private boolean isCurrentValid() {
        return wxJsapiTicket != null && expiredAt.isAfter(Instant.now());
    }

    private synchronized void refreshJsapiTicket() throws WxException {
        if (isCurrentValid()) return;
        logger.debug("Refreshing JsapiTicket");
        wxJsapiTicket = requestWxJsapiTicket();
        expiredAt = Instant.now().plusSeconds(wxJsapiTicket.getExpiresIn() - offset);
        logger.debug("JsapiTicket has been refreshed successfully");
    }

    private WxJsapiTicket requestWxJsapiTicket() throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/ticket/getticket")
                .setArg("access_token", accessTokenProvider.getAccessToken())
                .setArg("type", "jsapi");
        WxHttpResponse response = client.execute(request);
        return response.parse(WxJsapiTicket.class);
    }

}

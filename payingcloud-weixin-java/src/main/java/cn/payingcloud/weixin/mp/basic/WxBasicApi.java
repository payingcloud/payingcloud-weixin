package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;
import cn.payingcloud.weixin.mp.support.WxUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author YQ.Huang
 */
public class WxBasicApi {
    private final String appId;
    private final String appSecret;
    private final WxHttpClient client;

    public WxBasicApi(String appId, String appSecret, WxHttpClient client) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.client = client;
    }

    public String getBaseAuthorizeUrl(String redirectUrl, String state) throws UnsupportedEncodingException {
        return WxUtils.getAuthorizeUrl(appId, redirectUrl, "snsapi_base", state);
    }

    public String getUserAuthorizeUrl(String redirectUrl, String state) throws UnsupportedEncodingException {
        return WxUtils.getAuthorizeUrl(appId, redirectUrl, "snsapi_userinfo", state);
    }

    public String getLoginAuthorizeUrl(String redirectUrl, String state) throws UnsupportedEncodingException {
        return WxUtils.getAuthorizeUrl(appId, redirectUrl, "snsapi_login", state);
    }

    public WxAccessToken getAccessToken() throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/token")
                .setArg("grant_type", "client_credential")
                .setArg("appid", appId)
                .setArg("secret", appSecret);
        WxHttpResponse response = client.execute(request);
        return response.parse(WxAccessToken.class);
    }

    public WxOauth2AccessToken getOauth2AccessToken(String code) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/sns/oauth2/access_token")
                .setArg("appid", appId)
                .setArg("secret", appSecret)
                .setArg("code", code)
                .setArg("grant_type", "authorization_code");
        WxHttpResponse response = client.execute(request);
        return response.parse(WxOauth2AccessToken.class);
    }

    public WxAuthUserInfo getUserInfo(String openId, String oauth2AccessToken) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/sns/userinfo")
                .setArg("access_token", oauth2AccessToken)
                .setArg("openid", openId)
                .setArg("lang", "zh_CN");
        WxHttpResponse response = client.execute(request);
        return response.parse(WxAuthUserInfo.class);
    }

    public WxIpList getIpList(String accessToken) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/getcallbackip")
                .setArg("access_token", accessToken);
        WxHttpResponse response = client.execute(request);
        return response.parse(WxIpList.class);
    }

    public String getAppId() {
        return appId;
    }
}

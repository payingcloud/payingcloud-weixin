package cn.payingcloud.weixin.mp.user;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;

/**
 * @author YQ.Huang
 */
public class WxUserApi extends WxApi {

    public WxUserApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        super(client, accessTokenProvider);
    }

    public WxUserInfo getUserInfo(String openId, LANG lang) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/user/info")
                .setArg("access_token", getAccessToken())
                .setArg("openid", openId)
                .setArg("lang", lang);
        WxHttpResponse response = client.execute(request);
        return response.parse(WxUserInfo.class);
    }

    public enum LANG {
        zh_CN,
        zh_TW,
        en,
    }
}

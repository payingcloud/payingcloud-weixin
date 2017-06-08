package cn.payingcloud.weixin.mp.menu;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxClientException;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;
import cn.payingcloud.weixin.mp.support.WxResponse;

/**
 * @author YQ.Huang
 */
public class WxMenuApi extends WxApi {

    public WxMenuApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        super(client, accessTokenProvider);
    }

    public void createMenu(WxMenu menu) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + getAccessToken())
                .withMethod("POST")
                .withArg("button", menu.getButtons());
        WxHttpResponse response = client.execute(request);
        response.parse(WxResponse.class);
    }

    public void deleteMenu() throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/menu/delete")
                .withMethod("GET")
                .setArg("access_token", getAccessToken());
        WxHttpResponse response = client.execute(request);
        response.parse(WxResponse.class);
    }

}

package cn.payingcloud.weixin.mp.message.send;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;

/**
 * @author YQ.Huang
 */
public class WxMessageApi extends WxApi {

    public WxMessageApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        super(client, accessTokenProvider);
    }

    public WxSendMessageResponse sendTemplateMessage(WxTemplateMsg message) throws WxException {
        WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + getAccessToken())
                .setArg("touser", message.getOpenId())
                .setArg("template_id", message.getTemplateId())
                .setArg("url", message.getUrl())
                .setArg("data", message.getData());
        request.withMethod("post");
        WxHttpResponse response = client.execute(request);
        return response.parse(WxSendMessageResponse.class);
    }

}

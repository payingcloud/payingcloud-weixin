package cn.payingcloud.weixin.mp.account;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxClientException;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;

import static java.util.Collections.singletonMap;

/**
 * @author YQ.Huang
 */
public class WxAccountApi extends WxApi {

    public WxAccountApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        super(client, accessTokenProvider);
    }

    /**
     * 生成临时二维码
     *
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，取值范围[1, 4294967295]
     */
    public WxQrcode createTemporaryQrcode(int expireSeconds, int sceneId) throws WxException {
        WxHttpRequest request = request()
                .withArg("expire_seconds", expireSeconds)
                .withArg("action_name", "QR_SCENE")
                .withArg("action_info", singletonMap("scene", singletonMap("scene_id", sceneId)));
        WxHttpResponse response = client.execute(request);
        return response.parse(WxQrcode.class);
    }

    /**
     * 生成临时二维码，有效期为30秒
     *
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，取值范围[1, 4294967295]
     */
    public WxQrcode createTemporaryQrcode(int sceneId) throws WxException {
        WxHttpRequest request = request()
                .withArg("action_name", "QR_SCENE")
                .withArg("action_info", singletonMap("scene", singletonMap("scene_id", sceneId)));
        WxHttpResponse response = client.execute(request);
        return response.parse(WxQrcode.class);
    }

    /**
     * 生成永久二维码
     *
     * @param sceneId 场景值ID，取值范围[1, 100000]
     */
    public WxQrcode createPermanentQrcode(int sceneId) throws WxException {
        WxHttpRequest request = request()
                .withArg("action_name", "QR_LIMIT_SCENE")
                .withArg("action_info", singletonMap("scene", singletonMap("scene_id", sceneId)));
        WxHttpResponse response = client.execute(request);
        return response.parse(WxQrcode.class);
    }

    /**
     * 生成永久二维码
     *
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     */
    public WxQrcode createPermanentQrcode(String sceneStr) throws WxException {
        WxHttpRequest request = request()
                .withArg("action_name", "QR_LIMIT_STR_SCENE")
                .withArg("action_info", singletonMap("scene", singletonMap("scene_str", sceneStr)));
        WxHttpResponse response = client.execute(request);
        return response.parse(WxQrcode.class);
    }

    private WxHttpRequest request() throws WxException {
        return new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + getAccessToken())
                .withMethod("POST");
    }
}

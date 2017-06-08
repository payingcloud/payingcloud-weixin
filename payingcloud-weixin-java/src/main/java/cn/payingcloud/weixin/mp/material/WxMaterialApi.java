package cn.payingcloud.weixin.mp.material;

import cn.payingcloud.weixin.mp.WxApi;
import cn.payingcloud.weixin.mp.WxClientException;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import cn.payingcloud.weixin.mp.support.WxHttpRequest;
import cn.payingcloud.weixin.mp.support.WxHttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author ZM.Wang
 */
public class WxMaterialApi extends WxApi {

    public WxMaterialApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        super(client, accessTokenProvider);
    }

    public WxImageMaterial getImageMaterial(String materialId) throws WxException {
        try {
            WxHttpRequest request = new WxHttpRequest("https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + getAccessToken())
                    .setArg("media_id", materialId);
            request.withMethod("get");
            WxHttpResponse response = client.execute(request);
            int statusCode = response.getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                return new WxImageMaterial(response.getBody(), response.getContentType());
            } else {
                String errorJson = WxHttpClient.MAPPER.writeValueAsString(response.getBody());
                throw new WxClientException(errorJson);
            }
        } catch (JsonProcessingException e) {
            throw new WxClientException("流转json错误");
        }
    }
}

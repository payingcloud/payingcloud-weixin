package cn.payingcloud.weixin.mp.support;

import cn.payingcloud.weixin.mp.WxClientException;
import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.WxServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author YQ.Huang
 */
public class WxHttpResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxHttpResponse.class);

    private int statusCode;
    private String reasonPhrase;
    private String contentType;
    private InputStream body;

    public WxHttpResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public <T extends WxResponse> T parse(Class<T> tClass) throws WxException {
        try {
            if (statusCode >= 200 && statusCode < 300) {
                T result = WxHttpClient.MAPPER.readValue(body, tClass);
                if (!result.successful()) {
                    LOGGER.error("微信错误码：" + result.getErrCode() + ",错误内容：" + result.getErrMsg());
                    throw new WxServerException(result.getErrMsg());
                }
                return result;
            } else {
                throw new WxServerException("Failed to parse body, invalid status code");
            }
        } catch (IOException e) {
            throw new WxClientException(e.getLocalizedMessage(), e);
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public InputStream getBody() {
        return body;
    }

    public void setBody(InputStream body) {
        this.body = body;
    }

}

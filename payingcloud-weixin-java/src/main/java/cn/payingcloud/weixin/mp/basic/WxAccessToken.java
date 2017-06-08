package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.mp.support.WxResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YQ.Huang
 */
public class WxAccessToken extends WxResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn; // 单位：秒

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "WeixinAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                "} " + super.toString();
    }
}

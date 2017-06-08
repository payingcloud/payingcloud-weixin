package cn.payingcloud.weixin.mp.jssdk;

import cn.payingcloud.weixin.mp.support.WxResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ZM.Wang
 */
public class WxJsapiTicket extends WxResponse {

    private String ticket;

    @JsonProperty("expires_in")
    private int expiresIn;

    public String getTicket() {
        return ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}

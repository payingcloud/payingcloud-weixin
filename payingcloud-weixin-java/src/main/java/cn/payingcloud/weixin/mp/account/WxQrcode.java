package cn.payingcloud.weixin.mp.account;

import cn.payingcloud.weixin.mp.support.WxResponse;
import cn.payingcloud.weixin.mp.support.WxUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YQ.Huang
 */
public class WxQrcode extends WxResponse {

    private String ticket;

    @JsonProperty("expire_seconds")
    private int expireSeconds;

    private String url;

    public String getImgUrl() {
        return WxUtils.getQrcodeImgUrl(ticket);
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "WxQrcode{" +
                "ticket='" + ticket + '\'' +
                ", expireSeconds=" + expireSeconds +
                ", url='" + url + '\'' +
                '}';
    }
}

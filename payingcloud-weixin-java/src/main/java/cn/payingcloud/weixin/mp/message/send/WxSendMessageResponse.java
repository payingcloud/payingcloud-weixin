package cn.payingcloud.weixin.mp.message.send;

import cn.payingcloud.weixin.mp.support.WxResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ZM.Wang
 */
public class WxSendMessageResponse extends WxResponse {

    @JsonProperty("msgid")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }
}

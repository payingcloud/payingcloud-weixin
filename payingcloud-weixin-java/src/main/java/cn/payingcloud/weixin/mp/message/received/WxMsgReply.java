package cn.payingcloud.weixin.mp.message.received;

import org.apache.commons.lang3.Validate;

import java.time.Instant;

/**
 * @author YQ.Huang
 */
public abstract class WxMsgReply implements WxReply {

    public final String toUserName;
    public final String fromUserName;
    public final String createTime;
    public final String msgType;

    public WxMsgReply(WxMsg msg, String msgType) {
        Validate.notNull(msg);
        Validate.notBlank(msgType);
        this.toUserName = msg.fromUserName;
        this.fromUserName = msg.toUserName;
        this.createTime = Instant.now().getEpochSecond() + "";
        this.msgType = msgType;
    }

}

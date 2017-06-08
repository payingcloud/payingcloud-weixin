package cn.payingcloud.weixin.mp.message.received.msg;

import cn.payingcloud.weixin.mp.message.received.WxMsg;

/**
 * 普通消息
 *
 * @author YQ.Huang
 */
public abstract class WxUserMsg extends WxMsg {

    public final String msgId;

    public WxUserMsg(String toUserName, String fromUserName, String createTime, String msgType, String msgId) {
        super(toUserName, fromUserName, createTime, msgType);
        this.msgId = msgId;
    }
}

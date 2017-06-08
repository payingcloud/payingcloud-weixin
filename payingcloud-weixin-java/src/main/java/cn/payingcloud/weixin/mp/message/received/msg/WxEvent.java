package cn.payingcloud.weixin.mp.message.received.msg;

import cn.payingcloud.weixin.mp.message.received.WxMsg;

/**
 * @author YQ.Huang
 * @author ZM.Wang
 */
public abstract class WxEvent extends WxMsg {

    public final String event;

    public WxEvent(String toUserName, String fromUserName, String createTime, String event) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.EVENT);
        this.event = event;
    }

}

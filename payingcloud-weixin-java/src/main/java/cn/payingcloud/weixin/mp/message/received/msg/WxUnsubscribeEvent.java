package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author ZM.Wang
 */
public class WxUnsubscribeEvent extends WxEvent {

    public WxUnsubscribeEvent(String toUserName, String fromUserName, String createTime) {
        super(toUserName, fromUserName, createTime, WxEventTypes.UNSUBSCRIBE);
    }
}

package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author YQ.Huang
 * @author ZM.Wang
 */
public class WxSubscribeEvent extends WxEvent {

    public WxSubscribeEvent(String toUserName, String fromUserName, String createTime) {
        super(toUserName, fromUserName, createTime, WxEventTypes.SUBSCRIBE);
    }

}

package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author YQ.Huang
 */
public class WxViewMenuEvent extends WxEvent {

    public final String eventKey;

    public WxViewMenuEvent(String toUserName, String fromUserName, String createTime, String eventKey) {
        super(toUserName, fromUserName, createTime, WxEventTypes.VIEW);
        this.eventKey = eventKey;
    }
}

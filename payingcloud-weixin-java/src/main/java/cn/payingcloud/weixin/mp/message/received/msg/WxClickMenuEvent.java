package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author YQ.Huang
 */
public class WxClickMenuEvent extends WxEvent {

    public final String eventKey;

    public WxClickMenuEvent(String toUserName, String fromUserName, String createTime, String eventKey) {
        super(toUserName, fromUserName, createTime, WxEventTypes.CLICK);
        this.eventKey = eventKey;
    }
}

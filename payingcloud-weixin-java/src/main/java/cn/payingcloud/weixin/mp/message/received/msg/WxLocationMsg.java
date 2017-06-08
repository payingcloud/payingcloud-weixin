package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 位置消息
 *
 * @author YQ.Huang
 */
public class WxLocationMsg extends WxUserMsg {
    public final String locationX;
    public final String locationY;
    public final String scale;
    public final String label;

    public WxLocationMsg(String toUserName, String fromUserName, String createTime, String msgId, String locationX, String locationY, String scale, String label) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.LOCATION, msgId);
        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
    }

}

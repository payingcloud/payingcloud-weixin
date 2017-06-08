package cn.payingcloud.weixin.mp.message.received;

/**
 * @author YQ.Huang
 * @author ZM.Wang
 */
public abstract class WxMsg {

    public final String toUserName;
    public final String fromUserName;
    public final String createTime;
    public final String msgType;

    public WxMsg(String toUserName, String fromUserName, String createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }
}

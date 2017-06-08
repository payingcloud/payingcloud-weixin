package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 文本消息
 *
 * @author YQ.Huang
 * @author ZM.Wang
 */
public class WxTextMsg extends WxUserMsg {

    public final String content;

    public WxTextMsg(String toUserName, String fromUserName, String createTime, String msgId, String content) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.TEXT, msgId);
        this.content = content;
    }
}

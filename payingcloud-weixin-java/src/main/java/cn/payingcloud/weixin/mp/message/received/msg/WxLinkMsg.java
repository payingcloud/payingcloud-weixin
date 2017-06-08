package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 链接消息
 *
 * @author YQ.Huang
 */
public class WxLinkMsg extends WxUserMsg {

    public final String title;         // 消息标题
    public final String description;   // 消息描述
    public final String url;           // 消息链接

    public WxLinkMsg(String toUserName, String fromUserName, String createTime, String msgId, String title, String description, String url) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.LINK, msgId);
        this.title = title;
        this.description = description;
        this.url = url;
    }

}

package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 视频消息
 *
 * @author YQ.Huang
 */
public class WxVideoMsg extends WxUserMsg {
    public final String mediaId;
    public final String thumbMediaId;

    public WxVideoMsg(String toUserName, String fromUserName, String createTime, String msgId, String mediaId, String thumbMediaId) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.VIDEO, msgId);
        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
    }
}

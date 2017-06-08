package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 小视频消息
 *
 * @author YQ.Huang
 */
public class WxShortVideoMsg extends WxUserMsg {

    public final String mediaId;
    public final String thumbMediaId;

    public WxShortVideoMsg(String toUserName, String fromUserName, String createTime, String msgId, String mediaId, String thumbMediaId) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.SHORT_VIDEO, msgId);
        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
    }

}

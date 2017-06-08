package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 图片消息
 *
 * @author YQ.Huang
 */
public class WxImageMsg extends WxUserMsg {
    public final String picUrl;
    public final String mediaId;

    public WxImageMsg(String toUserName, String fromUserName, String createTime, String msgId, String picUrl, String mediaId) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.IMAGE, msgId);
        this.picUrl = picUrl;
        this.mediaId = mediaId;
    }

}

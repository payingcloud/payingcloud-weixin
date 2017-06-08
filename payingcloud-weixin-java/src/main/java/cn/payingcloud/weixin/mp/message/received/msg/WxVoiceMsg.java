package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * 语音消息
 *
 * @author YQ.Huang
 */
public class WxVoiceMsg extends WxUserMsg {

    public final String mediaId;
    public final String format;
    private String recognition;

    public WxVoiceMsg(String toUserName, String fromUserName, String createTime, String msgId, String mediaId, String format) {
        super(toUserName, fromUserName, createTime, WxMsgTypes.VOICE, msgId);
        this.mediaId = mediaId;
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}

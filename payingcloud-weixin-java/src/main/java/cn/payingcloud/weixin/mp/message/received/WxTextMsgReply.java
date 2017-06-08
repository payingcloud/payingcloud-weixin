package cn.payingcloud.weixin.mp.message.received;

import org.apache.commons.lang3.Validate;

/**
 * @author YQ.Huang
 */
public class WxTextMsgReply extends WxMsgReply {

    public final String text;

    public WxTextMsgReply(WxMsg msg, String text) {
        super(msg, "text");
        Validate.notBlank(text);
        this.text = text;
    }

    @Override
    public String getContent() {
        return "<xml>\n" +
                "<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>\n" +
                "<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>\n" +
                "<CreateTime>" + createTime + "</CreateTime>\n" +
                "<MsgType><![CDATA[" + msgType + "]]></MsgType>\n" +
                "<Content><![CDATA[" + text + "]]></Content>\n" +
                "</xml>";
    }
}

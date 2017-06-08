package cn.payingcloud.weixin.mp.message.received;

/**
 * @author YQ.Huang
 */
public interface WxReply {

    WxPlainTextReply plainTextReply = new WxPlainTextReply("");

    String getContent();

    static WxPlainTextReply plain(String content) {
        return plainTextReply.setContent(content);
    }

    static WxPlainTextReply success() {
        return plain("success");
    }

    static WxPlainTextReply empty() {
        return plain("");
    }
}

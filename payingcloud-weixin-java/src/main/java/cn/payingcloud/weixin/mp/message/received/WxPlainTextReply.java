package cn.payingcloud.weixin.mp.message.received;

import org.apache.commons.lang3.Validate;

/**
 * @author YQ.Huang
 */
public class WxPlainTextReply implements WxReply {

    private String content;

    public WxPlainTextReply(String content) {
        setContent(content);
    }

    public WxPlainTextReply setContent(String content) {
        Validate.notNull(content);
        this.content = content;
        return this;
    }

    @Override
    public String getContent() {
        return content;
    }
}

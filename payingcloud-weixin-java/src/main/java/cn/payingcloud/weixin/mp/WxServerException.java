package cn.payingcloud.weixin.mp;

/**
 * @author YQ.Huang
 */
public class WxServerException extends WxException {

    public WxServerException(String message) {
        super(message);
    }

    public WxServerException(String message, Throwable cause) {
        super(message, cause);
    }
}

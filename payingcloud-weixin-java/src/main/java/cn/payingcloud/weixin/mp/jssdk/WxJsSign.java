package cn.payingcloud.weixin.mp.jssdk;

/**
 * @author ZM.Wang
 */
public class WxJsSign {

    private final String appId;
    private final long timestamp;
    private final String nonceStr;
    private final String signature;

    public WxJsSign(String appId, long timestamp, String nonceStr, String signature) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.signature = signature;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSignature() {
        return signature;
    }
}

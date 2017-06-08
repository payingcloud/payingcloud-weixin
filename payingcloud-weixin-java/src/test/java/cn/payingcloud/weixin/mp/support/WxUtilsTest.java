package cn.payingcloud.weixin.mp.support;

import cn.payingcloud.weixin.mp.WxClientException;
import org.junit.Test;

/**
 * @author YQ.Huang
 */
public class WxUtilsTest {
    @Test
    public void validateToken() throws Exception {
        String signature = "9ce5cb51b30e609dac45e27156d656824649779c";
        String timestamp = "1487150143";
        String nonce = "450086131";
        String token = "payingcloud";
        WxUtils.validateToken(token, signature, timestamp, nonce);
    }

    @Test(expected = WxClientException.class)
    public void validateToken_invalidSignature() throws Exception {
        String signature = "invalidSignature";
        String timestamp = "1487150143";
        String nonce = "450086131";
        String token = "payingcloud";
        WxUtils.validateToken(token, signature, timestamp, nonce);
    }

    @Test(expected = WxClientException.class)
    public void validateToken_invalidToken() throws Exception {
        String signature = "9ce5cb51b30e609dac45e27156d656824649779c";
        String timestamp = "1487150143";
        String nonce = "450086131";
        String token = "invalidToken";
        WxUtils.validateToken(token, signature, timestamp, nonce);
    }
}
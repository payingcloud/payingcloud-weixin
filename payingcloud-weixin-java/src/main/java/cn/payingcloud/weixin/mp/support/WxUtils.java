package cn.payingcloud.weixin.mp.support;

import cn.payingcloud.weixin.mp.WxClientException;
import cn.payingcloud.weixin.mp.WxException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YQ.Huang
 */
public abstract class WxUtils {

    public static String getAuthorizeUrl(String appId, String redirectUrl, String scope, String state) throws UnsupportedEncodingException {
        return "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + appId + "&" +
                "redirect_uri=" + URLEncoder.encode(redirectUrl, "UTF-8") + "&" +
                "response_type=code" + "&" +
                "scope=" + scope + "&" +
                "state=" + URLEncoder.encode(state, "UTF-8") +
                "#wechat_redirect";
    }

    public static String getQrcodeImgUrl(String ticket) {
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
    }

    public static void validateToken(String token, String signature, String timestamp, String nonce) throws WxClientException {
        List<String> params = new ArrayList<>();
        params.add(timestamp);
        params.add(nonce);
        params.add(token);
        Collections.sort(params);
        String preSignStr = StringUtils.join(params.toArray());
        String sign = DigestUtils.sha1Hex(preSignStr);
        if (!StringUtils.equals(sign, signature)) {
            throw new WxClientException("Invalid token or signature");
        }
    }
}

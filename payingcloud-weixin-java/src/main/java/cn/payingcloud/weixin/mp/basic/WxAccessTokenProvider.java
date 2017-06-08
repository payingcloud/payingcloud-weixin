package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.mp.WxException;

/**
 * @author YQ.Huang
 */
public interface WxAccessTokenProvider {
    String getAccessToken() throws WxException;
    String getAppId();
}

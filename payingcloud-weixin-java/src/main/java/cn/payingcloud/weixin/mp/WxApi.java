package cn.payingcloud.weixin.mp;

import cn.payingcloud.weixin.mp.basic.WxAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;
import org.apache.commons.lang3.Validate;

/**
 * @author YQ.Huang
 */
public abstract class WxApi {

    protected final WxHttpClient client;
    protected final WxAccessTokenProvider accessTokenProvider;

    public WxApi(WxHttpClient client, WxAccessTokenProvider accessTokenProvider) {
        Validate.notNull(client);
        Validate.notNull(accessTokenProvider);
        this.client = client;
        this.accessTokenProvider = accessTokenProvider;
    }

    public String getAccessToken() throws WxException {
        return accessTokenProvider.getAccessToken();
    }
}

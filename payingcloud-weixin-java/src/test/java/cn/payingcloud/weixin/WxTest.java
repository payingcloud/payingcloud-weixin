package cn.payingcloud.weixin;

import cn.payingcloud.weixin.mp.basic.WxBasicApi;
import cn.payingcloud.weixin.mp.basic.WxSimpleAccessTokenProvider;
import cn.payingcloud.weixin.mp.support.WxHttpClient;

/**
 * @author YQ.Huang
 */
public abstract class WxTest {
    // 微信公众测试号参数
    public static final String APP_ID = "wx68f52196f9fc202a";
    public static final String APP_SECRET = "dc2661b0bd9317f260052d3512647df7";
    public static final WxHttpClient CLIENT = new WxHttpClient();
    public static final WxBasicApi BASIC_API = new WxBasicApi(APP_ID, APP_SECRET, CLIENT);
    public static final WxSimpleAccessTokenProvider ACCESS_TOKEN_PROVIDER = new WxSimpleAccessTokenProvider(BASIC_API);
}

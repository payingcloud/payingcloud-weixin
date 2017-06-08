package cn.payingcloud.weixin.mp.user;

import cn.payingcloud.weixin.WxTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
public class WxUserApiTest extends WxTest {

    private WxUserApi userApi = new WxUserApi(CLIENT, ACCESS_TOKEN_PROVIDER);

    @Test
    public void getUserInfo() throws Exception {
        WxUserInfo userInfo = userApi.getUserInfo("oAJvIs1bLRuycEKgefxnNwPe8q80", WxUserApi.LANG.zh_CN);
        assertEquals("oAJvIs1bLRuycEKgefxnNwPe8q80", userInfo.getOpenId());
        System.out.println(userInfo);
    }

}
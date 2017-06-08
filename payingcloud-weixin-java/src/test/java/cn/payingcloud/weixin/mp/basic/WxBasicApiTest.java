package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.WxTest;
import cn.payingcloud.weixin.mp.WxException;
import org.junit.Test;

/**
 * @author YQ.Huang
 */
public class WxBasicApiTest extends WxTest {

    @Test
    public void getIpList() throws Exception {
        System.out.println(BASIC_API.getIpList(ACCESS_TOKEN_PROVIDER.getAccessToken()));
    }

    @Test
    public void getAccessToken() throws Exception {
        WxAccessToken token = BASIC_API.getAccessToken();
        System.out.println(token.getAccessToken());
    }

    @Test(expected = WxException.class)
    public void getOauth2AccessToken_missingCode() throws Exception {
        BASIC_API.getOauth2AccessToken("");
    }

}
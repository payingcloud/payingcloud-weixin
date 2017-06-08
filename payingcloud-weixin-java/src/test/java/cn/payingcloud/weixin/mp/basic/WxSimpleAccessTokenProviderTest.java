package cn.payingcloud.weixin.mp.basic;

import cn.payingcloud.weixin.WxTest;
import cn.payingcloud.weixin.mp.WxException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.fail;

/**
 * @author YQ.Huang
 */
public class WxSimpleAccessTokenProviderTest extends WxTest {

    private WxSimpleAccessTokenProvider provider = new WxSimpleAccessTokenProvider(BASIC_API, 7195);

    @Test
    public void getAccessToken() throws Exception {
        Set<String> tokens = new HashSet<>();
        for (int i = 0; i < 11; i++) {
            String accessToken = provider.getAccessToken();
            Assert.assertNotNull(accessToken);
            System.out.println(accessToken);
            tokens.add(accessToken);
            Thread.sleep(1000);
        }
        Assert.assertEquals(3, tokens.size());
    }

    @Test
    public void getAccessToken_multithread() throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(provider.getAccessToken());
                } catch (WxException e) {
                    fail();
                }
            });
            thread.start();
        }
        Thread.sleep(5000);
    }

}
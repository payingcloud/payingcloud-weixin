package cn.payingcloud.weixin.mp.account;

import cn.payingcloud.weixin.WxTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author YQ.Huang
 */
public class WxAccountApiTest extends WxTest {

    private WxAccountApi accountApi = new WxAccountApi(CLIENT, ACCESS_TOKEN_PROVIDER);

    @Test
    public void createTemporaryQrcode() throws Exception {
        WxQrcode qrcode = accountApi.createTemporaryQrcode(60, 1);
        System.out.println(qrcode);
    }

    @Test
    public void createTemporaryQrcode_sameSceneId() throws Exception {
        WxQrcode qrcode1 = accountApi.createTemporaryQrcode(60, 1);
        WxQrcode qrcode2 = accountApi.createTemporaryQrcode(60, 1);
        System.out.println(qrcode1);
        System.out.println(qrcode2);
        Assert.assertNotEquals(qrcode1.getTicket(), qrcode2.getTicket());
    }

    @Test
    public void createPermanentQrcode_int() throws Exception {
        WxQrcode qrcode = accountApi.createPermanentQrcode(1);
        System.out.println(qrcode);
    }

    @Test
    public void createPermanentQrcode_str() throws Exception {
        WxQrcode qrcode = accountApi.createPermanentQrcode("1");
        System.out.println(qrcode);
    }

    @Test
    public void createPermanentQrcode_sameSceneId() throws Exception {
        WxQrcode qrcode1 = accountApi.createPermanentQrcode(1);
        WxQrcode qrcode2 = accountApi.createPermanentQrcode(1);
        System.out.println(qrcode1);
        System.out.println(qrcode2);
        Assert.assertEquals(qrcode1.getTicket(), qrcode2.getTicket());
    }
}
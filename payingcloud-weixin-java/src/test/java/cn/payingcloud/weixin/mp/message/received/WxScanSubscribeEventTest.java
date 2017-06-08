package cn.payingcloud.weixin.mp.message.received;

import cn.payingcloud.weixin.mp.message.received.msg.WxScanSubscribeEvent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
public class WxScanSubscribeEventTest {
    @Test
    public void parseSceneId() throws Exception {
        WxScanSubscribeEvent event = new WxScanSubscribeEvent("x",
                "x",
                "x",
                "qrscene_1",
                "x");
        assertEquals(1, event.sceneId());
    }

}
package cn.payingcloud.weixin.mp.message.received;

import cn.payingcloud.weixin.mp.message.received.msg.WxScanEvent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
public class WxScanEventTest {
    @Test
    public void parseSceneId() throws Exception {
        WxScanEvent event = new WxScanEvent("x",
                "x",
                "x",
                "1",
                "x");
        assertEquals(1, event.sceneId());
    }

}
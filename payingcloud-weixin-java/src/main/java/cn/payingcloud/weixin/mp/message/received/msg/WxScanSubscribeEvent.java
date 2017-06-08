package cn.payingcloud.weixin.mp.message.received.msg;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 扫描带参数二维码事件：1.用户未关注时，进行关注后的事件推送
 *
 * @author YQ.Huang
 * @author ZM.Wang
 */
public class WxScanSubscribeEvent extends WxSubscribeEvent {

    public final String eventKey;
    public final String ticket;

    public WxScanSubscribeEvent(String toUserName, String fromUserName, String createTime, String eventKey, String ticket) {
        super(toUserName, fromUserName, createTime);
        this.eventKey = eventKey;
        this.ticket = ticket;
    }

    public int sceneId() {
        return NumberUtils.toInt(StringUtils.substring(eventKey, 8)); // format: qrscene_1
    }

    public WxScanEvent toScanEvent() {
        return new WxScanEvent(toUserName, fromUserName, createTime, sceneId() + "", ticket);
    }
}

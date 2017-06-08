package cn.payingcloud.weixin.mp.message.received.msg;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 扫描带参数二维码事件：2.用户已关注时的事件推送
 *
 * @author YQ.Huang
 * @author ZM.Wang
 */
public class WxScanEvent extends WxEvent {

    public final String eventKey;
    public final String ticket;

    public WxScanEvent(String toUserName, String fromUserName, String createTime, String eventKey, String ticket) {
        super(toUserName, fromUserName, createTime, WxEventTypes.SCAN);
        this.eventKey = eventKey;
        this.ticket = ticket;
    }

    public int sceneId() {
        return NumberUtils.toInt(eventKey);
    }

}

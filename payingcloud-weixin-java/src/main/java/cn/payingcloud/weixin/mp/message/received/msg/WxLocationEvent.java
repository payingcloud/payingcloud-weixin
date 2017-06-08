package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author YQ.Huang
 */
public class WxLocationEvent extends WxEvent {

    public final String latitude;    // 地理位置纬度
    public final String longitude;   // 地理位置经度
    public final String precision;   // 地理位置精度

    public WxLocationEvent(String toUserName, String fromUserName, String createTime, String latitude, String longitude, String precision) {
        super(toUserName, fromUserName, createTime, WxEventTypes.LOCATION);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

}

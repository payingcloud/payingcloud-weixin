package cn.payingcloud.weixin.mp.message.send.msg;

import cn.payingcloud.weixin.mp.message.send.WxTemplateMsg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 帐户推广变动提醒
 *
 * @author YQ.Huang
 */
public class WxPromotionChangedMsg extends WxTemplateMsg {

    private static final DateFormat TIMESTAMP_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    public WxPromotionChangedMsg setTitle(String title) {
        addDataItem("first", title);
        return this;
    }

    public WxPromotionChangedMsg setReason(String reason) {
        addDataItem("reason", reason);
        return this;
    }

    public WxPromotionChangedMsg setTime(Date time) {
        addDataItem("time", TIMESTAMP_DATE_FORMAT.format(time));
        return this;
    }

    public WxPromotionChangedMsg setRemark(String remark) {
        addDataItem("remark", remark);
        return this;
    }
}

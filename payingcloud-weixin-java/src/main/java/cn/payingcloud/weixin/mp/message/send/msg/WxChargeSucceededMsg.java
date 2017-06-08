package cn.payingcloud.weixin.mp.message.send.msg;

import cn.payingcloud.weixin.mp.message.send.WxTemplateMsg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YQ.Huang
 */
public class WxChargeSucceededMsg extends WxTemplateMsg {

    private static final DateFormat TIMESTAMP_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    public WxChargeSucceededMsg setChannel(String channel) {
        addDataItem("keyword3", channel);
        return this;
    }

    public WxChargeSucceededMsg setChargeId(String chargeId) {
        addDataItem("keyword4", chargeId);
        return this;
    }

    public WxChargeSucceededMsg setTitle(String title) {
        addDataItem("first", title);
        return this;
    }

    public WxChargeSucceededMsg setMerchant(String merchant) {
        addDataItem("keyword2", merchant);
        return this;
    }

    public WxChargeSucceededMsg setMoney(String money) {
        addDataItem("keyword1", money);
        return this;
    }

    public WxChargeSucceededMsg setTime(Date time) {
        addDataItem("keyword5", TIMESTAMP_DATE_FORMAT.format(time));
        return this;
    }

    public WxChargeSucceededMsg setRemark(String remark) {
        addDataItem("remark", remark);
        return this;
    }
}

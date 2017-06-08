package cn.payingcloud.weixin.mp.support;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YQ.Huang
 */
public class WxResponse {

    @JsonProperty(value = "errcode", defaultValue = "0")
    private int errCode;

    @JsonProperty(value = "errmsg", defaultValue = "ok") // 测试发现 defaultValue 并未生效
    private String errMsg;

    public boolean successful() {
        return errCode == 0;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WeixinResponse{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}

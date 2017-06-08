package cn.payingcloud.weixin.mp.user;

import cn.payingcloud.weixin.mp.support.WxResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author YQ.Huang
 */
public class WxUserInfo extends WxResponse {

    private int subscribe;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("nickname")
    private String nickName;

    private int sex;

    private String country;

    private String province;

    private String city;

    private String language;

    @JsonProperty("headimgurl")
    private String headImgUrl;

    @JsonProperty("subscribe_time")
    private int subscribeTime;

    @JsonProperty("unionid")
    private String unionId;

    private String remark;

    @JsonProperty("groupid")
    private int groupId;

    @JsonProperty("tagid_list")
    private int[] tagIdList;

    public int getSubscribe() {
        return subscribe;
    }

    public String getOpenId() {
        return openId;
    }

    public String getNickName() {
        return nickName;
    }

    public int getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getLanguage() {
        return language;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public int getSubscribeTime() {
        return subscribeTime;
    }

    public String getUnionId() {
        return unionId;
    }

    public String getRemark() {
        return remark;
    }

    public int getGroupId() {
        return groupId;
    }

    public int[] getTagIdList() {
        return tagIdList;
    }

    @Override
    public String toString() {
        return "WxUserInfo{" +
                "subscribe=" + subscribe +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", language='" + language + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", subscribeTime=" + subscribeTime +
                ", unionId='" + unionId + '\'' +
                ", remark='" + remark + '\'' +
                ", groupId=" + groupId +
                ", tagIdList=" + Arrays.toString(tagIdList) +
                '}';
    }
}

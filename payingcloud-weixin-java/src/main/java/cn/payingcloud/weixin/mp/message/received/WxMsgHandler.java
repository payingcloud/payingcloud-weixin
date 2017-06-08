package cn.payingcloud.weixin.mp.message.received;

/**
 * @author YQ.Huang
 * @author ZM.Wang
 */
public interface WxMsgHandler<T extends WxMsg> {

    WxReply process(T msg);

    Class<T> getMsgClass();
}

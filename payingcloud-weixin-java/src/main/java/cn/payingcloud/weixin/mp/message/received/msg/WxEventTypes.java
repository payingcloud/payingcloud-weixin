package cn.payingcloud.weixin.mp.message.received.msg;

/**
 * @author YQ.Huang
 */
public interface WxEventTypes {
    String LOCATION = "LOCATION";          //位置消息
    String SUBSCRIBE = "subscribe";        //关注消息，也可能是带参二维码关注
    String UNSUBSCRIBE = "unsubscribe";    //取消关注消息
    String SCAN = "SCAN";                  //已关注后的带参二维码
    String CLICK = "CLICK";                //自定义菜单点击事件
    String VIEW = "VIEW";                  //自定义菜单连接跳转事件
}

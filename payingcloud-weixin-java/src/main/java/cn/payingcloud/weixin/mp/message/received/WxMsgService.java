package cn.payingcloud.weixin.mp.message.received;

import cn.payingcloud.weixin.mp.WxException;
import cn.payingcloud.weixin.mp.WxServerException;
import cn.payingcloud.weixin.mp.message.received.msg.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YQ.Huang
 */
public class WxMsgService {
    private static final Logger logger = LoggerFactory.getLogger(WxMsgService.class);
    private final Map<Class, WxMsgHandler> handlers = new HashMap<>();

    public void registerHandlers(WxMsgHandler... handlers) {
        Validate.notNull(handlers);
        for (WxMsgHandler handler : handlers) {
            registerHandler(handler);
        }
    }

    public void registerHandler(WxMsgHandler handler) {
        Validate.notNull(handler);
        handlers.put(handler.getMsgClass(), handler);
    }

    @SuppressWarnings("unchecked")
    public WxReply process(String xml) throws WxException {
        WxMsg msg = parse(xml);
        if (msg != null) {
            WxMsgHandler handler = handlers.get(msg.getClass());
            if (handler != null) {
                return handler.process(msg);
            } else {
                logger.debug("No registered handler found for " + msg.getClass());
            }
        }
        return WxReply.empty();
    }

    private WxMsg parse(String xml) throws WxException {
        Element root;
        try {
            root = DocumentHelper.parseText(xml).getRootElement();
        } catch (DocumentException e) {
            throw new WxServerException("Failed to parse message from xml.", e);
        }
        String msgType = findParam(root, "MsgType");
        String toUserName = findParam(root, "ToUserName");
        String fromUserName = findParam(root, "FromUserName");
        String createTime = findParam(root, "CreateTime");
        if (msgType.equals(WxMsgTypes.EVENT)) {
            String event = findParam(root, "Event");
            String eventKey;
            String ticket;
            switch (event) {
                case WxEventTypes.SUBSCRIBE:
                    eventKey = findParam(root, "EventKey", null);
                    ticket = findParam(root, "Ticket", null);
                    if (StringUtils.isAnyBlank(eventKey, ticket)) {
                        return new WxSubscribeEvent(toUserName, fromUserName, createTime);
                    } else {
                        return new WxScanSubscribeEvent(toUserName, fromUserName, createTime, eventKey, ticket);
                    }
                case WxEventTypes.UNSUBSCRIBE:
                    return new WxUnsubscribeEvent(toUserName, fromUserName, createTime);
                case WxEventTypes.SCAN:
                    eventKey = findParam(root, "EventKey");
                    ticket = findParam(root, "Ticket");
                    return new WxScanEvent(toUserName, fromUserName, createTime, eventKey, ticket);
                default:
                    logger.debug("Unsupported Event Type: " + event);
                    return null;
            }
        } else {
            switch (msgType) {
                case WxMsgTypes.TEXT:
                    String msgId = findParam(root, "MsgId");
                    String content = findParam(root, "Content");
                    return new WxTextMsg(toUserName, fromUserName, createTime, msgId, content);
                default:
                    logger.debug("Unsupported Msg Type: " + msgType);
                    return null;
            }
        }
    }

    private static String findParam(Element element, String param) throws WxServerException {
        String value = element.elementTextTrim(param);
        if (value != null) {
            return value;
        } else {
            throw new WxServerException("Could not find the parameter: " + param);
        }
    }

    private static String findParam(Element element, String param, String defaultValue) {
        String value = element.elementTextTrim(param);
        return value == null ? defaultValue : value;
    }
}

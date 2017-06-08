package cn.payingcloud.weixin.mp.support;

import java.util.*;

/**
 * @author YQ.Huang
 */
public class WxHttpRequest {

    private final List<Arg> args = new ArrayList<>();
    private final Map<String, String> headers = new LinkedHashMap<>();

    private String method = "GET";
    private String url;

    public WxHttpRequest(String url) {
        this.url = url;
    }

    public void setHeader(String name, String value) {
        headers.put(name, value);
    }

    public WxHttpRequest withHeader(String name, String value) {
        setHeader(name, value);
        return this;
    }

    public WxHttpRequest withArg(String key, Object value) {
        if (value != null) {
            args.add(new Arg(key, value));
        }
        return this;
    }

    /**
     * Unlike {@link #withArg(String, Object)}, overrides the existing value
     */
    public WxHttpRequest setArg(String key, Object value) {
        for (Arg e : args) {
            if (e.key.equals(key)) {
                e.value = value;
                return this;
            }
        }
        return withArg(key, value);
    }

    public WxHttpRequest withMethod(String method) {
        this.method = method.toUpperCase();
        return this;
    }

    public List<Arg> getArgs() {
        return Collections.unmodifiableList(args);
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public static class Arg {
        String key;
        Object value;

        private Arg(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}

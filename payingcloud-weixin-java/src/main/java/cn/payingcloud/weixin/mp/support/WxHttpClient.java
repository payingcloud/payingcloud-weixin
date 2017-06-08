package cn.payingcloud.weixin.mp.support;

import cn.payingcloud.weixin.mp.WxClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * @author YQ.Huang
 */
public class WxHttpClient {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setVisibility(new VisibilityChecker.Std(NONE, NONE, NONE, NONE, ANY));
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final HttpClient httpClient;

    public WxHttpClient() {
        this(5000, 5000);
    }

    public WxHttpClient(final int connectTimeout, final int socketTimeout) {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build();
    }

    public WxHttpResponse execute(WxHttpRequest wxHttpRequest) throws WxClientException {
        HttpUriRequest httpRequest = buildHttpUriRequest(wxHttpRequest);
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            WxHttpResponse wxHttpResponse = new WxHttpResponse(httpResponse.getStatusLine().getStatusCode());
            wxHttpResponse.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            wxHttpResponse.setBody(httpResponse.getEntity().getContent());
            wxHttpResponse.setContentType(httpResponse.getEntity().getContentType().getValue());
            return wxHttpResponse;
        } catch (IOException e) {
            throw new WxClientException(e.getLocalizedMessage(), e);
        }
    }

    private HttpUriRequest buildHttpUriRequest(WxHttpRequest wxHttpRequest) throws WxClientException {
        RequestBuilder requestBuilder = RequestBuilder.create(wxHttpRequest.getMethod())
                .setUri(wxHttpRequest.getUrl());

        for (String headerKey : wxHttpRequest.getHeaders().keySet()) {
            requestBuilder.addHeader(headerKey, wxHttpRequest.getHeaders().get(headerKey));
        }

        if ("POST".equalsIgnoreCase(wxHttpRequest.getMethod())
                || "PUT".equalsIgnoreCase(wxHttpRequest.getMethod())) {
            Map<String, Object> map = new HashMap<>();
            for (WxHttpRequest.Arg arg : wxHttpRequest.getArgs()) {
                map.put(arg.key, arg.value);
            }
            try {
                String json = MAPPER.writeValueAsString(map);
                StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
                requestBuilder.setEntity(entity);
            } catch (JsonProcessingException e) {
                throw new WxClientException(e.getLocalizedMessage(), e);
            }
        } else {
            for (WxHttpRequest.Arg arg : wxHttpRequest.getArgs()) {
                requestBuilder.addParameter(arg.key, arg.value.toString());
            }
        }

        return requestBuilder.build();
    }

}

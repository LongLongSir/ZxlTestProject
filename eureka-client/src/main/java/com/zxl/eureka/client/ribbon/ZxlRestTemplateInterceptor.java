package com.zxl.eureka.client.ribbon;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.http.client.*;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.URI;

/**
 * RestTemplate请求拦截器
 * @auth zhangxl
 * @date 2020/12/25
 */
public class ZxlRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        URI originalUri = request.getURI();
        String host = originalUri.getHost();
        System.out.println("=====host:"+host);
        if(originalUri.getPort()>0){
            HttpMethod method = request.getMethod();
            Assert.state(method != null, "No standard HTTP method");
            ClientHttpRequest delegate = requestFactory.createRequest(request.getURI(), method);
            request.getHeaders().forEach((key, value) -> delegate.getHeaders().addAll(key, value));
            if (body.length > 0) {
                if (delegate instanceof StreamingHttpOutputMessage) {
                    StreamingHttpOutputMessage streamingOutputMessage = (StreamingHttpOutputMessage) delegate;
                    streamingOutputMessage.setBody(outputStream -> StreamUtils.copy(body, outputStream));
                }
                else {
                    StreamUtils.copy(body, delegate.getBody());
                }
            }
            return delegate.execute();
        }else{
            return execution.execute(request,body);
        }
    }
}

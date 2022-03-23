package com.zxl.eureka.client.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.zxl.eureka.client.ribbon.ZxlRestTemplateInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth zhangxl
 * @date 2020/12/22
 */
@Configuration
public class ClientConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ZxlRestTemplateInterceptor zxlRestTemplateInterceptor){
        RestTemplate restTemplate=new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors=new ArrayList<>();
        interceptors.add(zxlRestTemplateInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public ZxlRestTemplateInterceptor zxlRestTemplateInterceptor(){
        return new ZxlRestTemplateInterceptor();
    }

    @Bean
    public IClientConfig zxlClientConfig(){
        return new DefaultClientConfigImpl();
    }

}

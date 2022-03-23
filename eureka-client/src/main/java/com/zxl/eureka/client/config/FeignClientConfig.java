package com.zxl.eureka.client.config;

import feign.Client;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FeignClientConfig {

    public static void main(String[] args) {
        String s="2";
        int i = Integer.parseInt(s);
        System.out.println(i);

    }

}

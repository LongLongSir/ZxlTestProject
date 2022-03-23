package com.zxl.eureka.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableEurekaClient
@EnableDiscoveryClient //可以不要，也能注册
@EnableHystrix
@EnableFeignClients
public class EurekaClientApplication {

    //-javaagent:D:\gitwork\jackyunJavaWork\agent-boot\JackYun.Framework.Agent\agent-boot\target\agent-boot.jar=serviceType=service-test-client,group=
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

}

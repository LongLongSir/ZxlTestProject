package com.zxl.eureka.client2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableEurekaClient
@EnableDiscoveryClient //可以不要，也能注册
//@EnableHystrix
public class EurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class,args);
    }

}

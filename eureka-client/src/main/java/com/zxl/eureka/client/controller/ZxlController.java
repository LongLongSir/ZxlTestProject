package com.zxl.eureka.client.controller;

import com.netflix.client.IClientConfigAware;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.IClientConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zxl.eureka.client.agent.ZxlAgent;
import com.zxl.eureka.client.feign.ZxlFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auth zhangxl
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/zxl")
public class ZxlController {


    //@Autowired
    private IClientConfig clientConfig;
    @Autowired
    private SpringClientFactory clientFactory;

    @Autowired
    private ZxlFeignClient zxlFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testString")
    public String getString(){
        return restTemplate.getForEntity("http://service-test-client2/zxl/testString",String.class).getBody();
    }

    @GetMapping("/testString2")
    public String getString2(){
        return restTemplate.getForEntity("http://192.168.4.52:8091/zxl/testString",String.class).getBody();
    }

    @GetMapping("/testFeignString")
    public String testFeignString(){
        return zxlFeignClient.testString();
    }

    @GetMapping("/testAgentToUpper")
    public String testAgentToUpper(String str){
        return new ZxlAgent().getUpperStr(str);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @PostMapping("/postHystrix")
    public String postHystrix(){
        System.out.println("postHystrix真实方法");
        int i=1/0;
        return zxlFeignClient.testString();
    }

    public String fallback(){
        System.out.println("postHystrix方法降级");
        return "xxxx";
    }


    @GetMapping("/getIClientConfigValue")
    public String getIClientConfigValue(String key){

        IClientConfig clientConfig = clientFactory.getClientConfig("default");
        Integer integer = clientConfig.get(CommonClientConfigKey.ConnectTimeout, 5000);
        return integer.toString();
    }

}

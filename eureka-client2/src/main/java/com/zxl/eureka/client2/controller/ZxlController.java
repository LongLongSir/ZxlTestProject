package com.zxl.eureka.client2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth zhangxl
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/zxl")
public class ZxlController {

    @GetMapping("/testString")
    public String testString() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("=====testString()====");
        return "zxce4323";
    }

    @PostMapping("/postString")
    public String postFeignString(String str) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("=====postFeignString()====");
        return str;
    }


}

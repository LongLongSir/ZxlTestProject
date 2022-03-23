package com.differ.zxl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth zhangxl
 * @date 2021/1/28
 */
@RestController
public class AdminController {

    @GetMapping("testSecurity")
    public String testSecurity(){
        return "zxcccccc";
    }

}

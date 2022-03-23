package com.zxl.eureka.client.agent;

import com.zxl.eureka.client.config.FeignClientConfig;
import org.springframework.util.ClassUtils;

import java.util.Locale;

public class ZxlAgent {

    public String getUpperStr(String str){
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(FeignClientConfig.class.getSimpleName());
        System.out.println(FeignClientConfig.class.getCanonicalName());
        System.out.println(FeignClientConfig.class.getName());
        System.out.println(ClassUtils.getPackageName(FeignClientConfig.class));


    }
}

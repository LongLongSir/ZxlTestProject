package com.differ.zxl.concurrent.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auth zhangxl
 * @date 2020/12/8
 */
public class AtomicMain {

    public static void main(String[] args) {
        Map<String , AtomicInteger> m=new ConcurrentHashMap<>();
        m.put("ss",new AtomicInteger(1));
        int result = m.get("ss").getAndIncrement();
        System.out.println(result);
        System.out.println(m.get("ss"));
        System.out.println("==========");
        result = m.get("ss").incrementAndGet();
        System.out.println(result);
        System.out.println(m.get("ss"));



    }

}

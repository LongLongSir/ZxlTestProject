package com.differ.zxl.concurrent.map;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auth zhangxl
 * @date 2020/12/9
 */
public class MapMain {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        ConcurrentHashMap<String , AtomicInteger> testMap=new ConcurrentHashMap<>();

        for (int i=0;i<100;i++){
            executorService.execute(()->{
                if(testMap.get("key")==null){
                    //线程安全的
                    testMap.putIfAbsent("key",new AtomicInteger());
                }
                testMap.get("key").getAndIncrement();
            });
        }
        Thread.sleep(100);
        executorService.shutdown();
        System.out.println(testMap.get("key").get());
    }

}

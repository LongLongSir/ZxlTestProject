package com.differ.zxl.jvm.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LinkedBlockZeroCoreMain {

    public static void main(String[] args)throws  Exception {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(0,10,2000,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(50));

        while (true){
            Thread.sleep(500);
            threadPoolExecutor.execute(()->{
                System.out.println("aaaaaaaa");
            });
        }

    }

}

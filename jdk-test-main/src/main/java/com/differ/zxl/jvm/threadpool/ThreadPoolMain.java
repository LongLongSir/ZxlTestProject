package com.differ.zxl.jvm.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolMain {

    public static void main(String[] args) {

        Executors.newFixedThreadPool(10); //固定线程池，固定核心数，无限队列

        Executors.newCachedThreadPool();//缓存线程池，没有核心线程数，采用同步队列，来了任务则直接new一个新线程(过期时间60s，可重复利用)

        Executors.newSingleThreadExecutor();//单核心线程，无限队列

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);//定时线程池，初始延迟一段时间，然后以固定频率执行任务
        //scheduledExecutorService.scheduleAtFixedRate()

    }
}

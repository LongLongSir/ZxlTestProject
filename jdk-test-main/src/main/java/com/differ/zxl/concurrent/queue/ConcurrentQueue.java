package com.differ.zxl.concurrent.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentQueue {

    public static void main(String[] args) {
        //Concurrent相关的队列集合，采用的CAS处理并发
        ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<>();

        //跳表，线程安全的带排序的TreeMap
        ConcurrentSkipListMap<String,String> map=new ConcurrentSkipListMap<>();

    }

}

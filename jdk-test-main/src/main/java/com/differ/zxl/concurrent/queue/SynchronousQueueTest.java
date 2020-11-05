package com.differ.zxl.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) throws Exception{

        //内部使用的TransferQueue实现的,同步队列，没有容量，放入和取出都会阻塞
        BlockingQueue<String> queue=new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println("qqq:"+queue.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        //queue.add("aaa");  //放入失败会抛异常
        //queue.offer("bbb"); //放入失败则返回false
        queue.put("ccc");//阻塞放入，有消费者则可以直接消费，内部使用transfer()

        System.out.println(queue.size());
    }
}

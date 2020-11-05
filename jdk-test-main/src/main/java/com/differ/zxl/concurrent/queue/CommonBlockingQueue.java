package com.differ.zxl.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CommonBlockingQueue {

    public static void main(String[] args)throws Exception {

        //无界队列 capacity默认Integer.MAX_VALUE，传入值必须大于0
        LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>();
        //有节队列 capacity必传且大于0
        //ArrayBlockingQueue<String> queue1=new ArrayBlockingQueue<>(0);

        new Thread(()->{
            try {
                System.out.println("qqq:"+queue.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        queue.put("ccc");

        System.out.println(queue.size());

    }

}

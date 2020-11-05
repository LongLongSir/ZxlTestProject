package com.differ.zxl.concurrent.queue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueTest {

    public static void main(String[] args) throws  Exception{
        LinkedTransferQueue<String> queue=new LinkedTransferQueue<>();

//        new Thread(()->{
//           try {
//               System.out.println("t1:"+queue.take());
//           }catch (Exception e){
//                e.printStackTrace();
//           }
//        }).start();
//
//        new Thread(()->{
//            try {
//                System.out.println("t2:"+queue.take());
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }).start();

        //Thread.sleep(1000);

        queue.transfer("aa");   //transfer是把该值直接交给消费者，不会入队列，如果没有take消费者，则transfer会阻塞(可设置超时时间)，这种数据交互效率更高
        //queue.put("bb");  //put还是正常的入队操作
        System.out.println(queue.size());

        new Thread(()->{
            try {
                System.out.println("xxx:"+queue.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

    }

}

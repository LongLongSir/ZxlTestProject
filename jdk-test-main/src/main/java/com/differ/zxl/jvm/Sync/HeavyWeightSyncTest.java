package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolC;

import java.util.concurrent.CountDownLatch;

//重量级锁性能测试
public class HeavyWeightSyncTest {


    public static void main(String[] args)throws Exception {

        JolC c=new JolC();
        CountDownLatch countDownLatch=new CountDownLatch(100000000);

        long start = System.currentTimeMillis();

        for(int i=0;i<2;i++){
            new Thread(()->{
                while (countDownLatch.getCount()>0){
                    c.cutDown(countDownLatch);
                }
            }).start();
        }
        countDownLatch.await();

        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
        System.out.println("=====after 锁状态=====");
        //System.out.println(ClassLayout.parseInstance(c).toPrintable());
        //出了sync锁块，锁消除了
        c.print();

        //重量级锁耗时：3018 ms

    }

}

package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolC;

import java.util.concurrent.CountDownLatch;

//重量级锁性能测试
public class HeavyWeightSyncTest {


    public static void main(String[] args)throws Exception {

        JolC c=new JolC();
        CountDownLatch countDownLatch=new CountDownLatch(Constant.SIZE);

        Thread t1=new Thread(()->{
            while (countDownLatch.getCount()>0){
                c.cutDown(countDownLatch);
            }
        }) ;
        Thread t2=new Thread(()->{
            while (countDownLatch.getCount()>0){
                c.cutDown(countDownLatch);
            }
        }) ;

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        countDownLatch.await();
        long end = System.currentTimeMillis();

        System.out.println("耗时："+(end-start));
        System.out.println("=====after 锁状态=====");
        //System.out.println(ClassLayout.parseInstance(c).toPrintable());
        //出了sync锁块，锁消除了
        c.print();

        //重量级锁耗时：3890 ms

    }

}

package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;

/**
 * @auth zhangxl
 * @date 2021/3/23
 */
public class HeavyWeightSyncTestV2 {

    public static void main(String[] args)throws Exception {

        JolB b=new JolB();
        //先让其膨胀
        Thread t1=new Thread(()->{
            synchronized (b){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (b){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        synchronized (b){
            System.out.println(ClassLayout.parseInstance(b).toPrintable());
        }

        long start = System.currentTimeMillis();
        for (int i=0;i<Constant.SIZE;i++){
            b.incr();
        }
        long end=System.currentTimeMillis();
        System.out.println("=========================");
        System.out.println("耗时："+(end-start));

        // 1405 ms  17758

    }
}

package com.differ.zxl.jvm.Sync.threadblocktest;

import com.differ.zxl.jvm.Sync.jol.JolA;

public class ThreadBlockMain {

    public static void main(String[] args)throws Exception {
        JolA a=new JolA();
        Thread t1=new Thread(()->{
            System.out.println("t1 sync before");
            synchronized (a){
                System.out.println("t1 sync in");
                try {
                    a.wait();//会释放锁资源和CPU资源，在被唤醒时会重新争夺锁资源，拿到锁资源时，
                } catch (InterruptedException e) {
                    System.out.println("t1 exception");
                    System.out.println("exception state:"+Thread.currentThread().getState());
                    e.printStackTrace();
                }
                System.out.println("t1 sync out 1");
            }
            System.out.println("t1 sync out 2");
        });
        t1.start();
        Thread.sleep(3000);
        synchronized (a){
            System.out.println("main sync in");
            t1.interrupt(); //会唤醒wait线程，唤醒了会尝试获取锁资源，获取到锁资源之后会抛出中断异常，并清除中断标记
            Thread.sleep(500);
            System.out.println(t1.getState());
            Thread.sleep(5000);
        }


    }
}

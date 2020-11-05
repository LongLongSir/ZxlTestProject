package com.differ.zxl.jvm.Sync.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;

public class JolC {

    public synchronized void cutDown(CountDownLatch countDownLatch){
        countDownLatch.countDown();
    }

    public synchronized void print(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}

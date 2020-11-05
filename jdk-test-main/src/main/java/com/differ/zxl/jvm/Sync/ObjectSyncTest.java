package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolA;
import org.openjdk.jol.info.ClassLayout;

//测试sync锁种类对应的标记位，以及jvm偏向锁延迟开启
public class ObjectSyncTest {

    public static void main(String[] args)throws  Exception {

        //jvm会延迟偏向锁的开启，大约延迟4s开启偏向锁，因为jvm启动时内部有大量的sync关键字代码块，以及gc线程等
        // 而消除偏向锁很耗性能，在jvm内部直接延迟了偏向锁
        //可通过启动参数（默认是开启偏向锁的，并开启了延迟） -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0  来关闭偏向锁的延迟开启
        Thread.sleep(4100);

        JolA a=new JolA();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println("===================");

        synchronized (a){
            System.out.println("synchronized");

        }

        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }

}

package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;

//测试偏向锁和轻量级锁的性能
public class TestBiasedAndLightWeight {

    public static void main(String[] args) {

        //通过jvm参数来设置偏向锁延迟关闭 -XX:BiasedLockingStartupDelay=0  关闭延迟，则测试为偏向锁
        JolB b=new JolB();
        System.out.println("=======当前锁状态：======");
        //b.hashCode(); //通过hashCode计算之后，该对象不可偏向，后面进入sync同步块之后直接升级为轻量级锁
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
        long start=System.currentTimeMillis();
        //加一亿次
        for (int i=0;i<100000000;i++){
            b.incr();
        }
        long end=System.currentTimeMillis();
        System.out.println("=========================");
        System.out.println("耗时："+(end-start));
        System.out.println("=======锁状态如下：======");
        //轻量锁测试时：从sync块中出来之后，锁被消除了，变成无锁状态
        //偏向锁测试时：对象头中仍然保存的是偏向锁状态
        //System.out.println(ClassLayout.parseInstance(b).toPrintable());
        b.print();

        //测试结果：
        //偏向锁耗时：150 ms
        //轻量级锁耗时：1983 ms
    }

}

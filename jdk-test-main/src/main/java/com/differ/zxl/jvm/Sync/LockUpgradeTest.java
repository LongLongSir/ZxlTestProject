package com.differ.zxl.jvm.Sync;


import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;

//测试sync锁升级，线程交替执行，和线程竞争执行
public class LockUpgradeTest {

    //使用 -XX:BiasedLockingStartupDelay=0  关闭偏向锁的延迟
    public static void main(String[] args)throws Exception {

        JolB b=new JolB();
        System.out.println(ClassLayout.parseInstance(b).toPrintable()); //可偏向
        System.out.println("=================");
        Thread t=new Thread(()->{
            b.print();//偏向该线程
            System.out.println("=================");
            System.out.println(Long.toHexString(Thread.currentThread().getId()));
        });
        t.start();
        Thread.sleep(7000);
        System.out.println(t.getState()); //打印线程状态  TERMINATED 已死亡

        b.print();//不此时主线程获取锁，是原来偏向的线程，升级为轻量级锁，此时指向栈中锁记录Lock Record的指针，线程交替执行，没有发生竞争。

                //有一种情况是可重新偏向的，jvm如果检测到同一个类所产生的很多对象(10次，class类中的epoch=10)需要从偏向锁升级为轻量级锁，则会发送重偏向

    }


}

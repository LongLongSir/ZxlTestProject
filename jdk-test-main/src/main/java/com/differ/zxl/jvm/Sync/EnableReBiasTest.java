package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolA;
import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class EnableReBiasTest {

    static List<JolB> list=new ArrayList<>();

    static JolB c=new JolB();
    //使用 -XX:BiasedLockingStartupDelay=0  关闭偏向锁的延迟
    //测试偏向锁 重新偏向 epoch 大于等于20次时，该类型的对象可重偏向
    public static void main(String[] args)throws Exception {

        Thread t1=new Thread(()->{
//           for(int i=0;i<1;i++){
//               JolB a=new JolB();
//               //a.printNoSync();
//               synchronized (a){
//                   //System.out.println("111111");
//                   a.printNoSync();
//                   //System.out.println(Thread.currentThread().getId());
//                   list.add(a);
//
//               }
//           }
            synchronized (c){
                c.printNoSync();
            }
        });
        System.out.println("t1 start");
        t1.start();
        t1.join();
        //System.out.println(ClassLayout.parseInstance(list.get(0)).toPrintable());
        //Thread.sleep(5000);
        System.out.println("t1 end");
        Thread t2=new Thread(()->{
//            for (JolB a : list){
//                //a.printNoSync();
//                synchronized (a){
//                    //System.out.println("22222");
//                    a.printNoSync();
//                    System.out.println("====hashCode计算====");
//                    //System.out.println(a); //加了这一行就变成了重量级锁，里面有hashCode计算，
//                    a.hashCode();
//                    a.printNoSync();
//                    //System.out.println(Thread.currentThread().getId());
//                    //System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                }
//            }
//            System.out.println("t2 end");
//            System.out.println("in t2==============");
//            list.get(0).printNoSync();
            synchronized (c){
                c.printNoSync();
                c.hashCode();
                c.printNoSync();
            }
        });
        System.out.println("t2 start");
        t2.start();
        t2.join();
        System.out.println("in main==============");
        c.printNoSync();

        ////======================================================




    }
}

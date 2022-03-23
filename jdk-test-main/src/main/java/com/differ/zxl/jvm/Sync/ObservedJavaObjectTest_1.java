package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolA;
import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

//查看对象信息
public class ObservedJavaObjectTest_1 {
    //-XX:+PrintCommandLineFlags  //打印jvm设置的默认参数
    public static void main(String[] args)throws Exception {
         //Thread.sleep(5000);
        JolA a=new JolA();
        //jvm的信息
//        System.out.println(VM.current().details());
//        System.out.println("================");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

//         // 2
//        System.out.println("=======before hash=========");
//        //jvm计算出的hashCode存放在该对象的对象头的MarkWord中的31位中
//        System.out.println(a.hashCode());
//        System.out.println(Integer.toHexString(a.hashCode()));
//        System.out.println("=======after hash=========");
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());


         // 3
        System.out.println("======3=====");
        new Thread(()->{
            synchronized (a){
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
//        int hashCode=a.hashCode();
//        System.out.println(hashCode);//hashCode值
//        System.out.println(Integer.toHexString(hashCode));//hashCode值转16进制
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());//打印对象存储结构

        synchronized (a){
            System.out.println("=====after hashCode=====");
            System.out.println(ClassLayout.parseInstance(a).toPrintable()); //轻量级锁

        }
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }


}

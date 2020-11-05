package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolA;
import com.differ.zxl.jvm.Sync.jol.JolB;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

//查看对象信息
public class ObservedJavaObjectTest {
    //-XX:+PrintCommandLineFlags  //打印jvm设置的默认参数
    public static void main(String[] args)throws Exception {
        JolA a=new JolA();
        //jvm的信息
        System.out.println(VM.current().details());
        System.out.println("================");
        //System.out.println(ClassLayout.parseClass(JolA.class).toPrintable());
        //System.out.println("================");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println("=======before hash=========");
        //jvm计算出的hashCode存放在该对象的对象头的MarkWord中的31位中
        System.out.println(a.hashCode());
        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println("=======after hash=========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());


//        JolA a=new JolA();
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        new Thread(()->{
//            synchronized (a){
//
//            }
//        }).start();
//        Thread.sleep(1000);
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        int hashCode=a.hashCode();
//        System.out.println(hashCode);//hashCode值
//        System.out.println(Integer.toHexString(hashCode));//hashCode值转16进制
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());//打印对象存储结构
//
//        synchronized (a){
//            System.out.println("=====after hashCode=====");
//            System.out.println(ClassLayout.parseInstance(a).toPrintable()); //轻量级锁
//        }
    }


}

package com.differ.zxl.jvm.Sync;

import com.differ.zxl.jvm.Sync.jol.JolA;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class LuBanReBiasTest {

    static List<JolA> list=new ArrayList<>();
    //使用 -XX:BiasedLockingStartupDelay=0  关闭偏向锁的延迟
    public static void main(String[] args)throws Exception {

        Thread t1=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    JolA a=new JolA();
                    synchronized (a){
                        System.out.println("11111111");
                        list.add(a);
                    }
                }
            }
        };

        t1.start();
        t1.join();

        System.out.println("before t2");
        //偏向
        System.out.println(ClassLayout.parseInstance(list.get(1)).toPrintable());
        Thread t2=new Thread(){
            int k=0;
            @Override
            public void run() {
                for(JolA a : list){
                    synchronized (a){
                        System.out.println("222222");
                        if(k==4){
                            System.out.println("t2 ing");
                            System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                    k++;
                }
            }
        };
        t2.start();

    }
}

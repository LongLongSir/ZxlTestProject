package com.differ.zxl.storage.test1;

import org.openjdk.jol.info.ClassLayout;

/**
 * 非静态内部类的对象会有一个指针指向外部类的对象
 * @auth zhangxl
 * @date 2023/4/4
 */

public class ExternalClassTest {

    class InnerClass {

    }

    public InnerClass getInnerInstance() {
        return new InnerClass();
    }

    public static void main(String[] args) {

        //外部内对象
        ExternalClassTest externalClassTest = new ExternalClassTest();

        //内部类对象
        InnerClass innerInstance = externalClassTest.getInnerInstance();

        System.out.println("===================外部实例对象内存布局==========================");
        System.out.println(ClassLayout.parseInstance(externalClassTest).toPrintable());

        System.out.println("===================内部实例对象内存布局===========================");
        System.out.println(ClassLayout.parseInstance(innerInstance).toPrintable());

    }

}

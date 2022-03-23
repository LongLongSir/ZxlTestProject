package com.differ.zxl.jvm.Sync.jol;

import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Field;

public class JolB {
    int i=0;

    public synchronized void incr(){
        i++;
    }

    public void incrNoSync(){
        i++;
    }

    public synchronized void print(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

    public void printNoSync(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

}

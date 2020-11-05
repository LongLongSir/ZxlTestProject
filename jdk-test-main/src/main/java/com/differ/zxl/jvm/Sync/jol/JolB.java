package com.differ.zxl.jvm.Sync.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolB {
    int i=0;

    public synchronized void incr(){
        i++;
    }

    public synchronized void print(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

    public void printNoSync(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}

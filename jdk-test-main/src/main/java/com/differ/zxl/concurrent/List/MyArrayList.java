package com.differ.zxl.concurrent.List;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

    public static void main(String[] args) {
        List<Integer> originList=new ArrayList<>();
        for(int i=0;i<100000;i++){
            originList.add(i);
        }
        List<Integer> list=new ArrayList<>();
        originList.stream().forEach(p->list.add(p));
        System.out.println(list.size());

        list.clear();

        //多线程，线程不安全
        originList.stream().parallel().forEach(p->list.add(p));
        System.out.println(list.size());
    }


}

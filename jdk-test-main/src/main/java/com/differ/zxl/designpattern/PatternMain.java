package com.differ.zxl.designpattern;


import com.differ.zxl.designpattern.singleton.LazySingleton;

public class PatternMain {
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(LazySingleton.getInstance());
                }
            }).start();
        }
    }
}

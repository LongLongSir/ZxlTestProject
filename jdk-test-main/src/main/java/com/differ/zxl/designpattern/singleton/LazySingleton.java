package com.differ.zxl.designpattern.singleton;

public class LazySingleton {
    private static LazySingleton ins;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(ins==null){
            synchronized (LazySingleton.class){
                if(ins==null){
                    ins=new LazySingleton();
                }
            }
        }
        return ins;
    }

}

package com.differ.zxl.designpattern.singleton;

import java.io.Serializable;

public class HungrySingleton implements Serializable {

    private static HungrySingleton ins;

    static {
        try {
            ins = new HungrySingleton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HungrySingleton() throws Exception {
        if(ins!=null){
            throw new Exception("不能反射获取对象");
        }
    }

    public static HungrySingleton getInstance(){
        return ins;
    }

    public HungrySingleton readResolve(){
        return ins;
    }

}

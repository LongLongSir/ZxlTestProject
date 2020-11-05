package com.differ.zxl.jvm;


import com.differ.zxl.jvm.Sync.jol.JolA;

import java.util.ArrayList;
import java.util.List;

public class JvmMain {
    public static void main(String[] args) {
        Integer intV = null;
        switch (intV) { //空指针异常
            case 1:
                System.out.println("1111");
                break;
            default:
                break;
        }

        List<JolA> list = new ArrayList<>();
        list.add(new JolA());
        list.add(new JolA());
        JolA t = new JolA();
        t.setB(true);
        list.add(t);
        list.removeIf(p -> !p.isB());
        System.out.println(list.size());
    }
}

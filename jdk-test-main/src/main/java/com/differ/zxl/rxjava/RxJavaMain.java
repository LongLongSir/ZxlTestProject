package com.differ.zxl.rxjava;


import com.differ.zxl.dto.ZxlDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth zhangxl
 * @date 2021/11/17
 */
public class RxJavaMain {

    public static void main(String[] args) {

        ZxlDTO zxlDTO=new ZxlDTO();
        zxlDTO.setAge(3);
        zxlDTO.setName("zzz");
        Integer s=4;
        //s=7;
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);

        list.forEach(t->{
            t=6;
            zxlDTO.setAge(t);
            t=7;
            zxlDTO.setAge(t);
        });
        System.out.println(list);
    }

}

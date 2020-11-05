package com.differ.zxl;

import java.util.HashMap;
import java.util.Map;

public class ZxlMain {


    public static void main(String[] args) {

        Map<String,String> map=new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put(null,"xxx");

        System.out.println(map.get("1"));
        System.out.println(map.get(""));
        System.out.println(map.get(null));
    }

}

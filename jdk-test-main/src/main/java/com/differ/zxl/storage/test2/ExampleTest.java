package com.differ.zxl.storage.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth zhangxl
 * @date 2023/4/20
 */
public class ExampleTest {
    private static String name="XiaoMing";

    public static void main(String[] args) {
        List<String > list=new ArrayList<String>(){{
            add("aa");
            add("bb");
            add(name);
        }};
        System.out.println(list);
    }

}

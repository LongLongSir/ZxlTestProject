package com.differ.zxl.storage.test3;

import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @auth zhangxl
 * @date 2023/4/20
 */
class TestClass{
    public List<String > createList(){
        List<String > list=new ArrayList<String>(){{
            add("aa");
            add("bb");
        }};
        return list;
    }
}

 public class ExampleTest2 {
    public static void main(String[] args)throws Exception{
        //System.out.println(new InnerClass().createList());
        List<String > list=new TestClass().createList();

        System.out.println("===================list实例对象内存布局==========================");
        System.out.println(ClassLayout.parseInstance(list).toPrintable());
        //================
        System.out.println("===================list实例对象内存布局==========================");
        Field field=list.getClass().getDeclaredField("this$0");
        field.setAccessible(true);
        System.out.println(field.get(list).getClass());
        System.out.println(ClassLayout.parseInstance(field.get(list)).toPrintable());

    }
}


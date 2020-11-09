package com.differ.zxl.jvm.Sync.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestObjectLayout {

    static Object generate() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", new Integer(1));
        map.put("b", "b");
        map.put("c", new Date());

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }
    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Object obj=generate();

        print(ClassLayout.parseInstance(obj).toPrintable());

        print(GraphLayout.parseInstance(obj).toPrintable());

        print("Count:"+GraphLayout.parseInstance(obj).totalCount());
        print("Size:"+GraphLayout.parseInstance(obj).totalSize());

    }

}

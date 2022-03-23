package com.differ.zxl.test.DynamicProperty;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import java.util.concurrent.TimeUnit;

/**
 * @auth zhangxl
 * @date 2022/1/18
 */
public class DynamicPropertyMain {

    public static void main(String[] args) throws InterruptedException {

        //文章 https://cloud.tencent.com/developer/article/1600683
        DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();
        DynamicStringProperty nameProperty = propertyFactory.getStringProperty("name", "defaultName");
        nameProperty.addCallback(() -> System.out.println("name属性值发生变化："));

        // 10秒钟读一次
        while (true) {
            System.out.println(nameProperty.get());
            TimeUnit.SECONDS.sleep(50);
        }
    }
}

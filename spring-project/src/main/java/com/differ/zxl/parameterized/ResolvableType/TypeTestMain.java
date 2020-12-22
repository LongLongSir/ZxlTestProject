package com.differ.zxl.parameterized.ResolvableType;

import com.differ.zxl.parameterized.ResolvableType.base.EventA;
import com.differ.zxl.parameterized.ResolvableType.manage.ProcessorManagerA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.differ.zxl.parameterized.ResolvableType")
public class TypeTestMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TypeTestMain.class);
        ProcessorManagerA a= (ProcessorManagerA) context.getBean("processorManagerA");
        a.realProcess(new EventA());
    }
}

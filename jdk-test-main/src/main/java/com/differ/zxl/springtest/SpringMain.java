package com.differ.zxl.springtest;

import com.differ.zxl.springtest.ResolvableType.base.EventA;
import com.differ.zxl.springtest.ResolvableType.manage.ProcessorManagerA;
import com.differ.zxl.springtest.bean.BeanA;
import com.differ.zxl.springtest.bean.BeanB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.differ.zxl.springtest.bean")
public class SpringMain {

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringMain.class);

    }
}

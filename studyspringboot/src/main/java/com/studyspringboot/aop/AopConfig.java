package com.studyspringboot.aop;

import com.studyspringboot.aop.Service.MyAOPService;
import com.studyspringboot.aop.interceptor.MyAopMethodInterceptor;
import com.studyspringboot.aop.interceptor.MyAopMethodInterceptorV2;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    // 第一种：（类级别，粒度较大）
    // 指定beanName  BeanNameAutoProxyCreator实现代理
    // 初始化后置处理AbstractAutoProxyCreator#postProcessAfterInitialization

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator=new BeanNameAutoProxyCreator();

        beanNameAutoProxyCreator.setBeanNames("*myService");

        beanNameAutoProxyCreator.setInterceptorNames("myAopMethodInterceptor","myAopMethodInterceptorV2");
        return beanNameAutoProxyCreator;
    }

    @Bean
    public MyAOPService myService(){
        return new MyAOPService();
    }

    @Bean
    public Advice myAopMethodInterceptor(){
        return  new MyAopMethodInterceptor();
    }
    @Bean
    public Advice myAopMethodInterceptorV2(){
        return  new MyAopMethodInterceptorV2();
    }

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AopConfig.class);

        MyAOPService service = (MyAOPService) context.getBean("myService");
        service.service1();
        service.service2();
    }
}

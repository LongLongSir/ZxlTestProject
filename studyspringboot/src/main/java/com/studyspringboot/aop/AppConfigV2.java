package com.studyspringboot.aop;

import com.studyspringboot.aop.Service.MyAOPService;
import com.studyspringboot.aop.interceptor.MyAopMethodInterceptor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigV2 {

    //第二种：（方法级别的）
    //指定方法名

    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(){
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor=new NameMatchMethodPointcutAdvisor();
        nameMatchMethodPointcutAdvisor.setMappedName("service1");
        nameMatchMethodPointcutAdvisor.setAdvice(new MyAopMethodInterceptor());
        return nameMatchMethodPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public MyAOPService myAopService(){
        return new MyAOPService();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfigV2.class);
        MyAOPService service = (MyAOPService) context.getBean("myIService");
        service.service1();
        service.service2();
    }

}

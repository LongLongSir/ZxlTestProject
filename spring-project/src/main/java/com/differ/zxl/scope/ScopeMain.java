package com.differ.zxl.scope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.differ.zxl.scope")
public class ScopeMain {

    @Bean
    @Scope("scopeBeanCC")
    public ScopeBeanC scopeBeanC(){
        return new ScopeBeanC();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ScopeMain.class);

        BeanFactory factory = context.getBeanFactory();

        ScopeA bean = factory.getBean(ScopeA.class);
        bean.testM();
    }
}

package com.differ.zxl.parameterized.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private BeanA beanA;


    public BeanB(BeanA beanA){
        this.beanA=beanA;
        System.out.println("==build beanB==,beanA:"+beanA);
    }
}

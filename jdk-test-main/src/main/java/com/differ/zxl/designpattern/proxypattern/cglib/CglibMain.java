package com.differ.zxl.designpattern.proxypattern.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibMain {

    public static void main(String[] args) {

        //对一个类进行代理，
        BaseObj baseObj=new BaseObj();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(BaseObj.class);
        enhancer.setCallback(new MyProxyMethodInterceptor(baseObj));
        BaseObj proxyObj = (BaseObj) enhancer.create();
        proxyObj.baseMe();


    }

}

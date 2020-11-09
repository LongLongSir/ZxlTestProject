package com.differ.zxl.designpattern.proxypattern.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyProxyMethodInterceptor implements MethodInterceptor {

    private Object targetObj;

    public MyProxyMethodInterceptor(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("===begin intercept===");
        Object res = method.invoke(targetObj,objects);
        //Object res =methodProxy.invoke(targetObj,objects);
        System.out.println("===end intercept===");
        return res;
    }
}

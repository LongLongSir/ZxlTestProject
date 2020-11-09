package com.differ.zxl.designpattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyInvocationHandle implements InvocationHandler {

    private Object object;

    public MyProxyInvocationHandle() {

    }

    public MyProxyInvocationHandle(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(proxy);
        Object res=null;
        System.out.println("操作前");
        System.out.println("===method:"+method.getName());
        if(object!=null){
            res = method.invoke(object,args);
        }
        System.out.println("操作后");
        return res;
    }
}

package com.studyspringboot.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAopMethodInterceptorV2  implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("qianV2");
        Object res = invocation.proceed();
        System.out.println("houV2");
        return res;
    }
}

package com.studyspringboot.aop.aspect;

import org.springframework.stereotype.Component;

@Component
public class Business implements IBusiness{

    public void query(String param){
        System.out.println("=====execute query:"+param+"=====");
    }

    public void testException(int i){
        System.out.println("testException");
        System.out.println("10/i="+(10/i));
    }

    public void testArgs(MyAnnotationTest test){
        System.out.println("testArgs");
    }

    public final void testFinal(){
        System.out.println("==testFinal==");
    }

    private static void testPrivateStatic(){
        System.out.println("====testPrivateStatic=====");
    }

}

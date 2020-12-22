package com.studyspringboot.aop;

import com.studyspringboot.aop.aspect.IBusiness;
import com.studyspringboot.aop.aspect.MyAnnotationTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Proxy;

//@Configuration
//@ComponentScan("com.myspringboot.studyspringboot.aop.aspect")
//@EnableAspectJAutoProxy(proxyTargetClass = true)   //即 <aop:aspectj-autoproxy>
                                        // proxyTargetClass 为true则cglib代理，若要代理接口或代理一个代理类型，则用jdk；
                                      //(默认)为false则JDK代理(代理类型是接口子类型),如果没有父接口，则还是用cglib代理
public class AopAspectJConfig {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopAspectJConfig.class);

        IBusiness business = (IBusiness) context.getBean("business");
        business.query("zxl");
        business.testArgs(new MyAnnotationTest());
        System.out.println("=======================");
        //business.testException(0);

//        MyAnnotationTest test= (MyAnnotationTest) context.getBean("myAnnotationTest");
//        test.anno();
//        test.doo();


    }

}

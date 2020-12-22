package com.studyspringboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

    @Pointcut("execution(* com.myspringboot.studyspringboot.aop.aspect.Business.*(..))")
    //@Pointcut("within(com.myspringboot.studyspringboot.aop.aspect.MyAnnotationTest)")  //基于类
    //@Pointcut("args(String)")  //参数类型
    //@Pointcut("args(String,String)||args()")  //可配置多种参数选择，可结合使用
    //@Pointcut("this(com.myspringboot.studyspringboot.aop.aspect.IBusiness)") //this是配代理对象的类型，代理对象是该类型的则会通知到
    //@Pointcut("bean(*business)") //根据beanName匹配
    //@Pointcut("@annotation(com.myspringboot.studyspringboot.aop.anno.MyPoint)")   //基于自定义注解,对有该注解方法进行横切
    //@Pointcut("@target(com.myspringboot.studyspringboot.aop.anno.MyAspect)")   //基于自定义注解，对标记有该注解的类的所有方法横切
    //@Pointcut("@args(com.myspringboot.studyspringboot.aop.anno.AnnoMethodOrType)")  //方法参数类型有该注解，则进行横切
    private void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("========begin Around=========");
        Object[] args = point.getArgs();
        for (Object arg:args) {
            System.out.println("参数："+arg);
        }
        //before 调用
        Object res = point.proceed(args);

        System.out.println("========end Around============");

        //after (finally)
        //afterReturning  /  afterThrowing
        return res;
    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after(即finally块执行)");
    }
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

}

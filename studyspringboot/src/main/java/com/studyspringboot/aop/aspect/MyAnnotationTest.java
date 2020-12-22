package com.studyspringboot.aop.aspect;


import com.studyspringboot.aop.anno.AnnoMethodOrType;
import org.springframework.stereotype.Component;

@Component
//@MyAspect
@AnnoMethodOrType
public class MyAnnotationTest {

    //@MyPoint
    public void anno(){
        System.out.println("======anno=====");
    }

    public void doo(){
        System.out.println("======doo=====");
    }

}

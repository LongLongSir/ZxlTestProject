package com.studyspringboot.aop.aspect;

public interface IBusiness {

    void query(String param);

    void testException(int i);

    void testArgs(MyAnnotationTest test);
}

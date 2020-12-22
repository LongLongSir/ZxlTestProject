package com.differ.zxl.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface AppSwitch {

    String des();

    String code();



}

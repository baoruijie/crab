package com.bao.crab.study.handspring.spring;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {
    String value() default "";
}

package com.bao.crab.study.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

/**
 * 这个在注解类，用来批注类，方法等知识点。
 * 批量任务中 读取有该注解的注释，作为知识点输出。
 */
@Target({ElementType.METHOD,ElementType.TYPE})//作用域
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface Study {
    /**
     * @Description 问题。
     * @return
     */
    String value() default "";

    @AliasFor("value")
    String ask() default "";
    /**
     * @Description 解答。
     * @return
     */
    String comment() default "";

}

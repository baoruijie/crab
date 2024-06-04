package com.bao.crab.study.annotation;

import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc 扫描所有带@Crab注解的类，读取类下的method，
 *       读取method的@Study注解，打印注解内容。
 * @date 2024/6/3 14:46
 */

public class Test {
    public static void main(String[] args) {
        Class cls = Test.class;
        Method[] methods = cls.getDeclaredMethods();
        for(Method method:methods){
            Study study = null;
            //需要添加生命周期为运行时 @Retention(RetentionPolicy.Runtime)，否则无法获取。
            study = method.getAnnotation(Study.class);
            method.setAccessible(true);
            if(study != null){
                String ask = study.ask();String comment = study.comment();System.out.println(ask + comment);
            }
        }
    }
    @Study(ask = "你是谁？",comment = "saoBao")
    public void run(){
        System.out.println("annotation");
    }
}

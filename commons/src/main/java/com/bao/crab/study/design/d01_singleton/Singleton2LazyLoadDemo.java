package com.bao.crab.study.design.d01_singleton;

/**
 * @Desc 懒加载
 * @Author 骚包
 * @Date 2023/1/9 14:48
 * @Version 1.0
 */

public class Singleton2LazyLoadDemo {
    private static Singleton2LazyLoadDemo instance = null;

    private Singleton2LazyLoadDemo(){}

    public static Singleton2LazyLoadDemo getInstance(){
        if(instance == null){
            instance = new Singleton2LazyLoadDemo();
        }
        return instance;
    }

}

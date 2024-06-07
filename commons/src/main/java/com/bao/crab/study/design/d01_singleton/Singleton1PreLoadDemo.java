package com.bao.crab.study.design.d01_singleton;

/**
 * @Desc 预加载
 * @Auth 骚包
 * @Date 2023/1/9 14:48
 * @Version 1.0
 */
public class Singleton1PreLoadDemo {
    private static Singleton1PreLoadDemo instance = new Singleton1PreLoadDemo();

    private Singleton1PreLoadDemo(){}

    public static Singleton1PreLoadDemo getInstance(){
        return instance;
    }
}

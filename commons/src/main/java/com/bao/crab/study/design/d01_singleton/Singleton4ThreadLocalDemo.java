package com.bao.crab.study.design.d01_singleton;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/9 15:17
 */

public class Singleton4ThreadLocalDemo {

    private static ThreadLocal<Singleton4ThreadLocalDemo> threadLocal = new ThreadLocal<>();

    private Singleton4ThreadLocalDemo(){}

    public static Singleton4ThreadLocalDemo getInstance(){
        Singleton4ThreadLocalDemo instance = threadLocal.get();
        if(instance == null){
            synchronized (Singleton4ThreadLocalDemo.class){
                instance = new Singleton4ThreadLocalDemo();
                threadLocal.set(instance);
            }
        }
        // assert instance == threadLocal.get();
        return instance;
    }


}

package com.bao.crab.study.design.d01_singleton;

/**
 * @desc
 * @author 骚包
 * @date 2023/1/9 15:01
 * @version 1.0
 */

public class Singleton3LockDemo {
    private static Singleton3LockDemo instance = null;
    private static Singleton3LockDemo instance2 = null;
    private static volatile Singleton3LockDemo instance3 = null;

    private Singleton3LockDemo(){}

    public static synchronized Singleton3LockDemo getInstance(){
        if(instance == null){
            instance = new Singleton3LockDemo();
        }
        return instance;
    }
    // 2.把sychronized加在if(instance==null)判断语句里面，保证instance未实例化的时候才加锁
    public static synchronized Singleton3LockDemo getInstance2() {
        if (instance2 == null) {
            synchronized (Singleton3LockDemo.class) {
                if (instance2 == null) {
                    instance2 = new Singleton3LockDemo();
                }
            }
        }
        return instance2;
    }

    // 3.new一个对象的代码是无法保证顺序性的，因此，我们需要使用另一个关键字volatile保证对象实例化过程的顺序性
    public static synchronized Singleton3LockDemo getInstance3() {
        if (instance3 == null) {
            synchronized (instance3) {
                if (instance3 == null) {
                    instance3 = new Singleton3LockDemo();
                }
            }
        }
        return instance3;
    }
}

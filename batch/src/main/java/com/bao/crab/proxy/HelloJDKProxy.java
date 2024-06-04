package com.bao.crab.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/13 16:34
 */

public class HelloJDKProxy implements InvocationHandler {

    private Hello target;

    public HelloJDKProxy(Hello hello){
        this.target = hello;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before...");
        Object obj = method.invoke(target,args);
        System.out.println("invoke after...");
        return obj;
    }
}

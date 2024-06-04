package com.bao.crab.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/13 16:57
 */

public class HelloCglibProxy implements MethodInterceptor {

    private Hello target;

    public HelloCglibProxy(Hello hello){
        this.target = hello;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("111");
        Object invoke = methodProxy.invokeSuper(o,objects);
        //method.invoke(target,objects);//这种方式也可以
        //methodProxy.invokeSuper(target,objects);//这种方式报错
        System.out.println("222");
        return invoke;
    }
}

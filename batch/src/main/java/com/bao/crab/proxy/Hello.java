package com.bao.crab.proxy;

import cn.hutool.aop.aspects.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/13 16:16
 */

public class Hello implements HelloService {

    @Override
    public void say(String s){
        System.out.println("hello," + s);
    }

    public final void sayNo(){
        System.out.println("this is final, no !!!");
    }



}

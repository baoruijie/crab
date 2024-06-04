package com.bao.crab.proxy;

import cn.hutool.aop.aspects.Aspect;
import cn.hutool.aop.aspects.SimpleAspect;

import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/13 16:29
 */

public class HelloAspect extends SimpleAspect {
    @Override
    public boolean before(Object target, Method method, Object[] args) {
        System.out.println("before。。 HelloAspect");
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args) {
        System.out.println("after。。 HelloAspect");
        return false;
    }

    @Override
    public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
        System.out.println("afterException");
        return false;
    }
}

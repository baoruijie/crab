package com.bao.crab.study.handspring.spring;

import com.bao.crab.study.handspring.service.OrderInterface;

import java.awt.event.WindowStateListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 17:12
 */

public class SaoBaoBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInit(String beanName, Object bean) {
        System.out.println("postProcessor ...before");
        return bean;
    }

    @Override
    public Object postProcessAfterInit(String beanName, Object bean) {
        System.out.println("postProcessor ...after");
        if(bean instanceof OrderInterface){
            Object proxyInstance = Proxy.newProxyInstance(SaoBaoBeanPostProcessor.class.getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("AOP");
                            return method.invoke(bean,args);
                        }
                    });
            return proxyInstance;
        }
        return bean;
    }

}

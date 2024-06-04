package com.bao.crab.proxy;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.proxy.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/13 16:17
 */

public class Test {

    public static void main(String[] args) {

        proxyUtil();
        System.out.println("===================");
        jdkProxy();
        System.out.println("===================");
        cglibProxy();
    }
    //hutool工具类获取代理
    public static void proxyUtil(){
        HelloService hello = new Hello();
        HelloService proxy = ProxyUtil.proxy(hello,new HelloAspect());

        System.out.println("proxy ==>"+proxy +"   Objects.isNull(obj) = " + Objects.isNull(proxy));
        if(Objects.isNull(proxy)){
            proxy.say("空指针异常1？？？");
        }else{
            proxy.say("空指针异常2？？？");
        }

        HelloService proxy2 = ProxyFactory.createProxy(hello,new HelloAspect());
        proxy2.say("ggggg");
    }
    public static void jdkProxy(){
        Hello hello = new Hello();
        HelloJDKProxy handler = new HelloJDKProxy(hello);
        HelloService proxy = (HelloService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),handler);
        proxy.say("world");
        //接口类里面没有sayNo方法，所以无法通过代理对象调用。

    }
    public static void cglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new HelloCglibProxy(new Hello()));
        Hello proxy = (Hello) enhancer.create();
        proxy.say("haha");
        proxy.sayNo();//final修饰的方法无法生效。

    }
}

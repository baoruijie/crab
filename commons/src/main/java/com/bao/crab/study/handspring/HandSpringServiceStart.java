package com.bao.crab.study.handspring;

import com.bao.crab.study.handspring.spring.ComponentScan;
import com.bao.crab.study.handspring.spring.HandApplicationContext;
import com.bao.crab.study.handspring.service.UserService;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 14:31
 */
@ComponentScan("com.bao.crab.study.handspring.service")
public class HandSpringServiceStart {

    /**
     * 1.new创建对象就是启动spring容器;
     * 2.扫描
     * 3.beanDefinition
     * 4.getBean方法底层实现
     * 5.bean创建过程
     * 6.依赖注入
     * 7.Aware回调
     * 8.初始化
     * 9.BeanPostProcessor机制
     * 10.AOP机制
     * 11.单例池原理
     * 12.@PostConstruct底层原理
     * 13.初始化底层原理
     * 14.推断构造方法底层原理
     * 15.AOP底层原理
     * 16.Spring事务底层原理，及失效原理
     * 17.@Configuration底层实现原理
     * 18.循环依赖，如何解决？
     * 19.什么是提前AOP；
     * 20.三级缓存作用；
     * 21.@Lazy为什么可以解决循环依赖；
     * 22.Spring整合MyBatis底层原理；
     * 23.整合MyBatis代理对象
     * 24.ImportBeanDefinitionRegistry
     * 25.Mapper扫描原理；
     * 26.Spring扫描入口；
     * 27.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        HandApplicationContext context = new HandApplicationContext(HandSpringServiceStart.class);

        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        System.out.println(context.getBean("orderService"));
        userService.test();


    }
}

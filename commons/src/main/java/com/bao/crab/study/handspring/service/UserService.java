package com.bao.crab.study.handspring.service;

import com.bao.crab.study.handspring.spring.Autowired;
import com.bao.crab.study.handspring.spring.Component;
import com.bao.crab.study.handspring.spring.Scope;
import com.bao.crab.study.handspring.spring.BeanNameAware;
import com.bao.crab.study.handspring.spring.InitializingBean;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 14:38
 */

@Component
@Scope
public class UserService implements BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

//    5.beanNameAware回调
    private String beanName;

    private String xxx;

    public void test(){
        System.out.println("userService..." + orderService);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("Aware ==== " + beanName);
    }

    @Override
    public void afterPropertiesSet() {
        this.xxx = "init";
        System.out.println("InitializingBean === " + this.xxx);
    }
}

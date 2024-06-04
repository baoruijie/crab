package com.bao.crab.schedule;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/12/20 09:20
 */

//@Component
class TaskSchedulerJob3 implements InitializingBean, BeanNameAware {

    private String dateCh;


    @Override
    public void setBeanName(String beanName) {
        System.out.println(Thread.currentThread().getName() +"--> "+ "===========>>>>>>>>>>>"+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet。。。");
        this.dateCh = Thread.currentThread().getName() +"--> "+ "现在时间是：";

    }
}

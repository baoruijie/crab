package com.bao.crab.study.handspring.spring;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 17:11
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInit(String beanName,Object bean);
    Object postProcessAfterInit(String beanName,Object bean);

}

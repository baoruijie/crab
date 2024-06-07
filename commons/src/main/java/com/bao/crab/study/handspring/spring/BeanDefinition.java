package com.bao.crab.study.handspring.spring;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 15:42
 */

public class BeanDefinition {
    private Class type;
    private String scope;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}

package com.bao.crab.study.design.d05_prototype;

import lombok.Data;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/10 22:34
 */
@Data
public class Student implements Cloneable{
    private String name;
    private int age;
    private String address;
    public Hobbit hobbit;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}

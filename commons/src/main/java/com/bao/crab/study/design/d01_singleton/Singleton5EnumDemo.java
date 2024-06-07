package com.bao.crab.study.design.d01_singleton;

public class Singleton5EnumDemo {

    private Singleton5EnumDemo(){}

    public static Singleton5EnumDemo getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }
    private enum SingletonEnum{
        INSTANCE;

        private Singleton5EnumDemo instance = null;

        SingletonEnum(){
            instance = new Singleton5EnumDemo();
        }
        private Singleton5EnumDemo getInstance(){
            return instance;
        }
    }
}

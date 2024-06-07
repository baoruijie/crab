package com.bao.crab.study.design.d02_factory;

/**
 * @author 骚包
 * @version 1.0
 * @desc 简单工厂模式有一个问题就是，类的创建依赖工厂类，如果想要拓展程序，必须对工厂类进行修改，这违背了开闭原则，
 * 所以，从设计角度考虑，有一定的问题，如何解决？我们可以定义一个创建对象的抽象方法并创建多个不同的工厂类实现该抽象方法，
 * 这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。这种方法也就是我们接下来要说的工厂方法模式。
 * @date 2023/1/10 16:13
 */

public class SimplePizzaFactory {


    public static void main(String[] args) {
        Pizza pizza1 = SimplePizzaFactory.createPizza("cheese");
        Pizza pizza2 = SimplePizzaFactory.createPizza("cheese");
        System.out.println(pizza1 == pizza2);
    }

    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (orderType.equals("greek")) {
            pizza = new GreekPizza();
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
        }
        return pizza;
    }
}

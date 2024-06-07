package com.bao.crab.study;

import com.bao.crab.study.annotation.Study;

import java.lang.reflect.Method;

/**
 * @author 骚包
 * @version 1.0
 * @desc 扫描所有带@Crab注解的类，读取类下的method，
 *       读取method的@Study注解，打印注解内容。
 * @date 2024/6/3 14:46
 */

public class Test {
    public static void main(String[] args) {
        Class cls = Test.class;
        Method[] methods = cls.getDeclaredMethods();
        for(Method method:methods){
            Study study = null;
            //需要添加生命周期为运行时 @Retention(RetentionPolicy.Runtime)，否则无法获取。
            study = method.getAnnotation(Study.class);
            method.setAccessible(true);
            if(study != null){
                System.out.println(study.ask() + study.comment());
            }
        }
    }
    @Study(ask = "扫描bean是哪一步？",comment = "1.AbstractApplicationContext.invokeBeanFactoryPostProcessors(beanFactory);\n" +
            "2.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());\n" +
            "3.invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry, beanFactory.getApplicationStartup());\n" +
            "4.postProcessor.postProcessBeanDefinitionRegistry(registry);\n" +
            "5.ConfigurationClassPostProcessor.processConfigBeanDefinitions(registry);\n" +
            "6.parser.parse(candidates;\n" +
            "7.processConfigurationClass(new ConfigurationClass(metadata,beanName);\n" +
            "8.sourceClass = doProcessConfigurationClass(sourceClass,configClass);\n" +
            "9.this.componentScanParser.parse(......);\n" +
            "10.scaner.doScan(...);\n" +
            "11.registerBeanDefinition(holder,this.registry);\n" +
            "12.BeanDefinitionReaderUtils.registryBeanDefinition(holder,registry);\n" +
            "13.registry.registryBeanDefinition(beanName,holder.getBeanDefinition())\n")
    public void run(){
        System.out.println("annotation");
    }
}

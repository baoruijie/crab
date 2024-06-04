package com.bao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Field;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/12/20 09:12
 */

@EnableScheduling
@SpringBootApplication(scanBasePackages = { //该注解包含ComponentScan注解。
        "com.bao.crab.simple",
        "com.bao.crab.config"
})
public class ScheduleApplication {
    private static Logger logger = LoggerFactory.getLogger(ScheduleApplication.class);

    public static ConfigurableApplicationContext ac ;

    public static void main(String[] args) {
        ac = SpringApplication.run(ScheduleApplication.class, args);
        BeanFactory bf = ac.getBeanFactory();
        if(bf.containsBean("rabbitTemplate")){

        }
    }


    @Scheduled(fixedDelay = 40000,initialDelay = 3000)
    public void report() throws IllegalAccessException, InstantiationException {
        if(ac!=null){
            //默认无异步是此种方式，
            TaskScheduler taskScheduler = (TaskScheduler)ac.getBean("taskScheduler");
//            taskScheduler--->class org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
            Class clazz = taskScheduler.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field f : fields){
                f.setAccessible(true);
                if("scheduledExecutor".equals(f.getName())){
//                    System.out.println(f.getName()+"\t-->\t"+f.get(taskScheduler));
                }
            }
//            System.out.println("----------------------------------------------");
            TaskExecutor taskExecutor = (TaskExecutor) ac.getBean("taskExecutor");
//            taskExecutor--->class org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
            Class cc = taskExecutor.getClass();
            Field [] ss = cc.getDeclaredFields();
            for(Field f : ss){
                f.setAccessible(true);
                if("threadPoolExecutor".equals(f.getName())){
                    System.out.println(f.getName()+"\t-->\t"+f.get(taskExecutor).toString().substring(45));
                }
            }
        }
    }
}

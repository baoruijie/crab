package com.bao.crab.executor;

import com.bao.crab.util.Print;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/12/20 09:20
 */

//@Component
@Async
class TaskExecutorJobs implements InitializingBean, BeanNameAware {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorJobs.class);
    private String dateCh;
    //cron = "0/1 * * * * ?" 每秒执行一次
    @Scheduled(cron = "0/1 * * * * ?")
    public void job1(){
        logger.info(Print.printTime());

    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println(Thread.currentThread().getName() +"--> "+ "===========>>>>>>>>>>>"+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet。。。");
        this.dateCh = Thread.currentThread().getName() +"--> "+ "现在时间是：";
    }

    @Scheduled(cron = "1 * * * * ?")
    public void job2(){
        System.out.println(Thread.currentThread().getName() +"--> "+ "每分钟第一秒执行一次");
    }

    @Scheduled(fixedRate = 5000)
    public void job3(){
        System.out.println(Thread.currentThread().getName() +"--> "+ "每5秒执行一次。");
    }
    @Scheduled(fixedRate = 6000)
    public void job4(){
        System.out.println(Thread.currentThread().getName() +"--> "+ "每6秒执行一次。");
    }
}

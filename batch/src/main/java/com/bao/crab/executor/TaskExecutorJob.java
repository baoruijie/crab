package com.bao.crab.executor;

import com.bao.crab.util.Print;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @desc
 * @Author 骚包
 * @date 2024/01/2024/1/16 22:41:07
 */
@Component
@Async
public class TaskExecutorJob {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorJob.class);
    private int count =0;

    @Scheduled(cron = "0/1 0/3 * * * *")
    protected void process() {
        method();
    }
    @Scheduled(cron = "0/1 0/3 * * * *")
    protected void process6() {
        method();
    }
    @Scheduled(cron = "0/1 0/3 * * * *")
    protected void process5() {
        method();
    }
    @Scheduled(cron = "0/1 0/3 * * * *")
    protected void process1() {
        method();
    }
    @Scheduled(cron = "0/1 0/3 * * * *")
    protected void process7() {
        method();
    }

    //延迟5秒后执行
//    @Scheduled(fixedRate = 50 ,initialDelay = 5000)
    protected void process2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Print.printTime() +"-50ms--> " +(count++) +" 项目启动后 延迟5秒后执行");
    }

    //	@Scheduled(fixedRate = 5000 )
    protected void process3() {
        logger.info(Print.printTime() +"--> " +(count++) +" fixedRate = 1000 任务开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(Print.printTime() +"--> " +(count++) +"fixedRate = 1000 任务结束");
    }

//    @Scheduled(fixedDelay = 5000 )
    protected void process4() {
        logger.info(Print.printTime() +"--> " +(count++) +"fixedDelay = 1000  任务开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(Print.printTime() +"--> " +(count++) +"fixedDelay = 1000  任务结束");
    }
    public void method(){
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

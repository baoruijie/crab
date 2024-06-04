package com.bao.crab.schedule;

import com.bao.crab.util.Print;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @desc
 * @Author 骚包
 * @date 2024/01/2024/1/16 22:40:25
 */

//@Component
public class TaskSchedulerJob {

    private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerJob.class);

    //
    @Scheduled(cron = "0/1 * * * * ?")
    public void job1(){
        Print.printTime();
    }

    @Scheduled(fixedRate = 2000)
    public void testFixRate(){
        logger.info(Print.printTime() + "fixedRate = 2000 begin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(Print.printTime() + "fixedRate = 2000 end");
        logger.info("结论：fixedRate 以开始时间为准，当执行时间超过间隔时间时，在执行结束后立马执行-----------------------------");
    }

    @Scheduled(fixedDelay = 5000)
    public void testFixDelay(){
        logger.info(Print.printTime() + "fixedDelay = 5000 begin");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info(Print.printTime() + "fixedDelay = 5000 end");
        logger.info("总结：fixedDelay的任务时间间隔为 设置的时间间隔加执行时间-----------------------------");
    }

    //    @Scheduled(fixedDelay = 1000) //同(fixedDelayString = "1000")
    public void job2(){
        logger.info("fixedDelay 1000" +"--> "+ "没有cron表达式是不是只执行一次？不，会报错。必须存在注解值");
    }


}

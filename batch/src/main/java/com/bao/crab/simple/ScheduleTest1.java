package com.bao.crab.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/12/20 09:20
 */

@Component
class ScheduleTest1 implements InitializingBean, BeanNameAware {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTest1.class);

    private String dateCh;
    @Scheduled(fixedRate = 34000)
    public void printCurrentTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        logger.info(dateCh+sdf.format(date));
        //System.out.println(dateCh + sdf.format(date));
    }

    @Scheduled(cron = "3/15 4/5 * * * ?")
    private void printCronExpresion(){
        logger.info("============================================================");
        logger.info("'*'代表每，'-'代表周期，'n/m'代表从n开始，每m时间，'n,m'代表具体时间，'?'代表不指定。其中日和周可能会冲突，所以一般指定日的时候，周用问号表示，指定周的时候日用问号表示。");
        logger.error("根据观察，使用斜杠的时候，最好每隔多少时间是60的约数。比如[0/59 * * * * ?]看似从0秒开始，每59秒执行1次，实际情况会导致每0秒，59秒执行");
        logger.info("从左到右依次是 秒，分，小时，日，月，周，年。其中年可以省略。");
        logger.info("[3/15 * * * * ?]{}","从第三秒开始，每隔15秒执行一次");
        logger.info("[3/15 4/5 * * * ?]{}","在04分，09分，14分。。。的第3秒开始，每15秒执行一次");
        logger.info("[4/15 4,9 * * * ?]{}","仅在04分，09分的第3秒开始，每15秒执行一次");
        logger.info("那如何解决呢？此时需要两个或两个以上表达式搭配使用");

    }

    //@Scheduled(cron = "* * * 8-12 * ?")
    private void printCronExpresion1(){

        logger.info("23424");

    }

    @Override
    public void setBeanName(String beanName) {

        System.out.println("===========>>>>>>>>>>>"+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet。。。");
        this.dateCh = "现在时间是：";

    }
}

package com.bao.crab.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/14 10:39
 */

@Component
public class SpringbootLifeCircle {
    private static Logger logger = LoggerFactory.getLogger(SpringbootLifeCircle.class);

    private String dateCh;
    @Scheduled(fixedRate = 30000)
    public void printCurrentTime(){
        int i = 0;
        logger.info(++i + "main方法SpringApplication.run(ScheduleApplication.class, args)启动");
        logger.info(++i + "refreshContext()->添加所有beanDefinition.");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("");

    }
}

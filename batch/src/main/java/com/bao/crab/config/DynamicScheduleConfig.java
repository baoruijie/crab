package com.bao.crab.config;

import com.bao.crab.util.Print;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @desc
 * @Author 骚包
 * @date 2024/01/2024/1/13 10:14:10
 */
//@Configuration
public class DynamicScheduleConfig implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DynamicScheduleConfig.class);
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
            () -> logger.info(Print.printTime() + "--> Hello World"),
                triggerContext -> {
                    String cron = "*/2 * * * * ?";//cronMapper.getCron();
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

//    @Mapper
//    public interface CronMapper{
//
//        @Select("select cron from cron limit 1")
//        public String getCron();
//    }
//    @Autowired
//    private CronMapper cronMapper;


}

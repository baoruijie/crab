package com.bao.crab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * spring.task.execution.pool.core-size: 50 #核心任务数量。
 * spring.task.execution.pool.max-size: 1000
 * spring.task.execution.pool.queue-capacity: 1000
 * spring.task.scheduling.thread-name-prefix: schedule-
 * spring.task.scheduling.pool.size: 38
 * 可在配置文件中配置，也可以通过bean的方式设置修改默认参数。
 */
@Configuration
public class TaskConfig {

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
        poolTaskScheduler.setPoolSize(25);
        poolTaskScheduler.setThreadNamePrefix("Scheduler-");
        return poolTaskScheduler;
    }

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(8);
        poolTaskExecutor.setThreadNamePrefix("Executor-");
        poolTaskExecutor.setMaxPoolSize(60);
        poolTaskExecutor.setQueueCapacity(200);
        poolTaskExecutor.setKeepAliveSeconds(1);
        poolTaskExecutor.setRejectedExecutionHandler( (r, Executor)-> System.out.println("queue full ..."));
        return poolTaskExecutor;
    }
//    ThreadPoolExecutor executor = new ThreadPoolExecutor(5,20,200, TimeUnit.MINUTES,new BlockingArrayQueue<>(500),ThreadFactory, RejectedExecutionHandler)

}

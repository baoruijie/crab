package com.bao.crab.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Readme {
    private static final Logger logger = LoggerFactory.getLogger(Readme.class);

    /**
     * fixedRate 每隔一定时间执行一次，单位豪秒
     */
    @Scheduled(fixedRate = 14000)
    public void job(){
        System.out.println(Thread.currentThread().getName() +"--> "+ "if no @Async annotation or Pool configuration,every job execute by the same thread. ");
        System.out.println(Thread.currentThread().getName() +"--> "+ "so we can add @Async解决[可加在方法上，也可以加类上]。");
        System.out.println(Thread.currentThread().getName() +"--> "+ "also 通过线程池方式, see ScheduleConfig.java" );
        System.out.println(Thread.currentThread().getName() +"--> "+ "从线程名字来看，执行完方法后即释放线程，等下次执行时重新获取。");
        System.out.println(Thread.currentThread().getName() +"--> "+ "@Async注解的方式还可以定义异步Future返回。");
        System.out.println(Thread.currentThread().getName() +"--> "+ "注意：使用@Async后，ScheduleConfig.java的配置就没有效果了，等于交给spring来控制线程的数量" +
                "如需自己定义，使用ThreadPoolTaskSchedule方式。");
        System.err.println(Thread.currentThread().getName() +"--> "+ "注意：使用@Async期底层是一个无界队列，所以不要直接使用@Async方式，可能会导致任务过多积压导致内存溢出。" +
                "【当定时任务过多，单个任务执行时间过长，导致任务积压，任务队列过大】");
        System.out.println("@Async注解 实际使用的是 TaskExecutor \n  配置方式  实际使用的是 TaskScheduler \n" +
                "默认即无注解的情况，有且仅有一个线程在执行任务，可查看TaskScheduler子类ThreadPoolTaskScheduler \n" +
                "当被@Async注解后，使用的是TaskExecutor，默认8个核心线程，子类 ThreadPoolTaskExecutor\n" +
                "根据其后缀可判断其是受spring控制的任务还是异步任务。");
        System.out.println("");
        System.out.println("fixedRate 理解起来比较麻烦，它的间隔时间是根据上次任务开始的时候计时的");
        System.out.println("fixedDelay 它的间隔时间是根据上次的任务结束的时候开始计时的");
        System.out.println("cron表达式若定义每秒执行，但是执行时间超过1秒，则会在任务结束后下一个满足表达式的时间点执行任务。" +
                "此方式与fixedDelay不同，如cron每秒执行，执行时间2.8秒，则下一个任务将会在0.2秒后开始。" +
                "当然，当cron任务同时有@Async修饰后，变为异步任务，无论程序执行多久，都每秒执行。");
        System.out.println("@Scheduled(cron = \"0/2 * * * * ?\") 意思是从第0秒开始，每隔2秒执行一次 \n" +
                "@Scheduled(cron = \"30/1 * * * * ?\") 同理，从30秒开始，每隔1秒执行一次");
    }

}

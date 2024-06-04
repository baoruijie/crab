package com.bao.crab.executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 2.为什么execute方法执行抛出了异常，而submit却没有异常抛出?
 * 答:  execute()在juc.ThreadPoolExecutor#runWorker中抛出运行异常，在java.lang.ThreadGroup#uncaughtException进行了异常处理。
 *      看submit源码，submit传进来的task会被封装成 FutureTask(RunnableFuture 实现类)，再包装成callable,后调用execute,最后返回future.
 *      调用run方法，其实是FutureTask的run方法，异常捕获后，setException(ex);异常被保存，在report方法中抛出异常，而最终在get方法中调用report.
 * 3.发生异常后，异常线程是否回收？
 * 答：说回收其实不太准确，线程执行最后会调用 processWorkExit,先remove,后重新addWork(null,false)新建一个新的线程放到线程池。
 *
 *
 * 说说submit和execute的区别。
 * 1.execute()方法的返回值是void,线程提交后无法得到线程的返回值。
 * 2.submit()方法返回值是Future,通过Future的get()方法获取执行返回值。get()方法是同步的，执行方法时，如果线程还没有执行完，会同步等到，直到线程执行完毕。
 * 3.submit()三种重载，支持参数Callable,Runnable
 *
 */
public class TaskSubmitAndExecuteDiff {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadPoolTaskScheduler 区别。
        ThreadPoolTaskExecutor poolTaskExecutor = buildExecutors();
        /**Start 注意这里虽然写法一样，但实际会根据是否有返回值来决定类型是Runnable还是Callable*/
        poolTaskExecutor.execute(()-> function(100));
        Future future1 = poolTaskExecutor.submit(()->  function(100));
        System.out.println("future result..1." + future1.get());
        /**End ***********参考底部注释：LAMBDA表达式的两种参数类型。**************************/
        Future future2 = poolTaskExecutor.submit(() -> function2(100));
        System.out.println("future result..2." + future2.get());


        poolTaskExecutor.execute(()-> errorMethod("execute"));
        Future future3 = poolTaskExecutor.submit(()->  errorMethod("submit"));
        Future future66 = poolTaskExecutor.submit(()-> 1/0);
        Future future77 = poolTaskExecutor.submit((Runnable) () -> {
            throw new RuntimeException("fff");
        });

        try {
            future3.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            future77.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
            System.out.println("66"+future66.get());
        } catch (Exception e){
            e.printStackTrace();
        }

        Future future88 = poolTaskExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() {
                return new RuntimeException("ggg");
            }
        });
        try {
            System.out.println("8888"+future88.get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void errorMethod(String mark){
        System.out.println(mark);
        throw new RuntimeException(Thread.currentThread().getName()+"-"+mark+ "出现异常");

    }
    private static void function2(int i){
        int sum = 0;
        for (int j = 0; j <=i ; j++) {
            sum+=j;
        }
        System.out.println(sum);
    }

    private static int function(int i){
        int sum = 0;
        for (int j = 0; j <=i ; j++) {
            sum+=j;
        }
        return sum;
    }

    private static ThreadPoolTaskExecutor buildExecutors(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(2);
        poolTaskExecutor.setThreadNamePrefix("Executor-");
        poolTaskExecutor.setMaxPoolSize(5);
        poolTaskExecutor.setQueueCapacity(20);
        poolTaskExecutor.setKeepAliveSeconds(10);
        poolTaskExecutor.setRejectedExecutionHandler( (r, Executor)-> System.out.println("queue full ..."));
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }

    /**
     *
     * LAMBDA表达式的两种参数类型。
     *  future =poolTaskExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() {
                return function(100);
            }
        });
        future =poolTaskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                function(100);
            }
        });
     */
}

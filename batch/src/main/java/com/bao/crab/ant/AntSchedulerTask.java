package com.bao.crab.ant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

public class AntSchedulerTask {


    private  final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ThreadPoolExecutor threadPool;


    public String getName() {
        return "callbackHandler";
    }


    /*public Result handle(Context context) {
        LOGGER.info("[CallbackHandler] handle callback job");
        Random random = new Random();
        int sleepTime = random.nextInt(5000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            return Result.failure("sleep error");
        }
        int num = random.nextInt(100);
        if (num > 50) {
            return Result.failure("handle failed");
        } else {
            return Result.ok();
        }
    }*/


    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    /**
     * Setter method for property threadPool.
     *
     * @param threadPool value to be assigned to property threadPool
     */
    public void setThreadPool(ThreadPoolExecutor threadPool) {
        this.threadPool = threadPool;
    }

}

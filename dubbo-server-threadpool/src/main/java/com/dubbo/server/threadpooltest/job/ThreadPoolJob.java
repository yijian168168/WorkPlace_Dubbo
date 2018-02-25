package com.dubbo.server.threadpooltest.job;

import com.dubbo.server.threadpooltest.threadpool.DubboThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhangQingrong
 * @date 2018/2/25 14:46
 */
@Component
public class ThreadPoolJob {

    /**
     * 线程池观测
     * */
    @Scheduled(cron = "0/1 * * * * ?")
    public void dubboThreadPoolMonitoring(){
        ThreadPoolExecutor threadPoolExecutor = DubboThreadPool.getThreadPoolExecutor();
        System.out.println("poolSize : " + threadPoolExecutor.getPoolSize() + "\t\t, queueSize : " + threadPoolExecutor.getQueue().size());
    }
}

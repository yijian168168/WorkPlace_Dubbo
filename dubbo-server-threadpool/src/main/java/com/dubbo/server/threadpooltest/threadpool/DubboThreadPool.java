package com.dubbo.server.threadpooltest.threadpool;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.threadpool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * dubbo 线程池扩展点
 *
 * @author ZhangQingrong
 * @date 2018/2/25 13:56
 */
@Component
public class DubboThreadPool implements ThreadPool {

    public Executor getExecutor(URL url) {
        return DubboThreadPool.getThreadPoolExecutor();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return ThreadPoolTaskExecutorHolder.threadPoolTaskExecutor.getThreadPoolExecutor();
    }

    private static class ThreadPoolTaskExecutorHolder {
        private static ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        static {
            threadPoolTaskExecutor.setCorePoolSize(100);
            threadPoolTaskExecutor.setMaxPoolSize(200);
            threadPoolTaskExecutor.setQueueCapacity(500);
            threadPoolTaskExecutor.setKeepAliveSeconds(10);
            threadPoolTaskExecutor.initialize();
        }
    }
}

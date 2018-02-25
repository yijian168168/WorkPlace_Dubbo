package com.dubbo.server.threadpooltest.service.impl;

import com.dubbo.server.threadpooltest.service.MyDubboService;
import com.dubbo.server.threadpooltest.threadpool.DubboThreadPool;
import org.springframework.stereotype.Component;

/**
 * @author ZhangQingrong
 * @date 2018/2/25 14:14
 */
@Component
public class MyDubboServiceImpl implements MyDubboService {

    public void createOrder() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

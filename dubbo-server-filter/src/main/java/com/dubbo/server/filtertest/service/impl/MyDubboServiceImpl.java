package com.dubbo.server.filtertest.service.impl;

import com.dubbo.server.filtertest.service.MyDubboService;
import org.springframework.stereotype.Component;

/**
 * @author ZhangQingrong
 * @date 2018/2/25 14:14
 */
@Component
public class MyDubboServiceImpl implements MyDubboService {

    public void createOrder() {
        System.out.println("receive msg .....");
    }
}

package com.dubbo.client.dubbo.config;

import com.alibaba.dubbo.config.*;
import com.dubbo.intf.dubbo.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ZhangQingrong
 * @date 2018/1/22 14:51
 */
@Component
public class DubboCustomerConfig {

    @PostConstruct
    public void init(){
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-service");

        //注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.7.21:3181");

        //引用服务
        ReferenceConfig<DubboService> reference = new ReferenceConfig();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface("com.dubbo.intf.dubbo.DubboService");
        reference.setCheck(false);
        DubboService dubboService = reference.get();
    }
}

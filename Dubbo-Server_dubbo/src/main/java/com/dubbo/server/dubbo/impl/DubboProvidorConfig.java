package com.dubbo.server.dubbo.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.intf.dubbo.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ZhangQingrong
 * @date 2018/1/22 14:49
 */
@Component
public class DubboProvidorConfig {

    @Autowired
    private DubboService dubboService;

    @PostConstruct
    public void init(){
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-service");

        //注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.7.21:3181");

        //协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20990);
        protocolConfig.setThreads(20);
        protocolConfig.setName("dubbo");

        //服务配置
        ServiceConfig<DubboService> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRef(dubboService);

        //暴露及注册服务
        serviceConfig.export();

    }
}

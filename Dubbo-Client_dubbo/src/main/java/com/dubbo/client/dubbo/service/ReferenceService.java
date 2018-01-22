package com.dubbo.client.dubbo.service;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;
import com.dubbo.intf.dubbo.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangQingrong on 2017/5/23.
 */
@Component
public class ReferenceService {

    @Autowired
    private ApplicationContext applicationContext;

    public DubboRespInfo dubboService(DubboSendInfo sendInfo) {

        //更改不同的Dubbo服务暴露的ip地址&端口
        String url = "dubbo://192.168.86.58:20880";

        ReferenceBean<DubboService> referenceBean = new ReferenceBean<DubboService>();
        referenceBean.setApplicationContext(applicationContext);
        referenceBean.setInterface(com.dubbo.intf.dubbo.DubboService.class);
        referenceBean.setUrl(url);
        DubboRespInfo dubboRespInfo = null;
        try {
            referenceBean.afterPropertiesSet();
            DubboService dubboService = referenceBean.get();
            dubboRespInfo = dubboService.service(sendInfo);
            System.out.print(dubboRespInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dubboRespInfo;
    }
}

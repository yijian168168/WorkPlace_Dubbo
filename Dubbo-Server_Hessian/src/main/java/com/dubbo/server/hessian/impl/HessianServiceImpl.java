package com.dubbo.server.hessian.impl;

import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;
import com.dubbo.intf.dubbo.DubboService;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangQingrong on 2017/6/20.
 */
//@Service
public class HessianServiceImpl implements DubboService {

    @PostConstruct
    public void init(){
        System.out.println("start ...................................");
    }

    public String service(String recMsg) {
        System.out.println(recMsg);
        return "success";
    }

    public DubboRespInfo service(DubboSendInfo sendInfo) {
        System.out.println(sendInfo.toString());
        DubboRespInfo dubboRespInfo = new DubboRespInfo();
        dubboRespInfo.setInfo("hello success !");
        return dubboRespInfo;
    }
}

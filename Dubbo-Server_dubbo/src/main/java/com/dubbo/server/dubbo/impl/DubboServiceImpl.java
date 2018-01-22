package com.dubbo.server.dubbo.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;
import com.dubbo.intf.dubbo.DubboService;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.Map;

/**
 * Created by zhangqingrong on 2016/5/7.
 */
@Service
public class DubboServiceImpl implements DubboService{

    public String service(String recMsg) {
        System.out.println("======logId====== : " + MDC.get("LOG_ID"));
        System.out.println(recMsg);
        String respMsg = "I am dubbo Server , I get your message .";
        return respMsg;
    }

    public DubboRespInfo service(DubboSendInfo sendInfo) {
        System.out.println(sendInfo.getInfo());
        DubboRespInfo respInfo = new DubboRespInfo();
        respInfo.setInfo("I am dubbo Server , I get your message [" + sendInfo.getInfo() + "]");
        return respInfo;
    }
}

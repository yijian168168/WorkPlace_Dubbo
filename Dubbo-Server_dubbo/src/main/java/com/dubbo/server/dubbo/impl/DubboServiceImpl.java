package com.dubbo.server.dubbo.impl;

import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;
import com.dubbo.intf.dubbo.DubboService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangqingrong on 2016/5/7.
 */
@Service
public class DubboServiceImpl implements DubboService{

    private String pgw1201_6531;

    public String service(String recMsg) {
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

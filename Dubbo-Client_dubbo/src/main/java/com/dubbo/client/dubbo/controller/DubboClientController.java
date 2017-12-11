package com.dubbo.client.dubbo.controller;

import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;
import com.dubbo.client.dubbo.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangqingrong on 2016/5/7.
 */
@Controller
public class DubboClientController{

//    @Autowired
//    private DubboService dubboService;

    @Autowired
    private ReferenceService referenceService;

   /* @ResponseBody
    @RequestMapping("stringService")
    public String stringService(String recMsg){
        System.out.println(recMsg);
        String respMsg = dubboService.service(recMsg);
        System.out.println(respMsg);
        return respMsg;
    }

    @ResponseBody
    @RequestMapping("objectService")
    public String objectService(String recMsg){
        System.out.println(recMsg);
        DubboSendInfo sendInfo = new DubboSendInfo();
        sendInfo.setInfo(recMsg);
        DubboRespInfo respInfo = dubboService.service(sendInfo);
        System.out.println(respInfo.getInfo());
        return respInfo.getInfo();
    }*/


    @ResponseBody
    @RequestMapping("objectService")
    public String objectService(String recMsg){
        System.out.println(recMsg);
        DubboSendInfo sendInfo = new DubboSendInfo();
        sendInfo.setInfo(recMsg);
        DubboRespInfo respInfo = referenceService.dubboService(sendInfo);
        System.out.println(respInfo.getInfo());
        return respInfo.getInfo();
    }

}

package com.dubbo.intf.dubbo;

import com.dubbo.bean.dubbo.DubboRespInfo;
import com.dubbo.bean.dubbo.DubboSendInfo;

/**
 * 接收dubbo协议的服务
 *
 * Created by zhangqingrong on 2016/5/7.
 */
public interface DubboService {

    public String service(String recMsg);

    public DubboRespInfo service(DubboSendInfo sendInfo);

}

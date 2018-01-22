package com.dubbo.server.dubbo.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * @author ZhangQingrong
 * @date 2017/12/28 15:09
 */
public class LogFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String logId = RpcContext.getContext().getAttachment("LOG_ID");
        MDC.put("LOG_ID" ,logId);
        System.out.println("dubbo filter : " + MDC.get("LOG_ID"));
        return invoker.invoke(invocation);
    }

}

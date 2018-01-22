package com.dubbo.client.dubbo.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * @author ZhangQingrong
 * @date 2017/12/28 15:09
 */
public class LogFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext.getContext().setAttachment("LOG_ID" , MDC.get("LOG_ID"));
        System.out.println("dubbo filter : " + RpcContext.getContext().getAttachment("LOG_ID"));
        return invoker.invoke(invocation);
    }

}

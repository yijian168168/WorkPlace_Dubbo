package com.dubbo.server.filtertest.filter;

        import com.alibaba.dubbo.rpc.*;
        import org.slf4j.MDC;

/**
 * @author ZhangQingrong
 * @date 2017/12/28 15:09
 */
public class LogFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Class<?> anInterface = invoker.getInterface();
        System.out.println("class name : " + anInterface.getName());
        System.out.println("method name : " + invocation.getMethodName());
        RpcContext.getContext().setAttachment("LOG_ID" , MDC.get("LOG_ID"));
        System.out.println("dubbo filter : " + RpcContext.getContext().getAttachment("LOG_ID"));
        return invoker.invoke(invocation);
    }

}

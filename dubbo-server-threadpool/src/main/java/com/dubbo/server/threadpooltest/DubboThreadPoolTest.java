package com.dubbo.server.threadpooltest;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.dubbo.server.threadpooltest.service.MyDubboService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhangQingrong
 * @date 2018/2/25 14:20
 */
public class DubboThreadPoolTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:etc/Spring-Context.xml");
        applicationContext.start();
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDubboThreadPool() {
        //更改不同的Dubbo服务暴露的ip地址&端口
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:etc/Spring-dubbo-client.xml");
        final ReferenceBean<MyDubboService> referenceBean = new ReferenceBean<MyDubboService>();
        referenceBean.setApplicationContext(applicationContext);
        referenceBean.setInterface(MyDubboService.class);
        try {
            referenceBean.afterPropertiesSet();
            for (int i = 0; i < 650; i++) {
                new Thread() {
                    @Override
                    public void run() {
                        MyDubboService dubboService = referenceBean.get();
                        dubboService.createOrder();
                    }
                }.start();
                Thread.sleep(100);
            }
            Thread.sleep(600000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

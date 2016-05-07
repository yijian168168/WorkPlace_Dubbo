package com.dubbo.bean.dubbo;

import java.io.Serializable;

/**
 * Created by zhangqingrong on 2016/5/7.
 */
public class DubboRespInfo implements Serializable{

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

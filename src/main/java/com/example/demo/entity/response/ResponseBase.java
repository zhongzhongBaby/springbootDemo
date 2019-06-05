package com.example.demo.entity.response;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResponseBase implements Serializable {

    private static final long serialVersionUID = 1L;
    private int code = 10000; // 状态码
    private String msg = "请求成功"; // 响应消息
    private Map<String,Object> data = new ConcurrentHashMap<>();
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }




}

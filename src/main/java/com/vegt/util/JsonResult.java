package com.vegt.util;

import org.omg.PortableInterceptor.INACTIVE;

/*封装服务器给浏览器的响应符数据*/
public class JsonResult<T> {
    private Integer state;
    private String message;
    private T data;

    public JsonResult(Integer state) {
        this.state =state;
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(String message) {
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

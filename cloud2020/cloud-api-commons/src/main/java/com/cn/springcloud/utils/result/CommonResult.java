package com.cn.springcloud.utils.result;

public class CommonResult<T>{
    public T data;
    public int code;
    public String message;

    public CommonResult() {
    }

    public CommonResult(int code, String message) {
        this.data = data;
        this.code = code;
    }

    public CommonResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

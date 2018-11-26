package com.program.vo;

import java.io.Serializable;

public class Msg4Ws<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;//消息编号
    private String msg;//消息描述
    private T data;//消息实体

    public Msg4Ws(int code) {
        this.code = code;
    }

    public Msg4Ws(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Msg4Ws(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Msg4Ws(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

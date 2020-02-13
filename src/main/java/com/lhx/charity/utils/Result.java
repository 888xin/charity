package com.lhx.charity.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 */
@Data
public class Result<T> implements Serializable {
    //提示信息
    private String msg;
    private Integer code;
    //具体的内容
    private T data;

    public Result() {
    }

    public Result(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}


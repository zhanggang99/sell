package com.zg.sell.domain;

//http请求返回的最外层对象

import lombok.Data;
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
}

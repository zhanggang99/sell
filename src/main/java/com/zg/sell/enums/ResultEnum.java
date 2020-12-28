package com.zg.sell.enums;

import lombok.Data;

public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ERROR(1,"失败")
    ;

    //进一步优化：异常code和msg通过异常枚举来统一管理。
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

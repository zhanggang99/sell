package com.zg.sell.error;

public class BusinessException extends RuntimeException {
    public BusinessException(){}
    public BusinessException(String message){
        super(message);
    }
}

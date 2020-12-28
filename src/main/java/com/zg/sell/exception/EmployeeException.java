package com.zg.sell.exception;

import com.zg.sell.enums.ResultEnum;
import lombok.Data;

@Data
public class EmployeeException extends RuntimeException{
    //进一步优化：小学对应code100，初中对应code101。通过写一人自己的exception来处理。
    // 继承RuntimeException,可以保证异常时事务回溯，则继承Exception则不会。同时要添加一个构造方法，把code赋值上。
    private Integer code;
//    public EmployeeException(Integer code,String message){
//        super(message);
//        this.code=code;
//        //https://www.imooc.com/video/14347
//    }
//    使用错误枚举：
    public EmployeeException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

}

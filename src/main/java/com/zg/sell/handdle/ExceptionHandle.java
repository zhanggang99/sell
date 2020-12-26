package com.zg.sell.handdle;

import com.zg.sell.domain.Result;
import com.zg.sell.exception.EmployeeException;
import com.zg.sell.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    //优化：添加一个异常处理类，统一捕获并包装异常：同时日志也不会再抛出异常了：

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof EmployeeException){
            EmployeeException exception = (EmployeeException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }
        return ResultUtil.error(-1, "未知错误");
    }
}

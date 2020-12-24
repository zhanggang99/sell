package com.zg.sell.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//描述：统一业务异常处理类
@ControllerAdvice(basePackages = {"com.zg.sell",})
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest req,Exception e)throws Exception{
        ErrorInfo errorInfo=new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }
}

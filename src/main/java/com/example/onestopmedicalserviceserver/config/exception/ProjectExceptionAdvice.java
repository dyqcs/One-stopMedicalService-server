package com.example.onestopmedicalserviceserver.config.exception;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //1、系统异常
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        //记录日志
        //发送给运维
        //发送给开发者
        System.err.println(e);
        return new Result(Code.GET_ERR,null,"系统异常...");
    }

    //2、业务异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){

        System.err.println(e);
        return new Result(Code.GET_ERR,null,"业务异常...");
    }

    //3、其他异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //记录日志
        //发送给运维
        //发送给开发者
        System.err.println(e);
        System.out.println("嘿嘿异常哪有跑....");
        return new Result(Code.GET_ERR,null,"系统异常...");
    }
}

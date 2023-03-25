package com.office.common.config.exception;

import com.office.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 异常处理器
 * @Author whi5p3r
 * @Date 2023/3/13 10:37 PM
 * @Version v1.0
 */

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> error(Exception e){
        e.printStackTrace();
        return Result.fail(e.getMessage()).message("全局异常捕捉");
    }
    // 特定异常处理
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result<String> error(RuntimeException e){
        e.printStackTrace();
        return Result.fail(e.getMessage()).message("运行时异常捕捉");
    }
    // 自定义异常处理
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> error(CustomException e){
        e.printStackTrace();
        return Result.fail(e.getMsg()).message("自定义异常处理").code(e.getCode());
    }
}

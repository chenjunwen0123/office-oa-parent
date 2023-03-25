package com.office.common.config.exception;

import com.office.common.ResultCodeEnum;
import lombok.Data;

/**
 * @Description 自定义异常类
 * @Author whi5p3r
 * @Date 2023/3/13 10:46 PM
 * @Version v1.0
 */
@Data
public class CustomException extends RuntimeException{
    private Integer code;
    private String msg;

    /**
     * 通过状态码和报错消息创建异常对象
     * @param code 状态码
     * @param msg 错误消息
     */
    public CustomException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 通过枚举类型创建异常类
     * @param codeEnum 枚举类型对象
     */
    public CustomException(ResultCodeEnum codeEnum){
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}

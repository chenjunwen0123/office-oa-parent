package com.office.common;

import lombok.Getter;

/**
 * @Description 统一返回结果状态信息集
 * @Author whi5p3r
 * @Date 2023/3/10 10:23 PM
 * @Version v1.0
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    SERVICE_ERROR(404,"服务异常"),
    DATA_ERROR(403,"数据异常"),
    LOGIN_AUTH(402,"未登录"),
    PERMISSION(401,"没有权限")
    ;

    private Integer code;
    private String msg;
    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

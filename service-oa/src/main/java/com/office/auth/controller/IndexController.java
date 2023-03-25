package com.office.auth.controller;

import com.office.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 首页相关接口
 * @Author whi5p3r
 * @Date 2023/3/17 12:07 AM
 * @Version v1.0
 */
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @PostMapping("/login")
    public Result<Map<String,Object>> login(){
        Map<String,Object> response = new HashMap<>();
        response.put("token","admin");
        return Result.ok(response);
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> info(@RequestParam(value = "token",required = false)String token){
        Map<String,Object> response = new HashMap<>();
        response.put("name","admin");
        response.put("roles", Collections.singletonList("admin"));
        response.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(response);
    }
    @PostMapping("/logout")
    public Result<String> logout(){
        return Result.ok("退出成功");
    }
}

package com.office.system.controller;

import com.office.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
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
        response.put("token","admin-token");
        return Result.ok(response);
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> info(@RequestParam("token")String token){
        Map<String,Object> response = new HashMap<>();
        response.put("name","admin");
        response.put("roles", Collections.singletonList("admin"));
        response.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(response);
    }
}

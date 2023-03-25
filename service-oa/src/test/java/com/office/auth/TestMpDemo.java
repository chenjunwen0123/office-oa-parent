package com.office.auth;

import com.office.auth.mapper.SysRoleMapper;
import com.office.auth.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestMpDemo {
    // 注入
    @Resource
    private SysRoleService sysRoleService;
    @Test
    public void getAll(){

    }
}

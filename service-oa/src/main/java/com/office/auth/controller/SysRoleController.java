package com.office.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.office.auth.service.SysRoleService;
import com.office.common.Result;
import com.office.model.system.SysRole;
import com.office.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "系统角色相关")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @ApiOperation("系统角色相关-查询全部角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll(){
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation("系统角色相关-分页查询角色")
    @GetMapping("/{pageNo}/{pageSize}")
    public Result<IPage<SysRole>> rolePage(@PathVariable(value = "pageNo") Integer pageNo,
                                           @PathVariable(value = "pageSize") Integer pageSize,
                                           SysRoleQueryVo sysRoleQueryVo){
        IPage<SysRole> pageInfo = new Page<>(pageNo,pageSize);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(sysRoleQueryVo.getRoleName()), SysRole::getRoleName, sysRoleQueryVo.getRoleName());
        return Result.ok(sysRoleService.page(pageInfo,wrapper));
    }
    @ApiOperation("系统角色相关-添加新角色")
    @PostMapping("/save")
    public Result<String> save(@RequestBody SysRole sysRole){
        boolean isSuccessful = sysRoleService.save(sysRole);
        if(isSuccessful){
            return Result.ok("添加成功");
        }else{
            return Result.fail("添加失败");
        }
    }
    @ApiOperation("系统角色相关-通过角色Id查询并更新角色")
    @PostMapping("/update")
    public Result<String> update(@RequestBody SysRole sysRole){
        boolean isSuccessful = sysRoleService.updateById(sysRole);
        if(isSuccessful){
            return Result.ok("更新成功");
        }else{
            return Result.fail("更新失败");
        }
    }
    @ApiOperation("系统角色相关-通过角色Id查询角色")
    @PostMapping("/getById/{id}")
    public Result<SysRole> getById(@PathVariable Long id){
        SysRole result = sysRoleService.getById(id);
        if(ObjectUtils.isNotEmpty(result)){
            return Result.ok(result);
        }else{
            return Result.fail(null);
        }
    }

    @ApiOperation("系统角色相关-根据角色Id删除")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteById(@PathVariable Long id){
        boolean isSuccessful = sysRoleService.removeById(id);
        if(isSuccessful){
            return Result.ok("删除成功");
        }else{
            return Result.fail("删除失败");
        }
    }

    @ApiOperation("系统角色相关-批量删除角色")
    @DeleteMapping("/deleteBatch")
    public Result<String> deleteBatchByIds(@RequestBody List<Long> ids){
        boolean isSuccessful = sysRoleService.removeByIds(ids);
        if(isSuccessful){
            return Result.ok("删除成功");
        }else{
            return Result.fail("删除失败");
        }
    }
}

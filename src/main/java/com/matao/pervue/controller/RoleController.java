package com.matao.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.*;
import com.matao.pervue.service.IMenu_roleService;
import com.matao.pervue.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    IMenu_roleService iMenu_roleService;


    /**
     * 查询所有的角色
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iRoleService.list());
    }

    /**
     * 查询menu菜单资源
     * @param current
     * @param size
     * @param roleVo
     * @return
     */
    @RequestMapping("/select")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, RoleVo roleVo){
        Page page = new Page(current,size);
        IPage<RoleVo> pageInfo=iRoleService.selectPageVo(page,roleVo);
        return  ResultEntity.ok(pageInfo);
    }

    /**
     * 详情方法
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public ResultEntity detail(Integer id){
        return  ResultEntity.ok(iRoleService.getById(id));
    }

    /**
     * 修改方法
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody Role entity){
        return ResultEntity.ok(iRoleService.updateById(entity));
    }
    @Transactional
    @RequestMapping("/deletes")
    public ResultEntity deletes(Integer ids[]){
        //首先删除管理的表
        for(Integer id:ids) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("rid", id);
            iMenu_roleService.remove(wrapper);
        }
        //再去删除主表

        //批量删除操作
        boolean flag =  iRoleService.removeByIds(Arrays.asList(ids));
        //定义返回结果
        return ResultEntity.ok(flag);
    }
}


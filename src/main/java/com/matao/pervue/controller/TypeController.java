package com.matao.pervue.controller;


import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    ITypeService iTypeService;
    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iTypeService.list());
    }
}


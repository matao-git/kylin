package com.matao.pervue.controller;


import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.service.IMenu_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu_role")
public class Menu_roleController {
    @Autowired
    private IMenu_roleService iMenu_roleService;

    @RequestMapping("/insert")
    public ResultEntity insert(Integer rid, Integer mids[]){
        try {
            iMenu_roleService.insertBatch(rid,mids);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.ok(false);
        }
        return ResultEntity.ok(true);
    }
}


package com.matao.pervue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.*;
import com.matao.pervue.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;

    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, GoodsVo goodsVo){
        Page<Goods> page = new Page<>(current,size);
        IPage<Goods> pageInfo=iGoodsService.selectPageVo(page,goodsVo);
        return  ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody Goods entity){
        boolean flag = iGoodsService.save(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]){
        boolean flag = iGoodsService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/update")
    public ResultEntity update(@RequestBody  Goods entity){
        boolean flag = iGoodsService.updateById(entity);
        return ResultEntity.ok(flag);
    }

}


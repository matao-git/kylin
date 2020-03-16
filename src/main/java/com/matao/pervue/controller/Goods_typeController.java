package com.matao.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.matao.pervue.entity.Goods_type;
import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.entity.User_role;
import com.matao.pervue.service.IGoods_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/goods_type")
public class Goods_typeController {
@Autowired
    private IGoods_typeService iGoods_typeService;

    @RequestMapping("/insert")
    public ResultEntity insert(Integer gid,Integer tids[]){
        //先删除
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("gid",gid);
        iGoods_typeService.remove(queryWrapper);
        //在执行保存
        if(tids!=null && tids.length>0){
            //创建批量保存集合
            ArrayList<Goods_type> entityList = new ArrayList<>();
            //for循环遍历角色的id
            for (Integer tid:tids){
                //床架用户角色对象
                Goods_type goods_type = new Goods_type();
                //设置用户id值
                goods_type.setGid(gid);
                //设置用户的角色id值
                goods_type.setTid(tid);
                //加入到集合中
                entityList.add(goods_type);
            }
            iGoods_typeService.saveBatch(entityList);
        }
        //返回结果
        return ResultEntity.ok(true);
    }

}


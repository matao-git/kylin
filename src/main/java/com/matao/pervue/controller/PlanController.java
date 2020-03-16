package com.matao.pervue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Dept;
import com.matao.pervue.entity.Plan;
import com.matao.pervue.entity.PlanVo;
import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.service.IDeptService;
import com.matao.pervue.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-16
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private IPlanService iPlanService;
    @Autowired
    private IDeptService iDeptService;
    @RequestMapping("planlist")
    public ResultEntity planList(PlanVo vo, @RequestParam(defaultValue = "1") long current, @RequestParam(defaultValue = "3")long size){


        Page page = new Page(current,size);

        IPage<PlanVo> pageInfo = iPlanService.selectPageVo(page,vo);

        return ResultEntity.ok(pageInfo);
    }


    @RequestMapping("planDesList")
    public ResultEntity selectById(Integer id){

        Plan plan = iPlanService.getById(id);
        //System.err.println(plan.getDeptId());
        Dept department = iDeptService.getById(plan.getDeptId());
        plan.setDnames(department.getName());
        return ResultEntity.ok(plan);
    }

    @RequestMapping("update")
    public ResultEntity update(@RequestBody Plan plan){

        boolean falg = iPlanService.saveOrUpdate(plan);
        return ResultEntity.ok(falg);
    }

    @RequestMapping("delete")
    public ResultEntity delete(Integer id){

        boolean falg = iPlanService.removeById(id);
        return ResultEntity.ok(falg);
    }

}


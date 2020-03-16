package com.matao.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Plan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matao.pervue.entity.PlanVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author matao
 * @since 2020-03-16
 */
public interface IPlanService extends IService<Plan> {

    IPage<PlanVo> selectPageVo(Page page, PlanVo vo);
}

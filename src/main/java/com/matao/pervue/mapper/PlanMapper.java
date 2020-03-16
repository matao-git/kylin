package com.matao.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matao.pervue.entity.PlanVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author matao
 * @since 2020-03-16
 */
public interface PlanMapper extends BaseMapper<Plan> {
    IPage<PlanVo> selectPageVo(Page page, PlanVo vo);
}

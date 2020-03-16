package com.matao.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Plan;
import com.matao.pervue.entity.PlanVo;
import com.matao.pervue.mapper.PlanMapper;
import com.matao.pervue.service.IPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author matao
 * @since 2020-03-16
 */
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements IPlanService {
    @Autowired
    private PlanMapper planMapper;
    @Override
    public IPage<PlanVo> selectPageVo(Page page, PlanVo vo) {
        return planMapper.selectPageVo(page,vo);
    }
}

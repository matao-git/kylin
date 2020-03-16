package com.matao.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Goods;
import com.matao.pervue.entity.GoodsVo;
import com.matao.pervue.mapper.GoodsMapper;
import com.matao.pervue.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public IPage<Goods> selectPageVo(Page<Goods> page, GoodsVo goodsVo) {
        return goodsMapper.selectPageVo(page,goodsVo);
    }
}

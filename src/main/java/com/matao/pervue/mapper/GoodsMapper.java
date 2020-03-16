package com.matao.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matao.pervue.entity.GoodsVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<Goods> selectPageVo(Page<Goods> page, GoodsVo goodsVo);
}

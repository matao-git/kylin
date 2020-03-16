package com.matao.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matao.pervue.entity.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author matao
 * @since 2020-03-13
 */
public interface IGoodsService extends IService<Goods> {

    IPage<Goods> selectPageVo(Page<Goods> page, GoodsVo goodsVo);
}

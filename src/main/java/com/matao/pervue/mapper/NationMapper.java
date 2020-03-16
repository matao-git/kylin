package com.matao.pervue.mapper;

import com.matao.pervue.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matao.pervue.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 Mapper 接口
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface NationMapper extends BaseMapper<Nation> {

    List<NationVo> findAll();
}

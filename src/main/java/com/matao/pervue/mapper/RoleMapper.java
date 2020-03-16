package com.matao.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matao.pervue.entity.RoleVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 角色列表自定义分页查询
     * @param page
     * @param roleVo
     * @return
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);
}

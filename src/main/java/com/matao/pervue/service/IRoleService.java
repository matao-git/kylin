package com.matao.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matao.pervue.entity.RoleVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface IRoleService extends IService<Role> {

    /**
     * 角色列表自定义分页查询
     * @param page
     * @param roleVo
     * @return
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);
}

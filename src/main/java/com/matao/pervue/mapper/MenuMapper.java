package com.matao.pervue.mapper;

import com.matao.pervue.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询所有结果
     * @return
     */
    List<Menu> listMenus();

    /**
     * 根据用户名称 查询用户所对应menu资源
     * @param userName
     * @return
     */
    List<Menu> listMenusByUserName(String userName);
}

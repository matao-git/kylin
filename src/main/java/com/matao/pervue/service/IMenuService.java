package com.matao.pervue.service;

import com.matao.pervue.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface IMenuService extends IService<Menu> {

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

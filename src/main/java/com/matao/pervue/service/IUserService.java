package com.matao.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matao.pervue.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {

    IPage<User> selectPageVo(Page<?> page, UserVo  userVo);
}

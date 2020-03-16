package com.matao.pervue.controller;


import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.entity.User;
import com.matao.pervue.service.IMenuService;
import io.lettuce.core.output.ScanOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService iMenuService;

    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iMenuService.listMenus());
    }

    @RequestMapping("listByUserName")
    public ResultEntity listByUserName(HttpServletRequest request, @RequestParam(defaultValue = "admin")String userName){

        System.out.println(request.getSession().getAttribute("user"));
        //获取session中的值
        User user = (User) request.getSession().getAttribute("user");
        //判断是否为空
        if(user!=null){
            //登录的用户
            userName = user.getUsername();
            System.out.println("@@@@@@"+userName);
        }
        return ResultEntity.ok(iMenuService.listMenusByUserName(userName));
    }
}


package com.matao.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matao.pervue.entity.ResultEntity;
import com.matao.pervue.entity.User;
import com.matao.pervue.entity.UserVo;
import com.matao.pervue.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author matao
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/user")
//跨越的注解访问
//@CrossOrigin
public class UserController {
    @Autowired
    private IUserService iUserService;
    @ResponseBody
    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, UserVo userVo){
        Page<User> page = new Page<>(current,size);
        IPage<User> pageInfo=iUserService.selectPageVo(page,userVo);
        return  ResultEntity.ok(pageInfo);
    }
    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]){
        boolean flag = iUserService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody  User entity){
        boolean flag = iUserService.save(entity);
        return ResultEntity.ok(flag);
    }
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody  User entity){
        boolean flag = iUserService.updateById(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,@RequestBody User user){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的idd
        System.out.println(session.getId()+"@@@@@@@@@@@@@@@@@@");
        //查询定义条件
        QueryWrapper queryWrapper = new QueryWrapper();
        //username名称是唯一
        queryWrapper.eq("username",user.getUsername());
        //获取实体对象
        User entity = iUserService.getOne(queryWrapper);
        //判断查询结果
        if(entity!=null){
            //判断密码
            if(entity.getPassword().equals(user.getPassword())){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
            return ResultEntity.error(5001,"用户名或密码错误");
    }

    @RequestMapping("/loginOut")
    public ResultEntity loginOut(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的idd
        System.out.println(session.getId()+"@@@@@@@@@@@@@@@@@@");

        session.removeAttribute("user");
        return ResultEntity.ok("true");
    }

}


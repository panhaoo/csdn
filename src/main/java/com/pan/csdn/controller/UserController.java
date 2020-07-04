package com.pan.csdn.controller;

import com.pan.csdn.bean.User;
import com.pan.csdn.service.IUserService;
import com.pan.csdn.utils.Result;
import com.pan.csdn.utils.ResultEnum;
import com.pan.csdn.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * @RestController=@Controller+@ResponseBody
 * @Controller 用于表示控制器类
 * @ResponseBody 返回的对象结果会被转为Json格式数据
 * */
@RestController
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/admin/toLogin")
    public ModelAndView toLogin(){
        System.out.println("进入登录页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_login");
        return mv;
    }

    @RequestMapping("/admin/doLogin")
    public Result login(String username, String password){
        Result result=null;
        System.out.println("执行登陆.....");
        System.out.println("【用户名】"+username+",【密码】"+password);
        User user=new User();
        user.setUname(username);
        user.setUpass(password);
        User loginUser=userService.login(user);
        if(loginUser!=null){
            result= ResultUtils.success(user);
        }
        else{
            result=ResultUtils.success(user);
            result.setCode(ResultEnum.LOGIN_FAILS.getCode());
            result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
        }
        return result;
    }

    @RequestMapping("/admin/index")
    public ModelAndView index(){
        System.out.println("进入后台页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_index");
        return mv;
    }

    @RequestMapping("/admin/list")
    public ModelAndView toList(){
        System.out.println("进入用户列表页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-list");
        return mv;
    }
}
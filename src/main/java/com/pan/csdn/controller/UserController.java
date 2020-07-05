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
import java.util.List;
import java.util.Map;

/*
 * @RestController=@Controller+@ResponseBody
 * @Controller 用于表示控制器类
 * @ResponseBody 返回的对象结果会被转为Json格式数据
 * */
@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        System.out.println("进入登录页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_login");
        return mv;
    }

    @RequestMapping("/doLogin")
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

    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("进入后台页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_index");
        return mv;
    }

    @RequestMapping("/list")
    public ModelAndView toList(){
        System.out.println("进入用户列表页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-list");
        return mv;
    }
    @RequestMapping("/ulist")
    public ModelAndView UList()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_list");
        return mv;
    }

    @RequestMapping("/toUAdd")
    public ModelAndView toUAdd()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-add");
        return mv;
    }
    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        //设置视图
        mv.setViewName("user-edit");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());

        return mv;
    }

    @RequestMapping("/toDetail/{id}")
    public ModelAndView toDetail(@PathVariable Integer id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-detail");
        User user = userService.getUserById(id);
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/todetail/{id}")
    public ModelAndView Detail(@PathVariable Integer id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-detail");
        User user = userService.getUserById(id);
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/uadd")
    public Result add(User user){
        System.out.println("添加数据["+user+"]");
        //用户数据添加至数据库
        userService.addUser(user);
        Result result = null;
        result = ResultUtils.success(user);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/getUsers")
    public Result getUsers(){
        Result result = null;
        List<User> list = userService.getUsers();
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result=null;
        int data=userService.delete(id);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("删除成功");
        }
        else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(User user){
        Result result=null;
        // 先获取原来对象的值
        User u=userService.getUserById(user.getId());
        u.setUname(user.getUname());
        u.setHeadpic(user.getHeadpic());
        int data=userService.update(u);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("更新成功");
        }
        else{
            result.setMsg("更新失败");
        }
        return result;
    }


    //上传图片
    @RequestMapping("/uploadHeadPic")
    public Result uploadHeadPic(@RequestParam("file") MultipartFile file) throws IOException {
        // 项目路径
        File projectPath = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println("projectPath="+projectPath);
        // 绝对路径=项目路径+自定义路径
        File upload = new File(projectPath.getAbsolutePath(), "static/user/");
        if (!upload.exists())
            upload.mkdirs();
        Result result=null;
        if (file.isEmpty()) {
            result=ResultUtils.error(-1,"上传失败");
        }
        else{
            //获取文件名称
            String fileName=file.getOriginalFilename();
            System.out.println("dest="+upload.getAbsolutePath()+"\\"+fileName);
            File dest=new File(upload.getAbsolutePath()+"\\"+fileName);
            //文件IO
            file.transferTo(dest);
            result=ResultUtils.success();
            result.setCode(0);
            result.setMsg("上传成功");
            Map<String,String> map=new HashMap<>();
            map.put("src",fileName);
            result.setData(map);
        }

        return result;
    }
}
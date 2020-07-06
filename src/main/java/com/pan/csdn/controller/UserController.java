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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RestController = @Controller + @ResponseBody
 * @Controller 用于表示控制器类
 * @ResponseBody 返回的对象结果会被转为Json格式数据
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 进入登陆页面
     * ModelAndView 是Springmvc返回 是一个模型加视图 结构
     */
    /* @RequestMapping 映射路径*/
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        System.out.println("进入后台登录页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-login");
        return mv;
    }

    @RequestMapping("/doLogin")
    public Result login(String uname, String upass){
        Result result = null;
        System.out.println("登录信息：【用户名】"+uname+",【密码】"+upass);
        User user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        User loginUser = userService.login(user);
        if(loginUser != null){
            result = ResultUtils.success(user);
        }else {
            result = ResultUtils.success(user);
            result.setCode(ResultEnum.LOGIN_FAILS.getCode());
            result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
        }
        return result;
    }

    /**
     * 进入欢迎页面
     * ModelAndView 是Springmvc返回 是一个模型加视图 结构
     */
    @RequestMapping("/index")
    public ModelAndView toIndex(){
        System.out.println("进入后台欢迎页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-index");
        return mv;
    }

    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome(){
        System.out.println("加载欢迎界面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-welcome");
        return mv;
    }

    /**
     * 进入用户列表
     */
    @RequestMapping("/toList")
    public ModelAndView toList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/getUsers")
    public Result getUsers(){
        Result result = null;
        List<User> list1 = userService.getUsers();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i).getFlag().equals("y")){
                list.add(list1.get(i));
            }
        }
        //list.forEach(System.out::println);
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/getUsersDeleted")
    public Result getUsersDeleted(){
        Result result = null;
        List<User> list1 = userService.getUsers();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i).getFlag().equals("n")){
                list.add(list1.get(i));
            }
        }
        //list.forEach(System.out::println);
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/toAddUser")
    public ModelAndView toAddUser(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-add");
        return mv;
    }

    @RequestMapping("/doAddUser")
    public Result doAddUser(User user) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        user.setDate(df.parse(df.format(System.currentTimeMillis())));
        System.out.println("添加用户:【"+user.toString()+"】");
        userService.addUser(user);
        Result result = null;
        result = ResultUtils.success(user);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/getUsersCount")
    public Result getUsersCount(){
        int count = userService.getUsersCount();
        System.out.println("共有数据:【"+count+"】");
        Result result = null;
        result = ResultUtils.success(count);
        return result;
    }

    @RequestMapping("/getUserById")
    public Result getUserById(Integer id){
        User user = userService.getUserById(id);
        Result result = null;
        result = ResultUtils.success(user);
        return result;
    }

    @RequestMapping("/toDetailUser/{id}")
    public ModelAndView toDetailUser(@PathVariable Integer id) throws ParseException {
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setViewName("user-detail");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        User user = userService.getUserById(id);
        System.out.println(user.getDate());
        String date = df.format(user.getDate());
        System.out.println(date);
        System.out.println(df.parse(date));
        user.setDate(df.parse(date));
        //设置数据
        mv.addObject("user",user);
        System.out.println(user.toString());
        return mv;
    }

    @RequestMapping("/toEditUser/{id}")
    public ModelAndView toEditUser(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setViewName("user-edit");
        User user = userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        //mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }

    @RequestMapping("/doEditUser")
    public Result doEditUser(User user){
        Result result = null;
        User user1 = userService.getUserById(user.getId());
        int data;
        if (user.getHeadpic() == user1.getHeadpic()){
            //data = userService.updateById(user1);
            data = 0;
        }
        else {
            data = userService.updateById(user);
        }
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("修改成功");
            System.out.println("修改用户:【"+user.toString()+"】");
        }
        else {
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping("/toEditUserpass/{id}")
    public ModelAndView toEditUserpass(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setViewName("user-editpass");
        User user = userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        //mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }

    @RequestMapping("/doEditUserPass")
    public Result doEditUserpass(Integer id , String upass){
        Result result = null;
        System.out.println(id);
        System.out.println(upass);
        User user1 = userService.getUserById(id);
        User user = user1;
        int data;
        if (upass == user1.getUpass()){
            //data = userService.updateById(user1);
            data = 0;
        }
        else {
            user.setUpass(upass);
            data = userService.updateById(user);
        }
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("修改成功");
            System.out.println("修改用户:【"+user.toString()+"】");
        }
        else {
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping("/doDeleteUser/{id}")
    //Restful路径传参(id)模式
    public Result doDeleteUser(@PathVariable Integer id){
        Result result = null;
        User user = userService.getUserById(id);
        user.setFlag("n");
        int data = userService.updateById(user);
        result = ResultUtils.success(data);
        if (data > 0){
            result.setMsg("删除成功");
            System.out.println("删除用户:【"+user.toString()+"】");
        }
        else {
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/doDeleteUser_Deleted/{id}")
    //Restful路径传参(id)模式
    public Result doDeleteUser_Deleted(@PathVariable Integer id){
        Result result = null;
        User user = userService.getUserById(id);
        int data = userService.deleteById(id);
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("删除成功");
            System.out.println("删除用户:【"+user.toString()+"】");
        }
        else {
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/doDeleteUsers/{ids}")
    //Restful路径传参(ids)模式
    public Result doDeleteUsers(@PathVariable List<Integer> ids){
        Result result = null;
        //int data = userService.deleteBatchIds(ids);
        int data = 0;
        for (Integer i: ids
             ) {
            User user = userService.getUserById(i);
            user.setFlag("n");
            data += userService.updateById(user);
        }
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("删除成功");
            System.out.println("删除"+data+"条用户信息");
        }
        else {
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/doDeleteUsers_Deleted/{ids}")
    //Restful路径传参(ids)模式
    public Result doDeleteUsers_Deleted(@PathVariable List<Integer> ids){
        Result result = null;
        int data = userService.deleteBatchIds(ids);
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("删除成功");
            System.out.println("删除"+data+"条用户信息");
        }
        else {
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/uploadHeadPic")
    public Result uploadHeadPic(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        // 项目路径
        File projectPath = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println("projectPath="+projectPath);
        // 绝对路径=项目路径+自定义路径
        File upload = new File(projectPath.getAbsolutePath(), "static/user/");
        if (!upload.exists())
            upload.mkdirs();
        Result result = null;
        if (file.isEmpty()) {
            result = ResultUtils.error(-1,"上传失败");
        }
        else{
            //获取文件名称
            String fileName = file.getOriginalFilename();
            System.out.println("dest="+upload.getAbsolutePath()+"\\"+fileName);
            File dest=new File(upload.getAbsolutePath()+"\\"+fileName);
            try {
                //文件IO
                file.transferTo(dest);
                result=ResultUtils.success();
                result.setCode(0);
                result.setMsg("上传成功");
                Map<String,String> map = new HashMap<>();
                map.put("src",fileName);
                result.setData(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("/searchByUname/{seachUname}")
    //Restful路径传参(id)模式
    public Result searchByUname(@PathVariable String seachUname){
        Result result = null;
        List<User> list = userService.searchByUname(seachUname);
        result = ResultUtils.success(list);
        result.setData(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/searchByDate/{dates}")
    public Result searchByDate(@PathVariable List<String> dates){
        Result result = null;
        List<User> list = userService.searchByDate(dates);
        result = ResultUtils.success(list);
        result.setData(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/searchByUname_Deleted/{seachUname}")
    //Restful路径传参(id)模式
    public Result searchByUname_Deleted(@PathVariable String seachUname){
        Result result = null;
        List<User> list = userService.searchByUname_Deleted(seachUname);
        result = ResultUtils.success(list);
        result.setData(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/searchByDate_Deleted/{dates}")
    public Result searchByDate_Deleted(@PathVariable List<String> dates){
        Result result = null;
        List<User> list = userService.searchByDate_Deleted(dates);
        result = ResultUtils.success(list);
        result.setData(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    /**
     * 进入用户删除页面
     * ModelAndView 是Springmvc返回 是一个模型加视图 结构
     */
    @RequestMapping("/toDeleted")
    public ModelAndView toDeleted(){
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setViewName("user-delete");
        return mv;
    }
}

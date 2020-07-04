package com.pan.csdn.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.csdn.bean.User;
import com.pan.csdn.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest2 {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){
        User user=userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void test02(){
        User user=userMapper.selectById(33);
        System.out.println(user);
    }
    @Test
    public void test03(){
        //添加用户
        User user=new User(null,"testman20200701","0701");
        userMapper.insert(user);
    }
    @Test
    public void test04(){
        //查询所有用户
        List<User> list= userMapper.selectList(null);
        for (User u:list
        ) {
            System.out.println(u);
        }
    }

    @Test
    public void test05(){
        //带条件查询
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("uname","testman20200701");
        List<User> list= userMapper.selectList(wrapper);
        for (User u:list) {
            System.out.println(u);
        }
    }

    @Test
    public void test06(){
        User user=userMapper.getUserById(1);
        System.out.println(user);
    }

}

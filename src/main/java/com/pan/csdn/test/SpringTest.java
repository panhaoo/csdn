package com.pan.csdn.test;

import com.pan.csdn.bean.User;
import com.pan.csdn.controller.UserController;
import com.pan.csdn.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Autowired
    IUserService userService;
    @Test
    public void test01(){
        userService.addUser(new User(1,"zhangsan","333"));
    }
}

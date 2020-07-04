package com.pan.csdn.dao;

import com.pan.csdn.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("mybatis")
public class UserDaoImpl implements IUserDao{

    List<User> list = new ArrayList<User>();

    @Override
    public void addUser(User user) {
        System.out.println("【添加用户mybatis】"+user.getUname());
        list.add(user);
    }

    @Override
    public User getUserById(Integer id) {
        User user = null;
        for (User u : list) {
            if (u.getId() == id){
                user = u;
            }
        }
        return user;
    }

    @Override
    public User Login(String uname, String upass) {
        User user = null;
        for (User u : list) {
            if (u.getUname() == uname && u.getUpass() == upass){
                user = u;
            }
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return list;
    }
}
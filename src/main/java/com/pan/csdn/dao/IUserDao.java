package com.pan.csdn.dao;


import com.pan.csdn.bean.User;

import java.util.List;

/**
 *用户Dao接口
 */
public interface IUserDao {
    public void addUser(User user);
    public User getUserById(Integer id);
    public User Login(String uname, String upass);
    public List<User> getUsers();
}

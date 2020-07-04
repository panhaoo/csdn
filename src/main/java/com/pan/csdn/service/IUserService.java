package com.pan.csdn.service;

import com.pan.csdn.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public User getUserById(Integer id);
    public User login(User user);
    public List<User> getUsers();
    public int getUsersCount();
    public int updateById(User user);
    public int deleteById(Integer id);
}

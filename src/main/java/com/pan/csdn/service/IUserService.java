package com.pan.csdn.service;

import com.pan.csdn.bean.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public User getUserById(Integer id);
    public User login(User user);
    public List<User> getUsers();
    public int getUsersCount();
    public int updateById(User user);
    public int deleteById(Integer id);
    public int deleteBatchIds(List<Integer> list);
    public List<User> searchByUname(String searchUname);
    public List<User> searchByDate(List<String> list);
    public List<User> searchByUname_Deleted(String searchUname);
    public List<User> searchByDate_Deleted(List<String> list);
}

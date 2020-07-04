package com.pan.csdn.service;

import com.pan.csdn.bean.User;
import com.pan.csdn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    //传统模式 Service 和 DAO 耦合了
    //Spring的注入方式就是来解决 组件和组件之间的耦合性问题
    //@Autowired 自动装配的注入方式 ：寻找实现IUserDao接口的实现类
    /*@Autowired
    @Qualifier(value = "mybatis")
    IUserDao userDao;*/
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public User login(User user) {
        User res = userMapper.getUserByName(user.getUname());
        if(user.getUpass().equals(res.getUpass())){
            return res;
        }else {
            return null;
        }
    }

    @Override
    public List<User> getUsers() {
        /*List<User> list = new ArrayList<>();
        list.add(new User(1,"zhangsan","123"));
        list.add(new User(2,"lisi","123"));
        list.add(new User(3,"wangwu","123"));
        list.add(new User(4,"zhaoliu","123"));*/
        List<User> list = userMapper.selectList(null);
        return list;
        //return userDao.getUsers();
    }

    @Override
    public int getUsersCount() {
        return userMapper.selectCount(null);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

}
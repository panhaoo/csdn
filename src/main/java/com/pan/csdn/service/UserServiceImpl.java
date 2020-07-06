package com.pan.csdn.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.csdn.bean.User;
import com.pan.csdn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service 注解 ：UserServiceImpl如果打上@Service，
// 在Spring启动的时候，会被扫描到Spring容器中，组件被Spring容器所管理。
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
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.eq("uname",user.getUname());
        try {
            if (userMapper.selectOne(wrapper).equals(null)){
                return null;
            }else {
                QueryWrapper<User> wrapper1 = queryWrapper.eq("uname",user.getUname())
                        .eq("upass",user.getUpass());
                if (userMapper.selectOne(wrapper1).equals(null)){
                    return null;
                }else {
                    return userMapper.selectOne(wrapper1);
                }
            }
        }catch (Exception e){
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

    @Override
    public int deleteBatchIds(List<Integer> list) {
        return userMapper.deleteBatchIds(list);
    }

    @Override
    public List<User> searchByUname(String searchUname) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.like("uname",searchUname).eq("flag","y");
        List<User> list = userMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<User> searchByUname_Deleted(String searchUname) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.like("uname",searchUname).eq("flag","n");
        List<User> list = userMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<User> searchByDate_Deleted(List<String> list) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> list1 = null;
        String start = list.get(0);
        String end = list.get(1);
        System.out.println("start:"+start);
        System.out.println("end:"+end);
        //>=ge  <= le
        if(!start.isEmpty() && !end.isEmpty()){
            QueryWrapper<User> wrapper1 = queryWrapper.ge("date",start).le("date",end).eq("flag","n");
            list1 = userMapper.selectList(wrapper1);
        }
        else if(!start.isEmpty() && end.isEmpty()) {
            QueryWrapper<User> wrapper2 = queryWrapper.ge("date",start).eq("flag","n");
            list1 = userMapper.selectList(wrapper2);
        }
        else if(start.isEmpty() && !end.isEmpty()){
            QueryWrapper<User> wrapper3 = queryWrapper.le("date",end).eq("flag","n");
            list1 = userMapper.selectList(wrapper3);
        }
        return list1;
    }

    @Override
    public List<User> searchByDate(List<String> list) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> list1 = null;
        String start = list.get(0);
        String end = list.get(1);
        System.out.println("start:"+start);
        System.out.println("end:"+end);
        //>=ge  <= le
        if(!start.isEmpty() && !end.isEmpty()){
            QueryWrapper<User> wrapper1 = queryWrapper.ge("date",start).le("date",end).eq("flag","y");
            list1 = userMapper.selectList(wrapper1);
        }
        else if(!start.isEmpty() && end.isEmpty()) {
            QueryWrapper<User> wrapper2 = queryWrapper.ge("date",start).eq("flag","y");
            list1 = userMapper.selectList(wrapper2);
        }
        else if(start.isEmpty() && !end.isEmpty()){
            QueryWrapper<User> wrapper3 = queryWrapper.le("date",end).eq("flag","y");
            list1 = userMapper.selectList(wrapper3);
        }
        return list1;
    }

}

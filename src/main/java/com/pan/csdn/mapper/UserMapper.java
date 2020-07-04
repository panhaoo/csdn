package com.pan.csdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.csdn.bean.User;

public interface UserMapper extends BaseMapper<User> {
    public User getUserById(Integer id);
    public User getUserByName(String uname);
}

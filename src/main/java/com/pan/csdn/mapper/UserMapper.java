package com.pan.csdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.csdn.bean.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    public List<User> searchByDate();
}

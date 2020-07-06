package com.pan.csdn.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.csdn.bean.Category;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int getCidByCname(String cname);

    List<Category> listCategory();
}
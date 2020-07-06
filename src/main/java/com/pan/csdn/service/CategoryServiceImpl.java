package com.pan.csdn.service;

import com.pan.csdn.bean.Category;
import com.pan.csdn.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryMapper.listCategory();
        return categoryList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delById(Integer id) throws Exception {
        int row = categoryMapper.deleteByPrimaryKey(id);
        return row > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOne(Category category) throws Exception {

        return categoryMapper.insertSelective(category);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateOne(Category category) throws Exception {
        return categoryMapper.updateByPrimaryKey(category);
    }
}

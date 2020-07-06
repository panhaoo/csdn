package com.pan.csdn.service;

import com.pan.csdn.bean.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategory();

    boolean delById(Integer id) throws Exception;

    int insertOne(Category category) throws Exception;

    Category getById(Integer id);

    int updateOne(Category category) throws Exception;
}

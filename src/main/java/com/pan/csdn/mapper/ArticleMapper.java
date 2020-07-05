package com.pan.csdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.csdn.bean.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    public List<Article> getArticles();
}

package com.dfrz.demo.service;

import com.dfrz.demo.bean.Article;
import com.dfrz.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService{
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> getArticles() {
        return articleMapper.selectList(null);
    }
}

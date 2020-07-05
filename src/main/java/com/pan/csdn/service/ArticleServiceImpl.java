package com.pan.csdn.service;

import com.pan.csdn.bean.Article;
import com.pan.csdn.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService{
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public List<Article> getArticles() {
        return articleMapper.selectList(null);
    }

    @Override
    public Article getArticleById(Integer id) {
        Article article = articleMapper.selectById(id);
        return article;
    }

    @Override
    public int update(Article article) {
        return articleMapper.updateById(article);
    }

    @Override
    public int delete(Integer id) {
        return articleMapper.deleteById(id);
    }
}

package com.pan.csdn.service;

import com.pan.csdn.bean.Article;

import java.util.List;

public interface IArticleService {

    public void addArticle(Article article);
    public List<Article> getArticles();
    public Article getArticleById(Integer id);
    public int update(Article article);
    public int delete(Integer id);
    public int deleteBatchIds(List<Integer> list);
    public int getArtsCount();

}

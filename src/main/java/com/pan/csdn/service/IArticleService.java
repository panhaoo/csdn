package com.pan.csdn.service;

import com.pan.csdn.bean.Article;
import com.pan.csdn.bean.Articles;

import java.util.List;

public interface IArticleService {

    public void addArticle(Article article);
    public List<Articles> getArticles();
    public List<Articles> getArticlesHot();
    public List<Articles> getArticlesCommend();
    public List<Articles> getArticlesWait();
    public List<Articles> getArticlesCategory(String categoryname);
    public List<Articles> getArticlesCategoryHot(String categoryname);
    public List<Articles> getArticlesCategoryCommend(String categoryname);
    public List<Articles> getArticlesCategoryWait(String categoryname);

    public Article getArticleById(Integer id);
    public int update(Article article);
    public int delete(Integer id);
    public int deleteBatchIds(List<Integer> list);
    public int getArtsCount();


  ;
}

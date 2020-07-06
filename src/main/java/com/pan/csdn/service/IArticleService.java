package com.pan.csdn.service;

import com.pan.csdn.bean.Article;
<<<<<<< HEAD
import com.pan.csdn.bean.User;
=======
import com.pan.csdn.bean.Articles;
>>>>>>> aba4866c7f97d50bc9647420abc0d4b14bfd7f6c

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
    public List<Article> searchByTitle(String title);
    public List<Article> searchByDate(List<String> list);


  ;
}

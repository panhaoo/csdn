package com.pan.csdn.service;

import com.pan.csdn.bean.Article;
import com.pan.csdn.bean.Articles;
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
    public List<Articles> getArticles() {
        return articleMapper.getArticles();
    }

    @Override
    public List<Articles> getArticlesHot() {
        return articleMapper.getArticlesHot();
    }

    @Override
    public List<Articles> getArticlesCommend() {
        return articleMapper.getArticlesCommend();
    }

    @Override
    public List<Articles> getArticlesWait() {
        return articleMapper.getArticlesWait();
    }

    @Override
    public List<Articles> getArticlesCategory(String categoryname) {
        int id = 0;
        if (categoryname.equals("计算机")){
            id = 7;
        }
        if (categoryname.equals("后端")){
            id = 8;
        }
        if (categoryname.equals("Java")){
            id = 9;
        }
        if (categoryname.equals("生活")){
            id = 10;
        }

        return articleMapper.getArticlesCategory(id);
    }

    @Override
    public List<Articles> getArticlesCategoryHot(String categoryname) {
        int id = 0;
        if (categoryname.equals("计算机")){
            id = 7;
        }
        if (categoryname.equals("后端")){
            id = 8;
        }
        if (categoryname.equals("Java")){
            id = 9;
        }
        if (categoryname.equals("生活")){
            id = 10;
        }
        return articleMapper.getArticlesCategoryHot(id);
    }

    @Override
    public List<Articles> getArticlesCategoryCommend(String categoryname) {
        int id = 0;
        if (categoryname.equals("计算机")){
            id = 7;
        }
        if (categoryname.equals("后端")){
            id = 8;
        }
        if (categoryname.equals("Java")){
            id = 9;
        }
        if (categoryname.equals("生活")){
            id = 10;
        }
        return articleMapper.getArticlesCategoryCommend(id);
    }

    @Override
    public List<Articles> getArticlesCategoryWait(String categoryname) {
        int id = 0;
        if (categoryname.equals("计算机")){
            id = 7;
        }
        if (categoryname.equals("后端")){
            id = 8;
        }
        if (categoryname.equals("Java")){
            id = 9;
        }
        if (categoryname.equals("生活")){
            id = 10;
        }
        return articleMapper.getArticlesCategoryWait(id);
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

    @Override
    public int deleteBatchIds(List<Integer> list) {
        return articleMapper.deleteBatchIds(list);
    }

    @Override
    public int getArtsCount() {
        return articleMapper.selectCount(null);
    }
}

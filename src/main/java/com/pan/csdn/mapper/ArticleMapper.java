package com.pan.csdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.csdn.bean.Article;
import com.pan.csdn.bean.Articles;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    public List<Articles> getArticles();
    public List<Articles> getArticlesHot();
    public List<Articles> getArticlesCommend();
    public List<Articles> getArticlesWait();

    public List<Articles> getArticlesCategory(Integer id);
    public List<Articles> getArticlesCategoryHot(Integer id);
    public List<Articles> getArticlesCategoryCommend(Integer id);
    public List<Articles> getArticlesCategoryWait(Integer id);

}

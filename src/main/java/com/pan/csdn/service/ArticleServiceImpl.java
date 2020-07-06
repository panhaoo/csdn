package com.pan.csdn.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.csdn.bean.Article;
import com.pan.csdn.bean.User;
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
        return articleMapper.getArticles();
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

    @Override
    public List<Article> searchByTitle(String title) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Article> wrapper = queryWrapper.like("title",title);
        List<Article> list = articleMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<Article> searchByDate(List<String> list) {
            QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
            List<Article> list1 = null;
            String start = list.get(0);
            String end = list.get(1);
            System.out.println("start:"+start);
            System.out.println("end:"+end);
            //>=ge  <= le
            if(!start.isEmpty() && !end.isEmpty()){
                QueryWrapper<Article> wrapper1 = queryWrapper.ge("date",start).le("date",end);
                list1 = articleMapper.selectList(wrapper1);
            }
            else if(!start.isEmpty() && end.isEmpty()) {
                QueryWrapper<Article> wrapper2 = queryWrapper.ge("date",start).le("date",end);
                list1 = articleMapper.selectList(wrapper2);
            }
            else if(start.isEmpty() && !end.isEmpty()){
                QueryWrapper<Article> wrapper3 = queryWrapper.ge("date",start).le("date",end);
                list1 = articleMapper.selectList(wrapper3);
            }
            return list1;
    }
}

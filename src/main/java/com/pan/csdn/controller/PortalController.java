package com.pan.csdn.controller;

import com.pan.csdn.bean.Article;
import com.pan.csdn.service.IArticleService;
import com.pan.csdn.utils.Result;
import com.pan.csdn.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/article")
public class PortalController {

    @Autowired
    IArticleService articleService;
    @RequestMapping("/toArticle")
    public ModelAndView toArticle(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("article_list");
        return mv;
    }
    @RequestMapping("/getArticles")
    public Result getUsers(){
        Result result = null;
        List<Article> list = articleService.getArticles();
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        //设置视图
        mv.setViewName("article-edit");
        Article article = articleService.getArticleById(id);
        //设置数据
        mv.addObject("article",article);
        return mv;
    }
    @RequestMapping("/toDetail/{id}")
    public ModelAndView toDetail(@PathVariable Integer id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("article-detail");
        Article article = articleService.getArticleById(id);
        mv.addObject("article",article);
        return mv;
    }
    @RequestMapping("/toArtAdd")
    public ModelAndView toArtAdd()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("article-add");
        return mv;
    }

    @RequestMapping("/artadd")
    public Result add(Article article){
        System.out.println("添加数据["+article+"]");
        //用户数据添加至数据库
        articleService.addArticle(article);
        Result result = null;
        result = ResultUtils.success(article);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }
    @RequestMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result=null;
        int data = articleService.delete(id);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("删除成功");
        }
        else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Article article){
        Result result=null;
        // 先获取原来对象的值
        Article a = articleService.getArticleById(article.getId());
        System.out.println(article.getTitle());
        System.out.println(article.getComment());
        System.out.println(article.getBrowse());
        System.out.println(article.getUserid());
        System.out.println(article.getReleasetime());

        a.setTitle(article.getTitle());
        a.setComment(article.getComment());
        a.setBrowse(article.getBrowse());
        a.setUserid(article.getUserid());
        a.setReleasetime(article.getReleasetime());
        int data = articleService.update(a);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("更新成功");
        }
        else{
            result.setMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("/portal_index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index");
        List<Article> articles = articleService.getArticles();
        modelAndView.addObject("articles",articles);
        return modelAndView;
    }

}

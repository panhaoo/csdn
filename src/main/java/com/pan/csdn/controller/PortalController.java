package com.pan.csdn.controller;

import com.pan.csdn.bean.Article;
import com.pan.csdn.bean.User;
import com.pan.csdn.bean.Articles;
import com.pan.csdn.bean.Category;
import com.pan.csdn.service.IArticleService;
import com.pan.csdn.service.ICategoryService;
import com.pan.csdn.utils.Result;
import com.pan.csdn.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/article")
public class PortalController {

    @Autowired
    ICategoryService categoryService;

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
        List<Articles> list = articleService.getArticles();
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/getArtsCount")
    public Result getArtsCount(){
        int count = articleService.getArtsCount();
        System.out.println("共有数据:【"+count+"】");
        Result result = null;
        result = ResultUtils.success(count);
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

    @RequestMapping("/edit")
    public Result Edit(Article article){
        Result result=null;
        // 先获取原来对象的值
        System.out.println("修改的值articleid为"+article.getId());
        Article a = articleService.getArticleById(article.getId());
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
    public Result add(Article article) {
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
    @RequestMapping("/doDeleteArts/{ids}")
    //Restful路径传参(ids)模式
    public Result doDeleteArts(@PathVariable List<Integer> ids){
        Result result = null;
        int data = articleService.deleteBatchIds(ids);
        result = ResultUtils.success(data);
        if (data > 0 ){
            result.setMsg("删除成功");
            System.out.println("删除"+data+"条文章信息");
        }
        else {
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/portal_index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticles();
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_hot")
    public ModelAndView toIndexHot(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_hot");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesHot();
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_commend")
    public ModelAndView toIndexCommend(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_commend");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesCommend();
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_wait")
    public ModelAndView toIndexWait() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_wait");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesWait();
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }
    @RequestMapping("/searchByTitle/{title}")
    //Restful路径传参(id)模式
    public Result searchByTitle(@PathVariable String title){
        Result result = null;
        List<Article> list = articleService.searchByTitle(title);
        System.out.println("list数据为"+list);
        result = ResultUtils.success(list);
        result.setData(list);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(list.size());
        return result;
    }

    @RequestMapping("/portal_index_category{categoryname}")
    public ModelAndView toIndexComputer(@PathVariable String categoryname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_category");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesCategory(categoryname);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categoryname",categoryname);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_category_hot{categoryname}")
    public ModelAndView toIndexCategoryHot(@PathVariable String categoryname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_category_hot");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesCategoryHot(categoryname);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categoryname",categoryname);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_category_commend{categoryname}")
    public ModelAndView toIndexCategoryCommend(@PathVariable String categoryname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_category_commend");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesCategoryCommend(categoryname);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categoryname",categoryname);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/portal_index_category_wait{categoryname}")
    public ModelAndView toIndexCategoryWait(@PathVariable String categoryname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal_index_category_wait");
        //获取分类列表
        List<Category> categories = categoryService.getAllCategory();
        //获取文章列表
        List<Articles> articles = articleService.getArticlesCategoryWait(categoryname);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("categoryname",categoryname);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
}

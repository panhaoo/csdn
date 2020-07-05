package com.dfrz.demo.controller;

import com.dfrz.demo.bean.Article;
import com.dfrz.demo.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PortalController {

    @Autowired
    IArticleService articleService;
    @RequestMapping("/portal_index")
    public ModelAndView toIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("portal_index");
        List<Article> articles = articleService.getArticles();
        mv.addObject("articles",articles);
        return mv;
    }
}

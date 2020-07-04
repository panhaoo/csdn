package com.pan.csdn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("进入后台页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}

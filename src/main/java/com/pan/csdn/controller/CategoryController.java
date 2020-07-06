package com.pan.csdn.controller;

import com.pan.csdn.bean.Category;
import com.pan.csdn.bean.LayuiTableVo;
import com.pan.csdn.bean.RespBean;
import com.pan.csdn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/allList")
    @ResponseBody
    public RespBean getAll() {
        List<Category> list = categoryService.getAllCategory();
        return RespBean.ok("成功").setData(list);
    }


    @GetMapping("/page")
    public String categoryPage() {
        return "categoryList";
    }

    @GetMapping("/addPage")
    public String addCategoryPage() {
        return "categoryAdd";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable("id") Integer id, Model model) {

        Category category = categoryService.getById(id);
        model.addAttribute("category", category);

        return "categoryEdit";
    }

    @GetMapping("/del/{id}")
    @ResponseBody
    public RespBean delCategory(@PathVariable("id") Integer id) {
        RespBean respBean = RespBean.ok("成功");
        try {
            boolean res = categoryService.delById(id);
            if (!res) {
                respBean.setCode(500);
                respBean.setMsg("系统错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respBean.setCode(500);
            respBean.setMsg("系统错误");
        }

        return respBean;
    }

    @GetMapping("/pageList")
    @ResponseBody
    public LayuiTableVo getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.getAllCategory();

        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        int levels = Integer.parseInt(request.getParameter("levels"));


        List<Category> levelList = categoryList.stream()
                .filter(category -> category.getLevels() == levels)
                .collect(Collectors.toList());


        int start = (page - 1) * limit;
        int rest = levelList.size() - start;
        int end = rest > limit ? start + limit : start + rest;

        List<Category> pageList = levelList.subList(start, end);

        pageList.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.getSort() - o2.getSort();
            }
        });

        LayuiTableVo layuiTableVo = new LayuiTableVo();
        layuiTableVo.setCode(0);
        layuiTableVo.setCount((long) levelList.size());
        layuiTableVo.setMsg("成功");
        layuiTableVo.setData(pageList);

        return layuiTableVo;
    }

    @PostMapping("/save")
    @ResponseBody
    public RespBean add(@RequestBody Category category) {

        RespBean respBean = RespBean.ok("成功");
        int count = 0;
        try {
            count = categoryService.insertOne(category);
            if (count <= 0) {
                respBean.setCode(500);
                respBean.setMsg("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respBean.setCode(500);
            respBean.setMsg("系统错误");
        }
        return respBean;

    }

    @PostMapping("/update")
    @ResponseBody
    public RespBean update(@RequestBody Category category) {

        RespBean respBean = RespBean.ok("成功");
        int count = 0;
        try {

            if (category.getPid() != 0) {
                Category parent = categoryService.getById(category.getPid());
                category.setLevels(parent.getLevels() + 1);
            } else {
                category.setLevels(1);
            }

            count = categoryService.updateOne(category);
            if (count <= 0) {
                respBean.setCode(500);
                respBean.setMsg("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respBean.setCode(500);
            respBean.setMsg("系统错误");
        }
        return respBean;

    }

}

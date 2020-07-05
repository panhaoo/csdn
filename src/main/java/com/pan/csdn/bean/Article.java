package com.dfrz.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_article")
public class Article {
        //主键
        @TableId(value = "id",type = IdType.AUTO)
        private Integer id;
        //标题
        private String title;
        //内容
        private String scontent;

    public Article() {
    }

    public Article(Integer id, String title, String scontent) {
        this.id = id;
        this.title = title;
        this.scontent = scontent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }

    @Override
    public String toString(){
        return "User{"+
                "id: "+id+
                ", 标题: "+title+
                ",内容: "+scontent+
                "}";
    }
}


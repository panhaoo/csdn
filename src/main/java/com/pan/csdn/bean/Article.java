package com.pan.csdn.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("article")
public class Article {
        //主键
        @TableId(value = "id",type = IdType.AUTO)
        private Integer id;
        //标题
        private String title;
        //内容
        private String category;

        private Integer comment;

        private String cover;

        private String scontent;

        private Integer browse;

        private Integer userid;

        private String releasetime;

        private String uname;
        public Article(){

        }


    public Article(Integer id, String title, String category, Integer comment, String cover, String scontent, Integer browse, Integer userid, String releasetime, String uname) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.comment = comment;
        this.cover = cover;
        this.scontent = scontent;
        this.browse = browse;
        this.userid = userid;
        this.releasetime = releasetime;
        this.uname = uname;
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

        public Integer getComment() {
            return comment;
        }

        public void setComment(Integer comment) {
            this.comment = comment;
        }

        public Integer getBrowse() {
            return browse;
        }

        public void setBrowse(Integer browse) {
            this.browse = browse;
        }

        public Integer getUserid() {
            return userid;
        }

        public void setUserid(Integer userid) {
            this.userid = userid;
        }

        public String getReleasetime() {
            return releasetime;
        }

        public void setReleasetime(String releasetime) {
            this.releasetime = releasetime;
        }

        public String getCategory() { return category; }

        public void setCategory(String category) { this.category = category; }



    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", comment=" + comment +
                ", cover='" + cover + '\'' +
                ", scontent='" + scontent + '\'' +
                ", browse=" + browse +
                ", userid=" + userid +
                ", releasetime='" + releasetime + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}


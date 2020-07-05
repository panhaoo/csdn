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
        private Integer comment;

        private Integer browse;

        private Integer userid;

        private String releasetime;

        public Article(){

        }

        public Article(Integer id, String title, Integer comment, Integer browse, Integer userid, String releasetime) {
            this.id = id;
            this.title = title;
            this.comment = comment;
            this.browse = browse;
            this.userid = userid;
            this.releasetime = releasetime;
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

        @Override
            public String toString(){
                return "User{"+
                        "id: "+id+
                        ", 标题: "+title+
                        ",评论: "+comment+
                        ",浏览: "+browse+
                        ",作者id: "+userid+
                        ",发布时间: "+releasetime+
                        "}";
            }
}


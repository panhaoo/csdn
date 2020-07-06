package com.pan.csdn.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description:
 * @Auther: 74285
 * @Date: 2020/7/6 14:58
 */
@TableName("article")
public class Articles {
    //主键
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //标题
    private String title;
    //内容
    private Integer cid;

    private String categoryname;

    private Integer comment;

    private String cover;

    private String scontent;

    private Integer browse;

    private Integer userid;

    private String releasetime;

    private String uname;
    public Articles(){

    }


    public Articles(Integer id, String title, Integer cid, String categoryname, Integer comment, String cover, String scontent, Integer browse, Integer userid, String releasetime, String uname) {
        this.id = id;
        this.title = title;
        this.cid = cid;
        this.categoryname = categoryname;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cid=" + cid +
                ", categoryname='" + categoryname + '\'' +
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

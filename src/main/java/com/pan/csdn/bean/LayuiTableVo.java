package com.pan.csdn.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoy
 * @公众号 编程无忧
 * @微信号 xy1490634389
 * @GitHub https://github.com/xy08143376
 * @博客 https://me.csdn.net/ghhgc
 * @网站 暂无
 * @时间 2020/7/2
 **/
public class LayuiTableVo implements Serializable {

    private static final long serialVersionUID = 8667039493560702284L;

    private Integer code;

    private String msg;

    private Long count;

    private List data;

    @Override
    public String toString() {
        return "LayuiTableVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}

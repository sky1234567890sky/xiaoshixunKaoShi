package com.example.asekeyang.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 华为 on 2019/6/13.
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    Long id;
    int img;
    String title;
    String url;
    @Generated(hash = 1205626357)
    public Student(Long id, int img, String title, String url) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.url = url;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getImg() {
        return this.img;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}

package com.example.yrw.myapplication3.entity;

/**
 * Created by Administrator on 2017\11\22 0022.
 */
public class shoppingdomain {
    String name;
    int ImgId;
    String submit;
    public shoppingdomain(String name, int imgId, String submit) {
        super();
        this.name = name;
        ImgId = imgId;
        this.submit=submit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImgId() {
        return ImgId;
    }
    public void setImgId(int imgId) {
        ImgId = imgId;
    }
    public String getSubmit() {
        return submit;
    }
    public void setSubmit(String submit) {
        this.submit = submit;
    }
}
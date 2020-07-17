package com.example.day_zhoukao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DatasBean {
    @Id
    private Long id;
    private String title;
    @Generated(hash = 1125384094)
    public DatasBean(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
   
}

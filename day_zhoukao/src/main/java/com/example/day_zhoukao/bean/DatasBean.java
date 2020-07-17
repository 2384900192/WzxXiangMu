package com.example.day_zhoukao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DatasBean {
    @Id
    private Long id;
    private String title;
    private boolean isChecked;
    @Generated(hash = 12852946)
    public DatasBean(Long id, String title, boolean isChecked) {
        this.id = id;
        this.title = title;
        this.isChecked = isChecked;
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
    public boolean getIsChecked() {
        return this.isChecked;
    }
    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    
}

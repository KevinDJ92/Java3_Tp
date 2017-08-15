package com.entities;

import java.io.Serializable;

public class Preferences implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id_user;
    private Integer id_preference;
    private String sex_preference;
    private Integer min_age;
    private Integer max_age;

    public Preferences() {
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
    
    public Integer getId_preference() {
        return id_preference;
    }

    public void setId_preference(Integer id_preference) {
        this.id_preference = id_preference;
    }

    public String getSex_preference() {
        return sex_preference;
    }

    public void setSex_preference(String sex_preference) {
        this.sex_preference = sex_preference;
    }

    public Integer getMin_age() {
        return min_age;
    }

    public void setMin_age(Integer min_age) {
        this.min_age = min_age;
    }

    public Integer getMax_age() {
        return max_age;
    }

    public void setMax_age(Integer max_age) {
        this.max_age = max_age;
    }
}

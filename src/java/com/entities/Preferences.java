package com.entities;

public class Preferences {
    private Integer id_user;
    private Integer id_preference;
    private String sex_preference;
    private int min_age;
    private int max_age;
    private int min_height;
    private int max_height;
    
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

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public void setMax_age(int max_age) {
        this.max_age = max_age;
    }

    public int getMin_height() {
        return min_height;
    }

    public void setMin_height(int min_height) {
        this.min_height = min_height;
    }

    public int getMax_height() {
        return max_height;
    }

    public void setMax_height(int max_height) {
        this.max_height = max_height;
    }
}

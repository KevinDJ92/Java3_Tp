package com.entities;

import java.util.Collection;

public class User {
    private int id_user;
    private String username;
    private String email;
    private String password;
    private String phone_number;
    private Integer id_role;
    private String sex;
    private int age;
    private Integer id_image;
    private Collection<Preferences> preferencesCollection;
    private Integer id_city;
    
    public User() {
    }

    public User(String username, String email, String password, String phone_number, int id_role, String sex, 
            int age, Integer id_image) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number; 
        this.id_role = id_role;
        this.sex = sex; 
        this.age = age;
        this.id_image = id_image;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId_image() {
        return id_image;
    }

    public void setId_image(Integer id_image) {
        this.id_image = id_image;
    }

    public Collection<Preferences> getPreferencesCollection() {
        return preferencesCollection;
    }

    public void setPreferencesCollection(Collection<Preferences> preferencesCollection) {
        this.preferencesCollection = preferencesCollection;
    }

    public Integer getId_city() {
        return id_city;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }
}

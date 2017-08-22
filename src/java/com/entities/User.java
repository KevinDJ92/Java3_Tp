package com.entities;

import java.sql.Date;
import java.util.List;

public class User {
    private Integer id_user;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String salt_password;
    private String hash_password;
    private Integer id_role;
    private String sex;
    private Date date_of_birth;
    private Integer height;
    private Integer id_city;
    private String phone_number;
    private String url_profile_image;
    private int age;
    private Boolean is_online;
    private Date date_signed_up;
    
    private Preferences preferences;
    private List<Favorite> favoriteList;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public User() {
       preferences = new Preferences();
    }
    
    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt_password() {
        return salt_password;
    }

    public void setSalt_password(String salt_password) {
        this.salt_password = salt_password;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
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

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId_city() {
        return id_city;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUrl_profile_image() {
        return url_profile_image;
    }

    public void setUrl_profile_image(String url_profile_image) {
        this.url_profile_image = url_profile_image;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public Date getDate_signed_up() {
        return date_signed_up;
    }

    public void setDate_signed_up(Date date_signed_up) {
        this.date_signed_up = date_signed_up;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    } 
}

package com.entities;

import java.io.Serializable;
import java.util.Collection;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id_city;
    private String name;
    private Collection<User> userCollection;

    public City() {
    }

    public City(Integer idCity) {
        this.id_city = idCity;
    }

    public City(Integer idCity, String name) {
        this.id_city = idCity;
        this.name = name;
    }

    public Integer getId_city() {
        return id_city;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }
}

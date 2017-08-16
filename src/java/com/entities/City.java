package com.entities;

import java.io.Serializable;
import java.util.Collection;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idCity;
    private String name;
    private Collection<User> userCollection;

    public City() {
    }

    public City(Integer idCity) {
        this.idCity = idCity;
    }

    public City(Integer idCity, String name) {
        this.idCity = idCity;
        this.name = name;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
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

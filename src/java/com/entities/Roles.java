
package com.entities;

import java.io.Serializable;
import java.util.Collection;

public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idRole;
    private String name;
    private Collection<User> userCollection;

    public Roles() {
    }

    public Roles(Integer idRole) {
        this.idRole = idRole;
    }

    public Roles(Integer idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
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

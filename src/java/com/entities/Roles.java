package com.entities;

public class Roles {
    private Integer idRole;
    private String name;

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
}

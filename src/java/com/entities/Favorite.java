package com.entities;

public class Favorite {
    private Integer idFavorite;
    private Integer id_user;
    private int id_favority_user;
    private Boolean isFavority;

    public Integer getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(Integer idFavorite) {
        this.idFavorite = idFavorite;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public int getId_favority_user() {
        return id_favority_user;
    }

    public void setId_favority_user(int id_favority_user) {
        this.id_favority_user = id_favority_user;
    }

    public Boolean getIsFavority() {
        return isFavority;
    }

    public void setIsFavority(Boolean isFavority) {
        this.isFavority = isFavority;
    }
}

package com.entities;

import java.io.Serializable;

public class Images implements Serializable {
    private static final long serialVersionUID = 1L; 
    private Integer idImage;
    private String url;
    private String title;
    private String alt;

    public Images() {
    }

    public Images(Integer idImage) {
        this.idImage = idImage;
    }

    public Images(Integer idImage, String url, String title, String alt) {
        this.idImage = idImage;
        this.url = url;
        this.title = title;
        this.alt = alt;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}

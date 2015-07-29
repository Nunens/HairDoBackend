/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.Style;

/**
 *
 * @author admin
 */
public class StyleDTO {

    private int styleID;
    private String name;
    private String imageURL;
    private String description;
    private long date;
    private String status;

    public StyleDTO() {
    }

    public StyleDTO(Style a) {
        styleID = a.getStyleID();
        name = a.getName();
        imageURL = a.getImageURL();
        description = a.getDescription();
        date = a.getDate().getTime();
        status = a.getStatus();
    }

    public int getStyleID() {
        return styleID;
    }

    public void setStyleID(int styleID) {
        this.styleID = styleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

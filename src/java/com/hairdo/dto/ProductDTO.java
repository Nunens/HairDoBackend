/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.Product;

/**
 *
 * @author admin
 */
public class ProductDTO {

    private int productID;
    private String name;
    private String description;
    private long date;
    private String status;

    public ProductDTO() {
    }

    public ProductDTO(Product a) {
        productID = a.getProductID();
        name = a.getName();
        description = a.getDescription();
        date = a.getDate().getTime();
        status = a.getStatus();
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

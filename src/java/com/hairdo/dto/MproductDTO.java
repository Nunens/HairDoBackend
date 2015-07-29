/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.Mproduct;

/**
 *
 * @author admin
 */
public class MproductDTO {

    private int mproductID;
    private long date;
    private String status;
    private int productID;
    private int styleID;
    private ProductDTO product;
    private StyleDTO style;

    public MproductDTO() {

    }

    public MproductDTO(Mproduct a) {
        mproductID = a.getMproductID();
        date = a.getDate().getTime();
        status = a.getStatus();
        productID = a.getProduct().getProductID();
        styleID = a.getStyle().getStyleID();
        product = new ProductDTO(a.getProduct());
        style = new StyleDTO(a.getStyle());
    }

    public int getMproductID() {
        return mproductID;
    }

    public void setMproductID(int mproductID) {
        this.mproductID = mproductID;
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStyleID() {
        return styleID;
    }

    public void setStyleID(int styleID) {
        this.styleID = styleID;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public StyleDTO getStyle() {
        return style;
    }

    public void setStyle(StyleDTO style) {
        this.style = style;
    }

}

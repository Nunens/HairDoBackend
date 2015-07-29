/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hairdo.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "mproduct", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mproduct.findAll", query = "SELECT m FROM Mproduct m"),
    @NamedQuery(name = "Mproduct.findByMproductID", query = "SELECT m FROM Mproduct m WHERE m.mproductID = :mproductID"),
    @NamedQuery(name = "Mproduct.findByDate", query = "SELECT m FROM Mproduct m WHERE m.date = :date"),
    @NamedQuery(name = "Mproduct.findByStyle", query = "SELECT m FROM Mproduct m WHERE m.style.styleID = :id"),
    @NamedQuery(name = "Mproduct.findByProduct", query = "SELECT m FROM Mproduct m WHERE m.product.productID = :id"),
    @NamedQuery(name = "Mproduct.findByStatus", query = "SELECT m FROM Mproduct m WHERE m.status = :status")})
public class Mproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mproductID")
    private Integer mproductID;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "styleID", referencedColumnName = "styleID")
    @ManyToOne(optional = false)
    private Style style;

    public Mproduct() {
    }

    public Mproduct(Integer mproductID) {
        this.mproductID = mproductID;
    }

    public Integer getMproductID() {
        return mproductID;
    }

    public void setMproductID(Integer mproductID) {
        this.mproductID = mproductID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mproductID != null ? mproductID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mproduct)) {
            return false;
        }
        Mproduct other = (Mproduct) object;
        if ((this.mproductID == null && other.mproductID != null) || (this.mproductID != null && !this.mproductID.equals(other.mproductID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Mproduct[ mproductID=" + mproductID + " ]";
    }
    
}

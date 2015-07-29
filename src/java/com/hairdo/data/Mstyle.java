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
@Table(name = "mstyle", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mstyle.findAll", query = "SELECT m FROM Mstyle m"),
    @NamedQuery(name = "Mstyle.findByMstyleID", query = "SELECT m FROM Mstyle m WHERE m.mstyleID = :mstyleID"),
    @NamedQuery(name = "Mstyle.findByPrice", query = "SELECT m FROM Mstyle m WHERE m.price = :price"),
    @NamedQuery(name = "Mstyle.findByStyle", query = "SELECT m FROM Mstyle m WHERE m.style.styleID = :id"),
    @NamedQuery(name = "Mstyle.findByStylist", query = "SELECT m FROM Mstyle m WHERE m.stylist.stylistID = :id"),
    @NamedQuery(name = "Mstyle.findByDate", query = "SELECT m FROM Mstyle m WHERE m.date = :date"),
    @NamedQuery(name = "Mstyle.findByStatus", query = "SELECT m FROM Mstyle m WHERE m.status = :status")})
public class Mstyle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mstyleID")
    private Integer mstyleID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "styleID", referencedColumnName = "styleID")
    @ManyToOne(optional = false)
    private Style style;
    @JoinColumn(name = "stylistID", referencedColumnName = "stylistID")
    @ManyToOne(optional = false)
    private Stylist stylist;

    public Mstyle() {
    }

    public Mstyle(Integer mstyleID) {
        this.mstyleID = mstyleID;
    }

    public Integer getMstyleID() {
        return mstyleID;
    }

    public void setMstyleID(Integer mstyleID) {
        this.mstyleID = mstyleID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mstyleID != null ? mstyleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mstyle)) {
            return false;
        }
        Mstyle other = (Mstyle) object;
        if ((this.mstyleID == null && other.mstyleID != null) || (this.mstyleID != null && !this.mstyleID.equals(other.mstyleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Mstyle[ mstyleID=" + mstyleID + " ]";
    }
    
}

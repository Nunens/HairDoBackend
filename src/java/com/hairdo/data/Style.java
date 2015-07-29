/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hairdo.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "style", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Style.findAll", query = "SELECT s FROM Style s"),
    @NamedQuery(name = "Style.findByStyleID", query = "SELECT s FROM Style s WHERE s.styleID = :styleID"),
    @NamedQuery(name = "Style.findByName", query = "SELECT s FROM Style s WHERE s.name = :name"),
    @NamedQuery(name = "Style.findByImageURL", query = "SELECT s FROM Style s WHERE s.imageURL = :imageURL"),
    @NamedQuery(name = "Style.findByDescription", query = "SELECT s FROM Style s WHERE s.description = :description"),
    @NamedQuery(name = "Style.findByDate", query = "SELECT s FROM Style s WHERE s.date = :date"),
    @NamedQuery(name = "Style.findByStatus", query = "SELECT s FROM Style s WHERE s.status = :status")})
public class Style implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "styleID")
    private Integer styleID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "imageURL")
    private String imageURL;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "style")
    private List<Mproduct> mproductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "style")
    private List<Mstyle> mstyleList;

    public Style() {
    }

    public Style(Integer styleID) {
        this.styleID = styleID;
    }

    public Integer getStyleID() {
        return styleID;
    }

    public void setStyleID(Integer styleID) {
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

    @XmlTransient
    public List<Mproduct> getMproductList() {
        return mproductList;
    }

    public void setMproductList(List<Mproduct> mproductList) {
        this.mproductList = mproductList;
    }

    @XmlTransient
    public List<Mstyle> getMstyleList() {
        return mstyleList;
    }

    public void setMstyleList(List<Mstyle> mstyleList) {
        this.mstyleList = mstyleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (styleID != null ? styleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Style)) {
            return false;
        }
        Style other = (Style) object;
        if ((this.styleID == null && other.styleID != null) || (this.styleID != null && !this.styleID.equals(other.styleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Style[ styleID=" + styleID + " ]";
    }
    
}

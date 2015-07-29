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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "stylist", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stylist.findAll", query = "SELECT s FROM Stylist s"),
    @NamedQuery(name = "Stylist.findByStylistID", query = "SELECT s FROM Stylist s WHERE s.stylistID = :stylistID"),
    @NamedQuery(name = "Stylist.findByName", query = "SELECT s FROM Stylist s WHERE s.name = :name"),
    @NamedQuery(name = "Stylist.findByPhone", query = "SELECT s FROM Stylist s WHERE s.phone = :phone"),
    @NamedQuery(name = "Stylist.findByEmail", query = "SELECT s FROM Stylist s WHERE s.email = :email"),
    @NamedQuery(name = "Stylist.stylistLogin", query = "SELECT s FROM Stylist s WHERE s.email = :email AND s.password = :password"),
    @NamedQuery(name = "Stylist.findByPassword", query = "SELECT s FROM Stylist s WHERE s.password = :password"),
    @NamedQuery(name = "Stylist.findByDate", query = "SELECT s FROM Stylist s WHERE s.date = :date"),
    @NamedQuery(name = "Stylist.findByStatus", query = "SELECT s FROM Stylist s WHERE s.status = :status")})
public class Stylist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stylistID")
    private Integer stylistID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "stylist")
    private List<StylistBranch> stylistBranchList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stylist")
    private List<Mstyle> mstyleList;

    public Stylist() {
    }

    public Stylist(Integer stylistID) {
        this.stylistID = stylistID;
    }

    public Stylist(Integer stylistID, String password) {
        this.stylistID = stylistID;
        this.password = password;
    }

    public Integer getStylistID() {
        return stylistID;
    }

    public void setStylistID(Integer stylistID) {
        this.stylistID = stylistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public List<StylistBranch> getStylistBranchList() {
        return stylistBranchList;
    }

    public void setStylistBranchList(List<StylistBranch> stylistBranchList) {
        this.stylistBranchList = stylistBranchList;
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
        hash += (stylistID != null ? stylistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stylist)) {
            return false;
        }
        Stylist other = (Stylist) object;
        if ((this.stylistID == null && other.stylistID != null) || (this.stylistID != null && !this.stylistID.equals(other.stylistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Stylist[ stylistID=" + stylistID + " ]";
    }
    
}

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
@Table(name = "branch", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchID", query = "SELECT b FROM Branch b WHERE b.branchID = :branchID"),
    @NamedQuery(name = "Branch.findByName", query = "SELECT b FROM Branch b WHERE b.name = :name"),
    @NamedQuery(name = "Branch.findByAddress", query = "SELECT b FROM Branch b WHERE b.address = :address"),
    @NamedQuery(name = "Branch.findByLatitude", query = "SELECT b FROM Branch b WHERE b.latitude = :latitude"),
    @NamedQuery(name = "Branch.findByLongitude", query = "SELECT b FROM Branch b WHERE b.longitude = :longitude"),
    @NamedQuery(name = "Branch.findByDate", query = "SELECT b FROM Branch b WHERE b.date = :date"),
    @NamedQuery(name = "Branch.findByStatus", query = "SELECT b FROM Branch b WHERE b.status = :status")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branchID")
    private Integer branchID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private List<Booking> bookingList;
    @OneToMany(mappedBy = "branch")
    private List<StylistBranch> stylistBranchList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private List<Timetable> timetableList;

    public Branch() {
    }

    public Branch(Integer branchID) {
        this.branchID = branchID;
    }

    public Branch(Integer branchID, String status) {
        this.branchID = branchID;
        this.status = status;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @XmlTransient
    public List<StylistBranch> getStylistBranchList() {
        return stylistBranchList;
    }

    public void setStylistBranchList(List<StylistBranch> stylistBranchList) {
        this.stylistBranchList = stylistBranchList;
    }

    @XmlTransient
    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchID != null ? branchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchID == null && other.branchID != null) || (this.branchID != null && !this.branchID.equals(other.branchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Branch[ branchID=" + branchID + " ]";
    }
    
}

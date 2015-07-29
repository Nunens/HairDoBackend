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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "stylistBranch", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StylistBranch.findAll", query = "SELECT s FROM StylistBranch s"),
    @NamedQuery(name = "StylistBranch.findByStylistBranchID", query = "SELECT s FROM StylistBranch s WHERE s.stylistBranchID = :stylistBranchID"),
    @NamedQuery(name = "StylistBranch.findByDate", query = "SELECT s FROM StylistBranch s WHERE s.date = :date"),
    @NamedQuery(name = "StylistBranch.findByStylist", query = "SELECT s FROM StylistBranch s WHERE s.stylist.stylistID = :id"),
    @NamedQuery(name = "StylistBranch.findByBranch", query = "SELECT s FROM StylistBranch s WHERE s.branch.branchID = :id"),
    @NamedQuery(name = "StylistBranch.findByStatus", query = "SELECT s FROM StylistBranch s WHERE s.status = :status")})
public class StylistBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stylistBranchID")
    private Integer stylistBranchID;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "stylistID", referencedColumnName = "stylistID")
    @ManyToOne
    private Stylist stylist;
    @JoinColumn(name = "branchID", referencedColumnName = "branchID")
    @ManyToOne
    private Branch branch;

    public StylistBranch() {
    }

    public StylistBranch(Integer stylistBranchID) {
        this.stylistBranchID = stylistBranchID;
    }

    public StylistBranch(Integer stylistBranchID, String status) {
        this.stylistBranchID = stylistBranchID;
        this.status = status;
    }

    public Integer getStylistBranchID() {
        return stylistBranchID;
    }

    public void setStylistBranchID(Integer stylistBranchID) {
        this.stylistBranchID = stylistBranchID;
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

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stylistBranchID != null ? stylistBranchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StylistBranch)) {
            return false;
        }
        StylistBranch other = (StylistBranch) object;
        if ((this.stylistBranchID == null && other.stylistBranchID != null) || (this.stylistBranchID != null && !this.stylistBranchID.equals(other.stylistBranchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.StylistBranch[ stylistBranchID=" + stylistBranchID + " ]";
    }
    
}

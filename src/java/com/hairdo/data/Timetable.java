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
@Table(name = "timetable", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t"),
    @NamedQuery(name = "Timetable.findByTimetableID", query = "SELECT t FROM Timetable t WHERE t.timetableID = :timetableID"),
    @NamedQuery(name = "Timetable.findByOpen", query = "SELECT t FROM Timetable t WHERE t.open = :open"),
    @NamedQuery(name = "Timetable.findByClose", query = "SELECT t FROM Timetable t WHERE t.close = :close"),
    @NamedQuery(name = "Timetable.findByBranch", query = "SELECT t FROM Timetable t WHERE t.branch.branchID = :id"),
    @NamedQuery(name = "Timetable.findByDate", query = "SELECT t FROM Timetable t WHERE t.date = :date"),
    @NamedQuery(name = "Timetable.findByStatus", query = "SELECT t FROM Timetable t WHERE t.status = :status")})
public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timetableID")
    private Integer timetableID;
    @Size(max = 255)
    @Column(name = "open")
    private String open;
    @Size(max = 255)
    @Column(name = "close")
    private String close;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "branchID", referencedColumnName = "branchID")
    @ManyToOne(optional = false)
    private Branch branch;

    public Timetable() {
    }

    public Timetable(Integer timetableID) {
        this.timetableID = timetableID;
    }

    public Integer getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(Integer timetableID) {
        this.timetableID = timetableID;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timetableID != null ? timetableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timetable)) {
            return false;
        }
        Timetable other = (Timetable) object;
        if ((this.timetableID == null && other.timetableID != null) || (this.timetableID != null && !this.timetableID.equals(other.timetableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Timetable[ timetableID=" + timetableID + " ]";
    }
    
}

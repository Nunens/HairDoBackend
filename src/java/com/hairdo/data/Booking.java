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
@Table(name = "booking", catalog = "HairLow", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingID", query = "SELECT b FROM Booking b WHERE b.bookingID = :bookingID"),
    @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :date"),
    @NamedQuery(name = "Booking.findByBookingTime", query = "SELECT b FROM Booking b WHERE b.bookingTime = :bookingTime"),
    @NamedQuery(name = "Booking.findByBranch", query = "SELECT b FROM Booking b WHERE b.branch.branchID = :id AND b.bookingDate > :date"),
    @NamedQuery(name = "Booking.findByCustomer", query = "SELECT b FROM Booking b WHERE b.customer.customerID = :id AND b.bookingDate > :date"),
    @NamedQuery(name = "Booking.findByDate", query = "SELECT b FROM Booking b WHERE b.date = :date"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookingID")
    private Integer bookingID;
    @Column(name = "bookingDate")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Size(max = 255)
    @Column(name = "bookingTime")
    private String bookingTime;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "branchID", referencedColumnName = "branchID")
    @ManyToOne(optional = false)
    private Branch branch;

    public Booking() {
    }

    public Booking(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        hash += (bookingID != null ? bookingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingID == null && other.bookingID != null) || (this.bookingID != null && !this.bookingID.equals(other.bookingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hairdo.data.Booking[ bookingID=" + bookingID + " ]";
    }
    
}

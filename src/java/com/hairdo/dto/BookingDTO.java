/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hairdo.dto;

import com.hairdo.data.Booking;

/**
 *
 * @author admin
 */
public class BookingDTO {
    private int bookingID;
    private long bookingDate;
    private String bookingTime;
    private long date;
    private String status;
    private int customerID;
    private int branchID;
    
    public BookingDTO(){
        
    }
    
    public BookingDTO(Booking a){
        bookingID = a.getBookingID();
        bookingDate = a.getBookingDate().getTime();
        bookingTime = a.getBookingTime();
        date = a.getDate().getTime();
        status = a.getStatus();
        customerID = a.getCustomer().getCustomerID();
        branchID = a.getBranch().getBranchID();
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public long getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(long bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    
    
}

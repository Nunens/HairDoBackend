/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.Customer;

/**
 *
 * @author admin
 */
public class CustomerDTO {

    private int customerID;
    private String name;
    private String phone;
    private String email;
    private long date;
    private String status;
    private String password;

    public CustomerDTO() {

    }

    public CustomerDTO(Customer a) {
        customerID = a.getCustomerID();
        name = a.getName();
        phone = a.getPhone();
        email = a.getEmail();
        date = a.getDate().getTime();
        status = a.getStatus();
        password = a.getPassword();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

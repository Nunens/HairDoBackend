/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.StylistBranch;

/**
 *
 * @author admin
 */
public class StylistBranchDTO {

    private int stylistBranchID;
    private long date;
    private String status;
    private int stylistID;
    private int branchID;
    private BranchDTO branch;
    private StylistDTO stylist;

    public StylistBranchDTO() {
    }

    public StylistBranchDTO(StylistBranch a) {
        stylistBranchID = a.getStylistBranchID();
        date = a.getDate().getTime();
        status = a.getStatus();
        stylistID = a.getStylist().getStylistID();
        branchID = a.getBranch().getBranchID();
        stylist = new StylistDTO(a.getStylist());
        branch = new BranchDTO(a.getBranch());
    }

    public int getStylistBranchID() {
        return stylistBranchID;
    }

    public void setStylistBranchID(int stylistBranchID) {
        this.stylistBranchID = stylistBranchID;
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

    public int getStylistID() {
        return stylistID;
    }

    public void setStylistID(int stylistID) {
        this.stylistID = stylistID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public StylistDTO getStylist() {
        return stylist;
    }

    public void setStylist(StylistDTO stylist) {
        this.stylist = stylist;
    }
    
    

}

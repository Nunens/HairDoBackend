/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import com.hairdo.data.Timetable;

/**
 *
 * @author admin
 */
public class TimetableDTO {

    private int timetableID;
    private String open;
    private String close;
    private long date;
    private String status;
    private int branchID;

    public TimetableDTO() {
    }

    public TimetableDTO(Timetable a) {
        timetableID = a.getTimetableID();
        open = a.getOpen();
        close = a.getClose();
        date = a.getDate().getTime();
        status = a.getStatus();
        branchID = a.getBranch().getBranchID();
    }

    public int getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(int timetableID) {
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

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

}

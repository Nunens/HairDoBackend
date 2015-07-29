/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

import java.util.List;

/**
 *
 * @author admin
 */
public class ResponseDTO {

    private int statusCode;
    private String message;
    public static final int OK = 0;
    public static final int SERVER_ERROR = 100;
    public static final int DATABASE_ERROR = 101;
    public static final int DATA_NOT_FOUND = 102;
    public static final int UNKNOWN_REQUEST = 103;
    
    private String sessionID;

    private BookingDTO booking;
    private BranchDTO branch;
    private CustomerDTO customer;
    private MproductDTO mproduct;
    private MstyleDTO mstyle;
    private ProductDTO product;
    private StyleDTO style;
    private StylistBranchDTO stylistBranch;
    private StylistDTO stylist;
    private TimetableDTO timetable;

    private List<BookingDTO> bookings;
    private List<BranchDTO> branchs;
    private List<CustomerDTO> customers;
    private List<MproductDTO> mproducts;
    private List<MstyleDTO> mstyles;
    private List<ProductDTO> products;
    private List<StyleDTO> styles;
    private List<StylistBranchDTO> stylistBranchs;
    private List<StylistDTO> stylists;
    private List<TimetableDTO> timetables;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public MproductDTO getMproduct() {
        return mproduct;
    }

    public void setMproduct(MproductDTO mproduct) {
        this.mproduct = mproduct;
    }

    public MstyleDTO getMstyle() {
        return mstyle;
    }

    public void setMstyle(MstyleDTO mstyle) {
        this.mstyle = mstyle;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public StyleDTO getStyle() {
        return style;
    }

    public void setStyle(StyleDTO style) {
        this.style = style;
    }

    public StylistBranchDTO getStylistBranch() {
        return stylistBranch;
    }

    public void setStylistBranch(StylistBranchDTO stylistBranch) {
        this.stylistBranch = stylistBranch;
    }

    public StylistDTO getStylist() {
        return stylist;
    }

    public void setStylist(StylistDTO stylist) {
        this.stylist = stylist;
    }

    public TimetableDTO getTimetable() {
        return timetable;
    }

    public void setTimetable(TimetableDTO timetable) {
        this.timetable = timetable;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }

    public List<BranchDTO> getBranchs() {
        return branchs;
    }

    public void setBranchs(List<BranchDTO> branchs) {
        this.branchs = branchs;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
        this.customers = customers;
    }

    public List<MproductDTO> getMproducts() {
        return mproducts;
    }

    public void setMproducts(List<MproductDTO> mproducts) {
        this.mproducts = mproducts;
    }

    public List<MstyleDTO> getMstyles() {
        return mstyles;
    }

    public void setMstyles(List<MstyleDTO> mstyles) {
        this.mstyles = mstyles;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<StyleDTO> getStyles() {
        return styles;
    }

    public void setStyles(List<StyleDTO> styles) {
        this.styles = styles;
    }

    public List<StylistBranchDTO> getStylistBranchs() {
        return stylistBranchs;
    }

    public void setStylistBranchs(List<StylistBranchDTO> stylistBranchs) {
        this.stylistBranchs = stylistBranchs;
    }

    public List<StylistDTO> getStylists() {
        return stylists;
    }

    public void setStylists(List<StylistDTO> stylists) {
        this.stylists = stylists;
    }

    public List<TimetableDTO> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<TimetableDTO> timetables) {
        this.timetables = timetables;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

}

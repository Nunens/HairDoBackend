/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.dto;

/**
 *
 * @author admin
 */
public class RequestDTO {

    public static final int addBooking = 1;
    public static final int updateBooking = 2;
    public static final int getBookings = 3;
    public static final int getBookingByCustomer = 4;
    public static final int getBookingByBranch = 5;
    public static final int addBranch = 6;
    public static final int updateBranch = 7;
    public static final int getBranchs = 8;
    public static final int addCustomer = 9;
    public static final int updateCustomer = 10;
    public static final int getCustomers = 11;
    public static final int customerLogin = 12;
    public static final int addMProduct = 13;
    public static final int updateMProduct = 14;
    public static final int getMProducts = 15;
    public static final int getMProductByProduct = 16;
    public static final int getMProductByStyle = 17;
    public static final int addMStyle = 18;
    public static final int updateMStyle = 19;
    public static final int getMStyles = 20;
    public static final int getMStyleByStyle = 21;
    public static final int getMStyleByStylist = 22;
    public static final int addProduct = 23;
    public static final int updateProduct = 24;
    public static final int getProducts = 25;
    public static final int addStyle = 26;
    public static final int updateStyle = 27;
    public static final int getStyles = 28;
    public static final int addStylist = 29;
    public static final int updateStylist = 30;
    public static final int getStylists = 31;
    public static final int addStylistBranch = 32;
    public static final int updateStylistBranch = 33;
    public static final int getStylistBranchs = 34;
    public static final int getStylistBranchByBranch = 35;
    public static final int getStylistBranchByStylist = 36;
    public static final int addTimetable = 37;
    public static final int updateTimetable = 38;
    public static final int getTimetables = 39;
    public static final int getTimetableByBranch = 40;
    public static final int stylistLogin = 41;
    public static final int getBookingByBookingDate = 42;

    private int requestType, bookingID, branchID, customerID, mproductID, mstyleID, productID, styleID, stylistID, stylistBranchID, timetableID;

    private BookingDTO bookingDTO;
    private BranchDTO branchDTO;
    private CustomerDTO customerDTO;
    private MproductDTO mproductDTO;
    private MstyleDTO mstyleDTO;
    private ProductDTO productDTO;
    private StyleDTO styleDTO;
    private StylistBranchDTO stylistBranchDTO;
    private StylistDTO stylistDTO;
    private TimetableDTO timetableDTO;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMproductID() {
        return mproductID;
    }

    public void setMproductID(int mproductID) {
        this.mproductID = mproductID;
    }

    public int getMstyleID() {
        return mstyleID;
    }

    public void setMstyleID(int mstyleID) {
        this.mstyleID = mstyleID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStyleID() {
        return styleID;
    }

    public void setStyleID(int styleID) {
        this.styleID = styleID;
    }

    public int getStylistID() {
        return stylistID;
    }

    public void setStylistID(int stylistID) {
        this.stylistID = stylistID;
    }

    public int getStylistBranchID() {
        return stylistBranchID;
    }

    public void setStylistBranchID(int stylistBranchID) {
        this.stylistBranchID = stylistBranchID;
    }

    public int getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(int timetableID) {
        this.timetableID = timetableID;
    }

    public BookingDTO getBookingDTO() {
        return bookingDTO;
    }

    public void setBookingDTO(BookingDTO bookingDTO) {
        this.bookingDTO = bookingDTO;
    }

    public BranchDTO getBranchDTO() {
        return branchDTO;
    }

    public void setBranchDTO(BranchDTO branchDTO) {
        this.branchDTO = branchDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public MproductDTO getMproductDTO() {
        return mproductDTO;
    }

    public void setMproductDTO(MproductDTO mproductDTO) {
        this.mproductDTO = mproductDTO;
    }

    public MstyleDTO getMstyleDTO() {
        return mstyleDTO;
    }

    public void setMstyleDTO(MstyleDTO mstyleDTO) {
        this.mstyleDTO = mstyleDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public StyleDTO getStyleDTO() {
        return styleDTO;
    }

    public void setStyleDTO(StyleDTO styleDTO) {
        this.styleDTO = styleDTO;
    }

    public StylistBranchDTO getStylistBranchDTO() {
        return stylistBranchDTO;
    }

    public void setStylistBranchDTO(StylistBranchDTO stylistBranchDTO) {
        this.stylistBranchDTO = stylistBranchDTO;
    }

    public StylistDTO getStylistDTO() {
        return stylistDTO;
    }

    public void setStylistDTO(StylistDTO stylistDTO) {
        this.stylistDTO = stylistDTO;
    }

    public TimetableDTO getTimetableDTO() {
        return timetableDTO;
    }

    public void setTimetableDTO(TimetableDTO timetableDTO) {
        this.timetableDTO = timetableDTO;
    }

}

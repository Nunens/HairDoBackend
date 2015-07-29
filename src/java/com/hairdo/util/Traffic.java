/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.util;

import com.google.gson.Gson;
import com.hairdo.dto.RequestDTO;
import com.hairdo.dto.ResponseDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Traffic {

    private static final Logger log = Logger.getLogger("Traffic");

    public static ResponseDTO processRequest(RequestDTO dto, DataUtil util) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Gson gson = new Gson();
        log.log(Level.INFO, dto.toString());
        log.log(Level.INFO, "###### ---> Starting AR Pilot main: requestType = {0}", dto.getRequestType());
        switch (dto.getRequestType()) {
            case RequestDTO.customerLogin:
                resp = util.customerLogin(dto.getCustomerDTO());
                break;
            case RequestDTO.stylistLogin:
                resp = util.stylistLogin(dto.getStylistDTO());
                break;
            case RequestDTO.addBooking:
                resp = util.addBooking(dto.getBookingDTO());
                break;
            case RequestDTO.addBranch:
                resp = util.addBranch(dto.getBranchDTO());
                break;
            case RequestDTO.addCustomer:
                resp = util.addCustomer(dto.getCustomerDTO());
                break;
            case RequestDTO.addMProduct:
                resp = util.addMProduct(dto.getMproductDTO());
                break;
            case RequestDTO.addMStyle:
                resp = util.addMStyle(dto.getMstyleDTO());
                break;
            case RequestDTO.addProduct:
                resp = util.addProduct(dto.getProductDTO());
                break;
            case RequestDTO.addStyle:
                resp = util.addStyle(dto.getStyleDTO());
                break;
            case RequestDTO.addStylist:
                resp = util.addStylist(dto.getStylistDTO());
                break;
            case RequestDTO.addStylistBranch:
                resp = util.addStylistBranch(dto.getStylistBranchDTO());
                break;
            case RequestDTO.addTimetable:
                resp = util.addTimetable(dto.getTimetableDTO());
                break;
            case RequestDTO.updateBooking:
                resp = util.updateBooking(dto.getBookingDTO());
                break;
            case RequestDTO.updateBranch:
                resp = util.updateBranch(dto.getBranchDTO());
                break;
            case RequestDTO.updateCustomer:
                resp = util.updateCustomer(dto.getCustomerDTO());
                break;
            case RequestDTO.updateMStyle:
                resp = util.updateMStyle(dto.getMstyleDTO());
                break;
            case RequestDTO.updateMProduct:
                resp = util.updateMProduct(dto.getMproductDTO());
                break;
            case RequestDTO.updateProduct:
                resp = util.updateProduct(dto.getProductDTO());
                break;
            case RequestDTO.updateStyle:
                resp = util.updateStyle(dto.getStyleDTO());
                break;
            case RequestDTO.updateStylist:
                resp = util.updateStylist(dto.getStylistDTO());
                break;
            case RequestDTO.updateStylistBranch:
                resp = util.updateStylistBranch(dto.getStylistBranchDTO());
                break;
            case RequestDTO.updateTimetable:
                resp = util.updateTimetable(dto.getTimetableDTO());
                break;
            case RequestDTO.getBookingByBookingDate:
                resp = util.getBookingByBookingDate();
                break;
            case RequestDTO.getBookingByBranch:
                resp = util.getBookingByBranch(dto.getBranchID());
                break;
            case RequestDTO.getBookingByCustomer:
                resp = util.getBookingByCustomer(dto.getCustomerID());
                break;
            case RequestDTO.getBookings:
                resp = util.getBookings();
                break;
            case RequestDTO.getBranchs:
                resp = util.getBranches();
                break;
            case RequestDTO.getMProductByProduct:
                resp = util.getMProductByProduct(dto.getProductID());
                break;
            case RequestDTO.getMProductByStyle:
                resp = util.getMProductByStyle(dto.getStyleID());
                break;
            case RequestDTO.getMStyleByStyle:
                resp = util.getMStyleByStyle(dto.getStyleID());
                break;
            case RequestDTO.getMStyleByStylist:
                resp = util.getMStyleByStylist(dto.getStylistID());
                break;
            case RequestDTO.getProducts:
                resp = util.getProducts();
                break;
            case RequestDTO.getStyles:
                resp = util.getStyles();
                break;
            case RequestDTO.getStylists:
                resp = util.getStylists();
                break;
            case RequestDTO.getStylistBranchByBranch:
                resp = util.getStylistBranchByBranch(dto.getBranchID());
                break;
            case RequestDTO.getStylistBranchByStylist:
                resp = util.getStylistBranchByStylist(dto.getStylistID());
                break;
            case RequestDTO.getTimetableByBranch:
                resp = util.getTimetableByBranch(dto.getBranchID());
                break;
        }
        return resp;
    }
}

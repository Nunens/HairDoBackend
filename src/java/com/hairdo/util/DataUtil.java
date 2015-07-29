/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hairdo.util;

import com.hairdo.data.Booking;
import com.hairdo.data.Branch;
import com.hairdo.data.Customer;
import com.hairdo.data.Mproduct;
import com.hairdo.data.Mstyle;
import com.hairdo.data.Product;
import com.hairdo.data.Style;
import com.hairdo.data.Stylist;
import com.hairdo.data.StylistBranch;
import com.hairdo.data.Timetable;
import com.hairdo.dto.BookingDTO;
import com.hairdo.dto.BranchDTO;
import com.hairdo.dto.CustomerDTO;
import com.hairdo.dto.MproductDTO;
import com.hairdo.dto.MstyleDTO;
import com.hairdo.dto.ProductDTO;
import com.hairdo.dto.ResponseDTO;
import com.hairdo.dto.StyleDTO;
import com.hairdo.dto.StylistBranchDTO;
import com.hairdo.dto.StylistDTO;
import com.hairdo.dto.TimetableDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sipho
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {

    private static final Logger log = Logger.getLogger("DataUtil");

    @PersistenceContext(unitName = "HairDoPU")
    private EntityManager em;

    public Booking getbooking(int id) {
        return em.find(Booking.class, id);
    }

    public Branch getBranch(int id) {
        return em.find(Branch.class, id);
    }

    public Customer getCustomer(int id) {
        return em.find(Customer.class, id);
    }

    public Mproduct getMproduct(int id) {
        return em.find(Mproduct.class, id);
    }

    public Mstyle getMstyle(int id) {
        return em.find(Mstyle.class, id);
    }

    public Product getProduct(int id) {
        return em.find(Product.class, id);
    }

    public Style getStyle(int id) {
        return em.find(Style.class, id);
    }

    public StylistBranch getStylistBranch(int id) {
        return em.find(StylistBranch.class, id);
    }

    public Stylist getStylist(int id) {
        return em.find(Stylist.class, id);
    }

    public Timetable getTimetable(int id) {
        return em.find(Timetable.class, id);
    }

    public ResponseDTO addBooking(BookingDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Booking a = new Booking();
            a.setBookingDate(new Date(dto.getBookingDate()));
            a.setBookingTime(dto.getBookingTime());
            a.setBranch(getBranch(dto.getBranchID()));
            a.setCustomer(getCustomer(dto.getCustomerID()));
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Booking Added");
            resp.setBooking(new BookingDTO(a));
            log.log(Level.INFO, "Added Booking {0}", a.getBookingID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Booking Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateBooking(BookingDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Booking a = getbooking(dto.getBookingID());
            a.setBookingDate(new Date(dto.getBookingDate()));
            a.setBookingTime(dto.getBookingTime());
            a.setBranch(getBranch(dto.getBranchID()));
            a.setCustomer(getCustomer(dto.getCustomerID()));
            a.setDate(new Date());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Booking Updated");
            resp.setBooking(new BookingDTO(a));
            log.log(Level.INFO, "Updated Booking {0}", a.getBookingID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Booking Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getBookings() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Booking.findAll", Booking.class);
            List<Booking> list = q.getResultList();
            List<BookingDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                //list.stream().forEach((cr) -> {
                for (Booking cr : list) {
                    gList.add(new BookingDTO(cr));
                }
                resp.setMessage("Booking found: " + gList.size());
                resp.setStatusCode(0);
                resp.setBookings(gList);
            } else {
                resp.setMessage("No Booking found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Booking {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ResponseDTO getBookingByBranch(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Booking.findByBranch", Booking.class);
            q.setParameter("id", id);
            q.setParameter("date", sdf.format(new Date()));
            List<Booking> list = q.getResultList();
            List<BookingDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                //list.stream().forEach((cr) -> {
                for (Booking cr : list) {
                    gList.add(new BookingDTO(cr));
                }
                resp.setMessage("Booking found: " + gList.size());
                resp.setStatusCode(0);
                resp.setBookings(gList);
            } else {
                resp.setMessage("No Booking found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Booking {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getBookingByCustomer(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Booking.findByCustomer", Booking.class);
            q.setParameter("id", id);
            q.setParameter("date", sdf.format(new Date()));
            List<Booking> list = q.getResultList();
            List<BookingDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                //list.stream().forEach((cr) -> {
                for (Booking cr : list) {
                    gList.add(new BookingDTO(cr));
                }
                resp.setMessage("Booking found: " + gList.size());
                resp.setStatusCode(0);
                resp.setBookings(gList);
            } else {
                resp.setMessage("No Booking found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Booking {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    
    public ResponseDTO getBookingByBookingDate() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Booking.findByBookingDate", Booking.class);
            q.setParameter("date", sdf.format(new Date()));
            List<Booking> list = q.getResultList();
            List<BookingDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                //list.stream().forEach((cr) -> {
                for (Booking cr : list) {
                    gList.add(new BookingDTO(cr));
                }
                resp.setMessage("Booking found: " + gList.size());
                resp.setStatusCode(0);
                resp.setBookings(gList);
            } else {
                resp.setMessage("No Booking found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Booking {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addBranch(BranchDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Branch a = new Branch();
            a.setAddress(dto.getAddress());
            a.setDate(new Date());
            a.setLatitude(dto.getLatitude());
            a.setLongitude(dto.getLongitude());
            a.setName(dto.getName());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Branch successfully added");
            resp.setBranch(new BranchDTO(a));
            log.log(Level.INFO, "Added Branch {0}", a.getBranchID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Branch Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateBranch(BranchDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Branch a = getBranch(dto.getBranchID());
            a.setAddress(dto.getAddress());
            //a.setDate(new Date());
            a.setLatitude(dto.getLatitude());
            a.setLongitude(dto.getLongitude());
            a.setName(dto.getName());
            a.setStatus("Active");
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Branch successfully updated");
            resp.setBranch(new BranchDTO(a));
            log.log(Level.INFO, "Updated branch {0}", a.getBranchID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Branch Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getBranches() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Branch.findAll", Branch.class);
            List<Branch> list = q.getResultList();
            List<BranchDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Branch a : list) {
                    vList.add(new BranchDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Branches found: " + vList.size());
                resp.setBranchs(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No Branches found");
            }
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addCustomer(CustomerDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Customer a = new Customer();
            a.setDate(new Date());
            a.setEmail(dto.getEmail());
            a.setName(dto.getName());
            a.setPhone(dto.getPhone());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Customer succefully added");
            resp.setCustomer(new CustomerDTO(a));
            log.log(Level.INFO, "Added Customer {0}", a.getCustomerID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Customer Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateCustomer(CustomerDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Customer a = getCustomer(dto.getCustomerID());
            a.setEmail(dto.getEmail());
            a.setName(dto.getName());
            a.setPhone(dto.getPhone());
            a.setStatus("Active");
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Customer succefully updated");
            resp.setCustomer(new CustomerDTO(a));
            log.log(Level.INFO, "Updating Customer {0}", a.getCustomerID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Customer Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getCustomerByID(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Customer.findByCustomerID", Customer.class);
            q.setParameter("customerID", id);
            List<Customer> list = q.getResultList();
            List<CustomerDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                //list.stream().forEach((cr) -> {
                for (Customer cr : list) {
                    gList.add(new CustomerDTO(cr));
                }
                resp.setMessage("Customer found: " + gList.size());
                resp.setStatusCode(0);
                resp.setCustomers(gList);
            } else {
                resp.setMessage("No Customer found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Customer {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO customerLogin(CustomerDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Customer.login", Customer.class);
            q.setParameter("email", dto.getEmail());
            q.setParameter("password", dto.getPassword());
            List<Customer> list = q.getResultList();
            List<CustomerDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                list.stream().forEach((cr) -> {
                    gList.add(new CustomerDTO(cr));
                });
                resp.setMessage("Customer found: " + gList.size());
                resp.setStatusCode(0);
                resp.setCustomers(gList);
            } else {
                resp.setMessage("No Customer found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found Customer {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addMProduct(MproductDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Mproduct a = new Mproduct();
            a.setDate(new Date());
            a.setProduct(getProduct(dto.getProductID()));
            a.setStatus("Active");
            a.setStyle(getStyle(dto.getStyleID()));
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("MProduct successfully added");
            resp.setMproduct(new MproductDTO(a));
            log.log(Level.OFF, "MProduct successfully added {0}", a.getMproductID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding MProduct Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateMProduct(MproductDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Mproduct a = getMproduct(dto.getMproductID());
            a.setProduct(getProduct(dto.getProductID()));
            a.setStyle(getStyle(dto.getStyleID()));
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("MProduct successfully updated");
            resp.setMproduct(new MproductDTO(a));
            log.log(Level.OFF, "MProduct successfully updated {0}", a.getMproductID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating MProduct Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getMProductByStyle(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Mproduct.findByStyle", Mproduct.class);
            q.setParameter("id", id);
            List<Mproduct> list = q.getResultList();
            List<MproductDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Mproduct a : list) {
                    vList.add(new MproductDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("MProducts found: " + vList.size());
                resp.setMproducts(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No MProducts found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting MProduct Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO getMProductByProduct(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Mproduct.findByProduct", Mproduct.class);
            q.setParameter("id", id);
            List<Mproduct> list = q.getResultList();
            List<MproductDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Mproduct a : list) {
                    vList.add(new MproductDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("MProducts found: " + vList.size());
                resp.setMproducts(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No MProducts found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting MProduct Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addMStyle(MstyleDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Mstyle a = new Mstyle();
            a.setDate(new Date());
            a.setStatus("Active");
            a.setPrice(dto.getPrice());
            a.setStyle(getStyle(dto.getStyleID()));
            a.setStylist(getStylist(dto.getStylistID()));
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("MStyle successfully added");
            resp.setMstyle(new MstyleDTO(a));
            log.log(Level.OFF, "Added MStyle {0}", a.getMstyleID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding MStyle Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateMStyle(MstyleDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Mstyle a = getMstyle(dto.getMstyleID());
            a.setPrice(dto.getPrice());
            a.setStyle(getStyle(dto.getStyleID()));
            a.setStylist(getStylist(dto.getStylistID()));
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("MStyle successfully updated");
            resp.setMstyle(new MstyleDTO(a));
            log.log(Level.OFF, "Added MStyle {0}", a.getMstyleID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating MStyle Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getMStyleByStyle(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Mstyle.findByStyle", Mstyle.class);
            q.setParameter("id", id);
            List<Mstyle> list = q.getResultList();
            List<MstyleDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Mstyle a : list) {
                    vList.add(new MstyleDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("MStyles found: " + vList.size());
                resp.setMstyles(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No MStyles found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting Mstyle Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO getMStyleByStylist(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Mstyle.findByStylist", Mstyle.class);
            q.setParameter("id", id);
            List<Mstyle> list = q.getResultList();
            List<MstyleDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Mstyle a : list) {
                    vList.add(new MstyleDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("MStyles found: " + vList.size());
                resp.setMstyles(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No MStyles found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting Mstyle Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addProduct(ProductDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Product a = new Product();
            a.setDate(new Date());
            a.setDescription(dto.getDescription());
            a.setName(dto.getName());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Product successfully added");
            resp.setProduct(new ProductDTO(a));
            log.log(Level.OFF, "added product {0}", a.getProductID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding product Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateProduct(ProductDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Product a = getProduct(dto.getProductID());
            a.setDescription(dto.getDescription());
            a.setName(dto.getName());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Product successfully updated");
            resp.setProduct(new ProductDTO(a));
            log.log(Level.OFF, "updated product {0}", a.getProductID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating product Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getProducts() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Product.findAll", Product.class);
            List<Product> list = q.getResultList();
            List<ProductDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Product a : list) {
                    vList.add(new ProductDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Products found: " + vList.size());
                resp.setProducts(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No Products found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting Mstyle Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addStyle(StyleDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Style a = new Style();
            a.setDate(new Date());
            a.setDescription(dto.getDescription());
            a.setImageURL(dto.getImageURL());
            a.setName(dto.getName());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Style successfully added");
            resp.setStyle(new StyleDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding style Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateStyle(StyleDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Style a = new Style();
            a.setDescription(dto.getDescription());
            a.setImageURL(dto.getImageURL());
            a.setName(dto.getName());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Style successfully updated");
            resp.setStyle(new StyleDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating style Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getStyles() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Style.findAll", Style.class);
            List<Style> list = q.getResultList();
            List<StyleDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Style a : list) {
                    vList.add(new StyleDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Styles found: " + vList.size());
                resp.setStyles(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No styles found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting style Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addStylistBranch(StylistBranchDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            StylistBranch a = new StylistBranch();
            a.setBranch(getBranch(dto.getBranchID()));
            a.setDate(new Date());
            a.setStatus("Active");
            a.setStylist(getStylist(dto.getStylistID()));
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Stylist branch successfully added");
            resp.setStylistBranch(new StylistBranchDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding stylist branch Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateStylistBranch(StylistBranchDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            StylistBranch a = getStylistBranch(dto.getStylistBranchID());
            a.setBranch(getBranch(dto.getBranchID()));
            a.setStylist(getStylist(dto.getStylistID()));
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Stylist branch successfully updated");
            resp.setStylistBranch(new StylistBranchDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating stylist branch Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getStylistBranchByStylist(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("StylistBranch.findByStylist", StylistBranch.class);
            q.setParameter("id", id);
            List<StylistBranch> list = q.getResultList();
            List<StylistBranchDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (StylistBranch a : list) {
                    vList.add(new StylistBranchDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Stylist branches found: " + vList.size());
                resp.setStylistBranchs(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No stylist branches found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting style Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO getStylistBranchByBranch(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("StylistBranch.findByBranch", StylistBranch.class);
            q.setParameter("id", id);
            List<StylistBranch> list = q.getResultList();
            List<StylistBranchDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (StylistBranch a : list) {
                    vList.add(new StylistBranchDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Stylist branches found: " + vList.size());
                resp.setStylistBranchs(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No stylist branches found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting style Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addStylist(StylistDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Stylist a = new Stylist();
            a.setDate(new Date());
            a.setEmail(dto.getEmail());
            a.setName(dto.getName());
            a.setPassword(dto.getPassword());
            a.setPhone(dto.getPhone());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Stylist successfully added");
            resp.setStylist(new StylistDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding stylist Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateStylist(StylistDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Stylist a = getStylist(dto.getStylistID());
            a.setEmail(dto.getEmail());
            a.setName(dto.getName());
            a.setPassword(dto.getPassword());
            a.setPhone(dto.getPhone());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Stylist successfully updated");
            resp.setStylist(new StylistDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating stylist Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getStylists() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Stylist.findAll", Stylist.class);
            List<Stylist> list = q.getResultList();
            List<StylistDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Stylist a : list) {
                    vList.add(new StylistDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Stylist found: " + vList.size());
                resp.setStylists(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No stylists found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting stylists Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO stylistLogin(StylistDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Stylist.stylistLogin", Stylist.class);
            q.setParameter("email", dto.getEmail());
            q.setParameter("password", dto.getPassword());
            List<Stylist> list = q.getResultList();
            List<StylistDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Stylist a : list) {
                    vList.add(new StylistDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Stylist found: " + vList.size());
                resp.setStylists(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No stylists found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting stylists Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }

    public ResponseDTO addTimetable(TimetableDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Timetable a = new Timetable();
            a.setBranch(getBranch(dto.getBranchID()));
            a.setClose(dto.getClose());
            a.setDate(new Date());
            a.setOpen(dto.getOpen());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Timetable successfully added");
            resp.setTimetable(new TimetableDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** adding timetable Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateTimetable(TimetableDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Timetable a = getTimetable(dto.getTimetableID());
            a.setBranch(getBranch(dto.getBranchID()));
            a.setClose(dto.getClose());
            a.setOpen(dto.getOpen());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Timetable successfully updated");
            resp.setTimetable(new TimetableDTO(a));
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** updating timetable Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getTimetableByBranch(int id) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Timetable.findByBranch", Timetable.class);
            q.setParameter("id", id);
            List<Timetable> list = q.getResultList();
            List<TimetableDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Timetable a : list) {
                    vList.add(new TimetableDTO(a));
                }
                resp.setStatusCode(0);
                resp.setMessage("Timetables found: " + vList.size());
                resp.setTimetables(vList);
            } else {
                resp.setStatusCode(ResponseDTO.DATA_NOT_FOUND);
                resp.setMessage("No timetables found");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** getting stylists Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
        }
        return resp;
    }
}

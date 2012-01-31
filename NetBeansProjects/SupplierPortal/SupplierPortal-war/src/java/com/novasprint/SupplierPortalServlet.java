/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novasprint;

import com.novasprint.ejb.SupplierPortalRemote;
import com.novasprint.jb.SupplierBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alfred.wong
 */
public class SupplierPortalServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String sregcode;
    @EJB
    private SupplierPortalRemote supplierPortal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        sregcode = request.getParameter("sregcode");
        if (sregcode != null && sregcode.length() > 0) {
            SupplierBean sbean = supplierPortal.getSupplierInfo(sregcode);
            request.setAttribute("supplierbean", sbean);
            String url = "../WebPages/supplierInfo.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        }


        //get the supplierbean from session
        HttpSession ses = request.getSession();
        SupplierBean sbean = (SupplierBean) ses.getAttribute("supplierregbean");

        String supplier_reg_code = sbean.getSupplier_reg_code();
        String supplier_name = sbean.getSupplier_name();
        String supplier_address = sbean.getSupplier_address();
        String supplier_number = sbean.getSupplier_number();
        String supplier_website = sbean.getSupplier_website();
        int status = sbean.getStatus();
        String created_by = sbean.getCreated_by();
        Timestamp created_date = sbean.getCreated_date();

        Hashtable formParams = new Hashtable();
        formParams.put("supplier_reg_code", supplier_reg_code);
        formParams.put("supplier_name", supplier_name);
        formParams.put("supplier_address", supplier_address);
        formParams.put("supplier_number", supplier_number);
        formParams.put("supplier_website", supplier_website);
        formParams.put("status", status);
        formParams.put("created_by", created_by);
        formParams.put("created_date", created_date);

        String userID = request.getParameter("userID");

        supplierPortal.registerSupplier(formParams, userID);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

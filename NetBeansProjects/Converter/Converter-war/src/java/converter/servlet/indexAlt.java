/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter.servlet;

import converter.ejb.Converter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alfred.wong
 */
public class indexAlt extends HttpServlet {

//    private Converter converter = null;
    private String amount;
    private BigDecimal yenAmount;
    private BigDecimal euroAmount;

    /* CASE lookup using @Annotation start*/
    @EJB
    private Converter converter;
    /* CASE lookup using @Annotation end*/
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        try {

            /* CASE lookup using JNDI method#1 - using '.class.getName()' method [used by javaee5tut]WORKS- start*/
            /*http://download.oracle.com/javaee/5/tutorial/doc/bnbnp.html*/
//            InitialContext ic = new InitialContext();
//            Converter converter = (Converter) ic.lookup(Converter.class.getName()); //must have import converter.ejb.Converter;
            /* CASE lookup using JNDI end*/

            /* CASE lookup using JNDI method#2 - using 'remote interface fqdn' method [used by wiki netbeans]WORKS- start*/
            /*reference: http://wiki.netbeans.org/CreatingEJB3UsingNetbeansAndGlassfish*/
            /**don't pass a .properties file as a parameter to the InitialContext
             * - that is only for a standalone client where
             * there is a webserver running - see wiki abvmentnd*/
//            InitialContext ctx = new InitialContext();
//            Converter converter = (Converter) ctx.lookup("converter.ejb.Converter"); //must have import converter.ejb.Converter;
            /* CASE lookup using JNDI end*/

            /* CASE lookup using JNDI method#3 - using 'jndi name defined in jboss.xml' method [used for jboss- see note below: ]DUNWORKS- start*/
            /*reference: nova training II pg18*/
//            Context initial = new InitialContext();
//            Object converter = initial.lookup("ejb/ConverterBean"); //must configure (1.)ejb-jar.xml & (2.) jboss.xml
            /* CASE lookup using JNDI end*/

            amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
            BigDecimal d = new BigDecimal(amount);

            yenAmount = converter.dollarToYen(d);
            euroAmount = converter.yenToEuro(yenAmount);
            }
            
        }

        /*CASE : JNDI start*/
//        catch (NamingException ex) {
//            Logger.getLogger(indexAlt.class.getName()).log(Level.SEVERE, null, ex);
//        }
        /*CASE : JNDI end*/

        /*CASE : @EJB start*/
        catch (Exception ex) {
            System.err.println("Caught an unexpected exception!");
            ex.printStackTrace();
        }
        /*CASE : @EJB end*/


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet indexAlt</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet indexAlt at " + request.getContextPath () + "</h1>");
            out.println("<br/>");
            out.println("<b>Amount Entered: </b>"+amount+"<br/>");
            out.println(amount+" Dollars are: "+yenAmount+" Yen");
            out.println(yenAmount+" Yen are: "+euroAmount+" Euros");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
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

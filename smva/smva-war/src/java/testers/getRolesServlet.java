/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * http://stackoverflow.com/questions/1726041/pass-resultset-from-servlet-to-jsp
 */

package testers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smva.ejb.SMVASession;
import com.smva.jb.RoleBean;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author alfred.wong
 */
public class getRolesServlet extends HttpServlet {

    @EJB
    private SMVASession rif;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList<RoleBean> alRoleBean = new ArrayList<RoleBean> ();
            alRoleBean = rif.getRoles();
            request.setAttribute("alRoleBean", alRoleBean);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/getRoles.jsp");
            rd.forward(request, response);
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet getRolesServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet getRolesServlet at " + request.getContextPath () + "</h1>");
//            //out.println("<br> " +rs.getString("role_name") + " | " +rs.getString("role_desc"));
//            out.println("</body>");
//            out.println("</html>");
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

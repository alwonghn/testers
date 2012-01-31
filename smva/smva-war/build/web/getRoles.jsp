<%-- 
    Document   : getRoles
    Created on : Nov 30, 2011, 7:24:28 PM
    Author     : alfred.wong
--%>
<%--copy from
    Document   : testdbconnection
    Created on : Oct 5, 2011, 6:09:22 PM
    Author     : alfred.wong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.smva.jb.RoleBean,java.util.*,javax.naming.*,javax.sql.DataSource,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>





 <%

    //  DataSource ds = null;
    //  Connection con = null;
    //  PreparedStatement ps = null;
    //  InitialContext ic;
    //  try {
    //  ic = new InitialContext();
    //  ds = (DataSource)ic.lookup( "java:/jdbc/AVMS" );
      //ds = (DataSource)ic.lookup( "java:/jboss" );
    //  con = ds.getConnection();
    //  ps = con.prepareStatement("SELECT * FROM dbo.ROLE");
      //pr = con.prepareStatement("SELECT * FROM dbo.JMS_USERS");
    //  ResultSet rs = ps.executeQuery();
    //  while (rs.next()) {
    //      out.println("<br> " +rs.getString("role_name") + " | " +rs.getString("role_desc"));
          //out.println("<br> " +rs.getString("USERID") + " | " +rs.getString("PASSWD"));
    //  }
    //  rs.close();
    //  ps.close();
    //  }catch(Exception e){
    //      out.println("Exception thrown :: " +e);
    //  }finally{
    //  if(con != null){
    //  con.close();
    // }
    //}

    //request.setAttribute("arr", new String[]{"one", "two", "three"});
    ArrayList<RoleBean> alRoleBean = new ArrayList<RoleBean> ();
    if(request.getSession().getAttribute("alRoleBean") !=null){
        alRoleBean = (ArrayList<RoleBean>)request.getSession().getAttribute("alRoleBean");
    }
 %>



 <html>
     <body>
         <table border ="1">
             <tr>
                 <th>Ind</th>
                 <th>Name</th>
                 <th>Desc</th>
                 <th>Mgt?</th>         
             </tr>
             <%--<c:forEach var="role" items="${requestScope.alRoleBean}">--%>
             <c:forEach var="role" items="${alRoleBean}">
                 <tr>
                     <td><c:out value="${role.role_ind}"/></td>
                     <td><c:out value="${role.role_name}"/></td>
                     <td><c:out value="${role.role_desc}"/></td>
                     <td><c:out value="${role.supervisor_role}"/></td>
                 </tr>
             </c:forEach>

         </table>
     </body>
 </html>
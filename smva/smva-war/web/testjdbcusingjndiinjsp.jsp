<%-- 
    Document   : testjdbcusingjndiinjsp
    Created on : Nov 30, 2011, 4:26:57 PM
    Author     : alfred.wong
--%>

<%--copy from
    Document   : testdbconnection
    Created on : Oct 5, 2011, 6:09:22 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,javax.naming.*,javax.sql.DataSource,java.sql.*"%>

 <%

  DataSource ds = null;
  Connection con = null;
  PreparedStatement ps = null;
  InitialContext ic;
  try {
  ic = new InitialContext();
  ds = (DataSource)ic.lookup( "java:/jdbc/AVMS" );
  //ds = (DataSource)ic.lookup( "java:/jboss" );
  con = ds.getConnection();
  ps = con.prepareStatement("SELECT * FROM dbo.ROLE");
  //pr = con.prepareStatement("SELECT * FROM dbo.JMS_USERS");
  ResultSet rs = ps.executeQuery();
  while (rs.next()) {
      out.println("<br> " +rs.getString("role_name") + " | " +rs.getString("role_desc"));
      //out.println("<br> " +rs.getString("USERID") + " | " +rs.getString("PASSWD"));
  }
  rs.close();
  ps.close();
  }catch(Exception e){
      out.println("Exception thrown :: " +e);
  }finally{
  if(con != null){
  con.close();
 }
} %>


<%--THISCODE: CLIENT CODE TO QUERY MSSQL DATABASE--%>
<%--Required: 1.AppServer:JBoss 2.Database:MSSQL--%>
<%--Previous Steps b4 running this code: instructions at  setup_app@jboss^appdb@mssql--%>
<%@page contentType="text/html"
 import="java.util.*,javax.naming.*,javax.sql.DataSource,java.sql.*"
 %>
 <%

  DataSource ds = null;
  Connection con = null;
  PreparedStatement pr = null;
  InitialContext ic;
  try {
  ic = new InitialContext();
  ds = (DataSource)ic.lookup( "java:jdbc/jboss" );  //nb: per:http://javahowto.blogspot.com/2006/08/access-jboss-datasource-remotely-from.html   if use <use-java-context>false</use-java-context> in the mysql-ds.xml file, then :  ds = (DataSource)ic.lookup( "jdbc/jboss" );
  con = ds.getConnection();
  pr = con.prepareStatement("SELECT USERID, PASSWD FROM dbo.JMS_USERS");
  ResultSet rs = pr.executeQuery();
  while (rs.next()) {
  out.println("<br> " +rs.getString("USERID") + " | " +rs.getString("PASSWD"));
  }
  rs.close();
  pr.close();
  }catch(Exception e){
  out.println("Exception thrown " +e);
  }finally{
  if(con != null){
  con.close();
 }
} %> 

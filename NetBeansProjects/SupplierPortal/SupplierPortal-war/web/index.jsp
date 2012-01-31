<%-- 
    Document   : index
    Created on : Sep 9, 2011, 4:11:33 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search and Register Suppliers</title>
    </head>
    <body>
        <h1>Search and Register Suppliers</h1>

        <form method="get" action="SupplierPortalServlet">
            Enter Supplier Registration Code:<input name="sregcode" type="TEXT" value="supplier_reg_code">
            <input type="submit" value="Search Supplier">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>


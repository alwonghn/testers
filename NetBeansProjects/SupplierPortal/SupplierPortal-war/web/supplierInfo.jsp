<%-- 
    Document   : supplierInfo
    Created on : Sep 14, 2011, 2:26:57 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Information</title>
    </head>
    <body>
        <h1>Supplier Information</h1>

        <jsp:useBean id="supplierbean" class="com.novasprint.jb.SupplierBean" scope="request"/>

        Supplier Registration Code: <jsp:getProperty name="supplierbean" property="supplier_reg_code"/>
        Supplier Name: <jsp:getProperty name="supplierbean" property="supplier_name"/>
        Supplier Address: <jsp:getProperty name="supplierbean" property="supplier_address"/>
        Supplier Number: <jsp:getProperty name="supplierbean" property="supplier_number"/>
        Supplier Website: <jsp:getProperty name="supplierbean" property="supplier_website"/>
        Supplier Status: <jsp:getProperty name="supplierbean" property="status"/>
        Created By: <jsp:getProperty name="supplierbean" property="created_by"/>
        Created Date: <jsp:getProperty name="supplierbean" property="created_date"/>

        <a href="/registerSupplier.jsp"><button type="submit">Register Supplier</button></a>
    </body>
</html>

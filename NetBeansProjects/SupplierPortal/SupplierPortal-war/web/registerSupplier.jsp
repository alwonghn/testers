<%-- 
    Document   : RegisterSupplier
    Created on : Sep 12, 2011, 5:36:23 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--<jsp:useBean id="supplierregbean" class="com.novasprint.jb.SupplierBean" scope="request"/>--%>
<jsp:useBean id="supplierregbean" class="com.novasprint.jb.SupplierBean" scope="session"/> <%--to put the bean in the session to pass to the servlet--%>
<jsp:setProperty name="supplierregbean" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New Supplier</title>
    </head>
    <body>
        <h1>Register New Supplier</h1>
        <form action="">
            Supplier Registration Code: <input name="supplier_reg_code" id="supplier_reg_code" type="text" />
            <%--<jsp:setProperty name="supplierregbean"  property="supplier_reg_code"/>--%>
            Supplier Name: <input name="supplier_name" id="supplier_name" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="supplier_name"/>--%>
            Supplier Address: <input name="supplier_address" id="supplier_address" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="supplier_address"/>--%>
            Supplier Number: <input name="supplier_number" id="supplier_number" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="supplier_number"/>--%>
            Supplier Website: <input name="supplier_website" id="supplier_website" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="supplier_website"/>--%>
            Supplier Status: <input name="status" id="status" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="status"/>--%>
            Created By: <input name="created_by" id="created_by" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="created_by"/>--%>
            Created Date: <input name="created_date" id="created_date" type="text">
            <%--<jsp:setProperty name="supplierregbean" property="created_date"/>--%>

            Please input your user id: <input name="userID" id="userID" type="text">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">

            <a href="/createProduct.jsp"><button type="submit">Create New Product</button></a><br/>
            <a href="/getSupplierProducts.jsp"><button type="submit">Retrieve Supplier's Products</button></a>
            <a href="/updateSupplierInfo.jsp"><button type="submit">Update Supplier's Information</button></a>
            <a href="/deregisterSupplier.jsp"><button type="submit">De-register Supplier</button></a>
        </form>
    </body>
</html>

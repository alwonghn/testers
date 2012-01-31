<%-- 
    Document   : indexAlt
    Created on : Sep 13, 2011, 5:55:19 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Alternative Converter Starter</h1>
        <hr>
        <p>Enter an amount to convert:</p>
        <form method="get" action="indexAltServlet">
            <input type="text" name="amount" size="25">
            <br>
            <p>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
        </form>
    </body>
</html>

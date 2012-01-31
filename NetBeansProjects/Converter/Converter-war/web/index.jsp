<%-- 
    Document   : index
    Created on : Sep 13, 2011, 4:28:19 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="converter.ejb.Converter, java.math.*, javax.naming.*"%>

<%!    private Converter converter = null;

    public void jspInit() {
        try {
            InitialContext ic = new InitialContext();
            converter = (Converter) ic.lookup(Converter.class.getName());
        } catch (Exception ex) {
            System.out.println("Couldn't create converter bean." + ex.getMessage());
        }
    }

    public void jspDestroy() {
        converter = null;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converter</title>
    </head>
    <body>
        <h1>Converter</h1>
        <hr>
        <p>Enter an amount to convert:</p>
        <form method="get">
            <input type="text" name="amount" size="25">
            <br>
            <p>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
        </form>

        <%
            String amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
                BigDecimal d = new BigDecimal(amount);

                BigDecimal yenAmount = converter.dollarToYen(d);
        %>
        <p>
            <%= amount%> dollars are  <%= yenAmount%>  Yen.
        <p>
            <%
                    BigDecimal euroAmount = converter.yenToEuro(yenAmount);
            %>
            <%= yenAmount%> Yen are <%= euroAmount%>  Euro.
            <%
                }
            %>



    </body>
</html>

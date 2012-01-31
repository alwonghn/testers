<%-- 
    Document   : crudpage
    Created on : Oct 23, 2011, 3:28:12 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table class="borderAll">
            <tr>
                <th>USER ID</th>
                <th>PASSWORD</th>
            </tr>
            <c:forEach var="user" items="${usersList}">
                <tr>
                    <td class="nowrap">${user.userid}</td>
                    <td class="nowrap">${user.passwd}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

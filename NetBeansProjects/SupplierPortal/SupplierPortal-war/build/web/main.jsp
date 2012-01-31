<%-- 
    Document   : main
    Created on : Sep 6, 2011, 4:11:06 PM
    Author     : alfred.wong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page buffer="none" %>
<%--The <midnight:content/>tag which handles the contents section
is simplistically implemented to use an include. Hence this page
cannot be buffered--%>

<%@taglib prefix="midnight" uri="http://www.midnightcookies.com/midnight" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Midnight Cookie Company</title>
    </head>
    <body text="#996633" link="#cc6600" vlink="#993300" alink="#000000">
        <span font-style="sans-serif">
            <TABLE border="0">
                <tr>
                <table border="0">
                    <tr>
                        <td width="80" height="100">&nbsp</td>
                        <td width="500" height="100"
                            text="#996633" bgcolor="#ffff99"
                            valign="middle" halign="center">
                            <jsp:include page="/WEB-INF/docs/header.jsp" flush="true"/>

                        </td>
                    </tr>
                    <tr>
                        <td width="90" height="300"
                            text="#996633" bgcolor="#ffff99"
                            valign="top">
                            <midnight:links separator="<br>"/>
                        </td>
                        <td width="500" height="300"
                            valign="top" cellpadding="15"
                            cellspacing="15">
                            <midnight:content/>

                        </td>
                    </tr>

                </table>
                </tr>
                <tr>
                    <td width="580" height="50" text="#996633"
                        bgcolor="#ffff99" valign="top">
                        <midnight:links separator="|"/>
                    </td>
                </tr>
            </TABLE>

        </span>
        <h1>Hello World!</h1>
    </body>
</html>

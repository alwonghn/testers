<%-- 
    Document   : webclient_call-the-webservice-method_1
    Created on : Oct 16, 2011, 6:29:15 PM
    Author     : a
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
        <h1>Hello World!</h1>
    </body>
</html>
<!--        // The client connects to the service with this code.
        AVMSWebServicesService service = new AVMSWebServicesService();
        final AVMSWebServices port = service.getAVMSWebServicesPort();

        LoginCheck loginCheck = port.loginPreferenceCheck();

        String login = loginCheck.getLogin();
        LoginPreferenceBean loginPreferenceBean = loginCheck.getLoginPreference();
        System.out.println("login - " + login + " login preference - " + loginPreferenceBean.getGroupId());-->
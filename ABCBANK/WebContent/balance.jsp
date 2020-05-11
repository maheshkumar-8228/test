<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
<title>BALANCE</title>
</head>
<body>
<marquee>
welcome to abc bank
</marquee>
<%
PrintWriter pw=response.getWriter();
session=request.getSession();
pw.println("your bank balance is"+"  "+session.getAttribute("balance"));
%>
</body>
</html>
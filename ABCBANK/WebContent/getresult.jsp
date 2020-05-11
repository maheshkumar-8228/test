<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>

<title>getresult</title>
</head>
<body>
<%
PrintWriter pw=response.getWriter();
session=request.getSession();
pw.println("your debit details are"+"  "+session.getAttribute("al2")+"<br>");
pw.println("your credit details are"+"  "+session.getAttribute("al1")+"<br>");
%>

</body>
</html>
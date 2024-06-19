<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
<form action="updateLead" method=post>
<input type = hidden name=id value="${leads.id}"><br>
First Name<input type=text name =firstName value="${leads.firstName}" ><br>
Last Name<input type=text name=lastName value="${leads.lastName}"><br>
Email<input type=text name=email value= "${leads.email}" ><br>
Mobile<input type=text name=mobile  value="${leads.mobile}"><br>
<input type=submit value=update />
</form>
</body>
</html> 
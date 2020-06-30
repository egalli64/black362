<%@page import="dao.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h1>Il ristorante Il Baco ti da il benvenuto,
	
	<%
		User user = (User) request.getAttribute("user");
	%>
	<%= user.getFirstName() %>
	<%= user.getLastName() %>
	</h1>
</body>
</html>
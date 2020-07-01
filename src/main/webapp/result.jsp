<%@page import="dao.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet"
 type="text/css"
 href="Ristorante.css">
</head>
<body>
	<section class = "header">
   		<div class = "headertop"> 
  			 <%@ include file="navbar.jsp"%>
   		</div>
   	</section>
   	
   	<div>
    	<h2><a href="ristorante.jsp">Ristorante Il Baco</a></h2>
    	
    	<div class="containerSignin">
		<h1>Il ristorante Il Baco ti da il benvenuto,
		
			<%
				User user = (User) request.getAttribute("user");
			%>
			<%= user.getFirstName() %>
			<%= user.getLastName() %>
		</h1>
	
	</div>
  	</div>
   	
</body>
</html>
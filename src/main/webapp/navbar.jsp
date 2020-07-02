<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Ristorante Il Baco</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<link rel="stylesheet" href="navbar.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="ristorante.jsp" id="logo">Ristorante Il Baco</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link" href="ristorante.jsp">Home</a>
            <a class="nav-item nav-link" href="menu.jsp">Menu</a>
            <a class="nav-item nav-link" href="location.jsp">Dove siamo</a>
            <a class="nav-item nav-link" href="ourstory.jsp">Chi siamo</a>
            
			<c:if test="${ sessionScope.user != null }">
				<a class="nav-item nav-link" href="#">User is ${sessionScope.user}</a>
				<a id="logout" class="nav-item nav-link" href="logout">
					Logout
				</a>
			</c:if>
			<c:if test="${ user == null }">
				<a id="colorPrimarySignin" class="nav-item nav-link " href="Signin.jsp?x=a">Registrati</a>
	        	<a id="colorPrimaryLogin" class="nav-item nav-link" href="Login.jsp">Login</a>
			</c:if>
          </div>
        </div>
      </nav>
</body>
</html>
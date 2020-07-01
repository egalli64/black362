<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="Signin.css">

<meta charset="utf-8">

<title>Registrazione</title>
</head>


<body>

	<section class = "header">
   		<div class = "headertop"> 
  			 <%@ include file="navbar.jsp"%>
   		</div>
   	</section>

	<div>
		<h2>
			<a href="ristorante.jsp">Ristorante Il Baco</a>
		</h2>
	</div>

	<div class="mt-5 containerSignin">
		<form action="signin" method="post">
			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="inputname">Nome</label> <input type="text"
						class="form-control" id="inputname" name="firstName" required>
				</div>

				<div class="form-group col-md-6">
					<label for="inputlastname">Cognome</label> <input type="text"
						class="form-control" id="inputlastname" name="lastName" required>
				</div>

				<div class="form-group col-md-6">
					<label for="inputusername">Username</label> <input type="text"
						class="form-control" id="inputusername" name="username" title="Da 8 a 12 caratteri alfanumerici."  
						pattern="[A-Za-z0-9]{8,12}" required>
				</div>

				<div class="form-group col-md-6">
					<label> Data di nascita</label> <input id="date2" type="date" name="date2" value="2020-30-06" min="1900-01-01" max="2020-30-06" required>
				</div>

				<div class="form-group col-md-6">
					<label for="inputnumber">Numero di telefono</label> <input
						type="text" class="form-control" id="inputnumber" title="Da 9 a 10 cifre." pattern="\d{9,10}" name="telephone">
				</div>

				<div class="form-group col-md-6">
					<label for="inputEmail4">Email</label> <input type="email"
						class="form-control" id="inputEmail4" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
				</div>

				<div class="form-group col-md-6">
					<label for="inputPassword4">Password</label> <input type="password"
						class="form-control" id="inputPassword4" name="password" title="Da 8 a 15 caratteri alfanumerici e i seguenti simboli: . _ + - @ $ ! ? &" pattern="[A-Za-z0-9._+-@$!?&]{8,15}" required>
				</div>
				<div class="form-group col-md-6">
					<label for="inputCity">Città </label> <input type="text"
						class="form-control" id="inputCity" name="city" required>
				</div>
			</div>

			<div class="form-group">
				<label for="inputAddress">Indirizzo</label> <input type="text"
					class="form-control" id="inputAddress" name="address" required>
			</div>

			<div class="form-row">


				<div class="form-group col-md-2">
					<label for="inputZip">CAP</label> <input type="text"
						class="form-control" id="inputZip" title="5 cifre" pattern="\d{5}" name="cap" required>
				</div>

			</div>
			<button type="submit" class="btn btn-primary btn-lg btn-block">Registrati</button>
			<div>
				Sei già registrato? <a href="Login.jsp">Effettua login</a>
			</div>

		</form>
	</div>

</body>

</html>
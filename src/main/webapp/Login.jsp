<!DOCTYPE html>
<html lang="en">
    <head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 <meta charset="utf-8">
 <link rel="stylesheet" href="login.css">
 <title>Login</title>
    </head>


<body>

	<section class = "header">
   		<div class = "headertop"> 
  		 	<%@ include file="navbar.jsp"%>
   		</div>
   </section>
   
  <div class="divFormLogin">
    <form class="formLogin form-group" action="login" method="POST">
      <h5 class="card-title">Inserisci i tuoi dati per accedere</h5>
      <div class="form-group">
        <label for="exampleDropdownFormEmail2">Username</label>
        <input type="text" name="username" class="form-control" id="exampleDropdownFormEmail2" placeholder="Mario321" required>
      </div>
      <div class="form-group">
        <label for="exampleDropdownFormPassword2">Password</label>
        <input type="password" name="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password" required>
      </div>
      <div class="containerCustomButton">
        <button type="submit" class="custumButton">Accedi</button>
        <div>Prima volta su Baco? <a href="Signin.jsp">Crea un nuovo account</a></div>
      </div>
    </form>

  </div>

</body>


</html>
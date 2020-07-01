<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 <meta charset="UTF-8">
 <link rel="stylesheet"
 type="text/css"
 href="Ristorante.css">
 <title>Ristorante Il Baco</title>
</head>

<body id="restaurant">

 <section class = "header">
   <div class = "headertop"> 
   
   	<%@ include file="navbar.jsp"%>
   <!--     <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Ristorante Il Baco</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#">Menu</a>
            <a class="nav-item nav-link" href="#">Dove siamo</a>
            <a class="nav-item nav-link" href="#">Chi siamo</a>
            <a class="nav-item nav-link" href="#">La nostra storia</a>   
	        <a id="colorPrimarySignin" class="nav-item nav-link " href="Signin.jsp?x=a">Registrati</a>
	        <a id="colorPrimaryLogin" class="nav-item nav-link" href="Login.jsp">Login</a>          
          </div>
        </div>
      </nav> -->
    </div>
    <div class="container_jumbo">
     <div class = "container_logo">
       <img class="logo" src="img/Logo.png" alt="">
     </div>
    </div>
    </section>
    <main>
    
      <div class="row">
        <div class="col-lg-6 col-sm-12">
          <div class="card" style="width: 30rem;">
            <img src="img/staff.jpg" class="card-img-top img-fluid" alt="...">
            <div class="card-body">
              <h5 class="card-title">Il nostro staff</h5>
              <p class="card-text">Le origini: Il ristorante Il Baco nasce nel 1800. Inizialmente venivano serviti solo bachi da seta e
    questo faceva allontanare possibli. Fu cosi che Pierpaolo Bacolino
     (Fondatore del ristorante) decise di aggiornare il menu e quindi smettere di morire di fame. D'allora, gli affari
     vanno a gonfie vele.
              </p>
              <a href="ourstory.jsp" class="btn btn-primary">Chi siamo</a>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-sm-12 ">
          <div class="card" style="width: 30rem;">
            <img src="img/tortellini.jpeg" class="card-img-top img-fluid" alt="...">
            <div class="card-body">
              <h5 class="card-title">Il nostro menù</h5>
              <p class="card-text">Il Baco riapre con il nuovo servizio a domicilio!
                Chiama o scrivici su whatsapp al 3339857424.
                Consegna gratuita per tutti gli ordini superiori a 15€.
                Se esegui un ordine superiore a 100 euro, le bibite le paghiamo noi!.
                Per gli ordini sotto i 15€ la consegna costa solo 3€
                e se hai qualche richiesta speciale… chiamaci!</p>
              <a href="menu.jsp" class="btn btn-primary">Vai al menù</a>
            </div>
          </div>
        </div>
      </div>
    </main>


	
	<div class="containerFooter">
		<%@ include file="footer.jsp"%>
		<br/>
	</div>
</body>
</html> 
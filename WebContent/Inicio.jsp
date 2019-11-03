<%@page import="beans.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "java.util.*" %>    
<%@taglib uri="WEB-INF/libreria.tld" prefix="custom" %>

<!-- Verificar la sesion -->
<custom:verificar_login usuario="${usuario}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/bootstrap-theme.css">
		<link rel="stylesheet" href="css/bootstrapValidator.css">
		<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
		
		<!-- Zoom -->
		<link rel="stylesheet" href="css/zoom/easyzoom.css">
		<link rel="stylesheet" href="css/zoom/pygments.css">
		
		<link rel="stylesheet" href="css/Predeterminado.css">
		<link rel="stylesheet" href="css/Inicio.css">
		<link rel="stylesheet" href="css/Productos.css"> <!-- Para los productos random -->
		
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="js/Predeterminado.js"></script>
		<script type="text/javascript" src="js/Inicio.js"></script>
		
		<title>Ferreteria Saravia</title>
	</head>
	
	<body id="start">
		<!--------------------------------------------------------------------------------------------->
		<!--------------------------------------- HEADER ---------------------------------------------->
		<!--------------------------------------------------------------------------------------------->
		<div class="jumbotron" id="header">
			<div class="container text-center">
				<h1>Ferretería Saravia</h1>
				<p>Herramientas para tu comodidad</p>
			</div>
		</div>

		<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="242">
			<div class="container-fluid">
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Inicio</a></li>
						<li><a href="Productos.jsp">Productos</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Cuenta.jsp" data-toggle="tooltip" title="Mi cuenta">
								<span class="glyphicon glyphicon-user"></span> ${usuario.nombre} ${usuario.apellido}</a></li>
						<li><a href="Carrito.jsp" data-toggle="tooltip" title="Carrito de compras">
								<span class="glyphicon glyphicon-shopping-cart"></span> Carrito <custom:cantidad_en_carrito/></a></li>
						<li><a href="HistorialServlet" data-toggle="tooltip" title="Mi historial de compras">
								<span class="glyphicon glyphicon-list-alt"></span> Historial</a></li>
						<li><a href="salir" data-toggle="tooltip" title="Cerrar sesion">
								<span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!--------------------------------------------------------------------------------------------->
		<!---------------------------------------- MAIN ----------------------------------------------->
		<!--------------------------------------------------------------------------------------------->
		<div class="container">
			<div id="bannerCarusel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#bannerCarusel" data-slide-to="0" class="active"></li>
					<li data-target="#bannerCarusel" data-slide-to="1"></li>
					<li data-target="#bannerCarusel" data-slide-to="2"></li>
				</ol>
	
				<!-- Imagenes -->
				<div class="carousel-inner">
	
					<div class="item active">
						<img src="img/banner/banner1.jpg" alt="herra" style="width: 100%;">
					</div>
	
					<div class="item">
						<img src="img/banner/banner2.jpg" alt="llaves" style="width: 100%;">
					</div>
	
					<div class="item">
						<img src="img/banner/banner3.jpg" alt="marti" style="width: 100%;">
					</div>
					
				</div>
	
				<!-- Controles derecha e izquierda -->
				<a class="left carousel-control" href="#bannerCarusel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span> 
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#bannerCarusel" data-slide="next"> 
					<span class="glyphicon glyphicon-chevron-right"></span> 
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		
		<!-- PRODUCTOS RANDOM -->
		<custom:productos_random/>
		<br><br><br><br><br>
		
		<div class="container">
			<div class="row">
				<div class="text-center">
					<div class="col-sm-4">
						<span class="glyphicon glyphicon-wrench logo"></span>
						<h3>HERRAMIENTAS</h3><br>
						<h4 class="relleno">Todo lo que busca y más</h4>
					</div>
					<div class="col-sm-4">
						<span class="glyphicon glyphicon-star logo"></span>
						<h3>CALIDAD</h3><br>
						<h4 class="relleno">Productos de primera clase</h4>
					</div>
					<div class="col-sm-4">
						<span class="glyphicon glyphicon-piggy-bank logo"></span>
						<h3>ECONOMICOS</h3><br>
						<h4 class="relleno">Al alcance de su bolsillo</h4>
					</div>
				</div>
			</div>
			
			<br><br><br><br><br>
			
			<div class="row">
				<custom:seccion_producto codigo="${random0}"/>
				<custom:seccion_producto codigo="${random1}"/>
				<custom:seccion_producto codigo="${random2}"/>
				
				<custom:modal_producto codigo="${random0}"/>
				<custom:modal_producto codigo="${random1}"/>
				<custom:modal_producto codigo="${random2}"/>
			</div>
			<div class="row">
				<custom:seccion_producto codigo="${random3}"/>
				<custom:seccion_producto codigo="${random4}"/>
				<custom:seccion_producto codigo="${random5}"/>
				
				<custom:modal_producto codigo="${random3}"/>
				<custom:modal_producto codigo="${random4}"/>
				<custom:modal_producto codigo="${random5}"/>
			</div>
		</div>
		
		<!--------------------------------------------------------------------------------------------->
		<!--------------------------------------- FOOTER ---------------------------------------------->
		<!--------------------------------------------------------------------------------------------->
		<footer class="text-center">
			<a class="up-arrow" href="#start" data-toggle="tooltip" title="IR ARRIBA">
				<span class="glyphicon glyphicon-chevron-up"></span>
			</a>
			<br><br>
			<p>&#169; 2018 TODOS LOS DERECHOS RESERVADOS</p>
		</footer>
		
		<!-- Libreria de zoom -->
		<script type="text/javascript" src="js/easyzoom.js"></script>
	</body>
</html>










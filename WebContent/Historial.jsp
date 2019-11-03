<%@page import="beans.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "java.util.*" %>    
<%@taglib uri="WEB-INF/libreria.tld" prefix="custom" %>
<!-- Display Tag -->
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!-- Verificar la sesion -->
<custom:verificar_login usuario="${usuario}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Displat Tag -->
		<link href="css/displayTag/displaytag.css" rel="stylesheet" type="text/css">
		<link href="css/displayTag/screen.css" rel="stylesheet" type="text/css">
		
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/bootstrap-theme.css">
		<link rel="stylesheet" href="css/bootstrapValidator.css">
		<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
		
		<link rel="stylesheet" href="css/Predeterminado.css">
		
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="js/Predeterminado.js"></script>
		
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
						<li><a href="Inicio.jsp">Inicio</a></li>
						<li><a href="Productos.jsp">Productos</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Cuenta.jsp" data-toggle="tooltip" title="Mi cuenta">
								<span class="glyphicon glyphicon-user"></span> ${usuario.nombre} ${usuario.apellido}</a></li>
						<li><a href="Carrito.jsp" data-toggle="tooltip" title="Carrito de compras">
								<span class="glyphicon glyphicon-shopping-cart"></span> Carrito <custom:cantidad_en_carrito/></a></li>
						<li class="active"><a href="#" data-toggle="tooltip" title="Mi historial de compras">
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
			<h2>Historial de Ventas</h2>
			<hr>
			
			<form action="HistorialServlet?tipo=listarXfecha" class="form-horizontal" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2">Buscar:</label>
					<div class="col-sm-4">
						<input class="form-control" id="buscarProducto" type="text">
					</div>
					<label class="control-label col-sm-2">Fecha:</label>
					<div class="col-sm-4">
						<input class="form-control" type="date" name="fecha">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"></label>
					<div class="col-sm-4">
						<a href="HistorialServlet" class="btn btn-primary" style="color:#FFFFFF">Ver todo</a>
					</div>
					<label class="control-label col-sm-2"></label>
					<div class="col-sm-4">
						<button type="submit" class="btn btn-primary">Buscar</button>
					</div>
				</div>
			</form>
			<br>
			<display:table name="${historial}" decorator="decorator.Wrapper">
				<display:column property="imagen" title="Producto"/>
				<display:column property="descripcion" title="Descripcion" sortable="true"/>
				<display:column property="marca" title="Marca" sortable="true"/>
				<display:column property="formatoPrecio" title="Precio"/>
				<display:column property="cantidad" sortable="true"/>
				<display:column property="formatoSubTotal" title="Sub total"/>
				<display:column property="formatoFecha" title="Fecha de compra"/>
			</display:table>
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
		
		<!-- FILTRAR PRODUCTOS -->
		<script type="text/javascript">
			$(document).ready(function(){
			  $("#buscarProducto").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("tbody tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
		</script>
	</body>
</html>










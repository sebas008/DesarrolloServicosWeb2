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
		
		<link rel="stylesheet" href="css/Predeterminado.css">
		<link rel="stylesheet" href="css/Cuenta.css">
		
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="js/Predeterminado.js"></script>
		<script type="text/javascript" src="js/Cuenta.js"></script>
		
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
						<li class="active"><a href="Cuenta.jsp" data-toggle="tooltip" title="Mi cuenta">
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
			<form class="form-horizontal">
				<h2>Datos de la cuenta</h2>
				<hr>
				<custom:alert_error mensaje="${mensaje}"/>
				<div class="form-group">
					<label class="control-label col-sm-2">Email:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.email}</p>
					</div>
				</div>
				<br>
				
				<h2>Datos Personales</h2>
				<hr>
				<div class="form-group">
					<label class="control-label col-sm-2">Nombre:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.nombre}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Apellido:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.apellido}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Distrito:</label>
					<div class="col-sm-10">
						<p class="form-control-static"><custom:buscar_distrito codigo="${usuario.codDistrito}"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Direccion:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.direccion}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Telefono:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.telefono}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">DNI:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${usuario.dni}</p>
					</div>
				</div>
				<br>
				<div class="col-sm-2">
					<a class="btn btn-primary btn-block" data-toggle="modal" data-target="#actualizar" id="actDatos">
						Actualizar datos <span class="glyphicon glyphicon-edit"></span></a>
				</div>
			</form>
		</div>
		
		<!-- Modal de actualzar datos -->
		<div id="actualizar" class="modal fade" role="dialog">
			<div class="modal-dialog">
	
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"><strong>Actualizar datos</strong></h4>
					</div>
					
					<div class="modal-body">
						<form action="LogueoRegistro?tipo=actualizar" method="post">
							<!-- Input oculto que almacenara el codigo -->
							<input type="hidden" name="codigo" value="${usuario.codigo}">
							<!------------------------------------------->
							<div class="form-group">
								<label class="control-label">Nombre</label>
								<input class="form-control" name="nombre" required maxlength="35" value="${usuario.nombre}">
							</div>
							<div class="form-group">
								<label class="control-label">Apellido</label>
								<input class="form-control" name="apellido" required maxlength="35" value="${usuario.apellido}">
							</div>
							<div class="form-group">
								<label class="control-label">Email</label>
								<input class="form-control" name="email" type="email" placeholder="example@gmail.com" required maxlength="55" value="${usuario.email}">
							</div>
							<div class="form-group">
								<label class="control-label">Nueva contraseña</label>
								<input class="form-control" name="clave" type="password" required maxlength="30">
							</div>
							<div class="form-group">
								<label class="control-label">Confirmar nueva contraseña</label>
								<input class="form-control" name="clave_confirm" type="password" required maxlength="30">
							</div>
							<div class="form-group">
								<label class="control-label">Distrito</label>
								<select class="form-control" name="codDistrito">
									<custom:distritos seleccionar="${usuario.codDistrito}"/>
								</select>
							</div>
							<div class="form-group">
								<label class="control-label">Direccion</label>
								<input class="form-control" name="direccion" placeholder="Av. example 0000" required maxlength="60" value="${usuario.direccion}">
							</div>
							<div class="form-group">
								<label class="control-label">Telefono</label>
								<input class="form-control" name="telefono" pattern="[0-9]{9}" placeholder="9 números" required maxlength="9" value="${usuario.telefono}">
							</div>
							<div class="form-group">
								<label class="control-label">DNI</label>
								<input class="form-control" name="dni" pattern="[0-9]{8}" placeholder="8 números" required maxlength="8" value="${usuario.dni}" readonly>
							</div>
							
							<div class="form-group">
								<input type="submit" id="btnActualizar" class="btn btn-lg btn-block" value="Actualizar">
							</div>
						</form>
					</div>
					
					<div class="modal-footer">
						<button id="cerrarModal" type="button" class="btn btn-sm" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				
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
	</body>
</html>










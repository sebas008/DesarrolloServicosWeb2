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
		<link rel="stylesheet" href="css/Productos.css">
		
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="js/Predeterminado.js"></script>
		<script type="text/javascript" src="js/Productos.js"></script>
		
		<title>Ferreteria Saravia</title>
	</head>
	
	<body data-spy="scroll" data-target="#scrollProductos" data-offset="70" id="start">
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
						<li class="active"><a href="#">Productos</a></li>
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
		
		<!------------------------------------------------------------------------------------------->
		<!--------------------------------------- MAIN ---------------------------------------------->
		<!------------------------------------------------------------------------------------------->
		<ul class="nav nav-tabs" id="categorias">
			<li class="active"><a class="subsub" data-toggle="tab" href="#Electricos">Electricos</a></li>
			<li><a class="subsub" data-toggle="tab" href="#Herramientas">Herramientas</a></li>
			<li><a class="subsub" data-toggle="tab" href="#Limpieza">Limpieza</a></li>
			<li><a class="subsub" data-toggle="tab" href="#Pinturas">Pinturas</a></li>
			<li><a class="subsub" data-toggle="tab" href="#Gafiteria">Gafiteria</a></li>
		</ul>
		
		<!-- Mensaje de Stock superado -->
		<div class="container">
			<custom:mensaje_warning mensaje="${alerta}"/>
		</div>
		
		<div class="tab-content" id="productos">
			<div id="Electricos" class="tab-pane fade in active">
				<!-------------------- Scroll Productos ------------------>
				<div class="container">
					<div class="row">
						<nav class="col-sm-3" id="scrollProductos">
							<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="250">
								<li><a href="#section1">Cable</a></li>
								<li><a href="#section2">Focos</a></li>
								<li><a href="#section3">Toma corrientes</a></li>
								<li><a href="#section4">Extensiones</a></li>
								<li><a href="#section5">Enchufes</a></li>
							</ul>
						</nav>
						
						<div class="col-sm-9">
							<div id="section1" class="secciones">
								<h1>Cable</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P001"/>
									<custom:modal_producto codigo="P001"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P002"/>
									<custom:modal_producto codigo="P002"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P003"/>
									<custom:modal_producto codigo="P003"/>
								</div>
							</div>
							<div id="section2" class="secciones">
								<h1>Focos</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P004"/>
									<custom:modal_producto codigo="P004"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P006"/>
									<custom:modal_producto codigo="P006"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P008"/>
									<custom:modal_producto codigo="P008"/>
								</div>
							</div>
							<div id="section3" class="secciones">
								<h1>Toma corrientes</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P009"/>
									<custom:modal_producto codigo="P009"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P010"/>
									<custom:modal_producto codigo="P010"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P011"/>
									<custom:modal_producto codigo="P011"/>
								</div>
							</div>
							<div id="section4" class="secciones">
								<h1>Extensiones</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P012"/>
									<custom:modal_producto codigo="P012"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P013"/>
									<custom:modal_producto codigo="P013"/>
								</div>
							</div>
							<div id="section5" class="secciones">
								<h1>Enchufes</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P015"/>
									<custom:modal_producto codigo="P015"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P016"/>
									<custom:modal_producto codigo="P016"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P017"/>
									<custom:modal_producto codigo="P017"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="Herramientas" class="tab-pane fade">
				<!-------------------- Scroll Productos ------------------>
				<div class="container">
					<div class="row">
						<nav class="col-sm-3" id="scrollProductos">
							<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="250">
								<li><a href="#section6">Alicates</a></li>
								<li><a href="#section7">Brochas</a></li>
								<li><a href="#section8">Linternas</a></li>
								<li><a href="#section9">Martillos</a></li>
								<li><a href="#section10">Taladros</a></li>
							</ul>
						</nav>
						
						<div class="col-sm-9">
							<div id="section6" class="secciones">
								<h1>Alicates</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P023"/>
									<custom:modal_producto codigo="P023"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P024"/>
									<custom:modal_producto codigo="P024"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P025"/>
									<custom:modal_producto codigo="P025"/>
								</div>
							</div>
							<div id="section7" class="secciones">
								<h1>Brochas</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P029"/>
									<custom:modal_producto codigo="P029"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P031"/>
									<custom:modal_producto codigo="P031"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P034"/>
									<custom:modal_producto codigo="P034"/>
								</div>
							</div>
							<div id="section8" class="secciones">
								<h1>Linternas</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P035"/>
									<custom:modal_producto codigo="P035"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P036"/>
									<custom:modal_producto codigo="P036"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P037"/>
									<custom:modal_producto codigo="P037"/>
								</div>
							</div>
							<div id="section9" class="secciones">
								<h1>Martillos</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P026"/>
									<custom:modal_producto codigo="P026"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P027"/>
									<custom:modal_producto codigo="P027"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P028"/>
									<custom:modal_producto codigo="P028"/>
								</div>
							</div>
							<div id="section10" class="secciones">
								<h1>Taladros</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P020"/>
									<custom:modal_producto codigo="P020"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P021"/>
									<custom:modal_producto codigo="P021"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P022"/>
									<custom:modal_producto codigo="P022"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="Limpieza" class="tab-pane fade">
				<!-------------------- Scroll Productos ------------------>
				<div class="container">
					<div class="row">
						<nav class="col-sm-3" id="scrollProductos">
							<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="250">
								<li><a href="#section11">Aerosol</a></li>
								<li><a href="#section12">Cocina</a></li>
								<li><a href="#section13">Detergentes</a></li>
								<li><a href="#section14">Insecticidas</a></li>
								<li><a href="#section15">Utensilios</a></li>
							</ul>
						</nav>
						
						<div class="col-sm-9">
							<div id="section11" class="secciones">
								<h1>Aerosol</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P050"/>
									<custom:modal_producto codigo="P050"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P051"/>
									<custom:modal_producto codigo="P051"/>
								</div>
							</div>
							<div id="section12" class="secciones">
								<h1>Cocina</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P047"/>
									<custom:modal_producto codigo="P047"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P048"/>
									<custom:modal_producto codigo="P048"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P049"/>
									<custom:modal_producto codigo="P049"/>
								</div>
							</div>
							<div id="section13" class="secciones">
								<h1>Detergentes</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P038"/>
									<custom:modal_producto codigo="P038"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P039"/>
									<custom:modal_producto codigo="P039"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P040"/>
									<custom:modal_producto codigo="P040"/>
								</div>
							</div>
							<div id="section14" class="secciones">
								<h1>Insecticidas</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P044"/>
									<custom:modal_producto codigo="P044"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P045"/>
									<custom:modal_producto codigo="P045"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P046"/>
									<custom:modal_producto codigo="P046"/>
								</div>
							</div>
							<div id="section15" class="secciones">
								<h1>Utensilios</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P041"/>
									<custom:modal_producto codigo="P041"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P042"/>
									<custom:modal_producto codigo="P042"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P043"/>
									<custom:modal_producto codigo="P043"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="Pinturas" class="tab-pane fade">
				<!-------------------- Scroll Productos ------------------>
				<div class="container">
					<div class="row">
						<nav class="col-sm-3" id="scrollProductos">
							<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="250">
								<li><a href="#section16">Barniz</a></li>
								<li><a href="#section17">Esmalte</a></li>
								<li><a href="#section18">Latex</a></li>
								<li><a href="#section19">Lijas</a></li>
								<li><a href="#section20">Temples</a></li>
							</ul>
						</nav>
						
						<div class="col-sm-9">
							<div id="section16" class="secciones">
								<h1>Barniz</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P059"/>
									<custom:modal_producto codigo="P059"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P060"/>
									<custom:modal_producto codigo="P060"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P061"/>
									<custom:modal_producto codigo="P061"/>
								</div>
							</div>
							<div id="section17" class="secciones">
								<h1>Esmalte</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P056"/>
									<custom:modal_producto codigo="P056"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P057"/>
									<custom:modal_producto codigo="P057"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P058"/>
									<custom:modal_producto codigo="P058"/>
								</div>
							</div>
							<div id="section18" class="secciones">
								<h1>Latex</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P053"/>
									<custom:modal_producto codigo="P053"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P054"/>
									<custom:modal_producto codigo="P054"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P055"/>
									<custom:modal_producto codigo="P055"/>
								</div>
							</div>
							<div id="section19" class="secciones">
								<h1>Lijas</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P065"/>
									<custom:modal_producto codigo="P065"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P066"/>
									<custom:modal_producto codigo="P066"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P067"/>
									<custom:modal_producto codigo="P067"/>
								</div>
							</div>
							<div id="section20" class="secciones">
								<h1>Temples</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P062"/>
									<custom:modal_producto codigo="P062"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P063"/>
									<custom:modal_producto codigo="P063"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P064"/>
									<custom:modal_producto codigo="P064"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="Gafiteria" class="tab-pane fade">
				<!-------------------- Scroll Productos ------------------>
				<div class="container">
					<div class="row">
						<nav class="col-sm-3" id="scrollProductos">
							<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="250">
								<li><a href="#section21">Conexiones</a></li>
								<li><a href="#section22">Griferia</a></li>
								<li><a href="#section23">Lavaderos</a></li>
								<li><a href="#section24">Pegamento</a></li>
								<li><a href="#section25">Tuberia</a></li>
							</ul>
						</nav>
						
						<div class="col-sm-9">
							<div id="section21" class="secciones">
								<h1>Conexiones</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P080"/>
									<custom:modal_producto codigo="P080"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P081"/>
									<custom:modal_producto codigo="P081"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P082"/>
									<custom:modal_producto codigo="P082"/>
								</div>
							</div>
							<div id="section22" class="secciones">
								<h1>Griferia</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P068"/>
									<custom:modal_producto codigo="P068"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P069"/>
									<custom:modal_producto codigo="P069"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P070"/>
									<custom:modal_producto codigo="P070"/>
								</div>
							</div>
							<div id="section23" class="secciones">
								<h1>Lavaderos</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P077"/>
									<custom:modal_producto codigo="P077"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P078"/>
									<custom:modal_producto codigo="P078"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P079"/>
									<custom:modal_producto codigo="P079"/>
								</div>
							</div>
							<div id="section24" class="secciones">
								<h1>Pegamento</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P074"/>
									<custom:modal_producto codigo="P074"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P075"/>
									<custom:modal_producto codigo="P075"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P076"/>
									<custom:modal_producto codigo="P076"/>
								</div>
							</div>
							<div id="section25" class="secciones">
								<h1>Tuberia</h1>
								<hr>
								<div class="row">
									<!-- Imagen 1 -->
									<custom:seccion_producto codigo="P071"/>
									<custom:modal_producto codigo="P071"/>

									<!-- Imagen 2 -->
									<custom:seccion_producto codigo="P072"/>
									<custom:modal_producto codigo="P072"/>
									
									<!-- Imagen 3 -->
									<custom:seccion_producto codigo="P073"/>
									<custom:modal_producto codigo="P073"/>
								</div>
							</div>
						</div>
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
		
		<!-- Libreria de zoom -->
		<script type="text/javascript" src="js/easyzoom.js"></script>
	</body>
</html>












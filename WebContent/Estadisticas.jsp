<%@page import="beans.ProductoDTO"%>
<%@page import="beans.CarritoDTO"%>
<%@page import="beans.VentaDTO"%>
<%@ page import="beans.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@page import = "java.util.*" %>    
<%@taglib uri="WEB-INF/libreria.tld" prefix="custom" %>

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
		<link rel="stylesheet" href="css/Estadisticas.css">
		
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js"></script>
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
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#" data-toggle="tooltip" title="Estadísticas de la Ferretería">
							<span class="glyphicon glyphicon-signal"></span> Estadísticas</a></li>
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
			<li class="active"><a data-toggle="tab" href="#Clientes">Clientes</a></li>
			<li><a data-toggle="tab" href="#Productos">Productos</a></li>
		</ul>
		
		<div class="tab-content">
			<div id="Clientes" class="tab-pane fade in active">
				<div class="container">
					<h2>Clientes con más compras</h2>
					<hr>
					
					<div class="panel-group" id="accordion">
					<%
						UsuarioDTO[] usuariosConMasCompras = (UsuarioDTO[])request.getAttribute("usuariosConMasCompras");
						for(int i = 0; i < usuariosConMasCompras.length; i++)
						{
							UsuarioDTO usu = usuariosConMasCompras[i];
					%>
							<div class="panel <% if(i == 0) { %> panel-success <% } else { %> panel-default <% } %>">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#ventas<%=usu.getCodigo()%>" style="display: block; text-decoration: none;">
											<%=usu.getNombre() + " " + usu.getApellido() %> <span style="float: right;"><b>Total Comprado:</b>&ensp; S/.<%=usu.getTotalComprado() %></span>
										</a>
									</h4>
								</div>
								<div id="ventas<%=usu.getCodigo()%>" class="panel-collapse collapse">
									<div class="panel-body">
										<%
											VentaDTO[] ventas = (VentaDTO[])request.getAttribute("ventas" + usu.getCodigo());
											for(int j = 0; j < ventas.length; j++)
											{
										%>
											<h5><b>Venta #<%=j + 1 %> &ensp;-&ensp; <%=ventas[j].getFecha() %></b></h5>
											<hr>
											
											<table class="table table-bordered table-striped">
												<thead style="background-color: #D6F0F9;">
													<tr>
														<th>Producto</th>
														<th>Descripcion</th>
														<th>Precio</th>
														<th>Cantidad</th>
														<th>Sub total</th>
													</tr>
												</thead>
												<tbody>
													<%
														for(CarritoDTO c : ventas[j].getDetalle())
														{
													%>
														<tr>
															<td width="10%" style="text-align: center;"><img style="width: 82px;" src="img/productos/todos/<%=c.getCodigo()%>.jpg"/></td>
															<td><%=c.getDescripcion() %></td>
															<td>S/.<%=c.getPrecio() %></td>
															<td><%=c.getCantidad() %></td>
															<td>S/.<%=c.getSubTotal() %></td>
														</tr>
													<%
														}
													%>
												</tbody>
											</table>
											<%
												if(j != ventas.length - 1)
												{
											%>
												<br>
											<%
												}
											%>
										<%
											}
										%>
									</div>
								</div>
							</div>
					<%
						}
					%>
  					</div>
				</div>
			</div>
			
			<div id="Productos" class="tab-pane fade">
				<div class="container">
					<h2>Productos</h2>
					<hr>
					
					<%
						int tope = (Integer)request.getAttribute("progressBarTope");
					
						ProductoDTO[] productos = (ProductoDTO[])request.getAttribute("productosMasVendidos");
						for(ProductoDTO p : productos)
						{
							int ancho = (p.getCantidadVendida() * 100) / tope;
					%>
						<div class="well" style="display: flex; flex-direction: row; margin-bottom: 0px; margin-top: 20px;" data-toggle="collapse" data-target="#info<%=p.getCodigo()%>">
							<img src="img/productos/todos/<%=p.getCodigo()%>.jpg" style="width: 8%; margin-right: 10px;" />
							
							<div style="width: 92%;">
								<span><%=p.getDescripcion()%></span> <span style="float: right;"><b>Stock actual:</b>&ensp; <%=p.getStockAct() %></span>
								<br><br>
								
								<div class="progress">
									<div class="progress-bar <% if(ancho == 100) { %> progress-bar-success <% } %> <% if(ancho <= 20) { %> progress-bar-danger <% } %> progress-bar-striped active" role="progressbar" 
										 aria-valuenow="<%=p.getCantidadVendida() %>" aria-valuemin="0" aria-valuemax="<%=tope %>" 
										 style="width: <%=ancho%>%;">
										 <%=p.getCantidadVendida() %>
									 </div>
								</div>
							</div>
						</div>
						
						<div id="info<%=p.getCodigo()%>" class="collapse">
							<%
								UsuarioDTO[] usuariosXproducto = (UsuarioDTO[])request.getAttribute("usuarios" + p.getCodigo());
							%>
							<br>
							<div style="display: flex; flex-direction: row;">
								<div style="width: 50%; padding-left: 80px;">
									<h4><b>Usuarios que compraron este producto:</b></h4>
									<br>
									<%
										for(UsuarioDTO u : usuariosXproducto)
										{
									%>
										<h5><%=u.getNombre() + " " + u.getApellido() %> :&ensp;<b><%=u.getCantidadComprado()%></b></h5>
									<%
										}
									%>
								</div>
								<div style="width: 50%;">
				  					<canvas id="infoChart<%=p.getCodigo()%>" style="width: 100%; margin: auto;"></canvas>
				  					<br><br><br>
				
				  					<script type="text/javascript">
				  					
				  						var clientes = [];
				  						var datosClientes = [];
				  						<%
				  							for(UsuarioDTO u : usuariosXproducto)
				  							{
				  						%>
				  							clientes.push('<%=u.getNombre() + " " + u.getApellido()%>');
				  							datosClientes.push(<%=u.getCantidadComprado()%>);
				  						<%
				  							}
				  						%>
				  					
				  						var clienteXproductoChart = document.getElementById("infoChart<%=p.getCodigo()%>").getContext("2d");
				  						var chart = new Chart(clienteXproductoChart, 
										{
				  							type: "pie",
				  							data:{
				  								labels: clientes,
				  								datasets:[{
				  									label: 'Clientes',
				  									data: datosClientes,
				  									backgroundColor:[
				  										'rgb(232, 136, 67)',
				  										'rgb(130, 232, 67)',
				  										'rgb(42, 137, 232)',
				  										'rgb(64, 52, 235)',
				  										'rgb(255, 204, 84)'
				  									]
				  								}]
											}
				  						});
				  					</script>
								</div>
							</div>
						</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</body>
</html>


























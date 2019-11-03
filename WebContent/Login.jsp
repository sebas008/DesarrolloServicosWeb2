<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="WEB-INF/libreria.tld" prefix="custom" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/bootstrap-theme.css">
		<link rel="stylesheet" href="css/bootstrapValidator.css">
		
		<link rel="stylesheet" href="css/Login.css">
		
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="js/Predeterminado.js"></script>
		
		<title>Ferreteria Saravia</title>
	</head>

	<body>
		<custom:alert_JS mensaje="${registroOK}"/>
		<div class="container">
			<div class="panel">
				<div class="panel-heading">
					<h2>Ferreteria Saravia</h2>
					<h4>Formulario de Login</h4>
				</div>
				
				<form action="LogueoRegistro?tipo=login" method="post">
					<!-- Mensaje de error si ingresa mal los datos -->
					<custom:alert_error mensaje="${mensaje}"/>

					<div class="form-group">
						<input class="form-control" type="email" name="email" placeholder="Email" required value="${email}">
					</div>
					
					<div class="form-group">
						<input class="form-control" name="clave" type="password" placeholder="Password" required>
					</div>
					
					<div class="form-group">
						<a href="Registro.jsp">¿No tiene cuenta? Registrese</a>
					</div>
					
					<div class="form-group">
						<input type="submit" id="btnIniciarSesion" class="btn btn-lg btn-block" value="Iniciar sesión">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>









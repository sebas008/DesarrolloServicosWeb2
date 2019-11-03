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
		<div class="container">
			<div class="panel">
				<div class="panel-heading">
					<h2>Ferreteria Saravia</h2>
					<h4>Formulario de Registro</h4>
				</div>
				
				<form action="LogueoRegistro?tipo=registro" method="post">
					<custom:alert_error mensaje="${mensaje}"/>
				
					<div class="form-group">
						<label class="control-label">Nombre</label>
						<input class="form-control" name="nombre" required maxlength="35" value="${nombre}">
					</div>
					<div class="form-group">
						<label class="control-label">Apellido</label>
						<input class="form-control" name="apellido" required maxlength="35" value="${apellido}">
					</div>
					<div class="form-group">
						<label class="control-label">Email</label>
						<input class="form-control" name="email" type="email" placeholder="example@gmail.com" required maxlength="55" value="${email}">
					</div>
					<div class="form-group">
						<label class="control-label">Contraseña</label>
						<input class="form-control" name="clave" type="password" required maxlength="30" value="${clave}">
					</div>
					<div class="form-group">
						<label class="control-label">Confirmar contraseña</label>
						<input class="form-control" name="clave_confirm" type="password" required maxlength="30">
					</div>
					<div class="form-group">
						<label class="control-label">Distrito</label>
						<select class="form-control" name="codDistrito">
							<custom:distritos seleccionar="${distrito}"/>
						</select>
					</div>
					<div class="form-group">
						<label class="control-label">Direccion</label>
						<input class="form-control" name="direccion" placeholder="Av. example 0000" required maxlength="60" value="${direccion}">
					</div>
					<div class="form-group">
						<label class="control-label">Telefono</label>
						<input class="form-control" name="telefono" pattern="[0-9]{9}" placeholder="9 números" required maxlength="9" value="${telefono}">
					</div>
					<div class="form-group">
						<label class="control-label">DNI</label>
						<input class="form-control" name="dni" pattern="[0-9]{8}" placeholder="8 números" required maxlength="8" value="${dni}">
					</div>
					
					<div class="form-group">
						<input type="submit" id="btnRegistrar" class="btn btn-lg btn-block" value="Registrarse">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>









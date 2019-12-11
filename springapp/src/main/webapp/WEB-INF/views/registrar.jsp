<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar nuevo usuario</title>
</head>
<body>
	<h2 align="center">Registrar nuevo usuario</h2>
	<br>
	<form action="http://localhost:8080/springapp/filmografia/registrarse" method="POST">
		<p align="center">Nombre:</p>
		<p align="center"><input type="text" name="user"></p>
		<p align="center">Clave:</p>
		<p align="center"><input type="text" name="passwd"></p>
		<p align="center"><input type="submit" value="Registrar"></p>
	</form>
	
	<p align="center"><a href="http://localhost:8080/springapp"><input type="button" value="Volver"></a></p>
</body>
</html>
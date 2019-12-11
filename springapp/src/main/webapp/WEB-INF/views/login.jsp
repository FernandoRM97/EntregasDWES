<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<br>
	<br>
	<form action="http://localhost:8080/springapp/filmografia/logearse" method="POST">
	<p align="center">Usuario:</p>
	<p align="center"><input type="text" name="user"></p>
	<p align="center">Contraseña:</p>
	<p align="center"><input type="text" name="passwd"></p>
	<p align="center"><input type="submit" value="Login"></p>
	</form>
	
	<p align="center"><a href="http://localhost:8080/springapp/"><input type="button" value="Inicio"></a></p>
</body>
</html>
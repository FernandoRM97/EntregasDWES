<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login Correcto</title>
</head>
<body>
	<h2 align="center">BIENVENIDO ${nombre}</h2>
	<p align="center">
		<a href="registrar.jsp"><input type="button"
			value="Registrar nuevo usuario"></a>
	</p>
	<form action="mantenimientoController" method="POST">
		<p align="center">
			<input type="submit" value="Mantenimiento peliculas">
		</p>
	</form>

	<p align="center">
		<a href="index.jsp"><input type="button" value="Inicio"></a>
	</p>

</body>
</html>
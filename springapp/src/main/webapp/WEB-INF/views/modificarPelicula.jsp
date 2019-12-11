<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Pelicula</title>
</head>
<body>
	<br>

	<form action="http://localhost:8080/springapp/filmografia/modificarPelicula" method="POST">
		<p align="center">Titulo de la Pelicula a Modificar</p>
		<p align="center">
			<input type="text" name="tituloMod">
		</p>

		<hr>

		<p align="center">Titulo</p>
		<p align="center">
			<input type="text" name="titulo">
		</p>
		<p align="center">Director</p>
		<p align="center">
			<input type="text" name="director">
		</p>
		<p align="center">Fecha</p>
		<p align="center">
			<input type="text" name="fecha">
		</p>
		<p align="center">
			<input type="submit" value="Modificar Pelicula">
		</p>
	</form>

	<p align="center">
		<a href="http://localhost:8080/springapp/"><input type="button" value="Inicio"></a>
	</p>
</body>
</html>
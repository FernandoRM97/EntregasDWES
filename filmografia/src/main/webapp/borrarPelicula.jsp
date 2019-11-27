<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrar Pelicula</title>
</head>
<body>
	<br>

	<form action="borrarPeliculaController" method="POST">
		<p align="center">Titulo</p>
		<p align="center">
			<input type="text" name="titulo">
		</p>
		<p align="center">
			<input type="submit" value="Borrar Pelicula">
		</p>
	</form>

	<p align="center">
		<a href="loginCorrecto.jsp"><input type="button" value="Inicio"></a>
	</p>
</body>
</html>
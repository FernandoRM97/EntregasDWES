<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento de peliculas</title>
</head>
<body>
	<h2 align="center">Peliculas</h2>
	
	<div align="center">
		<table border=1 style="text-align:center;">
			<tr>
				<td width=200px><b>Director</b></td>
				<td width=200px><b>Titulo</b></td>
				<td width=200px><b>Fecha</b></td>
			</tr>
			<c:forEach items="${listaPelis}" var="info">
				<tr>
					<td width=200px>${info.director}</td>
					<td width=200px>${info.titulo}</td>
					<td width=200px>${info.fecha}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<p align="center">
		<a href="http://localhost:8080/springapp/filmografia/nuevaPeli"><input type="button"
			value="Nueva Pelicula"></a>
	</p>
	<p align="center">
		<a href="http://localhost:8080/springapp/filmografia/modificarPeli"><input type="button"
			value="Modificar Pelicula"></a>
	</p>
	<p align="center">
		<a href="http://localhost:8080/springapp/filmografia/borrarPeli"><input type="button"
			value="Borrar Pelicula"></a>
	</p>
	<p align="center">
		<a href="http://localhost:8080/springapp"><input type="button" value="Inicio"></a>
	</p>
</body>
</html>
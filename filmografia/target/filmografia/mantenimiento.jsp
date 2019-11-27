<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<table border=1 style="text-align: center;">
		<tr>
			<td width=100px>Director</td>
			<td width=100px>Titulo</td>
			<td width=100px>Fecha</td>
		</tr>
		<c:forEach items="${listaPeliculas}" var="info">
			<tr>
				<td>${info.director}</td>
				<td>${info.titulo}</td>
				<td>${info.fecha}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>
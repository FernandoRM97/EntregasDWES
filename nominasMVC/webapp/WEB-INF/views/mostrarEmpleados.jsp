<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empleados</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
	<table border=1 style="text-align:center;">
		<tr>
			<td width=100px>DNI</td>
			<td width=100px>Nombre</td>
			<td width=100px>Sexo</td>
			<td width=100px>Categoria</td>
			<td width=100px>Años</td>
		</tr>
			<c:forEach items="${listaEmpleados}" var="info">
				<tr>
					<td>${info.dni}</td>
					<td>${info.nombre}</td>
					<td>${info.sexo}</td>
					<td>${info.categoria}</td>
					<td>${info.anyos}</td>
				</tr>
			</c:forEach>		
	</table>
	<br>
	<a href="Menu.html"><button>Volver</button></a>
</body>
</html>
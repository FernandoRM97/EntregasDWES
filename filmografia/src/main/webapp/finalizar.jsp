<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finalizar</title>
</head>
<body>
	<h2 align="center">Lista de Directores Consultados</h2>

	<div align="center">
		<table border=1 style="text-align: center;">
			<tr>
				<td width=200px><b>Director</b></td>
			</tr>
			<c:forEach items="${directoresConsultados}" var="info">
				<tr>
					<td width=200px>${info}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<p align="center">
		<a href="consultar.jsp"><input type="button" value="Otra Consulta"></a>
	</p>
	<form action="finfinController" method="POST">
		<p align="center">
			<input type="submit" value="Inicio">
		</p>
	</form>
</body>
</html>
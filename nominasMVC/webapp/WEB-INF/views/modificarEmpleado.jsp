<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Empleado</title>
</head>
<body>

	<br>
	<br>
	<fieldset style="width: 40%; text-align: center; margin-left: 300px">

		<form action="/mostrarSalarioEmpleado" method="GET">

			DNI :<input type="text" name="dni"> <br>
			<br> Nombre :<input type="text" name="nombre"> <br>
			<br> Sexo :<input type="text" name="sexo"> <br>
			<br> Categoria :<input type="text" name="categoria"> <br>
			<br> Años Trabajados :<input type="text" name="anyos"> <br>
			<br> <input type="submit" name="enviar" value="Modificar">

		</form>
	</fieldset>

</body>
</html>
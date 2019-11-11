<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<div align="center">
		<h2>Nóminas</h2>
	
		<a href="/infoEmpleados">
		<input type="button" value="Mostrar la información de los empleados." style="height: 28px; width: 500px;"/>
		</a>
		
		<form action="/mostrarSalarioEmpleado" method="GET">
		<br>
		DNI:
		<input type="text" name="dni"><br><br>
		<input name="action" value="mostrarSalario" style="visibility: hidden; display: none;">
		<input type="submit" value="Mostrar salario de un empleado por DNI" style="height: 28px; width: 500px;"/>
		</form>
		
		<br>
		
		<a href="/views/modificarEmpleado.jsp"><input type="button" value="Modificar datos de un empleado" style="height: 28px; width: 500px;"/></a>
		<br><br>
				
		<input type="button" value="Salir" style="height: 28px; width: 500px;"/>
	</div>
</body>
</html>
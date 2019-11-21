package net.itinajero.app.dao;

import java.sql.SQLException;
import java.util.List;

import net.itinajero.laboral.Empleado;

public interface DAO {
	
	List<Empleado> mostrarEmpleados() throws SQLException;
	
	String mostrarSalarioDni(String dni);
	
	void modificarEmpleado(String dni, String nombre, char sexo, int categoria, int anyos) throws SQLException;

}

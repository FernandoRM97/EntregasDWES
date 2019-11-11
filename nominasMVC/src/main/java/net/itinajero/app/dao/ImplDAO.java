package net.itinajero.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.itinajero.laboral.Empleado;

public class ImplDAO implements DAO {

	public List<Empleado> mostrarEmpleados() throws SQLException {

		Connection connection = Conexion.getConnection();

		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADOS");

		while (rs.next()) {
			lista.add(new Empleado(rs.getString("dni"), rs.getString("nombre"), rs.getString("sexo").charAt(0),
					rs.getInt("categoria"), rs.getInt("anyos")));
		}

		return lista;
	}

	public String mostrarSalarioDni(String dni) {
		String linea = null;

		try {

			Connection connection = Conexion.getConnection();

			PreparedStatement pst = connection.prepareStatement("SELECT SUELDO FROM NOMINAS WHERE DNI = ?");

			pst.setString(1, dni);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				linea = rs.getString(1);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println();
			System.out.println(sqle.getMessage());
			System.out.println();
			System.out.println(sqle.getSQLState());
			System.out.println();
			System.out.println(sqle.getErrorCode());
		}

		return linea;

	}

	public void modificarEmpleado(String dni, String nombre, char sexo, int categoria, int anyos) throws SQLException {

		Connection connection = Conexion.getConnection();

		Statement st = connection.createStatement();

		st.executeUpdate("UPDATE EMPLEADOS SET NOMBRE = '" + nombre + "' WHERE DNI = '" + dni + "'");
		st.executeUpdate("UPDATE EMPLEADOS SET SEXO = '" + sexo + "' WHERE DNI = '" + dni + "'");
		st.executeUpdate("UPDATE EMPLEADOS SET CATEGORIA = '" + categoria + "' WHERE DNI = '" + dni + "'");
		st.executeUpdate("UPDATE EMPLEADOS SET ANYOS = '" + anyos + "' WHERE DNI = '" + dni + "'");

		Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);

		int sueldo = emp.sueldo();

		st.executeUpdate("UPDATE NOMINAS SET SUELDO = " + sueldo);

		st.close();
		connection.close();
	}

}

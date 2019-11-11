package Laboral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Conexion;

/**
 * 
 * @author fernando Clase en la que almaceno los métodos de la clase menu
 * 
 */

public class OpcionesMenu {

	public void opcion1escribe() throws IOException {

		Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
		Empleado emp2 = new Empleado("Ada Lovelace", "32000031R", 'F');

		FileWriter f = new FileWriter("empleados.txt");

		f.write(emp1.imprime() + "\n");
		f.write(emp2.imprime() + "\n");

		f.close();

	}

	public void opcion1lee() throws FileNotFoundException {
		FileReader ff = new FileReader("empleados.txt");

		Scanner sf = new Scanner(ff);

		while (sf.hasNext()) {
			System.out.println(sf.nextLine());
			System.out.println(" ");
		}

		System.out.println(" ");

		sf.close();
	}

	public void opcion1actualiza() throws IOException {
		Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
		Empleado emp2 = new Empleado("Ada Lovelace", "32000031R", 'F');

		FileWriter f = new FileWriter("empleados.txt");

		// Actualizamos la informaciÃ³n

		emp1.setCategoria(9);
		emp2.incrAnyo();

		f.write(emp1.imprime() + "\n");
		f.write(emp2.imprime() + "\n");

		f.close();
	}

	public void opcion1binario() throws IOException {
		Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
		Empleado emp2 = new Empleado("Ada Lovelace", "32000031R", 'F');

		FileOutputStream f = new FileOutputStream("sueldos.dat");

		for (int i = 0; i < emp1.getDni().length(); i++) {
			f.write(i);
		}

		for (int i = 0; i < emp1.sueldo(); i++) {
			f.write(i);
		}

		for (int i = 0; i < emp2.getDni().length(); i++) {
			f.write(i);
		}

		for (int i = 0; i < emp2.sueldo(); i++) {
			f.write(i);
		}

		f.close();
	}

	public void altaEmpleado() throws SQLException {
		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();

		Scanner s = new Scanner(System.in);
		Scanner si = new Scanner(System.in);

		String dni, nombre;
		char sexo;
		int categoria, anyos, sueldo;

		System.out.println("Vamos a introducir un empleado en la base de datos");
		System.out.println("Introduce el nombre:");
		nombre = s.nextLine();
		System.out.println("Introduce el dni:");
		dni = s.nextLine();
		System.out.println("Introduce el sexo(M O F):");
		sexo = s.nextLine().charAt(0);
		System.out.println("Introduce la categoria del empleado");
		categoria = si.nextInt();
		System.out.println("Introduce los anyos que ha trabajado el empleado:");
		anyos = si.nextInt();

		Empleado emp1 = new Empleado(nombre, dni, sexo, categoria, anyos);

		sueldo = emp1.sueldo();

		String sql = "INSERT INTO EMPLEADOS VALUES('" + dni + "','" + nombre + "','" + sexo + "','" + categoria + "','"
				+ anyos + "')";
		
		String sql2 = "INSERT INTO NOMINAS VALUES('" + dni + "', '" + sueldo + "')";

		st.executeUpdate(sql);
		
		st.executeUpdate(sql2);

		s.close();
		si.close();
		st.close();
	}

	public void opcion4() throws SQLException {
		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();

		String sql = "SELECT * FROM EMPLEADOS";
		
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.println("DNI: " + rs.getString(1));
			System.out.println("Nombre: " + rs.getString(2));
			System.out.println("Sexo: " + rs.getString(3));
			System.out.println("Categoría: " + rs.getInt(4));
			System.out.println("Anyos trabajados: " + rs.getInt(5));
			
			String sql2 = "SELECT SUELDO FROM NOMINAS WHERE DNI = '" + rs.getString(1) + "'";
			
			ResultSet rs2 = st.executeQuery(sql2);
			
				while(rs2.next()) {
					System.out.println("Sueldo: " + rs2.getInt(1));
				}
			
			System.out.println("***************************************");
		}
	}

	public void opcion5() throws SQLException {
		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();

		Scanner s5 = new Scanner(System.in);

		String dni;

		System.out.println("Introduce el dni para buscar el salario de un empleado");
		dni = s5.nextLine();

		String sql = "SELECT * FROM EMPLEADOS WHERE DNI = '" + dni + "'";

		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("Sueldo: " + rs.getInt(6));
			System.out.println("***************************************");
		}

		s5.close();
	}
	
	public void opcion6() throws SQLException {
		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();
		
		Scanner s6 = new Scanner(System.in);
		Scanner s62 = new Scanner(System.in);
		
		String dni;
		
		System.out.println("Introduce el dni del empleado a modificar");
		dni = s6.nextLine();
		
		String nombre;
		char sexo;
		int categoria, anyos, sueldo;
		

		System.out.println("Introduce el nombre:");
		nombre = s6.nextLine();
		System.out.println("Introduce el sexo(M O F):");
		sexo = s6.nextLine().charAt(0);
		System.out.println("Introduce la categoria del empleado");
		categoria = s62.nextInt();
		System.out.println("Introduce los anyos que ha trabajado el empleado:");
		anyos = s62.nextInt();

		Empleado emp1 = new Empleado(nombre, dni, sexo, categoria, anyos);

		sueldo = emp1.sueldo();

		String sql = "UPDATE EMPLEADOS SET NOMBRE = '"+nombre+"', SEXO = '"+sexo+"' , CATEGORIA = '"+categoria+"' , ANYOS = '"+anyos+"' , SALARIO = '"+sueldo+"' WHERE DNI = '"+dni+"' ";
		
		st.executeUpdate(sql);
		
		s6.close();
		s62.close();
		
	}
	
	public void opcion7() throws SQLException {

	}
	
	public void opcion8() {
		
		// Mandando una consulta sql montando un procedure con un cursor y vaya actualizando todos los registros
		// se podra hacer pero no se si es lo correcto
	}
	
	public void opcion9() throws SQLException, IOException {
		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();
		
		String sql = "SELECT * FROM EMPLEADOS";
		
		ResultSet rs = st.executeQuery(sql);
		
		File f = new File("copiaSeguridad.txt");
		
		FileWriter fwr = new FileWriter(f);
		
		BufferedWriter bwr = new BufferedWriter(fwr);
		
		while (rs.next()) {
			bwr.write(rs.getString(1));
			bwr.write(" ");
			bwr.write(rs.getString(2));
			bwr.write(" ");
			bwr.write(rs.getString(3));
			bwr.write(" ");
			bwr.write(rs.getInt(4));
			bwr.write(" ");
			bwr.write(rs.getInt(5));
			bwr.write(" ");
			bwr.write(rs.getInt(6));
			bwr.write("\n");
		}
		
		bwr.close();
	}
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	
	public List<String> mostrarEmpleados() throws ClassNotFoundException, SQLException {
		
		stmt = con.createStatement();

		List<String> empleados = new ArrayList<String>();

		rs = stmt.executeQuery("select * from Empleados");
		rs2 = stmt.executeQuery("select * from Nominas");

		while (rs.next()) {
			String empleado = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getInt(4) + ","
					+ rs.getInt(5) + rs2.getInt(2);
			empleados.add(empleado);
		}

		return empleados;

	}
}
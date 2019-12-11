package com.companyname.springapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.companyname.springapp.domain.Pelicula;
import com.companyname.springapp.domain.Usuario;

public class Conexion implements ConexionDAO{

	private static final String URL = "jdbc:oracle:thin:@192.168.205.57:1521:xe";
	private static final String USERNAME = "cine";
	private static final String PASSWORD = "cine";
	
	static HashSet<String> listaDirectores = new HashSet<>();

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Conexion realizada con exito");
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Conexion fallida");
			System.out.println("");
		}
		return connection;
	}

	public ArrayList<Usuario> consultarLogin(String usuario, String clave)
			throws ClassNotFoundException, SQLException {

		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();

		ResultSet rs = st
				.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE = '" + usuario + "' AND CLAVE = '" + clave + "' ");

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			lista.add(new Usuario(rs.getString("nombre"), rs.getString("clave")));
		}

		return lista;

	}
	
	public void nuevoUser(String nombre, String clave) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		String sql = "INSERT INTO USUARIOS VALUES ('" + nombre + "', '" + clave + "')";
		
		st.executeUpdate(sql);
		
	}
	
	public ArrayList<Pelicula> verPelis() throws ClassNotFoundException, SQLException{
		
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PELICULA");
		
		while(rs.next()) {
			lista.add(new Pelicula(rs.getString("director"), rs.getString("titulo"), rs.getDate("fecha")));
		}
		
		return lista;
		
	}

	public void nuevaPeli(String director, String titulo, String fecha) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		String sql = "INSERT INTO PELICULA VALUES ('" + director + "', '" + titulo + "', '" + fecha + "')";
		
		st.executeUpdate(sql);
		
	}

	public void modificarPeli(String director, String titulo, String fecha, String tituloMod) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		String sql = "UPDATE PELICULA SET DIRECTOR = '" + director + "' , TITULO = '" + titulo + "' , FECHA = '" + fecha + "'  WHERE TITULO =  '" + tituloMod + "' ";
		
		st.executeUpdate(sql);
	}

	public void borrarPeli(String titulo) throws SQLException, ClassNotFoundException {
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		String sql = "DELETE FROM PELICULA WHERE TITULO =  '" + titulo + "' ";
		
		st.executeUpdate(sql);
		
	}

	public ArrayList<Pelicula> consultarDirector(String director) throws ClassNotFoundException, SQLException {
		
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		
		Connection connection = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PELICULA WHERE DIRECTOR = '" + director + "' ");
		
		while(rs.next()) {
			lista.add(new Pelicula(rs.getString("director"), rs.getString("titulo"), rs.getDate("fecha")));
			listaDirectores.add(rs.getString("director"));
		}
		
		return lista;
		
	}
	
	public HashSet<String> listaDirectores(){
		return listaDirectores;
	}
	

}

package com.companyname.springapp.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import com.companyname.springapp.domain.Pelicula;
import com.companyname.springapp.domain.Usuario;

public interface ConexionDAO {

	ArrayList<Usuario> consultarLogin(String usuario, String clave) throws ClassNotFoundException, SQLException;
	
	void nuevoUser(String nombre, String clave) throws ClassNotFoundException, SQLException;
	
	ArrayList<Pelicula> verPelis() throws ClassNotFoundException, SQLException;
	
	void nuevaPeli(String director, String titulo, String fecha) throws ClassNotFoundException, SQLException;
	
	void modificarPeli(String director, String titulo, String fecha, String tituloMod) throws ClassNotFoundException, SQLException;
	
	void borrarPeli(String titulo) throws SQLException, ClassNotFoundException;
	
	ArrayList<Pelicula> consultarDirector(String director) throws ClassNotFoundException, SQLException;
	
	HashSet<String> listaDirectores();
	
}

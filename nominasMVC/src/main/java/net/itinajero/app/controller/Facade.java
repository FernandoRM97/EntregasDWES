package net.itinajero.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Facade {

	String hacer(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws SQLException;
	
}

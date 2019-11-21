package net.itinajero.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.dao.ImplDAO;

@Controller
public class ModificarInfoEmpleadoController implements Facade {

	ImplDAO dao = new ImplDAO();
	
	@RequestMapping(value="/mostrarInfoEmpleado", method=RequestMethod.GET)
	public String hacer(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
			throws SQLException {

		String vista = "index";
		
		String dni = request.getParameter("dni");
		
		String nombre = request.getParameter("nombre");
		
		char sexo = request.getParameter("sexo").charAt(0);
		
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		
		int anyos = Integer.parseInt(request.getParameter("anyos"));
		
		dao.modificarEmpleado(dni, nombre, sexo, categoria, anyos);
		
		return vista;
	}

}

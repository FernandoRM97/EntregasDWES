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
public class MostrarSalarioEmpleadoController implements Facade {

	ImplDAO dao = new ImplDAO();

	@RequestMapping(value = "/mostrarSalarioEmpleado", method = RequestMethod.GET)
	public String hacer(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
			throws SQLException {

		String vista = "/mostrarSalarioEmpleado";

		String dni = request.getParameter("dni");

		String sueldo = dao.mostrarSalarioDni(dni);

		request.setAttribute("sueldoEmp", sueldo);

		return vista;
	}

}

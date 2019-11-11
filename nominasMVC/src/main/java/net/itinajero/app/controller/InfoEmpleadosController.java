package net.itinajero.app.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.dao.ImplDAO;
import net.itinajero.laboral.Empleado;


@Controller
@RequestMapping("nominasMVC")
public class InfoEmpleadosController implements Facade {

	ImplDAO dao = new ImplDAO();
	
	@RequestMapping(value="/infoEmpleados", method=RequestMethod.GET)
	public String hacer(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String vista = "mostrarEmpleados";
		
		List<Empleado> lista = dao.mostrarEmpleados(); 
		
		request.setAttribute("listaEmpleados", lista);
		
		return vista;
	}


}

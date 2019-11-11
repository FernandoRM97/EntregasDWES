package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Conexion;
import Laboral.DatosNoCorrectosException;
import Laboral.Empleado;

/**
 * Servlet implementation class controladorUnico
 */
public class controladorUnico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorUnico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String value = request.getParameter("action");
		
		if(value.equals("mostrarEmpleados")) {
			
			try {
				
				List<Empleado> emp = Conexion.mostrarEmpleados();
				request.setAttribute("listaEmpleados", emp);
				RequestDispatcher rd = request.getRequestDispatcher("mostrarEmpleados.jsp");
				rd.forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(value.equals("mostrarSalario")) {
			
			RequestDispatcher rd;
			
			String salario = null;
			
			salario = Conexion.mostrarSalarioDni(request.getParameter("dni"));
			request.setAttribute("salarioEmp", salario);
			rd = request.getRequestDispatcher("mostrarSalarioEmpleado.jsp");
			rd.forward(request, response);
		} else if(value.equals("modificarEmpleado")) {
			RequestDispatcher rd;
			
			String dni = request.getParameter("dni");
			
			String nombre = request.getParameter("nombre");
			
			char sexo = request.getParameter("sexo").charAt(0);
			
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			
			int anyos = Integer.parseInt(request.getParameter("anyos"));
			
			
			try {
	
				Conexion.modificarEmpleado(dni, nombre, sexo, categoria, anyos);
				rd = request.getRequestDispatcher("Menu.html");
				rd.forward(request, response);
				
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

						
		}
		
		
	}



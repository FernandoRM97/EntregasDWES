package filmografia.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.bbdd.Conexion;

/**
 * Servlet implementation class altaPeliculaController
 */
public class altaPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Conexion conexion;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public altaPeliculaController() {
		super();

		conexion = new Conexion();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;

		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");

		try {
			Conexion.nuevaPeli(director, titulo, fecha);
		} catch (ClassNotFoundException e) {
			rd = request.getRequestDispatcher("nuevaPeliculaFail.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("nuevaPeliculaFail.jsp");
			rd.forward(request, response);
		}

		rd = request.getRequestDispatcher("mantenimientoController");
		rd.forward(request, response);
	}

}

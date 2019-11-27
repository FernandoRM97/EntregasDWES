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
 * Servlet implementation class borrarPeliculaController
 */
public class borrarPeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public borrarPeliculaController() {
		super();
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

		String titulo = request.getParameter("titulo");


		try {
			Conexion.borrarPeli(titulo);
		} catch (ClassNotFoundException e) {
			rd = request.getRequestDispatcher("borrarPeliculaFail.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("borrarPeliculaFail.jsp");
			rd.forward(request, response);
		} catch (IllegalStateException e) {
			rd = request.getRequestDispatcher("borrarPeliculaFail.jsp");
			rd.forward(request, response);
		}

		rd = request.getRequestDispatcher("mantenimientoController");
		rd.forward(request, response);
	}

}

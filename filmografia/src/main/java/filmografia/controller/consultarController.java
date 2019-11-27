package filmografia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.bbdd.Conexion;
import filmografia.model.Pelicula;

/**
 * Servlet implementation class consultarController
 */
public class consultarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public consultarController() {
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

		String director = request.getParameter("director");

		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();

		try {
			lista = Conexion.consultarDirector(director);
		} catch (ClassNotFoundException e) {
			rd = request.getRequestDispatcher("consultarIncorrecto.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("consultarIncorrecto.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("director", director);
		request.setAttribute("pelis", lista);
		rd = request.getRequestDispatcher("consultarPelis.jsp");
		rd.forward(request, response);
	}

}

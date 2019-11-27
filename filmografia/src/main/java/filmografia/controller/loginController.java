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
import filmografia.model.Usuario;

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;

		String usuario = request.getParameter("user");

		String clave = request.getParameter("passwd");

		try {

			ArrayList<Usuario> lista = new ArrayList<Usuario>();

			lista = Conexion.consultarLogin(usuario, clave);

			if (lista.isEmpty()) {
				rd = request.getRequestDispatcher("loginIncorrecto.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("nombre", usuario);
				rd = request.getRequestDispatcher("loginCorrecto.jsp");		
				
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException e) {
			rd = request.getRequestDispatcher("loginIncorrecto.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			rd = request.getRequestDispatcher("loginIncorrecto.jsp");
			rd.forward(request, response);
		} catch (IndexOutOfBoundsException e) {
			rd = request.getRequestDispatcher("loginIncorrecto.jsp");
			rd.forward(request, response);
		}
	}

}

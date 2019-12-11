package com.companyname.springapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.domain.Pelicula;
import com.companyname.springapp.domain.Usuario;
import com.companyname.springapp.repository.Conexion;

@Controller
@RequestMapping("/filmografia")
public class FilmografiaController {

	Conexion co = new Conexion();

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("index");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public ModelAndView info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("info");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("login");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/logearse")
	public ModelAndView loguearse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("user");
		String clave = request.getParameter("passwd");

		String pagina;

		try {

			ArrayList<Usuario> lista = new ArrayList<Usuario>();

			lista = co.consultarLogin(usuario, clave);

			if (lista.isEmpty()) {
				pagina = "loginIncorrecto";
			} else {
				request.setAttribute("nombre", usuario);
				pagina = "loginCorrecto";

			}

		} catch (ClassNotFoundException e) {
			pagina = "loginIncorrecto";
		} catch (SQLException e) {
			pagina = "loginIncorrecto";
		} catch (IndexOutOfBoundsException e) {
			pagina = "loginIncorrecto";
		}

		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/registrar")
	public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("registrar");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrarse")
	public ModelAndView registrarse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("user");
		String clave = request.getParameter("passwd");

		String pagina;

		try {
			co.nuevoUser(usuario, clave);
		} catch (ClassNotFoundException e) {
			pagina = "registrarFail";
		} catch (SQLException e) {
			pagina = "registrarFail";
		}

		pagina = "index";

		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/mantenimiento")
	public ModelAndView mantenimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Pelicula> lista = new ArrayList<>();

		try {
			lista = co.verPelis();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listaPelis", lista);

		return new ModelAndView("mantenimiento");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/consultar")
	public ModelAndView consultarDirectores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("consultar");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/consultarPelis")
	public ModelAndView consultarDirectores2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String director = request.getParameter("director");

		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();

		String pagina;

		try {
			lista = co.consultarDirector(director);
		} catch (ClassNotFoundException e) {
			pagina = "index";
		} catch (SQLException e) {
			pagina = "index";
		}

		request.setAttribute("director", director);
		request.setAttribute("pelis", lista);

		pagina = "consultarPelis";

		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/finalizar")
	public ModelAndView finalizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashSet<String> lista;

		lista = co.listaDirectores();

		request.setAttribute("directoresConsultados", lista);

		return new ModelAndView("finalizar");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/fin")
	public ModelAndView fin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		co = new Conexion();

		return new ModelAndView("index");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/nuevaPeli")
	public ModelAndView nuevaPeli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("nuevaPelicula");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/altaPeli")
	public ModelAndView altaPeli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");

		String pagina;

		try {
			co.nuevaPeli(director, titulo, fecha);
		} catch (ClassNotFoundException e) {
			pagina = "nuevaPeliculaFail";

		} catch (SQLException e) {
			pagina = "nuevaPeliculaFail";
		}

		pagina = "mantenimiento";

		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/borrarPeli")
	public ModelAndView borrarPeli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("borrarPelicula");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/borrarPelicula")
	public ModelAndView borrarPelicula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		
		String pagina;

		try {
			co.borrarPeli(titulo);
		} catch (ClassNotFoundException e) {
			pagina = "borrarPeliculaFail";
		} catch (SQLException e) {
			pagina = "borrarPeliculaFail";
		} catch (IllegalStateException e) {
			pagina = "borrarPeliculaFail";
		}

		pagina = "mantenimiento";

		return new ModelAndView(pagina);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/modificarPeli")
	public ModelAndView modificarPeli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("modificarPelicula");

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modificarPelicula")
	public ModelAndView modificarPelicula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina;

		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		String tituloMod = request.getParameter("tituloMod");

		try {
			co.modificarPeli(director, titulo, fecha, tituloMod);
		} catch (ClassNotFoundException e) {
			pagina = "modificarPeliculaFail";
		} catch (SQLException e) {
			pagina = "modificarPeliculaFail";
		}

		pagina = "mantenimiento";
		
		return new ModelAndView(pagina);

	}
}

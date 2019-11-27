package filmografia.model;

import java.util.Date;

public class Pelicula {

	public String director;

	public String titulo;

	public Date fecha;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Pelicula(String director, String titulo, Date fecha) {
		super();
		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}

}

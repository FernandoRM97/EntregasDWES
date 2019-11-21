package net.itinajero.laboral;

import net.itinajero.app.exception.DatosNoCorrectosException;

/**
 * Clase Empleado que hereda de Persona
 * @author fernando
 *
 */
public class Empleado extends Persona implements Nomina {

	static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000 };

	private int categoria;
	
	public int anyos;

	/**
	 * Constructor con todos los parámetros 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @param categoria
	 * @param anyos
	 * @throws DatosNoCorrectosException
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
		super(nombre, dni, sexo);

			if (categoria > 0 && categoria < 11) {
				this.categoria = categoria;
			} else {
				throw new DatosNoCorrectosException();
			}


			if (anyos >= 0) {
				this.anyos = anyos;
			} else {
				throw new DatosNoCorrectosException();
			}

	}

	/**
	 * Constructor con algunos parámetros y otros cargados por defecto
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;
	}

	/**
	 * Setter del atributo categoría
	 * @param categoria
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * Getter de categoria
	 * @return categoria del objeto
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Aumenta los años trabajados en uno
	 * @return años trabajados mas uno
	 */
	public int incrAnyo() {
		this.anyos = this.anyos++;

		return this.anyos;
	}

	/**
	 *  ToString que muestra los atributos del objeto Empleado
	 */
	public String imprime() {
		return "Empleado [categoria=" + categoria + ", anyos=" + anyos + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}

	/**
	 * Método que calcula el sueldo de cada Empleado
	 */
	public int sueldo() {
		final int CONS = 5000;

		int sueldo = 0;
		int sueldo2 = 0;

		for (int i = 0; i < SUELDO_BASE.length; i++) {
			if (i == this.categoria) {
				sueldo2 = SUELDO_BASE[i-1];
			}
		}

		sueldo = (sueldo2 + (CONS * this.anyos));

		return sueldo;
	}

	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}
	
	

}
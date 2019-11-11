package net.itinajero.laboral;

import net.itinajero.app.exception.DatosNoCorrectosException;

/**
package Laboral;

/**
 * Esta es una clase padre Persona para que luego diferentes clases puedan heredar de ella.
 * @author fernando
 * @version 1.0
 *
 */
public abstract class Persona {

	public String nombre;

	public String dni;

	public char sexo;
	
	/**
	 * Constructor con todos los parámetros
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */

	public Persona(String nombre, String dni, char sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		
	}

	/**
	 * Constructor con los siguientes parámetros:
	 * 
	 * @param nombre
	 * @param sexo
	 */
	public Persona(String nombre, char sexo) {
		super();
		this.nombre = nombre;
		
			if(this.sexo == 'H' || this.sexo == 'M') {
				this.sexo = sexo;
			} else {
				throw new DatosNoCorrectosException();
			}

		
	}

	/**
	 * Setter del parámetro dni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Getter del dni
	 * @return dni
	 */

	public String getDni() {
		return dni;
	}

	/**
	 * ToString que muestra por pantalla los atributos del objeto
	 * @return mensaje
	 */
	public String imprime() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
}
package net.itinajero.app.exception;

/**
 * Esta es una clase en la cual creamos una Excepcion
 * 
 * @author fernando
 *
 */
public class DatosNoCorrectosException extends RuntimeException {

	public DatosNoCorrectosException() {
		super();
	}

	public DatosNoCorrectosException(String s) {
		super(s);
	}

	public DatosNoCorrectosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatosNoCorrectosException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
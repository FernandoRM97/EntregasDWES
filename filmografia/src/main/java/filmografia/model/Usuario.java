package filmografia.model;

public class Usuario {

	public String nombre;
	
	public String clave;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Usuario(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}
	
}

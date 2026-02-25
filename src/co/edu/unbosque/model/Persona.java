package co.edu.unbosque.model;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String correoInst;
	private long id;
	private long telefono;
	private String contrasena;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoInst = correoInst;
		this.id = id;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreoInst() {
		return correoInst;
	}

	public void setCorreoInst(String correoInst) {
		this.correoInst = correoInst;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Persona: \nnombres: " + nombre + "\napellidos:" + apellido + "\nCorreo institucional: " + correoInst + "\nNumero de identificacion: " + id
				+ "\nNumero de celular: " + telefono + "\nContraseña: " + contrasena;
	}
	
	

}

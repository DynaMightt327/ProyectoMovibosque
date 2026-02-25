package co.edu.unbosque.model;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String correoInst;
	private long id;
	private long telefono;
	private String contrasena;
	private String facultad;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena, String facultad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoInst = correoInst;
		this.id = id;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.facultad = facultad;
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
	
	public String getFacultad() {
		return facultad;
	}
	
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", correoInst=" + correoInst + ", id=" + id
				+ ", telefono=" + telefono + ", contrasena=" + contrasena + ", facultad=" + facultad + "]";
	}
	

	

	
	

}

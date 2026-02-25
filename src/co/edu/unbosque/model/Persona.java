package co.edu.unbosque.model;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String correoInst;
	private String nUsuario;
	private long id;
	private long telefono;
	private String contrasena;
	private String facultad;
	private String rol;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoInst = correoInst;
		this.nUsuario = nUsuario;
		this.id = id;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.facultad = facultad;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Persona: \nNombres: " + nombre + "\nApellidos: " + apellido + "\nCorreo institucional: " + correoInst + "\nUsuario: "
				+ nUsuario + "\nNumero de identificacion:" + id + "\nNumero de celular: " + telefono + "\nContraseña: " + contrasena + "\nFacultad: "
				+ facultad + "\nRol: " + rol;
	}

	
	
	

}

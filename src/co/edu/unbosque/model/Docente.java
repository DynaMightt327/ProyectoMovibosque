package co.edu.unbosque.model;

public class Docente extends Persona {
	
	private String facultad;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(String facultad) {
		super();
		this.facultad = facultad;
	}

	public Docente(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String facultad) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		this.facultad = facultad;
	}

	public Docente(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Docente: \nFacultad: " + facultad;
	}
	
	

}

package co.edu.unbosque.model;

public class Administrativo extends Persona{
	
	private String facultad;
	private int annoServicio;
	
	public Administrativo() {
		// TODO Auto-generated constructor stub
	}

	public Administrativo(String facultad, int annoServicio) {
		super();
		this.facultad = facultad;
		this.annoServicio = annoServicio;
	}

	public Administrativo(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String facultad, String facultad2, int annoServicio) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		facultad = facultad2;
		this.annoServicio = annoServicio;
	}

	public Administrativo(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String facultad) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrativo [facultad=" + facultad + ", annoServicio=" + annoServicio + "]";
	}

	
	
	

}

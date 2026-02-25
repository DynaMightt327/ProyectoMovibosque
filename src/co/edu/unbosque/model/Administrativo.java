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
			String facultad, int annoServicio) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		this.facultad = facultad;
		this.annoServicio = annoServicio;
	}

	public Administrativo(String nombre, String apellido, String correoInst, long id, long telefono,
			String contrasena) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Administrativo: \nFacultad: " + facultad + "\nAños de servicio: " + annoServicio;
	}
	
	

}

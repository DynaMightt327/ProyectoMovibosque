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


	public Administrativo(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol, String facultad2, int annoServicio) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		facultad = facultad2;
		this.annoServicio = annoServicio;
	}
	
	

	public Administrativo(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrativo: \nFacultad: " + facultad + "\naños de servicio: " + annoServicio;
	}

	
	
	

}

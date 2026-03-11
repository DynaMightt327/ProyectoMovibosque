package co.edu.unbosque.model;

public class Administrativo extends Persona{
	
	private int annoServicio;
	
	public Administrativo() {
		// TODO Auto-generated constructor stub
	}

	
	public Administrativo(int annoServicio) {
		super();
		this.annoServicio = annoServicio;
	}


	public Administrativo(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol, int annoServicio) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		this.annoServicio = annoServicio;
	}


	public Administrativo(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		// TODO Auto-generated constructor stub
	}


	public int getAnnoServicio() {
		return annoServicio;
	}


	public void setAnnoServicio(int annoServicio) {
		this.annoServicio = annoServicio;
	}


	@Override
	public String toString() {
		return super.toString() + "Administrativo: \naños de servicio: " + annoServicio;
	}

	
	
	

}

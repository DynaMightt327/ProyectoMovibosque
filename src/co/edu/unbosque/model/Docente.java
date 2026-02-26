package co.edu.unbosque.model;

public class Docente extends Persona {
	
	private int numeroMateria;;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(int numeroMateria) {
		super();
		this.numeroMateria = numeroMateria;
	}


	public Docente(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol, int numeroMateria) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		this.numeroMateria = numeroMateria;
	}
	

	public Docente(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
			String contrasena, String facultad, String rol) {
		super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
		// TODO Auto-generated constructor stub
	}

	public int getNumeroMateria() {
		return numeroMateria;
	}

	public void setNumeroMateria(int numeroMateria) {
		this.numeroMateria = numeroMateria;
	}

	@Override
	public String toString() {
		return "Docente: \nNumero de materias: " + numeroMateria;
	}

	
	
	

}

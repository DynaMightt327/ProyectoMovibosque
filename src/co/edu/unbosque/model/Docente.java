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

	public Docente(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena, String facultad,
			int numeroMateria) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		this.numeroMateria = numeroMateria;
	}

	public Docente(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena, String facultad) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Docente: \nNumero de materias: " + numeroMateria;
	}

	
	
	

}

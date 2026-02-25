package co.edu.unbosque.model;

public class Estudiante extends Persona{
	
	private String carrera;
	private int semestre;
	private String facultad;
	
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(String carrera, int semestre, String facultad) {
		super();
		this.carrera = carrera;
		this.semestre = semestre;
		this.facultad = facultad;
	}

	public Estudiante(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String carrera, int semestre, String facultad) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		this.carrera = carrera;
		this.semestre = semestre;
		this.facultad = facultad;
	}

	public Estudiante(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena) {
		super(nombre, apellido, correoInst, id, telefono, contrasena);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Estudiante: \nCarrera: " + carrera + "\nSemestre: " + semestre + "\nFacultad: " + facultad;
	}
	
	

}

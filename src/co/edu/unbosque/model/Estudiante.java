package co.edu.unbosque.model;

public class Estudiante extends Persona{
	
	private String carrera;
	private int semestre;
	
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(String carrera, int semestre) {
		super();
		this.carrera = carrera;
		this.semestre = semestre;
	}

	public Estudiante(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String facultad, String carrera, int semestre) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		this.carrera = carrera;
		this.semestre = semestre;
	}

	public Estudiante(String nombre, String apellido, String correoInst, long id, long telefono, String contrasena,
			String facultad) {
		super(nombre, apellido, correoInst, id, telefono, contrasena, facultad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Estudiante: \nCarrera: " + carrera + "\nSemestre: " + semestre;
	}
	
	

	
	
	

}

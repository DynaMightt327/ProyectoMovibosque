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


public Estudiante(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
		String contrasena, String facultad, String rol, String carrera, int semestre) {
	super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
	this.carrera = carrera;
	this.semestre = semestre;
}


public Estudiante(String nombre, String apellido, String correoInst, String nUsuario, long id, long telefono,
		String contrasena, String facultad, String rol) {
	super(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol);
	// TODO Auto-generated constructor stub
}


public String getCarrera() {
	return carrera;
}

public void setCarrera(String carrera) {
	this.carrera = carrera;
}

public int getSemestre() {
	return semestre;
}

public void setSemestre(int semestre) {
	this.semestre = semestre;
}


@Override
public String toString() {
	return super.toString() + "Estudiante \nCarrera:" + carrera + "\nSemestre:" + semestre;
}


}

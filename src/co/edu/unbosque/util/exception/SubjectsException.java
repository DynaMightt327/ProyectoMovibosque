package co.edu.unbosque.util.exception;

public class SubjectsException extends Exception {
	
	public SubjectsException() {
		super("No se permiten numeros negativos, letras, simbolos o numeros mayores a 5");
	}

}

package co.edu.unbosque.util.exception;

public class ExperienceException extends Exception{
	
	public ExperienceException() {
		super("No se permiten numeros negativos, letras, simbolos o numeros mayores a 30");
	}

}

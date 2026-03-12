package co.edu.unbosque.util.exception;

public class CelException extends Exception {

	public CelException() {
		super("No se permiten letras, numeros negativos, digitos menores o mayores que 10 y simbolos");
	}
	
}

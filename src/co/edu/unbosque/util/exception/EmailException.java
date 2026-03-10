package co.edu.unbosque.util.exception;

public class EmailException extends Exception {
	
	public EmailException() {
		super("Correo invalido: por favor entre un correo valido con el formato adecuado");
	}

}

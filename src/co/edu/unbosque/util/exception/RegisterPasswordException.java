package co.edu.unbosque.util.exception;

public class RegisterPasswordException extends Exception {
	
	public RegisterPasswordException() {
		super("Contraseña invalida, la contraseña debe contener por lo menos 10 caracteres");
	}

}

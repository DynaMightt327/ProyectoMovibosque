package co.edu.unbosque.util.exception;

public class NickNameException extends Exception {
	
	public NickNameException() {
		super("Usuario invalido: minimo 5 letras, no numeros, simbolos o espacios al inicio o al final");
	}

}

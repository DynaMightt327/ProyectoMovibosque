package co.edu.unbosque.util.exception;

public class SemesterExcepcion extends Exception{
	
	public SemesterExcepcion() {
		super("No se permiten numeros negativos, letras, simbolos o numeros mayores a 12");
	}

}

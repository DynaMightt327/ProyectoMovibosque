package co.edu.unbosque.controller;

import co.edu.unbosque.view.VentanaInicial;

public class Controller {
	
	private VentanaInicial vi;
	
	public Controller() {
		vi = new VentanaInicial();
	}
	
	public void iniciar() {
		vi.setVisible(true);
		
		
	}

}

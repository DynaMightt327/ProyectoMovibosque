package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VentanaIngreso;
import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaRegistro;

public class Controller implements ActionListener {
	
	private VentanaInicial vi;
	private VentanaRegistro vr;
	private VentanaIngreso vin;
	
	public Controller() {
		vi = new VentanaInicial();
		vr = new VentanaRegistro();
		vin = new VentanaIngreso();
		asignarOyentes();
	}
	
	
	public void asignarOyentes() {
		//==PRIMERA VENTANA==
		vi.getRegistrar().addActionListener(this);
		vi.getRegistrar().setActionCommand("boton_registrar");
		
		vi.getIniciarSesion().addActionListener(this);
		vi.getIniciarSesion().setActionCommand("boton_iniciar_sesion");
		
		//==VENTANA REGISTRO==
		vr.getbVolver().addActionListener(this);
		vr.getbVolver().setActionCommand("boton_volver_registrar");
		
		vr.getbRegistrar().addActionListener(this);
		vr.getbRegistrar().setActionCommand("boton_crear_cuenta");
		
		//==VENTANA INICIAR SESION==
		vin.getVolver().addActionListener(this);
		vin.getVolver().setActionCommand("boton_volver_iniciar_sesion");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_registrar": {
			vi.setVisible(false);
			vr.setVisible(true);
			break;
			
		}
		case "boton_volver_registrar": {
			vr.setVisible(false);
			vi.setVisible(true);
			break;
			
		}
		case "boton_crear_cuenta":{
			vr.setVisible(false);
			vin.setVisible(true);
			break;
		}
		
		case "boton_iniciar_sesion":{
			vi.setVisible(false);
			vin.setVisible(true);
			break;
		}
		
		case "boton_volver_iniciar_sesion":{
			vin.setVisible(false);
			vi.setVisible(true);
			break;
		}
		default:{
			break;
		}
		
	}
		
	}

	public void iniciar() {
		vi.setVisible(true);
		
	}
}

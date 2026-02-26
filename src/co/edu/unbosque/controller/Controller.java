package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Administrativo;
import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.view.VentanaEstudianteInicio;
import co.edu.unbosque.view.VentanaIngreso;
import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaRegistro;

public class Controller implements ActionListener {
	
	private VentanaInicial vi;
	private VentanaRegistro vr;
	private VentanaIngreso vin;
	private VentanaEstudianteInicio vei;
	
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Docente> listaDocentes;
	private ArrayList<Administrativo> listaAdmins;
	
	public Controller() {
		//==VENTANAS==
		vi = new VentanaInicial();
		vr = new VentanaRegistro();
		vin = new VentanaIngreso();
		vei = new VentanaEstudianteInicio();
		
		//==LISTAS==
		listaEstudiantes = new ArrayList<>();
		
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
		vr.getbRegistrar().setActionCommand("boton_guardar_cuenta");
		
		//==VENTANA INICIAR SESION==
		vin.getVolver().addActionListener(this);
		vin.getVolver().setActionCommand("boton_volver_iniciar_sesion");
		
		vin.getIniciar().addActionListener(this);
		vin.getIniciar().setActionCommand("boton_entrar_cuenta");
		
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
		case "boton_guardar_cuenta":{
			try {
				String nombre = vr.gettNombre().getText();
				String apellido = vr.gettApellido().getText();
				String correoInst = vr.gettCorreo().getText();
				String nUsuario = vr.gettUsuario().getText();
				long id = (long) Long.parseLong(vr.gettDocumento().getText());
				long telefono = (long) Long.parseLong(vr.gettTelefono().getText());
				String contrasena = vr.gettContrasena().getText();
				String facultad = (String) vr.gettFacultad().getSelectedItem();
				String rol = (String) vr.gettRol().getSelectedItem();
				
				if(rol.equalsIgnoreCase("Estudiante")) {
				//listaEstudiantes.add(new Estudiante(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, rol, 0));
				
				}else if(rol.equalsIgnoreCase("Docente")) {
				//listaDocentes.add(new Docente(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, 0));
				}else if(rol.equalsIgnoreCase("Administrativo")) {
				//listaAdmins.add(new Administrativo(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, facultad, 0));
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
		case "boton_entrar_cuenta":{
			vin.setVisible(false);
			vei.setVisible(true);
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

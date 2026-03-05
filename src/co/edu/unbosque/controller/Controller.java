package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Administrativo;
import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.DocenteDAO;
import co.edu.unbosque.model.persistence.EstudianteDAO;
import co.edu.unbosque.view.VentanaEstudianteInicio;
import co.edu.unbosque.view.VentanaIngreso;
import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaRegistro;

public class Controller implements ActionListener {
	
	private VentanaInicial vi;
	private VentanaRegistro vr;
	private VentanaIngreso vin;
	private VentanaEstudianteInicio vei;
	
	private AdministrativoDAO aDAO;
	private DocenteDAO dDAO;
	private EstudianteDAO eDAO;
	
	
	public Controller() {
		//==VENTANAS==
		vi = new VentanaInicial();
		vr = new VentanaRegistro();
		vin = new VentanaIngreso();
		vei = new VentanaEstudianteInicio();
		
		//==LISTAS==
		aDAO = new AdministrativoDAO();
		dDAO = new DocenteDAO();
		eDAO = new EstudianteDAO();
		
		asignarOyentes();
		actualizarCamposPorRol();
		
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
		
		vr.gettRol().addActionListener(this);
		vr.gettRol().setActionCommand("cambio_rol");
		
		//==VENTANA PRINCIPAL PARA ESTUDIANTE==
		vei.getSalir().addActionListener(this);
		vei.getSalir().setActionCommand("cerrar_sesion_estudiante");
		
		vei.getInicio().addActionListener(this);
		vei.getInicio().setActionCommand("ver_principal_estudiante");
		
		vei.getbTren().addActionListener(this);
		vei.getbTren().setActionCommand("ver_rutas_tren");
		
		vei.getTren().addActionListener(this);
		vei.getTren().setActionCommand("ver_rutas_tren");

		vei.getbBus().addActionListener(this);
		vei.getbBus().setActionCommand("ver_rutas_bus");
		
		vei.getBus().addActionListener(this);
		vei.getBus().setActionCommand("ver_rutas_bus_dos");
		
		vei.getFlechaDerechaUno().addActionListener(this);
		vei.getFlechaDerechaUno().setActionCommand("usar_flecha_derecha_tren");
		
		vei.getFlechaIzquierdaUno().addActionListener(this);
		vei.getFlechaIzquierdaUno().setActionCommand("usar_flecha_izquierda_tren");

		vei.getFlechaDerechaDos().addActionListener(this);
		vei.getFlechaDerechaDos().setActionCommand("usar_flecha_derecha_tren");
		
		vei.getFlechaIzquierdaDos().addActionListener(this);
		vei.getFlechaIzquierdaDos().setActionCommand("usar_flecha_izquierda_tren");
		
		
		vei.getFlechaDerUnoBus().addActionListener(this);
		vei.getFlechaDerUnoBus().setActionCommand("usar_flecha_derecha_bus");
		
		vei.getFlechaIzqUnoBus().addActionListener(this);
		vei.getFlechaIzqUnoBus().setActionCommand("usar_flecha_izquierda_bus");

		vei.getFlechaDerDosBus().addActionListener(this);
		vei.getFlechaDerDosBus().setActionCommand("usar_flecha_derecha_bus");
		
		vei.getFlechaIzqDosBus().addActionListener(this);
		vei.getFlechaIzqDosBus().setActionCommand("usar_flecha_izquierda_bus");
		
		
	}
	
	public void actualizarCamposPorRol() {
		String rol = (String) vr.gettRol().getSelectedItem();
		
	
		if(rol == null){
			
			if(vr.getCarrera() != null)vr.getCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.gettCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.getSemestre().setVisible(false);
			if(vr.getCarrera() != null)vr.gettSemestre().setVisible(false);
			
			//ocultar los de docente
			if(vr.getCarrera() != null)vr.getNumMateria().setVisible(false);
			if(vr.getCarrera() != null)vr.gettNumMateria().setVisible(false);
			
			//ocultar los de administrativo
			if(vr.getCarrera() != null)vr.getAnnoServicio().setVisible(false);
			if(vr.getCarrera() != null)vr.gettAnnoServicio().setVisible(false);
			
			
		}else if(rol.equalsIgnoreCase("Estudiante")) {
			
			//mostrar los campos de estudainte
			if(vr.getCarrera() != null)vr.getCarrera().setVisible(true);
			if(vr.getCarrera() != null)vr.gettCarrera().setVisible(true);
			if(vr.getCarrera() != null)vr.getSemestre().setVisible(true);
			if(vr.getCarrera() != null)vr.gettSemestre().setVisible(true);
			
			//ocultar los de docente
			if(vr.getCarrera() != null)vr.getNumMateria().setVisible(false);
			if(vr.getCarrera() != null)vr.gettNumMateria().setVisible(false);
			
			//ocultar los de administrativo
			if(vr.getCarrera() != null)vr.getAnnoServicio().setVisible(false);
			if(vr.getCarrera() != null)vr.gettAnnoServicio().setVisible(false);
			
		} else if(rol.equalsIgnoreCase("Docente")) {
			
			//ocultar los de estudiante
			if(vr.getCarrera() != null)vr.getCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.gettCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.getSemestre().setVisible(false);
			if(vr.getCarrera() != null)vr.gettSemestre().setVisible(false);
			
			//mostrar campos de docente
			if(vr.getCarrera() != null)vr.getNumMateria().setVisible(true);
			if(vr.getCarrera() != null)vr.gettNumMateria().setVisible(true);
			
			//ocultar los de administrativo
			if(vr.getCarrera() != null)vr.getAnnoServicio().setVisible(false);
			if(vr.getCarrera() != null)vr.gettAnnoServicio().setVisible(false);
			
		} else if(rol.equalsIgnoreCase("Administrativo")) {
			
			//Ocultar los de estudiantes
			if(vr.getCarrera() != null)vr.getCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.gettCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.getSemestre().setVisible(false);
			if(vr.getCarrera() != null)vr.gettSemestre().setVisible(false);
			
			//Ocultar los de docente
			if(vr.getCarrera() != null)vr.getNumMateria().setVisible(false);
			if(vr.getCarrera() != null)vr.gettNumMateria().setVisible(false);
			
			//Mostrar los de administrativo
			if(vr.getCarrera() != null)vr.getAnnoServicio().setVisible(true);
			if(vr.getCarrera() != null)vr.gettAnnoServicio().setVisible(true);
			
		} else {
			
			//Ocultar los de estudiantes
			if(vr.getCarrera() != null)vr.getCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.gettCarrera().setVisible(false);
			if(vr.getCarrera() != null)vr.getSemestre().setVisible(false);
			if(vr.getCarrera() != null)vr.gettSemestre().setVisible(false);
			
			//Ocultar los de docente
			if(vr.getCarrera() != null)vr.getNumMateria().setVisible(false);
			if(vr.getCarrera() != null)vr.gettNumMateria().setVisible(false);
			
			//Ocultar los de administrativo
			if(vr.getCarrera() != null)vr.getAnnoServicio().setVisible(false);
			if(vr.getCarrera() != null)vr.gettAnnoServicio().setVisible(false);
			
		}
		
		vr.revalidate();
		vr.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_registrar": {
			vi.setVisible(false);
			vr.setVisible(true);
		}
		case "cambio_rol": {
			actualizarCamposPorRol();
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
					
					String carrera = vr.gettCarrera().getText();
					int semestre = 	Integer.parseInt(vr.gettSemestre().getText());
					eDAO.crear(new Estudiante(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, carrera, semestre));
					
				}else if(rol.equalsIgnoreCase("Docente")) {
					int numeroMateria = Integer.parseInt(vr.gettNumMateria().getText());
					dDAO.crear(new Docente(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, numeroMateria));
					
				}else if(rol.equalsIgnoreCase("Administrativo")) {
					int annoServicio = Integer.parseInt(vr.gettAnnoServicio().getText());
					aDAO.crear(new Administrativo(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad, rol, facultad, annoServicio));
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
		case "cambio rol": {
			actualizarCamposPorRol();
			break;
		}
		case "cerrar_sesion_estudiante": {
			vei.setVisible(false);
			vin.setVisible(true);
			break;
		}
		case "ver_rutas_tren":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getHorarioIda().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			break;
		}
		case "ver_rutas_bus":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			break;
		}
		case "ver_principal_estudiante":{
			vei.getPanelPrincipal().setVisible(true);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			break;
		}
		case "usar_flecha_derecha_tren":{
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_tren":{			
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIda().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_bus":{
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_bus":{			
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
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

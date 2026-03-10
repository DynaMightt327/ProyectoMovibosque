package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.login.CredentialException;

import co.edu.unbosque.model.Administrativo;
import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.DocenteDAO;
import co.edu.unbosque.model.persistence.EstudianteDAO;
import co.edu.unbosque.util.exception.EmptyDataException;
import co.edu.unbosque.util.exception.LastNameException;
import co.edu.unbosque.util.exception.NameException;
import co.edu.unbosque.util.exception.NumericalDataException;
import co.edu.unbosque.util.exception.OutRangeException;
import co.edu.unbosque.view.VentanaAdminInicio;
import co.edu.unbosque.view.VentanaDocenteInicio;
import co.edu.unbosque.view.VentanaEstudianteInicio;
import co.edu.unbosque.view.VentanaIngreso;
import co.edu.unbosque.view.VentanaInicial;
import co.edu.unbosque.view.VentanaRegistro;

public class Controller implements ActionListener {
	
	private VentanaInicial vi;
	private VentanaRegistro vr;
	private VentanaIngreso vin;
	private VentanaEstudianteInicio vei;
	private VentanaDocenteInicio vdi;
	private VentanaAdminInicio vai;
	
	private AdministrativoDAO aDAO;
	private DocenteDAO dDAO;
	private EstudianteDAO eDAO;
	
	private Estudiante estudianteActual;
	private Docente docenteActual;
	private Administrativo adminActual;
	
	
	public Controller() {
		//==VENTANAS==
		vi = new VentanaInicial();
		vr = new VentanaRegistro();
		vin = new VentanaIngreso();
		vei = new VentanaEstudianteInicio();
		vdi = new VentanaDocenteInicio();
		vai = new VentanaAdminInicio();
		
		//==DAO==
		aDAO = new AdministrativoDAO();
		dDAO = new DocenteDAO();
		eDAO = new EstudianteDAO();
		
		estudianteActual = new Estudiante();
		docenteActual = new Docente();
		adminActual = new Administrativo();
		
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
		vei.getTren().setActionCommand("ver_rutas_tren_dos");

		vei.getbBus().addActionListener(this);
		vei.getbBus().setActionCommand("ver_rutas_bus");
		
		vei.getBus().addActionListener(this);
		vei.getBus().setActionCommand("ver_rutas_bus_dos");
		
		vei.getFlechaDerechaUno().addActionListener(this);
		vei.getFlechaDerechaUno().setActionCommand("usar_flecha_derecha_tren");
		
		/*vei.getFlechaIzquierdaUno().addActionListener(this);
		vei.getFlechaIzquierdaUno().setActionCommand("usar_flecha_izquierda_tren");*/

		/*vei.getFlechaDerechaDos().addActionListener(this);
		vei.getFlechaDerechaDos().setActionCommand("usar_flecha_derecha_tren");*/
		
		vei.getFlechaIzquierdaDos().addActionListener(this);
		vei.getFlechaIzquierdaDos().setActionCommand("usar_flecha_izquierda_tren");
		
		
		vei.getFlechaDerUnoBus().addActionListener(this);
		vei.getFlechaDerUnoBus().setActionCommand("usar_flecha_derecha_bus");
		
		/*vei.getFlechaIzqUnoBus().addActionListener(this);
		vei.getFlechaIzqUnoBus().setActionCommand("usar_flecha_izquierda_bus");

		vei.getFlechaDerDosBus().addActionListener(this);
		vei.getFlechaDerDosBus().setActionCommand("usar_flecha_derecha_bus");*/
		
		vei.getFlechaIzqDosBus().addActionListener(this);
		vei.getFlechaIzqDosBus().setActionCommand("usar_flecha_izquierda_bus");
		
		vei.getPerfil().addActionListener(this);
		vei.getPerfil().setActionCommand("ver_perfil_estudiante");
		
		vei.getReserva().addActionListener(this);
		vei.getReserva().setActionCommand("ver_reserva");
		
		
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
				
				verificarNombre(nombre);
				verificarApellido(apellido);
				
				
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
				
				JOptionPane.showMessageDialog(vr, "Cuenta creada exitosamente", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();
				vr.setVisible(false);
				vi.setVisible(true);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(vr, "Error al registrar cuenta. Verifique datos", "ERROR", JOptionPane.ERROR_MESSAGE);
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
			try {
				String usuario = vin.gettUsuario().getText();
				String contrasena = new String(vin.gettContrasena().getPassword());
				
				Estudiante estudiante = eDAO.buscarPorCredencial(usuario, contrasena);
				
				if(estudiante != null) {
					if(!estudiante.getRol().equalsIgnoreCase("Estudiante")) {
						throw new CredentialException("El usuario no pertenece a estudiante");
					}
					
					estudianteActual = estudiante;
					
					vin.setVisible(false);
					vei.setVisible(true);
					break;
				}
				
				Docente docente = dDAO.buscarPorCredencial(usuario, contrasena);
				
				if(docente != null) {
					if(!docente.getRol().equalsIgnoreCase("Docente")) {
						throw new CredentialException("El usuario no pertenece a docente");
					}
					
					docenteActual = docente;
					
					vin.setVisible(false);
					vdi.setVisible(true);
					break;
				}
				
				Administrativo administrativo =aDAO.buscarPorCredencial(usuario, contrasena);
				
				if(administrativo != null) {
					if(!administrativo.getRol().equalsIgnoreCase("Administrativo")) {
						throw new CredentialException("El usuario no pertenece a administrativo");
					}
					
					adminActual = administrativo;
					
					vin.setVisible(false);
					vai.setVisible(true);
				}
				throw new CredentialException("Error, usuario o contraseña incorrectos");
				
			} catch (CredentialException ex) {
				JOptionPane.showMessageDialog(vin, ex.getMessage(), "Error en credenciales", JOptionPane.ERROR_MESSAGE);
			}
			}
		case "cerrar_sesion_estudiante": {
			vei.setVisible(false);
			vin.setVisible(true);
			break;
		}
		case "ver_perfil_estudiante": {
			
			actualizarPerfilEstudiante();
			
			vei.getPanelPrincipal().setVisible(false);
			vei.getTrenHorario().setVisible(false);
			vei.getBusHorario().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(true);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_rutas_tren":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioIda().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_rutas_tren_dos":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioIda().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_rutas_bus":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getBusHorario().setVisible(true);
			vei.getTrenHorario().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_rutas_bus_dos":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getBusHorario().setVisible(true);
			vei.getTrenHorario().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_principal_estudiante":{
			vei.getPanelPrincipal().setVisible(true);
			vei.getHorarioIda().setVisible(false);
			vei.getTrenHorario().setVisible(false);
			vei.getBusHorario().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_reserva":{
			vei.getPanelPrincipal().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_tren":{
			vei.getHorarioIda().setVisible(false);
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioRegreso().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_tren":{			
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIda().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_bus":{
			vei.getBusHorario().setVisible(true);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_bus":{			
			vei.getBusHorario().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
			break;
		}
		
		
		default:{
			break;
		}
		
	}
		
	}
	
	public void limpiarCampos() {

		vr.gettNombre().setText("");
		vr.gettApellido().setText("");
		vr.gettCorreo().setText("");
		vr.gettUsuario().setText("");
		vr.gettDocumento().setText("");
		vr.gettTelefono().setText("");
		vr.gettContrasena().setText("");

		vr.gettFacultad().setSelectedIndex(0);
		vr.gettRol().setSelectedIndex(0);

		vr.gettCarrera().setText("");
		vr.gettSemestre().setText("");
		vr.gettNumMateria().setText("");
		vr.gettAnnoServicio().setText("");

	}
	
	public void actualizarPerfilEstudiante() {
		
		vei.gettNombre().setText(estudianteActual.getNombre());
		vei.gettApellido().setText(estudianteActual.getApellido());
		vei.gettCorreo().setText(estudianteActual.getCorreoInst());
		vei.gettUsuario().setText(estudianteActual.getnUsuario());
		vei.gettDocumento().setText(String.valueOf(estudianteActual.getId()));
		vei.gettTelefono().setText(String.valueOf(estudianteActual.getTelefono()));
		vei.gettFacultad().setText(estudianteActual.getFacultad());
		vei.gettCarrera().setText(estudianteActual.getCarrera());
		vei.gettSemestre().setText(String.valueOf(estudianteActual.getSemestre()));
		
	}
	/*
	public static void ValidarCampoVacio (String valor, String nombreCampo) throws EmptyDataException {
		if(valor == null || valor.equals("")) {
			throw new EmptyDataException("El campo " + nombreCampo + " no puede estra vacio.");
		}
	}
	
	public static void validarDatoPositivo(String valor, String nombreCampo) throws OutRangeException, NumericalDataException {
		if(valor == null || valor.equals("")) {
			throw new NumericalDataException("El campo " + nombreCampo + " debe ser un numero entero positivo");
		}
		
		try {
			int numero = Integer.parseInt(valor);
			if(numero <= 0) {
				throw new OutRangeException("El campo " + nombreCampo + " debe ser mayor que cero"); 
			}
		} catch (NumberFormatException e) {
			throw new NumericalDataException("El campo " + nombreCampo + " debe ser un numero entero");
		}
	}
	
	public static void validarLargoPositivo(String valor, String nombreCampo) throws NumericalDataException, OutRangeException {
		if(valor == null || valor.equals("")) {
			throw new NumericalDataException("El campo " + nombreCampo + " debe ser un numero valido");
		}
		try {
			long numero = Long.parseLong(valor);
			if(numero <= 0) {
				throw new OutRangeException("El campo " + nombreCampo + " debe ser mayor a cero");
			}
		} catch (NumberFormatException e) {
			throw new NumericalDataException("El campo " + nombreCampo + " debe ser un numero valido");
		}
	}
	
	public static void validarCorreo(String correo) throws EmptyDataException, OutRangeException {
		if(correo == null || correo.equals("")) {
			throw new EmptyDataException("El campo de correo institucional no puede estar vacio");
		}
		if(!correo.contains("@")) {
			throw new OutRangeException("El correo institucional debe contener @");
		}
		if(!correo.contains("unbosque.edu.co")) {
			throw new OutRangeException("El correo debe contener al final (unbosque.edu.co)");
		}
	}
	
	*/
	
	public static void verificarNombre(String name) throws NameException {
		if (name == null || name.isEmpty()) {
			throw new NameException();
		}
		if (!name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || name.length() < 5) {
			throw new NameException();
		}
	}
	
	public static void verificarApellido(String apellido) throws LastNameException {
		if (apellido == null || apellido.isEmpty()) {
			throw new LastNameException();
		}
		if (!apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || apellido.length() < 5) {
			throw new LastNameException();
		}
	}

	public void iniciar() {
		vi.setVisible(true);
		
	}
}

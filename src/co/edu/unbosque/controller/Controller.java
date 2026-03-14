package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.security.auth.login.CredentialException;

import co.edu.unbosque.model.Administrativo;
import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.persistence.AdministrativoDAO;
import co.edu.unbosque.model.persistence.DocenteDAO;
import co.edu.unbosque.model.persistence.EstudianteDAO;
import co.edu.unbosque.model.persistence.ReservaDAO;
import co.edu.unbosque.util.exception.CelException;
import co.edu.unbosque.util.exception.ComboBoxException;
import co.edu.unbosque.util.exception.EmailException;
import co.edu.unbosque.util.exception.ExperienceException;
import co.edu.unbosque.util.exception.IdException;
import co.edu.unbosque.util.exception.LastNameException;
import co.edu.unbosque.util.exception.NameException;
import co.edu.unbosque.util.exception.NickNameException;
import co.edu.unbosque.util.exception.RegisterPasswordException;
import co.edu.unbosque.util.exception.SemesterExcepcion;
import co.edu.unbosque.util.exception.SubjectsException;
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
	private String horarioSeleccionado;

	private AdministrativoDAO aDAO;
	private DocenteDAO dDAO;
	private EstudianteDAO eDAO;
	private ReservaDAO rDAO;

	private Estudiante estudianteActual;
	private Docente docenteActual;
	private Administrativo adminActual;

	public Controller() {
		// ==VENTANAS==
		vi = new VentanaInicial();
		vr = new VentanaRegistro();
		vin = new VentanaIngreso();
		vei = new VentanaEstudianteInicio();
		vdi = new VentanaDocenteInicio();
		vai = new VentanaAdminInicio();
		horarioSeleccionado = null;

		// ==DAO==
		aDAO = new AdministrativoDAO();
		dDAO = new DocenteDAO();
		eDAO = new EstudianteDAO();
		rDAO = new ReservaDAO();

		estudianteActual = new Estudiante();
		docenteActual = new Docente();
		adminActual = new Administrativo();

		asignarOyentes();
		actualizarCamposPorRol();
		exportarUsuario();

	}

	public void asignarOyentes() {
		// ==PRIMERA VENTANA==
		vi.getRegistrar().addActionListener(this);
		vi.getRegistrar().setActionCommand("boton_registrar");

		vi.getIniciarSesion().addActionListener(this);
		vi.getIniciarSesion().setActionCommand("boton_iniciar_sesion");
		
		vdi.getCancelar().addActionListener(this);
		vdi.getCancelar().setActionCommand("cancelar_reserva_docente");
		
		vai.getCancelar().addActionListener(this);
		vai.getCancelar().setActionCommand("cancelar_reserva_admin");

		// ==VENTANA REGISTRO==
		vr.getbVolver().addActionListener(this);
		vr.getbVolver().setActionCommand("boton_volver_registrar");
		
		vei.getCancelar().addActionListener(this);
		vei.getCancelar().setActionCommand("cancelar_reserva_estudiante");

		vr.getbRegistrar().addActionListener(this);
		vr.getbRegistrar().setActionCommand("boton_guardar_cuenta");
		
		vr.gettFacultad().addActionListener(this);
		vr.gettFacultad().setActionCommand("cambio_facultad");
		
		vei.getrBus().addActionListener(this);
		vei.getrBus().setActionCommand("seleccionar_bus_estudiante");

		vei.getrTren().addActionListener(this);
		vei.getrTren().setActionCommand("seleccionar_tren_estudiante");

		vei.getrUsaquen().addActionListener(this);
		vei.getrUsaquen().setActionCommand("actualizar_costo_estudiante");

		vei.getrChia().addActionListener(this);
		vei.getrChia().setActionCommand("actualizar_costo_estudiante");

		// ==VENTANA INICIAR SESION==
		vin.getVolver().addActionListener(this);
		vin.getVolver().setActionCommand("boton_volver_iniciar_sesion");

		vin.getIniciar().addActionListener(this);
		vin.getIniciar().setActionCommand("boton_entrar_cuenta");

		vr.gettRol().addActionListener(this);
		vr.gettRol().setActionCommand("cambio_rol");

		// ==VENTANA PARA ESTUDIANTE==
		vei.getSalir().addActionListener(this);
		vei.getSalir().setActionCommand("cerrar_sesion_estudiante");

		vei.getInicio().addActionListener(this);
		vei.getInicio().setActionCommand("ver_principal_estudiante");

		vei.getbTren().addActionListener(this);
		vei.getbTren().setActionCommand("ver_rutas_tren_e");
		vei.getTren().addActionListener(this);
		vei.getTren().setActionCommand("ver_rutas_tren_e");

		vei.getbBus().addActionListener(this);
		vei.getbBus().setActionCommand("ver_rutas_bus_e");
		vei.getBus().addActionListener(this);
		vei.getBus().setActionCommand("ver_rutas_bus_e");
		

		vdi.getVerEstudiante().addActionListener(this);
		vdi.getVerEstudiante().setActionCommand("ver_estudiantes_misma_reserva");

		vai.getVerPersona().addActionListener(this);
		vai.getVerPersona().setActionCommand("ver_personas_misma_reserva");

		vei.getFlechaDerechaUno().addActionListener(this);
		vei.getFlechaDerechaUno().setActionCommand("usar_flecha_derecha_tren_e");
		vei.getFlechaIzquierdaDos().addActionListener(this);
		vei.getFlechaIzquierdaDos().setActionCommand("usar_flecha_izquierda_tren_e");

		vei.getFlechaDerUnoBus().addActionListener(this);
		vei.getFlechaDerUnoBus().setActionCommand("usar_flecha_derecha_bus_e");
		vei.getFlechaIzqDosBus().addActionListener(this);
		vei.getFlechaIzqDosBus().setActionCommand("usar_flecha_izquierda_bus_e");

		vei.getPerfil().addActionListener(this);
		vei.getPerfil().setActionCommand("ver_perfil_estudiante");

		vei.getReserva().addActionListener(this);
		vei.getReserva().setActionCommand("ver_reserva_estudiante");

		//== VENTANA PARA DOCENTE == 
		vdi.getSalir().addActionListener(this);
		vdi.getSalir().setActionCommand("cerrar_sesion_docente");
		
		vdi.getInicio().addActionListener(this);
		vdi.getInicio().setActionCommand("ver_principal_docente");
		
		vdi.getbTren().addActionListener(this);
		vdi.getbTren().setActionCommand("ver_rutas_tren_d");
		
		vdi.getTren().addActionListener(this);
		vdi.getTren().setActionCommand("ver_rutas_tren_d");
		
		vdi.getbBus().addActionListener(this);
		vdi.getbBus().setActionCommand("ver_rutas_bus_d");
		
		vdi.getBus().addActionListener(this);
		vdi.getBus().setActionCommand("ver_rutas_bus_d");
		
		vdi.getFlechaDerechaUno().addActionListener(this);
		vdi.getFlechaDerechaUno().setActionCommand("usar_flecha_derecha_tren_d");
		
		vdi.getFlechaIzquierdaDos().addActionListener(this);
		vdi.getFlechaIzquierdaDos().setActionCommand("usar_flecha_izquierda_tren_d");
		
		vdi.getFlechaDerUnoBus().addActionListener(this);
		vdi.getFlechaDerUnoBus().setActionCommand("usar_flecha_derecha_bus_d");
		vdi.getFlechaIzqDosBus().addActionListener(this);
		vdi.getFlechaIzqDosBus().setActionCommand("usar_flecha_izquierda_bus_d");
		
		vdi.getPagar().addActionListener(this);
		vdi.getPagar().setActionCommand("pagar_reserva_docente");
		
		vdi.getPerfil().addActionListener(this);
		vdi.getPerfil().setActionCommand("ver_perfil_docente");
		
		vdi.getReserva().addActionListener(this);
		vdi.getReserva().setActionCommand("ver_reserva_docente");
		
		vei.getbMananaUno().addActionListener(this);
		vei.getbMananaUno().setActionCommand("seleccionar_horario");

		vei.getbMananaDos().addActionListener(this);
		vei.getbMananaDos().setActionCommand("seleccionar_horario");

		vei.getbMananaTres().addActionListener(this);
		vei.getbMananaTres().setActionCommand("seleccionar_horario");

		vei.getbMananaCuatro().addActionListener(this);
		vei.getbMananaCuatro().setActionCommand("seleccionar_horario");

		vei.getbMananaCinco().addActionListener(this);
		vei.getbMananaCinco().setActionCommand("seleccionar_horario");

		vei.getbMananaSeis().addActionListener(this);
		vei.getbMananaSeis().setActionCommand("seleccionar_horario");

		vei.getbMananaSiete().addActionListener(this);
		vei.getbMananaSiete().setActionCommand("seleccionar_horario");

		vei.getbMananaOcho().addActionListener(this);
		vei.getbMananaOcho().setActionCommand("seleccionar_horario");

		vei.getbTardeUno().addActionListener(this);
		vei.getbTardeUno().setActionCommand("seleccionar_horario");

		vei.getbTardeDos().addActionListener(this);
		vei.getbTardeDos().setActionCommand("seleccionar_horario");

		vei.getbTardeTres().addActionListener(this);
		vei.getbTardeTres().setActionCommand("seleccionar_horario");

		vei.getbTardeCuatro().addActionListener(this);
		vei.getbTardeCuatro().setActionCommand("seleccionar_horario");

		vei.getbTardeCinco().addActionListener(this);
		vei.getbTardeCinco().setActionCommand("seleccionar_horario");

		vei.getbTardeSeis().addActionListener(this);
		vei.getbTardeSeis().setActionCommand("seleccionar_horario");

		vei.getbTardeSiete().addActionListener(this);
		vei.getbTardeSiete().setActionCommand("seleccionar_horario");

		vei.getbTardeOcho().addActionListener(this);
		vei.getbTardeOcho().setActionCommand("seleccionar_horario");

		vei.getbTardeNueve().addActionListener(this);
		vei.getbTardeNueve().setActionCommand("seleccionar_horario");

		vei.getbTardeDiez().addActionListener(this);
		vei.getbTardeDiez().setActionCommand("seleccionar_horario");

		vei.getbTardeOnce().addActionListener(this);
		vei.getbTardeOnce().setActionCommand("seleccionar_horario");

		vei.getbTardeDoce().addActionListener(this);
		vei.getbTardeDoce().setActionCommand("seleccionar_horario");

		vei.getbTardeTrece().addActionListener(this);
		vei.getbTardeTrece().setActionCommand("seleccionar_horario");

		vei.getbTardeCatorce().addActionListener(this);
		vei.getbTardeCatorce().setActionCommand("seleccionar_horario");

		vei.getbTardeQuince().addActionListener(this);
		vei.getbTardeQuince().setActionCommand("seleccionar_horario");

		vei.gettMananaUno().addActionListener(this);
		vei.gettMananaUno().setActionCommand("seleccionar_horario");

		vei.gettMananaDos().addActionListener(this);
		vei.gettMananaDos().setActionCommand("seleccionar_horario");

		vei.gettMananaTres().addActionListener(this);
		vei.gettMananaTres().setActionCommand("seleccionar_horario");

		vei.gettMananaCuatro().addActionListener(this);
		vei.gettMananaCuatro().setActionCommand("seleccionar_horario");

		vei.gettTardeUno().addActionListener(this);
		vei.gettTardeUno().setActionCommand("seleccionar_horario");

		vei.gettTardeDos().addActionListener(this);
		vei.gettTardeDos().setActionCommand("seleccionar_horario");

		vei.gettTardeTres().addActionListener(this);
		vei.gettTardeTres().setActionCommand("seleccionar_horario");

		vei.gettTardeCuatro().addActionListener(this);
		vei.gettTardeCuatro().setActionCommand("seleccionar_horario");
		
		//== VENTANA PARA ADMINISTRATIVO==
		vai.getSalir().addActionListener(this);
		vai.getSalir().setActionCommand("cerrar_sesion_admin");
		
		vai.getInicio().addActionListener(this);
		vai.getInicio().setActionCommand("ver_principal_admin");
		
		vai.getbTren().addActionListener(this);
		vai.getbTren().setActionCommand("ver_rutas_tren_a");
		
		vai.getTren().addActionListener(this);
		vai.getTren().setActionCommand("ver_rutas_tren_a");
		
		vai.getbBus().addActionListener(this);
		vai.getbBus().setActionCommand("ver_rutas_bus_a");
		
		vai.getBus().addActionListener(this);
		vai.getBus().setActionCommand("ver_rutas_bus_a");
		
		vei.getPagar().addActionListener(this);
		vei.getPagar().setActionCommand("pagar_reserva_estudiante");
		
		vai.getFlechaDerechaUno().addActionListener(this);
		vai.getFlechaDerechaUno().setActionCommand("usar_flecha_derecha_tren_a");
		
		vai.getFlechaIzquierdaDos().addActionListener(this);
		vai.getFlechaIzquierdaDos().setActionCommand("usar_flecha_izquierda_tren_a");
		
		vai.getFlechaDerUnoBus().addActionListener(this);
		vai.getFlechaDerUnoBus().setActionCommand("usar_flecha_derecha_bus_a");
		vai.getFlechaIzqDosBus().addActionListener(this);
		vai.getFlechaIzqDosBus().setActionCommand("usar_flecha_izquierda_bus_a");
		
		vai.getPerfil().addActionListener(this);
		vai.getPerfil().setActionCommand("ver_perfil_admin");
		
		vai.getReserva().addActionListener(this);
		vai.getReserva().setActionCommand("ver_reserva_admin");
		
		vai.getDinero().addActionListener(this);
		vai.getDinero().setActionCommand("ver_dinero_viajes");
		
		vai.getPagar().addActionListener(this);
		vai.getPagar().setActionCommand("pagar_reserva_admin");
		
		
	
	}


	public void actualizarCamposPorRol() {
		String rol = (String) vr.gettRol().getSelectedItem();

		vr.getCarrera().setVisible(false);
		vr.getSemestre().setVisible(false);
		vr.getNumMateria().setVisible(false);
		vr.getAnnoServicio().setVisible(false);

		vr.gettIngenieria().setVisible(false);
		vr.gettMedicina().setVisible(false);
		vr.gettArte().setVisible(false);
		vr.gettMatematica().setVisible(false);

		vr.gettSemestre().setVisible(false);
		vr.gettNumMateria().setVisible(false);
		vr.gettAnnoServicio().setVisible(false);

		if (rol == null || rol.equals("...")) {
			return;
		}

		if (rol.equalsIgnoreCase("Estudiante")) {
			vr.getCarrera().setVisible(true);
			vr.getSemestre().setVisible(true);
			vr.gettSemestre().setVisible(true);

			actualizarPorFacultad();
		}
		else if (rol.equalsIgnoreCase("Docente")) {
			vr.getNumMateria().setVisible(true);
			vr.gettNumMateria().setVisible(true);
		}
		else if (rol.equalsIgnoreCase("Administrativo")) {
			vr.getAnnoServicio().setVisible(true);
			vr.gettAnnoServicio().setVisible(true);
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
			break;
		}
		case "ver_estudiantes_misma_reserva": {
			verEstudiantesMismaReservaDocente();
			break;
		}
		case "ver_personas_misma_reserva": {
			verPersonasMismaReservaAdmin();
			break;
		}
		case "pagar_reserva_estudiante" : {
			String tipoTransporte = null;
			if(vei.getrBus().isSelected()) {
				tipoTransporte = "Bus";
			}
			if(vei.getrTren().isSelected()) {
				tipoTransporte = "Tren";
			}
			if(tipoTransporte == null) {
				JOptionPane.showMessageDialog(vei, "Debe seleccionar un tipo de transporte");
				break;
			}
			
			String ruta = null;
			if(vei.getrUsaquen().isSelected()) {
				ruta = "Usaquen - Chia";
			}
			if(vei.getrChia().isSelected()) {
				ruta = "Chia - Usaquen";
			}
			if(ruta == null) {
				JOptionPane.showMessageDialog(vei, "Debe seleccionar la ruta");
				break;
			}
			
			String fecha = obtenerFecha();
			if(fecha == null || fecha.trim().equals("")) {
				JOptionPane.showMessageDialog(vei, "Debe seleccionar la fecha de la reserva");
				break;
			}
			
			if(!rDAO.hayCupo(tipoTransporte, ruta, fecha)) {
				JOptionPane.showMessageDialog(vei, "No hay cupos disponibles");
				break;
			}
			
			double costoBase = calcularCostoBase(estudianteActual.getFacultad(), estudianteActual.getSemestre());
			double descuento = calcularDescuento(estudianteActual.getRol());
			double total = costoBase - descuento;
			
			if(total < 0) {
				total = 0;
			}
			
			if(estudianteActual.getFacultad().equalsIgnoreCase("Artes")) {
				vei.getPlata().setText("Aplausos");
			} else {
				vei.getPlata().setText("" + total);
			}
			int idReserva = rDAO.generarId();
			Reserva nueva = new Reserva(idReserva, estudianteActual.getId(), estudianteActual.getRol(), tipoTransporte, ruta, fecha, costoBase, descuento, total);
			rDAO.crear(nueva);
			JOptionPane.showMessageDialog(vei, "Reserva creada con exito\nNumero de reserva: " + idReserva);
			mostrarReservaEstudiante();
			actualizarCostoReservaEstudiante();
			horarioSeleccionado = null;
			break;
		}
		case "cancelar_reserva_estudiante": {
			cancelarReservaEstudiante();
			break;
		}
		case "cancelar_reserva_docente": {
			cancelarReservaDocente();
			break;
		}
		case "cancelar_reserva_admin": {
			cancelarReservaAdmin();
			break;
		}
		case "pagar_reserva_admin": {
			String tipoTransporte = null;
			if (vai.getrTren().isSelected()) {
				tipoTransporte = "Tren";
			}
			if (vai.getrBus().isSelected()) {
				JOptionPane.showMessageDialog(vai, "Como administrativo solo puede reservar Tren");
				break;
			}
			if (tipoTransporte == null) {
				JOptionPane.showMessageDialog(vai, "Debe seleccionar el tren para poder reservar");
				break;
			}

			String ruta = null;
			if (vai.getrUsaquen().isSelected()) {
				ruta = "Usaquen - Chia";
			}
			if (vai.getrChia().isSelected()) {
				ruta = "Chia - Usaquen";
			}
			if (ruta == null) {
				JOptionPane.showMessageDialog(vai, "Debe seleccionar la ruta");
				break;
			}
			String dia = (String) vai.getDia().getSelectedItem();
			String diaSemana = (String) vai.getDiaSemana().getSelectedItem();
			if (diaSemana == null || dia == null || diaSemana.equals("...") || dia.equals("...")) {
				JOptionPane.showMessageDialog(vai, "Debe seleccionar la fecha de la reserva");
				break;
			}
			String fecha = diaSemana + " " + dia;
			if (horarioSeleccionado != null && !horarioSeleccionado.trim().equals("")) {
				fecha = fecha + " - " + horarioSeleccionado;
			}
			if (!rDAO.hayCupo(tipoTransporte, ruta, fecha)) {
				JOptionPane.showMessageDialog(vai, "No hay cupos disponibles para esa fecha y ruta");
				break;
			}
			double costoBase = calcularCostoBase(adminActual.getFacultad(), 0);
			double descuento = 0; 
			double extra = adminActual.getAnnoServicio() * 500; 
			double total = costoBase + extra;
			vai.getPlata().setText("" + total);

			int idReserva = rDAO.generarId();
			Reserva nueva = new Reserva(idReserva, adminActual.getId(), adminActual.getRol(), tipoTransporte, ruta,
					fecha, costoBase, descuento, total);
			rDAO.crear(nueva);
			JOptionPane.showMessageDialog(vai, "Reserva creada con éxito\n" + "Número de reserva: " + idReserva + "\n"
					+ "Total a pagar: " + total);
			horarioSeleccionado = null;
			break;
		}
		case "pagar_reserva_docente": {
			String tipoTransporte = null;
			if (vdi.getrBus().isSelected()) {
				tipoTransporte = "Bus";
			}
			if (vdi.getrTren().isSelected()) {
				tipoTransporte = "Tren";
			}
			if (tipoTransporte == null) {
				JOptionPane.showMessageDialog(vdi, "Debe seleccionar un tipo de transporte");
				break;
			}

			String ruta = null;
			if (vdi.getrUsaquen().isSelected()) {
				ruta = "Usaquen - Chia";
			}
			if (vdi.getrChia().isSelected()) {
				ruta = "Chia - Usaquen";
			}
			if (ruta == null) {
				JOptionPane.showMessageDialog(vdi, "Debe seleccionar la ruta");
				break;
			}

			String fecha = obtenerFechaDocente();
			if (fecha == null || fecha.trim().equals("")) {
				JOptionPane.showMessageDialog(vdi, "Debe seleccionar la fecha de la reserva");
				break;
			}
			if (!rDAO.hayCupo(tipoTransporte, ruta, fecha)) {
				JOptionPane.showMessageDialog(vdi, "No hay cupos disponibles");
				break;
			}
			double costoBase = calcularCostoBase(docenteActual.getFacultad(), 0);
			double descuento = calcularDescuento(docenteActual.getRol());
			double total = costoBase - descuento;
			if (total < 0) {
				total = 0;
			}
			vdi.getPlata().setText("" + total);
			int idReserva = rDAO.generarId();
			Reserva nueva = new Reserva(idReserva, docenteActual.getId(), docenteActual.getRol(), tipoTransporte, ruta,
					fecha, costoBase, descuento, total);
			rDAO.crear(nueva);
			JOptionPane.showMessageDialog(vdi,
					"Reserva creada con exito\nNumero de reserva: " + idReserva + "\nTotal a pagar: " + total);
			break;
		}
		case "cambio_rol": {
			actualizarCamposPorRol();
			break;

		}
		case "seleccionar_bus_estudiante": {
			actualizarCostoReservaEstudiante();

			vei.getTrenHorario().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);

			vei.getBusHorario().setVisible(true);
			vei.getHorarioIdaBus().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			break;
		}
		case "actualizar_costo_estudiante": {
			actualizarCostoReservaEstudiante();
			break;
		}
		case "seleccionar_tren_estudiante": {
			actualizarCostoReservaEstudiante();

			vei.getBusHorario().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);

			vei.getTrenHorario().setVisible(true);
			vei.getHorarioIda().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);

			break;
		}

		case "seleccionar_horario": {

			if (e.getSource() == vei.getbMananaUno()) {
				horarioSeleccionado = "7AM";
			} else if (e.getSource() == vei.getbMananaDos()) {
				horarioSeleccionado = "9AM";
			} else if (e.getSource() == vei.getbMananaTres()) {
				horarioSeleccionado = "9AM"; 
			} else if (e.getSource() == vei.getbMananaCuatro()) {
				horarioSeleccionado = "9AM";
			} else if (e.getSource() == vei.getbMananaCinco()) {
				horarioSeleccionado = "11AM";
			} else if (e.getSource() == vei.getbMananaSeis()) {
				horarioSeleccionado = "11AM";
			} else if (e.getSource() == vei.getbMananaSiete()) {
				horarioSeleccionado = "12M";
			} else if (e.getSource() == vei.getbMananaOcho()) {
				horarioSeleccionado = "1PM";
			} else if (e.getSource() == vei.getbTardeUno()) {
				horarioSeleccionado = "10AM";
			} else if (e.getSource() == vei.getbTardeDos()) {
				horarioSeleccionado = "10AM";
			} else if (e.getSource() == vei.getbTardeTres()) {
				horarioSeleccionado = "10AM";
			} else if (e.getSource() == vei.getbTardeCuatro()) {
				horarioSeleccionado = "10AM";
			} else if (e.getSource() == vei.getbTardeCinco()) {
				horarioSeleccionado = "11AM";
			} else if (e.getSource() == vei.getbTardeSeis()) {
				horarioSeleccionado = "11AM";
			} else if (e.getSource() == vei.getbTardeSiete()) {
				horarioSeleccionado = "12M";
			} else if (e.getSource() == vei.getbTardeOcho()) {
				horarioSeleccionado = "1PM";
			} else if (e.getSource() == vei.getbTardeNueve()) {
				horarioSeleccionado = "1PM";
			} else if (e.getSource() == vei.getbTardeDiez()) {
				horarioSeleccionado = "3PM";
			} else if (e.getSource() == vei.getbTardeOnce()) {
				horarioSeleccionado = "3PM";
			} else if (e.getSource() == vei.getbTardeDoce()) {
				horarioSeleccionado = "4PM";
			} else if (e.getSource() == vei.getbTardeTrece()) {
				horarioSeleccionado = "5PM";
			} else if (e.getSource() == vei.getbTardeCatorce()) {
				horarioSeleccionado = "5PM";
			} else if (e.getSource() == vei.getbTardeQuince()) {
				horarioSeleccionado = "5PM";
			} else if (e.getSource() == vei.gettMananaUno()) {
				horarioSeleccionado = "Martes mañana";
			} else if (e.getSource() == vei.gettMananaDos()) {
				horarioSeleccionado = "Miércoles mañana";
			} else if (e.getSource() == vei.gettMananaTres()) {
				horarioSeleccionado = "Jueves mañana";
			} else if (e.getSource() == vei.gettMananaCuatro()) {
				horarioSeleccionado = "Viernes mañana";
			} else if (e.getSource() == vei.gettTardeUno()) {
				horarioSeleccionado = "Martes tarde";
			} else if (e.getSource() == vei.gettTardeDos()) {
				horarioSeleccionado = "Miércoles tarde";
			} else if (e.getSource() == vei.gettTardeTres()) {
				horarioSeleccionado = "Jueves tarde";
			} else if (e.getSource() == vei.gettTardeCuatro()) {
				horarioSeleccionado = "Viernes tarde";
				actualizarCostoReservaEstudiante();
			}
			break;
		}
		case "boton_volver_registrar": {
			limpiarCampos();
			vr.setVisible(false);
			vi.setVisible(true);
			break;

		}
		case "cambio_facultad": {

			String rol = (String) vr.gettRol().getSelectedItem();
			if ("Estudiante".equalsIgnoreCase(rol)) {
				actualizarPorFacultad();
				vr.getCarrera().setVisible(true);
				vr.getSemestre().setVisible(true);
				vr.gettSemestre().setVisible(true);
			}
			break;

		}
		case "boton_guardar_cuenta": {
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
				verificarCorreo(correoInst);
				verificarUsuario(nUsuario);
				verificarId(id);
				verificarTelefono(telefono);
				verificarContrasenaRegistrada(contrasena);
				verificarComboBox(facultad);
				verificarComboBox(rol);

				if (rol.equalsIgnoreCase("Estudiante")) {
					String facultadSeleccionada = (String) vr.gettFacultad().getSelectedItem();
					String carrera = null;

					if ("Ingeniería".equals(facultadSeleccionada)) {
						carrera = (String) vr.gettIngenieria().getSelectedItem();
					} else if ("Medicina".equals(facultadSeleccionada)) {
						carrera = (String) vr.gettMedicina().getSelectedItem();
					} else if ("Artes".equals(facultadSeleccionada)) {
						carrera = (String) vr.gettArte().getSelectedItem();
					} else if ("Matemáticas".equals(facultadSeleccionada)) {
						carrera = (String) vr.gettMatematica().getSelectedItem();
					}

					String semestreTxt = vr.gettSemestre().getText();

					verificarComboBox(carrera);
					verificarSemestre(semestreTxt);

					int semestre = Integer.parseInt(semestreTxt);
					eDAO.crear(new Estudiante(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultadSeleccionada, rol, carrera, semestre));

				} else if (rol.equalsIgnoreCase("Docente")) {

					String materiasTxt = vr.gettNumMateria().getText();
					verificarMateria(materiasTxt);
					int numeroMateria = Integer.parseInt(materiasTxt);
					dDAO.crear(new Docente(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena, facultad,
							rol, numeroMateria));

				} else if (rol.equalsIgnoreCase("Administrativo")) {

					String aniosTxt = vr.gettAnnoServicio().getText();
					verificarExperiencia(aniosTxt);
					int annoServicio = Integer.parseInt(aniosTxt);
					aDAO.crear(new Administrativo(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena,
							facultad, rol, annoServicio));
				}
				exportarUsuario();
				JOptionPane.showMessageDialog(vr, "Cuenta creada exitosamente", "Registro completado",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();
				vr.setVisible(false);
				vin.setVisible(true);

			} catch (RegisterPasswordException e1) {
				JOptionPane.showMessageDialog(vr, "Contraseña no válida.", "ERROR", JOptionPane.ERROR_MESSAGE);
				e1.getStackTrace();
			} catch (NameException e1) {
				JOptionPane.showMessageDialog(vr, "Nombre no válido (Mal escrito).", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				e1.getStackTrace();
			} catch (LastNameException e1) {
				JOptionPane.showMessageDialog(vr, "Apellido no válido (Mal escrito).", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (EmailException e1) {
				JOptionPane.showMessageDialog(vr, "Correo institucional no válido.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NickNameException e1) {
				JOptionPane.showMessageDialog(vr, "Usuario institucional no válido", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (ComboBoxException e1) {
				JOptionPane.showMessageDialog(vr, "Seleccion de combobox invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (SemesterExcepcion e1) {
				JOptionPane.showMessageDialog(vr, "Seleccion de semestre invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (IdException e1) {
				JOptionPane.showMessageDialog(vr, "Id invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (CelException e1) {
				JOptionPane.showMessageDialog(vr, "Telefono invalido", "ERROR", JOptionPane.ERROR_MESSAGE);				
				e1.printStackTrace();
			} catch (SubjectsException e1) {				
				JOptionPane.showMessageDialog(vr, "Numero de materias invalido", "ERROR", JOptionPane.ERROR_MESSAGE);				
				e1.printStackTrace();
			} catch (ExperienceException e1) {
				JOptionPane.showMessageDialog(vr, "Numero de años de servicio invalido", "ERROR", JOptionPane.ERROR_MESSAGE);				
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vr, "No se puede colocar un valor que no es el solicitado", "ERROR", JOptionPane.ERROR_MESSAGE);				
				e1.printStackTrace();
				
			}
			break;
		}

		case "boton_iniciar_sesion": {
			vi.setVisible(false);
			vin.setVisible(true);
			break;
		}

		case "boton_volver_iniciar_sesion": {
			vin.setVisible(false);
			vi.setVisible(true);
			break;
		}
		case "boton_entrar_cuenta": {
			try {
				String usuario = vin.gettUsuario().getText();
				String contrasena = new String(vin.gettContrasena().getPassword());

				Estudiante estudiante = eDAO.buscarPorCredencial(usuario, contrasena);

				if (estudiante != null) {
					if (!estudiante.getRol().equalsIgnoreCase("Estudiante")) {
						throw new CredentialException("El usuario no pertenece a estudiante");
					}

					estudianteActual = estudiante;

					vin.setVisible(false);
					vei.setVisible(true);
					mostrarNombreEstudiante();
					actualizarRecaudo();
					break;
				}

				Docente docente = dDAO.buscarPorCredencial(usuario, contrasena);

				if (docente != null) {
					if (!docente.getRol().equalsIgnoreCase("Docente")) {
						throw new CredentialException("El usuario no pertenece a docente");
					}

					docenteActual = docente;

					vin.setVisible(false);
					vdi.setVisible(true);
					mostrarNombreDocente();
					break;
				}

				Administrativo administrativo = aDAO.buscarPorCredencial(usuario, contrasena);

				if (administrativo != null) {
					if (!administrativo.getRol().equalsIgnoreCase("Administrativo")) {
						throw new CredentialException("El usuario no pertenece a administrativo");
					}

					adminActual = administrativo;

					vin.setVisible(false);
					vai.setVisible(true);
					mostrarNombreAdmin();
					break;
				}
				throw new CredentialException("Error, usuario o contraseña incorrectos");

			} catch (CredentialException ex) {
				JOptionPane.showMessageDialog(vin, ex.getMessage(), "Error en credenciales", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "cerrar_sesion_estudiante": {
			vei.setVisible(false);
			vin.setVisible(true);
			break;
		}
		case "cerrar_sesion_docente": {
			vdi.setVisible(false);
			vin.setVisible(true);
			break;
		}
		case "cerrar_sesion_admin": {
			vai.setVisible(false);
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
			vei.getPanelImagen().setVisible(true);
			
			break;
		}
		case "ver_perfil_docente": {
			
			actualizarPerfilDocente();
			
			vdi.getPanelPrincipal().setVisible(false);
			vdi.getTrenHorario().setVisible(false);
			vdi.getBusHorario().setVisible(false);
			vdi.getHorarioIda().setVisible(false);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(false);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getPanelMiPerfil().setVisible(true);
			vdi.getPanelReserva().setVisible(false);
			vdi.getPanelImagen().setVisible(true);
			break;
		}
		case "ver_perfil_admin": {
			
			actualizarPerfilAdministrativo();
			
			vai.getPanelPrincipal().setVisible(false);
			vai.getTrenHorario().setVisible(false);
			vai.getBusHorario().setVisible(false);
			vai.getHorarioIda().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(true);
			vai.getPanelReserva().setVisible(false);
			vai.getPanelAplauso().setVisible(false);
			vai.getPanelPlata().setVisible(false);
			vai.getPanelImagen().setVisible(true);
			break;
		}
		case "ver_rutas_tren_e": {
				mostrarSoloTrenEstudiante();
			break;
		}
		case "ver_rutas_tren_d": {
			mostrarSoloTrenDocente();
			break;
		}
		case "ver_rutas_tren_a": {
			mostrarSoloTrenAdmin();
			break;
		}
	
		case "ver_rutas_bus_e": {
			mostrarSoloBusEstudiante();
			break;
		}
		case "ver_rutas_bus_d": {
			mostrarSoloBusDocente();
			break;
		}
		case "ver_rutas_bus_a": {
			mostrarSoloTrenAdmin();
			break;
		}
		case "ver_principal_estudiante": {
			vei.getPanelPrincipal().setVisible(true);
			vei.getHorarioIda().setVisible(false);
			vei.getTrenHorario().setVisible(false);
			vei.getBusHorario().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(false);
			vei.getPanelImagen().setVisible(false);
			break;
		}
		case "ver_principal_docente": {
			vdi.getPanelPrincipal().setVisible(true);
			vdi.getHorarioIda().setVisible(false);
			vdi.getTrenHorario().setVisible(false);
			vdi.getBusHorario().setVisible(false);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(false);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getPanelMiPerfil().setVisible(false);
			vdi.getPanelReserva().setVisible(false);
			vdi.getPanelImagen().setVisible(false);
			actualizarRecaudo();
			break;
		}
		case "ver_principal_admin": {
			vai.getPanelPrincipal().setVisible(true);
			vai.getHorarioIda().setVisible(false);
			vdi.getTrenHorario().setVisible(false);
			vdi.getBusHorario().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(false);
			vai.getPanelReserva().setVisible(false);
			vai.getPanelAplauso().setVisible(false);
			vai.getPanelPlata().setVisible(false);
			vai.getPanelImagen().setVisible(false);
			break;
		}
		case "ver_reserva_estudiante": {
			vei.getPanelPrincipal().setVisible(false);
			vei.getHorarioIda().setVisible(false);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getPanelMiPerfil().setVisible(false);
			vei.getPanelReserva().setVisible(true);
			vei.getPanelImagen().setVisible(false);
			mostrarReservaEstudiante();
			break;
		}
		case "ver_reserva_docente": {
			vdi.getPanelPrincipal().setVisible(false);
			vdi.getHorarioIda().setVisible(false);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(false);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getPanelMiPerfil().setVisible(false);
			vdi.getPanelReserva().setVisible(true);
			vdi.getPanelImagen().setVisible(false);
			mostrarReservaDocente();
			break;
		}
		case "ver_reserva_admin": {
			vai.getPanelPrincipal().setVisible(false);
			vai.getHorarioIda().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(false);
			vai.getPanelReserva().setVisible(true);
			vai.getPanelAplauso().setVisible(false);
			vai.getPanelPlata().setVisible(false);
			vai.getPanelImagen().setVisible(false);
			mostrarReservaAdmin();
			break;
		}
		case "ver_dinero_viajes": {
			vai.getPanelPrincipal().setVisible(false);
			vai.getHorarioIda().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(false);
			vai.getPanelReserva().setVisible(false);
			vai.getPanelAplauso().setVisible(true);
			vai.getPanelPlata().setVisible(true);
			vai.getPanelImagen().setVisible(false);
			actualizarRecaudo();
			break;
		}
		case "usar_flecha_derecha_tren_e": {
			vei.getHorarioIda().setVisible(false);
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioRegreso().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_tren_e": {
			vei.getTrenHorario().setVisible(true);
			vei.getHorarioRegreso().setVisible(false);
			vei.getHorarioIda().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_bus_e": {
			vei.getBusHorario().setVisible(true);
			vei.getHorarioIdaBus().setVisible(false);
			vei.getHorarioRegresoBus().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_bus_e": {
			vei.getBusHorario().setVisible(true);
			vei.getHorarioRegresoBus().setVisible(false);
			vei.getHorarioIdaBus().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_tren_d": {
			vdi.getHorarioIda().setVisible(false);
			vdi.getTrenHorario().setVisible(true);
			vdi.getHorarioRegreso().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_tren_d": {
			vdi.getTrenHorario().setVisible(true);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIda().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_bus_d": {
			vdi.getBusHorario().setVisible(true);
			vdi.getHorarioIdaBus().setVisible(false);
			vdi.getHorarioRegresoBus().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_bus_d": {
			vdi.getBusHorario().setVisible(true);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_tren_a": {
			vai.getHorarioIda().setVisible(false);
			vai.getTrenHorario().setVisible(true);
			vai.getHorarioRegreso().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_tren_a": {
			vai.getTrenHorario().setVisible(true);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIda().setVisible(true);
			break;
		}
		case "usar_flecha_derecha_bus_a": {
			vai.getBusHorario().setVisible(true);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(true);
			break;
		}
		case "usar_flecha_izquierda_bus_a": {
			vai.getBusHorario().setVisible(true);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getHorarioIdaBus().setVisible(true);
			break;
		}

		default: {
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

		vr.gettIngenieria().setSelectedIndex(0);
		vr.gettMedicina().setSelectedIndex(0);
		vr.gettArte().setSelectedIndex(0);
		vr.gettMatematica().setSelectedIndex(0);

		vr.gettSemestre().setText("");
		vr.gettNumMateria().setText("");
		vr.gettAnnoServicio().setText("");

	}
	
	public void mostrarNombreEstudiante() {
		vei.getTitulo().setText("¡Bienvenido, " + estudianteActual.getNombre() + "!");
	}
	public void mostrarNombreDocente() {
		vdi.getTitulo().setText("¡Bienvenido, " + docenteActual.getNombre() + "!");
	}
	public void mostrarNombreAdmin() {
		vai.getTitulo().setText("¡Bienvenido, " + adminActual.getNombre() + "!");
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
	
	public void actualizarPerfilDocente() {
		vdi.gettNombre().setText(docenteActual.getNombre());
		vdi.gettApellido().setText(docenteActual.getApellido());
		vdi.gettCorreo().setText(docenteActual.getCorreoInst());
		vdi.gettUsuario().setText(docenteActual.getnUsuario());
		vdi.gettDocumento().setText(String.valueOf(docenteActual.getId()));
		vdi.gettTelefono().setText(String.valueOf(docenteActual.getTelefono()));
		vdi.gettFacultad().setText(docenteActual.getFacultad());
		vdi.gettNumMateria().setText(String.valueOf(docenteActual.getNumeroMateria()));
	}
	
	public void actualizarPerfilAdministrativo() {
		vai.gettNombre().setText(adminActual.getNombre());
		vai.gettApellido().setText(adminActual.getApellido());
		vai.gettCorreo().setText(adminActual.getCorreoInst());
		vai.gettUsuario().setText(adminActual.getnUsuario());
		vai.gettDocumento().setText(String.valueOf(adminActual.getId()));
		vai.gettTelefono().setText(String.valueOf(adminActual.getTelefono()));
		vai.gettFacultad().setText(adminActual.getFacultad());
		vai.gettAnnoServicio().setText(String.valueOf(adminActual.getAnnoServicio()));
	}
	

	public void actualizarPorFacultad() {
		
		vr.gettIngenieria().setVisible(false);
		vr.gettMedicina().setVisible(false);
		vr.gettArte().setVisible(false);
		vr.gettMatematica().setVisible(false);

		String facultad = (String) vr.gettFacultad().getSelectedItem();

		if ("Ingeniería".equals(facultad)) {
			vr.gettIngenieria().setVisible(true);
		} else if ("Medicina".equals(facultad)) {
			vr.gettMedicina().setVisible(true);
		} else if ("Artes".equals(facultad)) {
			vr.gettArte().setVisible(true);
		} else if ("Matemáticas".equals(facultad)) {
			vr.gettMatematica().setVisible(true);
		}
	}
	
	
	// ====EXCEPCIONES=====
	/*
	 * public static void ValidarCampoVacio (String valor, String nombreCampo)
	 * throws EmptyDataException { if(valor == null || valor.equals("")) { throw new
	 * EmptyDataException("El campo " + nombreCampo + " no puede estra vacio."); } }
	 * 
	 * public static void validarDatoPositivo(String valor, String nombreCampo)
	 * throws OutRangeException, NumericalDataException { if(valor == null ||
	 * valor.equals("")) { throw new NumericalDataException("El campo " +
	 * nombreCampo + " debe ser un numero entero positivo"); }
	 * 
	 * try { int numero = Integer.parseInt(valor); if(numero <= 0) { throw new
	 * OutRangeException("El campo " + nombreCampo + " debe ser mayor que cero"); }
	 * } catch (NumberFormatException e) { throw new
	 * NumericalDataException("El campo " + nombreCampo +
	 * " debe ser un numero entero"); } }
	 * 
	 * public static void validarLargoPositivo(String valor, String nombreCampo)
	 * throws NumericalDataException, OutRangeException { if(valor == null ||
	 * valor.equals("")) { throw new NumericalDataException("El campo " +
	 * nombreCampo + " debe ser un numero valido"); } try { long numero =
	 * Long.parseLong(valor); if(numero <= 0) { throw new
	 * OutRangeException("El campo " + nombreCampo + " debe ser mayor a cero"); } }
	 * catch (NumberFormatException e) { throw new
	 * NumericalDataException("El campo " + nombreCampo); } }
	 * 
	 * public static void validarCorreo(String correo) throws EmptyDataException,
	 * OutRangeException { if(correo == null || correo.equals("")) { throw new
	 * EmptyDataException("El campo de correo institucional no puede estar vacio");
	 * } if(!correo.contains("@")) { throw new
	 * OutRangeException("El correo institucional debe contener @"); }
	 * if(!correo.contains("unbosque.edu.co")) { throw new
	 * OutRangeException("El correo debe contener al final (unbosque.edu.co)"); } }
	 * 
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

	public static void verificarCorreo(String correo) throws EmailException {
		if (correo == null || correo.isEmpty()) {
			throw new EmailException();
		}

		if (correo.contains(" ")) {
			throw new EmailException();
		}
		if (correo.isEmpty() || !correo.matches("[A-Za-z]{5,}[A-Za-z0-9._-]*@unbosque.edu.co$")) {
			throw new EmailException();
		}

		if (correo.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new EmailException();
		}
	}

	public static void verificarUsuario(String usuario) throws NickNameException {
		if (usuario == null || usuario.isEmpty()) {
			throw new NickNameException();
		}
		if (!usuario.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || usuario.length() < 5) {
			throw new NickNameException();
		}
	}

	public static void verificarComboBox(String combo) throws ComboBoxException {
		if (combo == null || combo.equals("...")) {
			throw new ComboBoxException();
		}
	}

	public static void verificarContrasenaRegistrada(String contrasena) throws RegisterPasswordException {
		if (contrasena == null || contrasena.isEmpty() || contrasena.length() < 10) {
			throw new RegisterPasswordException();
		}
	}
	

	public static void verificarSemestre(String semestreTxt) throws SemesterExcepcion {
		if (semestreTxt == null || semestreTxt.isEmpty()) {
			throw new SemesterExcepcion();
		}

		if (!semestreTxt.matches("^[0-9]{1,2}$")) {
			throw new SemesterExcepcion();
		}

		int semestre = Integer.parseInt(semestreTxt);
		if (semestre <= 0 || semestre > 12) {
			throw new SemesterExcepcion();
		}
	}
	
	public static void verificarId (long id) throws IdException {
		
		String idTxt = Long.toString(id);
		if(!idTxt.matches("^[0-9]{8,10}$")) {
			throw new IdException();
		}
	}
		
	public static void verificarTelefono(long telefono) throws CelException {
		
		String telefonoTxt = Long.toString(telefono);
		if(!telefonoTxt.matches("^3[0-9]{9}$")) {
			throw new CelException();
		}
		
	}
	
	public static void verificarMateria(String materiaTxt) throws SubjectsException {

		if (materiaTxt == null || materiaTxt.isEmpty()) {
			throw new SubjectsException();
		}

		if (!materiaTxt.matches("^[1-6]$")) {
			throw new SubjectsException();
		}

		int numeroMateria = Integer.parseInt(materiaTxt);

		if (numeroMateria < 1 || numeroMateria > 6) {
			throw new SubjectsException();
		}

	}
	

	public static void verificarExperiencia(String anioTxt) throws ExperienceException {

		if (anioTxt == null || anioTxt.isEmpty()) {
			throw new ExperienceException();
		}
		if (!anioTxt.matches("^[0-9]{1,2}$")) {
			throw new ExperienceException();
		}
		int annoServicio = Integer.parseInt(anioTxt);
		if (annoServicio < 1 || annoServicio > 30) {
			throw new ExperienceException();
		}
	}
	
	public String obtenerFecha() {
		
		String dia = (String) vei.getDia().getSelectedItem();
		String mes = (String) vei.getDiaSemana().getSelectedItem();
		
		if(dia == null || mes == null) {
			return "";
		}
		if(dia.equals("...") || mes.equals("...")) {
			return "";
		}
		
		return dia + "/" + mes;
		
	}
	
	public double calcularCostoBase(String facultad, int semestre) {
		if(facultad == null) {
			return 0;
		}
		if(facultad.equalsIgnoreCase("Ingenieria")) {
			return 1000;
		}
		if(facultad.equalsIgnoreCase("Medicina")) {
			return 2000;
		}
		if(facultad.equalsIgnoreCase("Artes")) {
			return 0;
		}
		if(facultad.equalsIgnoreCase("Matematicas")) {
			return semestre * 3000;
		}
		return calcularBase(facultad, semestre);
	}
	
	public double calcularDescuento(String rol) {
		if(rol == null) {
			return 0;
		}
		if(rol.equalsIgnoreCase("Estudiante")) {
			return 100;
		}
		if(rol.equalsIgnoreCase("Docente")) {
			return 50;
		}
		return 0;
	}
	
	public void actulizarReservaEstudiante() {
		ArrayList<Reserva> reserva = rDAO.listaPorUsuario(estudianteActual.getId());
		
		if(reserva == null || reserva.size() == 0) {
			JOptionPane.showMessageDialog(vei, "No tiene reservas", "Mis reservas", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		String texto = "";
		int i = 0;
		while (i < reserva.size()) {
			Reserva r = reserva.get(i);
			texto = texto + "Reserva #: " + r.getIdReserva() + "\nTransporte: " + r.getTipoTransporte() + "\nRuta: " + r.getRuta() + "\nFecha: " + r.getFecha() + "\nTotal: " + r.getTotalPagar() + "/n-------------------";
			i++;
		}
		
		JOptionPane.showMessageDialog(vei,texto, "Mis reservas", JOptionPane.INFORMATION_MESSAGE);	
	}
	

	public void actualizarCostoReservaEstudiante() {

		boolean transporteSeleccionado = vei.getrBus().isSelected() || vei.getrTren().isSelected();
		boolean rutaSeleccionada = vei.getrUsaquen().isSelected() || vei.getrChia().isSelected();
		boolean horarioOk = (horarioSeleccionado != null && !horarioSeleccionado.trim().equals(""));

		if (!transporteSeleccionado || !rutaSeleccionada || !horarioOk) {
			vei.getPlata().setText("");
			return;
		}

		double costoBase = calcularCostoBase(estudianteActual.getFacultad(), estudianteActual.getSemestre());
		double descuento = calcularDescuento(estudianteActual.getRol());
		double total = costoBase - descuento;

		if (total < 0) {
			total = 0;
		}

		if (estudianteActual.getFacultad().equalsIgnoreCase("Artes")) {
			vei.getPlata().setText("Aplausos");
		} else {
			vei.getPlata().setText("" + total);
		}
	}
	

	public double calcularBase(String facultad, int semestre) {
		if (facultad == null)
			return 0;

		facultad = facultad.trim().toLowerCase();

		if (facultad.equals("ingeniería") || facultad.equals("ingenieria")) {
			return 1000;
		}
		if (facultad.equals("medicina")) {
			return 2000;
		}
		if (facultad.equals("artes")) {
			return 0;
		}
		if (facultad.equals("matemáticas") || facultad.equals("matematicas")) {
			return semestre * 3000;
		}

		return 0;
	}
	public String obtenerFechaDocente() {
		String dia = (String) vdi.getDia().getSelectedItem();
		String mes = (String) vdi.getDiaSemana().getSelectedItem();
		
		if(dia == null) {
			return "";
		}
		if(dia.equals("...") || mes.equals("...")) {
			return "";
		}
		return dia + "/" + mes;
		
	}
	
	public void mostrarReservaEstudiante( ) {
		ArrayList<Reserva> reserva = rDAO.listaPorUsuario(estudianteActual.getId());
		if(reserva == null || reserva.size() == 0) {
			vei.gettReserva().setText("no tienes reserva creadas");
			return;
		}
		String texto = "";
		for (Reserva r : reserva) {
			texto = texto + "Reserva #: " + r.getIdReserva() + "\nTransporte: " + r.getTipoTransporte() + "\nRuta: "
					+ r.getRuta() + "\nFecha: " + r.getFecha() + "\nTotal: " + r.getTotalPagar()
					+ "\n-------------------------\n";
		}
		vei.gettReserva().setText(texto);
	}

	public void mostrarReservaAdmin() {
		ArrayList<Reserva> reservas = rDAO.listaPorUsuario(adminActual.getId());
		if (reservas == null || reservas.size() == 0) {
			vai.gettReserva().setText("No tienes reservas creadas.");
			return;
		}
		String texto = "";
		for (Reserva r : reservas) {
			texto = texto + "Reserva #: " + r.getIdReserva() + "\nTransporte: " + r.getTipoTransporte() + "\nRuta: "
					+ r.getRuta() + "\nFecha: " + r.getFecha() + "\nTotal: " + r.getTotalPagar()
					+ "\n-------------------------\n";
		}
		vai.gettReserva().setText(texto);
	}
	public void mostrarReservaDocente() {
		ArrayList<Reserva> reservas = rDAO.listaPorUsuario(docenteActual.getId());

		if (reservas == null || reservas.size() == 0) {
			vdi.gettReserva().setText("No tienes reservas creadas.");
			return;
		}
		String texto = "";
		for (Reserva r : reservas) {
			texto = texto + "Reserva #: " + r.getIdReserva() + "\nTransporte: " + r.getTipoTransporte() + "\nRuta: "
					+ r.getRuta() + "\nFecha: " + r.getFecha() + "\nTotal: " + r.getTotalPagar()
					+ "\n-------------------------\n";
		}
		vdi.gettReserva().setText(texto);
	}

	public void actualizarRecaudo() {
		ArrayList<Reserva> reserva = rDAO.mostrarTodo();
		
		if(reserva == null) {
			reserva = new ArrayList<>();
		}
		double dineroTotal = 0;
		int aplausoTotal = 0;		
		for (Reserva r : reserva) {
			if (r.getTotalPagar() > 0) {
				dineroTotal = dineroTotal + r.getTotalPagar();
			}
			if (r.getRol() != null && r.getRol().equalsIgnoreCase("Estudiante")) {

				Estudiante est = eDAO.buscarPorId(r.getIdUsuario());

				if (est != null && est.getFacultad() != null && est.getFacultad().equalsIgnoreCase("Artes")) {

					aplausoTotal++;
				}
			}
		}

		vai.getDineroTotal().setText(String.valueOf(dineroTotal));
		vai.getAplausoTotal().setText(String.valueOf(aplausoTotal));

	}
	
	public String limpiarArchivo(String valor) {
		if(valor == null) {
			return"";
		}
		if(valor.contains(",") || valor.contains("/n")) {
			return "\"" + valor + "\"";
		}
		return valor;
	}
	
	public void escribirTxt(File archivo, String contenido) {
		try {
			PrintWriter escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportarEstudiante() {
		ArrayList<Estudiante> estudiantes = eDAO.mostrarTodo();
		if(estudiantes == null || estudiantes.isEmpty()) {
			return;
		}
			File archivo = new File("Estudiante.txt");
			String contenido = "";
			
			for (int i = 0; i < estudiantes.size(); i++) {
				Estudiante est = estudiantes.get(i);
				
				contenido = contenido + "Nombre: " + est.getNombre() + "\nApellido: " + est.getApellido() + "\nCorreo: "
						+ est.getCorreoInst() + "\nUsuario: " + est.getnUsuario() + "\nId: " + est.getId()
						+ "\nTelefono: " + est.getTelefono() + "\nFacultad: " + est.getFacultad() + "\nCarrera: "
						+ est.getCarrera() + "\nSemestre: " + est.getSemestre() + "\n-------------------------------\n";
			
			escribirTxt(archivo, contenido);
			
		}
	}
	
	public void exportarDocente() {
		ArrayList<Docente> docentes = dDAO.mostrarTodo();
		if(docentes == null || docentes.isEmpty()) {
			return;
		}
			File archivo = new File("Docente.txt");
			
			String contenido = "";
			for (int i = 0; i < docentes.size(); i++) {
				Docente doc = docentes.get(i);
				
				contenido = contenido + "Nombre: " + doc.getNombre() + "\nApellido: " + doc.getApellido() + "\nCorreo: "
						+ doc.getCorreoInst() + "\nUsuario: " + doc.getnUsuario() + "\nId: " + doc.getId()
						+ "\nTelefono: " + doc.getTelefono() + "\nFacultad: " + doc.getFacultad() + "\nNumero de materias: "
						+ doc.getNumeroMateria() + "\n-------------------------------\n";
			escribirTxt(archivo, contenido);
		}
	}
	
	public void exportarAdministrativo() {
		ArrayList<Administrativo> admins = aDAO.mostrarTodo();
		if(admins == null || admins.isEmpty()) {
			return;
		}
		File archivo = new File("Administrativo.txt");
		String contenido = "";
		
		for (int i = 0; i < admins.size(); i++) {
			Administrativo ad = admins.get(i);
			
			contenido += "Nombre: " + ad.getNombre() + "\nApellido: " + ad.getApellido() + "\nCorreo: "
					+ ad.getCorreoInst() + "\nUsuario: " + ad.getnUsuario() + "\nDocumento: " + ad.getId()
					+ "\nTelefono: " + ad.getTelefono() + "\nFacultad: " + ad.getFacultad() + "\nAños servicio: " + ad.getAnnoServicio() + "\n------------------------------\n";  
		}
		escribirTxt(archivo, contenido);
	}
	
	public void exportarUsuario() {
		exportarAdministrativo();
		exportarDocente();
		exportarEstudiante();
	}
	

	public void verEstudiantesMismaReservaDocente() {
		ArrayList<Reserva> reservasDocente = rDAO.listaPorUsuario(docenteActual.getId());

		if (reservasDocente == null || reservasDocente.isEmpty()) {
			JOptionPane.showMessageDialog(vdi, "No tienes reservas creadas.", "Estudiantes en mis reservas",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ArrayList<Reserva> todasLasReservas = rDAO.mostrarTodo();
		if (todasLasReservas == null) {
			todasLasReservas = new ArrayList<Reserva>();
		}
		ArrayList<Long> idsEstudiantesAgregados = new ArrayList<Long>();
		String texto = "";
		for (int i = 0; i < reservasDocente.size(); i++) {
			Reserva reservaDoc = reservasDocente.get(i);

			for (int j = 0; j < todasLasReservas.size(); j++) {
				Reserva r = todasLasReservas.get(j);
				if (r.getRol() == null || !r.getRol().equalsIgnoreCase("Estudiante")) {
					continue;
				}

				boolean mismoTransporte = r.getTipoTransporte() != null
						&& r.getTipoTransporte().equalsIgnoreCase(reservaDoc.getTipoTransporte());

				boolean mismaRuta = r.getRuta() != null && r.getRuta().equalsIgnoreCase(reservaDoc.getRuta());

				boolean mismaFecha = r.getFecha() != null && r.getFecha().equalsIgnoreCase(reservaDoc.getFecha());

				if (mismoTransporte && mismaRuta && mismaFecha) {

					Estudiante est = eDAO.buscarPorId(r.getIdUsuario());
					if (est == null) {
						continue;
					}
					if (idsEstudiantesAgregados.contains(est.getId())) {
						continue;
					}
					idsEstudiantesAgregados.add(est.getId());

					texto = texto + "Nombre: " + est.getNombre() + " " + est.getApellido() + "\nCorreo: "
							+ est.getCorreoInst() + "\nFacultad: " + est.getFacultad() + "\nCarrera: "
							+ est.getCarrera() + "\nSemestre: " + est.getSemestre() + "\nReserva #: " + r.getIdReserva()
							+ "\nRuta: " + r.getRuta() + "\nFecha: " + r.getFecha()
							+ "\n--------------------------------\n";
				}
			}
		}
		if (texto.equals("")) {
			texto = "No hay estudiantes con reservas en los mismos viajes que tú.";
		}

		JOptionPane.showMessageDialog(vdi, texto, "Estudiantes en mis reservas", JOptionPane.INFORMATION_MESSAGE);
	}

	public void verPersonasMismaReservaAdmin() {
		ArrayList<Reserva> reservasAdmin = rDAO.listaPorUsuario(adminActual.getId());
		if (reservasAdmin == null || reservasAdmin.isEmpty()) {
			JOptionPane.showMessageDialog(vai, "No tienes reservas creadas.", "Personas en mis reservas",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ArrayList<Reserva> todasLasReservas = rDAO.mostrarTodo();
		if (todasLasReservas == null) {
			todasLasReservas = new ArrayList<Reserva>();
		}		
		ArrayList<Long> idsEstudiantesAgregados = new ArrayList<Long>();
		ArrayList<Long> idsDocentesAgregados = new ArrayList<Long>();

		String texto = "";
		for (int i = 0; i < reservasAdmin.size(); i++) {
			Reserva reservaAdmin = reservasAdmin.get(i);

			for (int j = 0; j < todasLasReservas.size(); j++) {
				Reserva r = todasLasReservas.get(j);

				if (r.getRol() == null) {
					continue;
				}
				boolean mismoTransporte = r.getTipoTransporte() != null
						&& r.getTipoTransporte().equalsIgnoreCase(reservaAdmin.getTipoTransporte());
				boolean mismaRuta = r.getRuta() != null && r.getRuta().equalsIgnoreCase(reservaAdmin.getRuta());
				boolean mismaFecha = r.getFecha() != null && r.getFecha().equalsIgnoreCase(reservaAdmin.getFecha());
				if (!(mismoTransporte && mismaRuta && mismaFecha)) {
					continue;
				}
				if (r.getRol().equalsIgnoreCase("Estudiante")) {
					Estudiante est = eDAO.buscarPorId(r.getIdUsuario());
					if (est != null && !idsEstudiantesAgregados.contains(est.getId())) {
						idsEstudiantesAgregados.add(est.getId());
						texto = texto + "[ESTUDIANTE]\n" + "Nombre: " + est.getNombre() + " " + est.getApellido()
								+ "\nCorreo: " + est.getCorreoInst() + "\nFacultad: " + est.getFacultad()
								+ "\nCarrera: " + est.getCarrera() + "\nSemestre: " + est.getSemestre()
								+ "\nReserva #: " + r.getIdReserva() + "\nRuta: " + r.getRuta() + "\nFecha: "
								+ r.getFecha() + "\n--------------------------------\n";
					}
				}
				else if (r.getRol().equalsIgnoreCase("Docente")) {
					Docente doc = dDAO.buscarPorId(r.getIdUsuario());
					if (doc != null && !idsDocentesAgregados.contains(doc.getId())) {
						idsDocentesAgregados.add(doc.getId());
						texto = texto + "[DOCENTE]\n" + "Nombre: " + doc.getNombre() + " " + doc.getApellido()
								+ "\nCorreo: " + doc.getCorreoInst() + "\nFacultad: " + doc.getFacultad()
								+ "\nNúmero de materias: " + doc.getNumeroMateria() + "\nReserva #: " + r.getIdReserva()
								+ "\nRuta: " + r.getRuta() + "\nFecha: " + r.getFecha()
								+ "\n--------------------------------\n";
					}
				}
			}
		}

		if (texto.equals("")) {
			texto = "No hay estudiantes ni docentes con reservas en los mismos viajes que tú.";
		}
		JOptionPane.showMessageDialog(vai, texto, "Personas en mis reservas", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarSoloBusEstudiante() {
		vei.getTrenHorario().setVisible(false);
		vei.getHorarioIda().setVisible(false);
		vei.getHorarioRegreso().setVisible(false);
		vei.getBusHorario().setVisible(true);
		vei.getHorarioIdaBus().setVisible(true);
		vei.getHorarioRegresoBus().setVisible(false);
	}
	
	public void mostrarSoloBusDocente() {
		vdi.getTrenHorario().setVisible(false);
		vdi.getHorarioIda().setVisible(false);
		vdi.getHorarioRegreso().setVisible(false);
		vdi.getBusHorario().setVisible(true);
		vdi.getHorarioIdaBus().setVisible(true);
		vdi.getHorarioRegresoBus().setVisible(false);
	}

	public void mostrarSoloBusAdmin() {
		vai.getTrenHorario().setVisible(false);
		vai.getHorarioIda().setVisible(false);
		vai.getHorarioRegreso().setVisible(false);
		vai.getBusHorario().setVisible(true);
		vai.getHorarioIdaBus().setVisible(true);
		vai.getHorarioRegresoBus().setVisible(false);
	}
	
	public void mostrarSoloTrenEstudiante() {
		vei.getBusHorario().setVisible(false);
		vei.getHorarioIdaBus().setVisible(false);
		vei.getHorarioRegresoBus().setVisible(false);
		vei.getTrenHorario().setVisible(true);
		vei.getHorarioIda().setVisible(true);
		vei.getHorarioRegreso().setVisible(false);
	}

	public void mostrarSoloTrenDocente() {
		vdi.getBusHorario().setVisible(false);
		vdi.getHorarioIdaBus().setVisible(false);
		vdi.getHorarioRegresoBus().setVisible(false);
		vdi.getTrenHorario().setVisible(true);
		vdi.getHorarioIda().setVisible(true);
		vdi.getHorarioRegreso().setVisible(false);
	}

	public void mostrarSoloTrenAdmin() {
		vai.getBusHorario().setVisible(false);
		vai.getHorarioIdaBus().setVisible(false);
		vai.getHorarioRegresoBus().setVisible(false);
		vai.getTrenHorario().setVisible(true);
		vai.getHorarioIda().setVisible(true);
		vai.getHorarioRegreso().setVisible(false);
	}
	
	public void cancelarReservaEstudiante() {
		// Pedir ID al usuario
		String idTxt = JOptionPane.showInputDialog(vei, "Ingrese el número de la reserva a cancelar:",
				"Cancelar reserva", JOptionPane.QUESTION_MESSAGE);
		if (idTxt == null || idTxt.trim().equals("")) {
			return;
		}

		try {
			int idReserva = Integer.parseInt(idTxt.trim());
			ArrayList<Reserva> lista = rDAO.mostrarTodo();
			int indexEncontrado = -1;
			for (int i = 0; i < lista.size(); i++) {
				Reserva r = lista.get(i);
				if (r.getIdReserva() == idReserva && r.getIdUsuario() == estudianteActual.getId()) {
					indexEncontrado = i;
					break;
				}
			}
			if (indexEncontrado == -1) {
				JOptionPane.showMessageDialog(vei, "No existe una reserva con ese número o no pertenece a tu usuario.",
						"Cancelar reserva", JOptionPane.ERROR_MESSAGE);
				return;
			}
			boolean eliminado = rDAO.eliminar(indexEncontrado);
			if (eliminado) {
				JOptionPane.showMessageDialog(vei, "Reserva cancelada exitosamente.", "Cancelar reserva",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarReservaEstudiante();
				actualizarRecaudo();
			} else {
				JOptionPane.showMessageDialog(vei, "No se pudo eliminar la reserva.", "Cancelar reserva",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vei, "El número ingresado no es válido.", "Cancelar reserva",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void cancelarReservaDocente() {

		String idTxt = JOptionPane.showInputDialog(vdi, "Ingrese el número de reserva que desea cancelar:",
				"Cancelar reserva", JOptionPane.QUESTION_MESSAGE);
		if (idTxt == null || idTxt.trim().equals("")) {
			return;
		}
		try {
			int idReserva = Integer.parseInt(idTxt.trim());

			ArrayList<Reserva> lista = rDAO.mostrarTodo();
			int indexEncontrado = -1;

			for (int i = 0; i < lista.size(); i++) {
				Reserva r = lista.get(i);
				if (r.getIdReserva() == idReserva && r.getIdUsuario() == docenteActual.getId()) {
					indexEncontrado = i;
					break;
				}
			}
			if (indexEncontrado == -1) {
				JOptionPane.showMessageDialog(vdi, "No existe una reserva con ese número o no pertenece a su usuario.",
						"Cancelar reserva", JOptionPane.ERROR_MESSAGE);
				return;
			}
			boolean eliminado = rDAO.eliminar(indexEncontrado);
			if (eliminado) {
				JOptionPane.showMessageDialog(vdi, "Reserva cancelada correctamente.", "Cancelar reserva",
						JOptionPane.INFORMATION_MESSAGE);
				actualizarRecaudo();
			} else {
				JOptionPane.showMessageDialog(vdi, "No se pudo cancelar la reserva.", "Cancelar reserva",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vdi, "El número ingresado no es válido.", "Cancelar reserva",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void cancelarReservaAdmin() {
		String idTxt = JOptionPane.showInputDialog(vai, "Ingrese el número de reserva que desea cancelar:",
				"Cancelar reserva", JOptionPane.QUESTION_MESSAGE);
		if (idTxt == null || idTxt.trim().equals("")) {
			return;
		}
		try {
			int idReserva = Integer.parseInt(idTxt.trim());
			ArrayList<Reserva> lista = rDAO.mostrarTodo();
			int indexEncontrado = -1;
			for (int i = 0; i < lista.size(); i++) {
				Reserva r = lista.get(i);
				if (r.getIdReserva() == idReserva && r.getIdUsuario() == adminActual.getId()) {
					indexEncontrado = i;
					break;
				}
			}
			if (indexEncontrado == -1) {
				JOptionPane.showMessageDialog(vai, "No existe una reserva con ese número o no pertenece a su usuario.",
						"Cancelar reserva", JOptionPane.ERROR_MESSAGE);
				return;
			}
			boolean eliminado = rDAO.eliminar(indexEncontrado);
			if (eliminado) {
				JOptionPane.showMessageDialog(vai, "Reserva cancelada correctamente.", "Cancelar reserva",
						JOptionPane.INFORMATION_MESSAGE);
				actualizarRecaudo();
			} else {
				JOptionPane.showMessageDialog(vai, "No se pudo cancelar la reserva.", "Cancelar reserva",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vai, "El número ingresado no es válido.", "Cancelar reserva",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void iniciar() {
		vi.setVisible(true);

	}
}

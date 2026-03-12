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

	private AdministrativoDAO aDAO;
	private DocenteDAO dDAO;
	private EstudianteDAO eDAO;

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

		// ==DAO==
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
		// ==PRIMERA VENTANA==
		vi.getRegistrar().addActionListener(this);
		vi.getRegistrar().setActionCommand("boton_registrar");

		vi.getIniciarSesion().addActionListener(this);
		vi.getIniciarSesion().setActionCommand("boton_iniciar_sesion");

		// ==VENTANA REGISTRO==
		vr.getbVolver().addActionListener(this);
		vr.getbVolver().setActionCommand("boton_volver_registrar");

		vr.getbRegistrar().addActionListener(this);
		vr.getbRegistrar().setActionCommand("boton_guardar_cuenta");

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
		
		vdi.getPerfil().addActionListener(this);
		vdi.getPerfil().setActionCommand("ver_perfil_docente");
		
		vdi.getReserva().addActionListener(this);
		vdi.getReserva().setActionCommand("ver_reserva_docente");
		
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
	
	}

	public void actualizarCamposPorRol() {
		String rol = (String) vr.gettRol().getSelectedItem();

		if (rol == null) {

			if (vr.getCarrera() != null)
				vr.getCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.getSemestre().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettSemestre().setVisible(false);

			// ocultar los de docente
			if (vr.getCarrera() != null)
				vr.getNumMateria().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettNumMateria().setVisible(false);

			// ocultar los de administrativo
			if (vr.getCarrera() != null)
				vr.getAnnoServicio().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettAnnoServicio().setVisible(false);

		} else if (rol.equalsIgnoreCase("Estudiante")) {

			// mostrar los campos de estudainte
			if (vr.getCarrera() != null)
				vr.getCarrera().setVisible(true);
			if (vr.getCarrera() != null)
				vr.gettCarrera().setVisible(true);
			if (vr.getCarrera() != null)
				vr.getSemestre().setVisible(true);
			if (vr.getCarrera() != null)
				vr.gettSemestre().setVisible(true);

			// ocultar los de docente
			if (vr.getCarrera() != null)
				vr.getNumMateria().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettNumMateria().setVisible(false);

			// ocultar los de administrativo
			if (vr.getCarrera() != null)
				vr.getAnnoServicio().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettAnnoServicio().setVisible(false);

		} else if (rol.equalsIgnoreCase("Docente")) {

			// ocultar los de estudiante
			if (vr.getCarrera() != null)
				vr.getCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.getSemestre().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettSemestre().setVisible(false);

			// mostrar campos de docente
			if (vr.getCarrera() != null)
				vr.getNumMateria().setVisible(true);
			if (vr.getCarrera() != null)
				vr.gettNumMateria().setVisible(true);

			// ocultar los de administrativo
			if (vr.getCarrera() != null)
				vr.getAnnoServicio().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettAnnoServicio().setVisible(false);

		} else if (rol.equalsIgnoreCase("Administrativo")) {

			// Ocultar los de estudiantes
			if (vr.getCarrera() != null)
				vr.getCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.getSemestre().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettSemestre().setVisible(false);

			// Ocultar los de docente
			if (vr.getCarrera() != null)
				vr.getNumMateria().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettNumMateria().setVisible(false);

			// Mostrar los de administrativo
			if (vr.getCarrera() != null)
				vr.getAnnoServicio().setVisible(true);
			if (vr.getCarrera() != null)
				vr.gettAnnoServicio().setVisible(true);

		} else {

			// Ocultar los de estudiantes
			if (vr.getCarrera() != null)
				vr.getCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettCarrera().setVisible(false);
			if (vr.getCarrera() != null)
				vr.getSemestre().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettSemestre().setVisible(false);

			// Ocultar los de docente
			if (vr.getCarrera() != null)
				vr.getNumMateria().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettNumMateria().setVisible(false);

			// Ocultar los de administrativo
			if (vr.getCarrera() != null)
				vr.getAnnoServicio().setVisible(false);
			if (vr.getCarrera() != null)
				vr.gettAnnoServicio().setVisible(false);

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
			limpiarCampos();
			vr.setVisible(false);
			vi.setVisible(true);
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

					String carrera = (String) vr.gettCarrera().getSelectedItem();
					String semestreTxt = vr.gettSemestre().getText();

					verificarComboBox(carrera);
					verificarSemestre(semestreTxt);
					
					int semestre = Integer.parseInt(semestreTxt);
					eDAO.crear(new Estudiante(nombre, apellido, correoInst, nUsuario, id, telefono, contrasena,
							facultad, rol, carrera, semestre));

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

				JOptionPane.showMessageDialog(vr, "Cuenta creada exitosamente", "Registro completado",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();
				vr.setVisible(false);
				vi.setVisible(true);

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
			break;
		}
		case "ver_perfil_admin": {
			
			actualizarPerfilAdministrativo();
			
			vai.getPanelPrincipal().setVisible(false);
			//vai.getTrenHorario().setVisible(false);
			//vai.getBusHorario().setVisible(false);
			vai.getHorarioIda().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(true);
			vai.getPanelReserva().setVisible(false);
			break;
		}
		case "ver_rutas_tren_e": {
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
		case "ver_rutas_tren_a": {
			vdi.getPanelPrincipal().setVisible(false);
			vdi.getTrenHorario().setVisible(true);
			vdi.getHorarioIda().setVisible(true);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(false);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getPanelMiPerfil().setVisible(false);
			vdi.getPanelReserva().setVisible(false);
			break;
		}
	
		case "ver_rutas_bus_e": {
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
		case "ver_rutas_bus_a": {
			vdi.getPanelPrincipal().setVisible(false);
			vdi.getBusHorario().setVisible(true);
			vdi.getTrenHorario().setVisible(false);
			vdi.getHorarioIda().setVisible(false);
			vdi.getHorarioRegreso().setVisible(false);
			vdi.getHorarioIdaBus().setVisible(true);
			vdi.getHorarioRegresoBus().setVisible(false);
			vdi.getPanelMiPerfil().setVisible(false);
			vdi.getPanelReserva().setVisible(false);
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
			break;
		}
		case "ver_principal_admin": {
			vai.getPanelPrincipal().setVisible(true);
			vai.getHorarioIda().setVisible(false);
			//vdi.getTrenHorario().setVisible(false);
			//vdi.getBusHorario().setVisible(false);
			vai.getHorarioRegreso().setVisible(false);
			vai.getHorarioIdaBus().setVisible(false);
			vai.getHorarioRegresoBus().setVisible(false);
			vai.getPanelMiPerfil().setVisible(false);
			vai.getPanelReserva().setVisible(false);
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

		vr.gettCarrera().setSelectedIndex(0);
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
		vai.gettAnosServicio().setText(String.valueOf(adminActual.getAnnoServicio()));
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
	 * NumericalDataException("El campo " + nombreCampo +
	 * " debe ser un numero valido"); } }
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

		if (!correo.contains("@")) {
			throw new EmailException();
		}

		if (correo.isEmpty() || correo.matches("^[A-Za-z0-9._-]+$")) {
			throw new EmailException();
		}

		if (correo.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new EmailException();
		}

		if (!correo.endsWith("unbosque.edu.co")) {
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
		if(!idTxt.matches("^[0-9]{10}$")) {
			throw new IdException();
		}
	}
		
	public static void verificarTelefono(long telefono) throws CelException {
		
		String telefonoTxt = Long.toString(telefono);
		if(!telefonoTxt.matches("^[0-9]{10}$")) {
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


	public void iniciar() {
		vi.setVisible(true);

	}
}

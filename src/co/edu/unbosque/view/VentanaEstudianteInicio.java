package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class VentanaEstudianteInicio extends JFrame {

	private JLabel titulo;
	private JLabel mensaje;
	private JLabel lTren;
	private JLabel lBus;
	private JLabel lMiReserva;
	
	private JTextArea tMensaje;
	
	private JPanel menuBar;
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelUno;
	private JPanel panelDos;
	private JPanel panelTres;
	private JPanel panelCuatro;
	
	//tren
	private JPanel trenHorario;
	private JPanel horarioIda;
	private JPanel horarioRegreso;
	private JButton flechaDerechaUno;
	private JButton flechaIzquierdaUno;
	private JButton flechaDerechaDos;
	private JButton flechaIzquierdaDos;
	
	//bus
	private JPanel busHorario;
	private JPanel horarioIdaBus;
	private JPanel horarioRegresoBus;
	private JButton flechaDerUnoBus;
	private JButton flechaIzqUnoBus;
	private JButton flechaDerDosBus;
	private JButton flechaIzqDosBus;
	
	//mi perfil
	private JPanel panelMiPerfil;
	private JLabel dato;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel correo;
	private JLabel usuario;
	private JLabel documento;
	private JLabel telefono;
	private JLabel facultad;
	private JLabel carrera;
	private JLabel semestre;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tCorreo;
	private JTextField tUsuario;
	private JTextField tDocumento;
	private JTextField tTelefono;
	private JTextField tFacultad;
	private JTextField tCarrera;
	private JTextField tSemestre;
	
	//reservas
	private JPanel panelReserva;
	private JPanel panelRuta;
	private JPanel infoCosto;
	private JTextArea info;
	private JLabel tituloReserva;
	private JLabel fecha;
	private JLabel transporte;
	private JLabel ruta;
	private JLabel infoRuta;
	private JLabel costo;
	private JRadioButton rBus;
	private JRadioButton rTren;
	private JRadioButton rUsaquen;
	private JRadioButton rChia;
	private JButton pagar;
	private ButtonGroup grupoTransporte;
	private ButtonGroup grupoRuta;
	private JPanel calendario;
	private JDateChooser calendar;
	private JTextField plata;
	
	//botones de la barra lateral
	private JButton inicio;
	private JButton tren;
	private JButton bTren;
	private JButton bus;
	private JButton bBus;
	private JButton perfil;
	private JButton reserva;
	private JButton salir;
	
	public VentanaEstudianteInicio() {
		setVisible(false);
		initComp();
	}

	public void initComp() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana principal de estudiante");
		this.setBounds(250, 30, 980, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#99bc9f"));

		// ==PANEL==
		menuBar = new JPanel();
		menuBar.setLayout(null);
		menuBar.setBounds(5, 18, 150, 610);
		menuBar.setBackground(Color.decode("#6d9a77"));
		// menuBar.setBackground(new Color(152, 189, 160, 180));
		// menuBar.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(menuBar);

		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBounds(0, 0, 980, 680);
		panelPrincipal.setBackground(Color.decode("#99bc9f"));
		add(panelPrincipal);

		panelMiPerfil = new JPanel();
		panelMiPerfil.setLayout(null);
		panelMiPerfil.setBounds(520, 50, 400, 540);
		panelMiPerfil.setBackground(Color.decode("#ffffff"));
		panelMiPerfil.setVisible(false);
		add(panelMiPerfil);
		
		//===============

		panelReserva = new JPanel();
		panelReserva.setLayout(null);
		panelReserva.setBounds(180, 20, 760, 606);
		panelReserva.setBackground(Color.decode("#ffffff"));
		panelReserva.setVisible(false);
		add(panelReserva);
		
		//===============================
		panelSuperior = new JPanel();
		panelSuperior.setLayout(null);
		panelSuperior.setBounds(180, 18, 760, 150);
		panelSuperior.setBackground(Color.decode("#6d9a77"));
		panelPrincipal.add(panelSuperior);

		panelUno = new JPanel();
		panelUno.setLayout(null);
		panelUno.setBounds(180, 185, 460, 160);
		panelUno.setBackground(Color.decode("#ffffff"));
		panelPrincipal.add(panelUno);

		panelDos = new JPanel();
		panelDos.setLayout(null);
		panelDos.setBounds(180, 365, 220, 260);
		panelDos.setBackground(Color.decode("#ffffff"));
		panelPrincipal.add(panelDos);
		
		panelTres = new JPanel();
		panelTres.setLayout(null);
		panelTres.setBounds(420, 365, 220, 260);
		panelTres.setBackground(Color.decode("#ffffff"));
		panelPrincipal.add(panelTres);
		
		panelCuatro = new JPanel();
		panelCuatro.setLayout(null);
		panelCuatro.setBounds(660, 185, 274, 440);
		panelCuatro.setBackground(Color.decode("#ffffff"));
		panelPrincipal.add(panelCuatro);
		
		//LABELS

		titulo = new JLabel("Bienvenido, estudiante :D");
		titulo.setBounds(20, 50, 650, 55);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		panelSuperior.add(titulo);

		mensaje = new JLabel("Mensajes y alertas");
		mensaje.setBounds(20, 10, 250, 20);
		mensaje.setForeground(Color.BLACK);
		mensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelUno.add(mensaje);
		
		lTren = new JLabel("Horarios del tren");
		lTren.setBounds(45, 227, 250, 20);
		lTren.setForeground(Color.BLACK);
		lTren.setFont(new Font("Arial", Font.BOLD, 16));
		panelDos.add(lTren);
		
		lBus = new JLabel("Horarios de buses");
		lBus.setBounds(40, 227, 250, 20);
		lBus.setForeground(Color.BLACK);
		lBus.setFont(new Font("Arial", Font.BOLD, 16));
		panelTres.add(lBus);
		
		lMiReserva = new JLabel("Mis Reservas");
		lMiReserva.setBounds(90, 10, 250, 20);
		lMiReserva.setForeground(Color.BLACK);
		lMiReserva.setFont(new Font("Arial", Font.BOLD, 16));
		panelCuatro.add(lMiReserva);
		
		//TEXT AREA
		
		tMensaje = new JTextArea(" No hay actualizaciones. El sistema de transporte está funcionando con\n normalidad");
		tMensaje.setBounds(15, 45, 428, 100);
		tMensaje.setBackground(Color.decode("#e0ebe0"));
		tMensaje.setEditable(false);
		panelUno.add(tMensaje);
		
		//BOTONES
				
		inicio = new JButton("Inicio");
		inicio.setBounds(31, 50, 80, 25);
		inicio.setFont(new Font("Agency FB", Font.BOLD, 20));
		inicio.setForeground(Color.decode("#ffffff"));
		inicio.setBackground(Color.decode("#376445"));
		inicio.setBorderPainted(false);
		inicio.setFocusPainted(false);
		menuBar.add(inicio);

		tren = new JButton("Rutas Tren");
		tren.setBounds(18, 150, 110, 25);
		tren.setFont(new Font("Agency FB", Font.BOLD, 20));
		tren.setForeground(Color.decode("#ffffff"));
		tren.setBackground(Color.decode("#376445"));
		tren.setBorderPainted(false);
		tren.setFocusPainted(false);
		menuBar.add(tren);

		ImageIcon imagenn = new ImageIcon(getClass().getResource("tren.png"));
		JLabel labelImagenn = new JLabel(imagenn);
		bTren = new JButton(imagenn);
		bTren.setBounds(5, 34, 220, 170);
		bTren.setFont(new Font("Agency FB", Font.BOLD, 45));
		bTren.setBackground(Color.decode("#ffffff"));
		bTren.setBorderPainted(false);
		bTren.setFocusPainted(false);
		panelDos.add(bTren);

		bus = new JButton("Rutas buses");
		bus.setBounds(18, 250, 110, 25);
		bus.setFont(new Font("Agency FB", Font.BOLD, 20));
		bus.setForeground(Color.decode("#ffffff"));
		bus.setBackground(Color.decode("#376445"));
		bus.setBorderPainted(false);
		bus.setFocusPainted(false);
		menuBar.add(bus);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("bus.png"));
		JLabel labelImagen = new JLabel(imagen);
		bBus = new JButton(imagen);
		bBus.setBounds(0, 35, 228, 150);
		bBus.setFont(new Font("Agency FB", Font.BOLD, 20));
		bBus.setBackground(Color.decode("#ffffff"));
		bBus.setBorderPainted(false);
		bBus.setFocusPainted(false);
		panelTres.add(bBus);		

		perfil = new JButton("Mi Perfil");
		perfil.setBounds(23, 350, 100, 25);
		perfil.setFont(new Font("Agency FB", Font.BOLD, 20));
		perfil.setForeground(Color.decode("#ffffff"));
		perfil.setBackground(Color.decode("#376445"));
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		menuBar.add(perfil);

		reserva = new JButton("Reservar");
		reserva.setBounds(15, 450, 120, 25);
		reserva.setFont(new Font("Agency FB", Font.BOLD, 20));
		reserva.setForeground(Color.decode("#ffffff"));
		reserva.setBackground(Color.decode("#376445"));
		reserva.setBorderPainted(false);
		reserva.setFocusPainted(false);
		menuBar.add(reserva);

		salir = new JButton("Cerrar Sesión");
		salir.setBounds(14, 550, 120, 25);
		salir.setFont(new Font("Agency FB", Font.BOLD, 20));
		salir.setForeground(Color.decode("#ffffff"));
		salir.setBackground(Color.decode("#376445"));
		salir.setBorderPainted(false);
		salir.setFocusPainted(false);
		menuBar.add(salir);
		
		//==TODO LO DEL TREN==
		horarioIda = new JPanel();
		horarioIda.setLayout(null);
		horarioIda.setBounds(175, 140, 772, 485);
		horarioIda.setBackground(Color.decode("#f2efe5"));
		horarioIda.setVisible(false);
		add(horarioIda);
		
		JLabel us = new JLabel("Usaquen - Chia");
		us.setBounds(290, 28, 250, 30);
		us.setForeground(Color.BLACK);
		us.setFont(new Font("Arial", Font.BOLD, 28));
		horarioIda.add(us);

		horarioRegreso = new JPanel();
		horarioRegreso.setLayout(null);
		horarioRegreso.setBounds(175, 140, 772, 485);
		horarioRegreso.setBackground(Color.decode("#f2efe5"));
		horarioRegreso.setVisible(false);
		add(horarioRegreso);
		
		JLabel ch = new JLabel("Chia - Usaquen");
		ch.setBounds(290, 28, 250, 30);
		ch.setForeground(Color.BLACK);
		ch.setFont(new Font("Arial", Font.BOLD, 28));
		horarioRegreso.add(ch);

		trenHorario = new JPanel();
		trenHorario.setLayout(null);
		trenHorario.setBounds(290, 0, 500, 200);
		trenHorario.setBackground(Color.decode("#99bc9f"));
		trenHorario.setVisible(false);
		add(trenHorario);
		
		//==IMAGENES==
		ImageIcon horario = new ImageIcon(getClass().getResource("horarioo.JPG"));
		JLabel lIconTren = new JLabel(horario);
		lIconTren.setBounds(0, 0, 500, 170);
		// panelLogo.add(lIcon);
		trenHorario.add(lIconTren);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("horariotren.JPG"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(40, 50, 692, 435);
		// panelLogo.add(lIcon);
		horarioIda.add(lIcon);

		ImageIcon imageLogo2 = new ImageIcon(getClass().getResource("horariotrentarde.JPG"));
		JLabel lIcon2 = new JLabel(imageLogo2);
		lIcon2.setBounds(40, 50, 692, 435);
		// panelLogo.add(lIcon);
		horarioRegreso.add(lIcon2);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("flechaadelante.png"));
		JLabel labelImagen1 = new JLabel(imagen1);
		flechaDerechaUno = new JButton(imagen1);
		flechaDerechaUno.setBackground(Color.WHITE);
		flechaDerechaUno.setBounds(700, 5, 63, 65);
		flechaDerechaUno.setFocusPainted(false);
		flechaDerechaUno.setBorderPainted(false);
		horarioIda.add(flechaDerechaUno);
		
		ImageIcon imagen4 = new ImageIcon(getClass().getResource("flechaatras.png"));
		JLabel labelImagen4 = new JLabel(imagen4);
		flechaIzquierdaDos = new JButton(imagen4);
		flechaIzquierdaDos.setBackground(Color.WHITE);
		flechaIzquierdaDos.setBounds(18, 5, 65, 66);
		flechaIzquierdaDos.setFocusPainted(false);
		flechaIzquierdaDos.setBorderPainted(false);
		horarioRegreso.add(flechaIzquierdaDos);

		//==TODO LO DEL BUS==
		busHorario = new JPanel();
		busHorario.setLayout(null);
		busHorario.setBounds(290, -90, 500, 200);
		busHorario.setBackground(Color.decode("#99bc9f"));
		busHorario.setVisible(false);
		add(busHorario);
		
		horarioIdaBus = new JPanel();
		horarioIdaBus.setLayout(null);
		horarioIdaBus.setBounds(175, 140, 772, 485);
		horarioIdaBus.setBackground(Color.decode("#f2efe5"));
		horarioIdaBus.setVisible(false);
		add(horarioIdaBus);

		horarioRegresoBus = new JPanel();
		horarioRegresoBus.setLayout(null);
		horarioRegresoBus.setBounds(175, 140, 772, 485);
		horarioRegresoBus.setBackground(Color.decode("#f2efe5"));
		horarioRegresoBus.setVisible(false);
		add(horarioRegresoBus);
		
		JLabel usb = new JLabel("Usaquen - Chia");
		usb.setBounds(290, 28, 250, 30);
		usb.setForeground(Color.BLACK);
		usb.setFont(new Font("Arial", Font.BOLD, 28));
		horarioIdaBus.add(usb);
		
		JLabel chb = new JLabel("Chia - Usaquen");
		chb.setBounds(290, 28, 250, 30);
		chb.setForeground(Color.BLACK);
		chb.setFont(new Font("Arial", Font.BOLD, 28));
		horarioRegresoBus.add(chb);
		
		//==IMAGENES==
		
		ImageIcon horarioo = new ImageIcon(getClass().getResource("horariooo.JPG"));
		JLabel lIconBus = new JLabel(horarioo);
		lIconBus.setBounds(0, 90, 500, 170);
		// panelLogo.add(lIcon);
		busHorario.add(lIconBus);
		
		ImageIcon imageLogo5 = new ImageIcon(getClass().getResource("horariobus.JPG"));
		JLabel lIcon5 = new JLabel(imageLogo5);
		lIcon5.setBounds(40, 50, 692, 435);
		// panelLogo.add(lIcon);
		horarioIdaBus.add(lIcon5);

		ImageIcon imageLogo6 = new ImageIcon(getClass().getResource("horariobusregreso.JPG"));
		JLabel lIcon6 = new JLabel(imageLogo6);
		lIcon6.setBounds(40, 50, 692, 435);
		// panelLogo.add(lIcon);
		horarioRegresoBus.add(lIcon6);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("flechaadelante.png"));
		JLabel labelImagen5 = new JLabel(imagen5);
		flechaDerUnoBus = new JButton(imagen5);
		flechaDerUnoBus.setBackground(Color.WHITE);
		flechaDerUnoBus.setBounds(700, 5, 63, 65);
		flechaDerUnoBus.setFocusPainted(false);
		flechaDerUnoBus.setBorderPainted(false);
		horarioIdaBus.add(flechaDerUnoBus);

		ImageIcon imagen8 = new ImageIcon(getClass().getResource("flechaatras.png"));
		JLabel labelImagen8 = new JLabel(imagen8);
		flechaIzqDosBus = new JButton(imagen8);
		flechaIzqDosBus.setBackground(Color.WHITE);
		flechaIzqDosBus.setBounds(18, 5, 65, 66);
		flechaIzqDosBus.setFocusPainted(false);
		flechaIzqDosBus.setBorderPainted(false);
		horarioRegresoBus.add(flechaIzqDosBus);
		
		//==TODO LO DE MI PERFIL==
		
		dato = new JLabel("Mi información");
		dato.setBounds(95, 47, 250, 35);
		dato.setForeground(Color.BLACK);
		dato.setFont(new Font("Arial", Font.BOLD, 30));
		panelMiPerfil.add(dato);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(30, 130, 80, 25);
		nombre.setFont(new Font("Agency FB", Font.BOLD, 20));
		nombre.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(nombre);

		tNombre = new JTextField();
		tNombre.setBounds(85, 130, 290, 25);
		tNombre.setFont(new Font("Agency FB", Font.BOLD, 20));
		tNombre.setForeground(Color.decode("#111d15"));
		tNombre.setBackground(Color.decode("#e0ebe0"));
		tNombre.setEditable(false);
		tNombre.setBorder(null);
		panelMiPerfil.add(tNombre);

		apellido = new JLabel("Apellidos:");
		apellido.setBounds(30, 170, 80, 25);
		apellido.setFont(new Font("Agency FB", Font.BOLD, 20));
		apellido.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(apellido);
		
		tApellido = new JTextField();
		tApellido.setBounds(88, 170, 287, 25);
		tApellido.setFont(new Font("Agency FB", Font.BOLD, 20));
		tApellido.setForeground(Color.decode("#111d15"));
		tApellido.setBackground(Color.decode("#e0ebe0"));
		tApellido.setEditable(false);
		tApellido.setBorder(null);
		panelMiPerfil.add(tApellido);

		correo = new JLabel("Correo Institucional:");
		correo.setBounds(30, 210, 150, 25);
		correo.setFont(new Font("Agency FB", Font.BOLD, 20));
		correo.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(correo);

		tCorreo = new JTextField();
		tCorreo.setBounds(157, 210, 218, 25);
		tCorreo.setFont(new Font("Agency FB", Font.BOLD, 20));
		tCorreo.setForeground(Color.decode("#111d15"));
		tCorreo.setBackground(Color.decode("#e0ebe0"));
		tCorreo.setEditable(false);
		tCorreo.setBorder(null);
		panelMiPerfil.add(tCorreo);
		
		usuario = new JLabel("Usuario Institucional:");
		usuario.setBounds(30, 250, 150, 25);
		usuario.setFont(new Font("Agency FB", Font.BOLD, 20));
		usuario.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(usuario);

		tUsuario = new JTextField();
		tUsuario.setBounds(162, 250, 214, 25);
		tUsuario.setFont(new Font("Agency FB", Font.BOLD, 20));
		tUsuario.setForeground(Color.decode("#111d15"));
		tUsuario.setBackground(Color.decode("#e0ebe0"));
		tUsuario.setEditable(false);
		tUsuario.setBorder(null);
		panelMiPerfil.add(tUsuario);

		documento = new JLabel("Documento de Identidad:");
		documento.setBounds(30, 290, 200, 25);
		documento.setFont(new Font("Agency FB", Font.BOLD, 20));
		documento.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(documento);

		tDocumento = new JTextField();
		tDocumento.setBounds(175, 290, 201, 25);
		tDocumento.setFont(new Font("Agency FB", Font.BOLD, 18));
		tDocumento.setForeground(Color.decode("#111d15"));
		tDocumento.setBackground(Color.decode("#e0ebe0"));
		tDocumento.setEditable(false);
		tDocumento.setBorder(null);
		panelMiPerfil.add(tDocumento);
		
		telefono = new JLabel("Número de teléfono:");
		telefono.setBounds(30, 330, 150, 25);
		telefono.setFont(new Font("Agency FB", Font.BOLD, 20));
		telefono.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(telefono);

		tTelefono = new JTextField();
		tTelefono.setBounds(160, 330, 216, 25);
		tTelefono.setFont(new Font("Agency FB", Font.BOLD, 18));
		tTelefono.setForeground(Color.decode("#111d15"));
		tTelefono.setBackground(Color.decode("#e0ebe0"));
		tTelefono.setEditable(false);
		tTelefono.setBorder(null);
		panelMiPerfil.add(tTelefono);

		facultad = new JLabel("Facultad:");
		facultad.setBounds(30, 370, 150, 25);
		facultad.setFont(new Font("Agency FB", Font.BOLD, 20));
		facultad.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(facultad);
		
		tFacultad = new JTextField();
		tFacultad.setBounds(90, 370, 288, 25);
		tFacultad.setFont(new Font("Agency FB", Font.BOLD, 20));
		tFacultad.setForeground(Color.decode("#111d15"));
		tFacultad.setBackground(Color.decode("#e0ebe0"));
		tFacultad.setEditable(false);
		tFacultad.setBorder(null);
		panelMiPerfil.add(tFacultad);
		
		carrera = new JLabel("Carrera:");
		carrera.setBounds(30, 410, 150, 25);
		carrera.setFont(new Font("Agency FB", Font.BOLD, 20));
		carrera.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(carrera);

		tCarrera = new JTextField();
		tCarrera.setBounds(90, 410, 288, 25);
		tCarrera.setFont(new Font("Agency FB", Font.BOLD, 20));
		tCarrera.setForeground(Color.decode("#111d15"));
		tCarrera.setBackground(Color.decode("#e0ebe0"));
		tCarrera.setEditable(false);
		tCarrera.setBorder(null);
		panelMiPerfil.add(tCarrera);

		semestre = new JLabel("Semestre:");
		semestre.setBounds(30, 450, 150, 25);
		semestre.setFont(new Font("Agency FB", Font.BOLD, 20));
		semestre.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(semestre);
		
		tSemestre = new JTextField();
		tSemestre.setBounds(95, 450, 285, 25);
		tSemestre.setFont(new Font("Agency FB", Font.BOLD, 18));
		tSemestre.setForeground(Color.decode("#111d15"));
		tSemestre.setBackground(Color.decode("#e0ebe0"));
		tSemestre.setEditable(false);
		tSemestre.setBorder(null);
		panelMiPerfil.add(tSemestre);
		
		//==TODO LO DE RESERVAS==
		
		tituloReserva = new JLabel("Nueva Reserva");
		tituloReserva.setBounds(95, 20, 250, 38);
		tituloReserva.setForeground(Color.BLACK);
		tituloReserva.setFont(new Font("Arial", Font.BOLD, 35));
		panelReserva.add(tituloReserva);

		info = new JTextArea("*Recuerde llegar 10 minutos antes de la hora \nde la reservación y presentar la captura de esta. \nNo puede reservar sin pagar :)");
		info.setBounds(490, 558, 250, 40);
		info.setForeground(Color.BLACK);
		info.setFont(new Font("Arial", Font.BOLD, 10));
		panelReserva.add(info);
		
		transporte = new JLabel("Tipo transporte");
		transporte.setBounds(45, 70, 250, 20);
		transporte.setForeground(Color.BLACK);
		transporte.setFont(new Font("Arial", Font.BOLD, 18));
		panelReserva.add(transporte);

		transporte = new JLabel("Horario de viaje");
		transporte.setBounds(235, 70, 250, 20);
		transporte.setForeground(Color.BLACK);
		transporte.setFont(new Font("Arial", Font.BOLD, 18));
		panelReserva.add(transporte);
		
		rBus = new JRadioButton("Bus");
		rBus.setBounds(50, 100, 120, 25);
		rBus.setFont(new Font("Agency FB", Font.BOLD, 20));
		rBus.setForeground(Color.decode("#ffffff"));
		rBus.setBackground(Color.decode("#376445"));
		rBus.setBorderPainted(false);
		rBus.setFocusPainted(false);
		panelReserva.add(rBus);
		
		rTren = new JRadioButton("Tren");
		rTren.setBounds(50, 140, 120, 25);
		rTren.setFont(new Font("Agency FB", Font.BOLD, 20));
		rTren.setForeground(Color.decode("#ffffff"));
		rTren.setBackground(Color.decode("#376445"));
		rTren.setBorderPainted(false);
		rTren.setFocusPainted(false);
		panelReserva.add(rTren);

		rUsaquen = new JRadioButton("Usaquén - Chía");
		rUsaquen.setBounds(230, 100, 180, 25);
		rUsaquen.setFont(new Font("Agency FB", Font.BOLD, 20));
		rUsaquen.setForeground(Color.decode("#ffffff"));
		rUsaquen.setBackground(Color.decode("#376445"));
		rUsaquen.setBorderPainted(false);
		rUsaquen.setFocusPainted(false);
		panelReserva.add(rUsaquen);
		
		rChia = new JRadioButton("Chía - Usaquen");
		rChia.setBounds(230, 140, 180, 25);
		rChia.setFont(new Font("Agency FB", Font.BOLD, 20));
		rChia.setForeground(Color.decode("#ffffff"));
		rChia.setBackground(Color.decode("#376445"));
		rChia.setBorderPainted(false);
		rChia.setFocusPainted(false);
		panelReserva.add(rChia);
		
		grupoTransporte = new ButtonGroup();
		grupoTransporte.add(rBus);
		grupoTransporte.add(rTren);
		
		grupoRuta = new ButtonGroup();
		grupoRuta.add(rUsaquen);
		grupoRuta.add(rChia);
		
		calendario = new JPanel();
		calendario.setLayout(null);
		calendario.setBounds(490, 50, 235, 260);
		calendario.setBackground(Color.decode("#99bc9f"));
		panelReserva.add(calendario);
		
		fecha = new JLabel("Seleccione la fecha del viaje");
		fecha.setBounds(12, 18, 250, 20);
		fecha.setForeground(Color.BLACK);
		fecha.setFont(new Font("Arial", Font.BOLD, 15));
		calendario.add(fecha);
		
		calendar = new JDateChooser();
		calendar.setBounds(32, 48, 180, 30);
		calendar.setBackground(Color.decode("#e0ebe0"));
		calendario.add(calendar);

		panelRuta = new JPanel();
		panelRuta.setLayout(null);
		panelRuta.setBounds(20, 180, 430, 410);
		panelRuta.setBackground(Color.decode("#99bc9f"));
		panelReserva.add(panelRuta);
		
		infoCosto = new JPanel();
		infoCosto.setLayout(null);
		infoCosto.setBounds(490, 340, 235, 140);
		infoCosto.setBackground(Color.decode("#99bc9f"));
		panelReserva.add(infoCosto);

		costo = new JLabel("Costo de la reserva");
		costo.setBounds(37, 18, 250, 20);
		costo.setForeground(Color.BLACK);
		costo.setFont(new Font("Arial", Font.BOLD, 17));
		infoCosto.add(costo);
		
		plata = new JTextField();
		plata.setBounds(60, 57, 120, 50);
		plata.setFont(new Font("Agency FB", Font.BOLD, 20));
		plata.setForeground(Color.decode("#111d15"));
		plata.setBackground(Color.decode("#e0ebe0"));
		plata.setBorder(null);
		plata.setEditable(false);
		infoCosto.add(plata);
		
		pagar = new JButton("Pagar y reservar");
		pagar.setBounds(535, 505, 150, 45);
		pagar.setFont(new Font("Agency FB", Font.BOLD, 20));
		pagar.setForeground(Color.decode("#ffffff"));
		pagar.setBackground(Color.decode("#376445"));
		pagar.setBorderPainted(false);
		pagar.setFocusPainted(false);
		panelReserva.add(pagar);
	}

	public JPanel getBusHorario() {
		return busHorario;
	}

	public void setBusHorario(JPanel busHorario) {
		this.busHorario = busHorario;
	}

	public JPanel getTrenHorario() {
		return trenHorario;
	}

	public void setTrenHorario(JPanel trenHorario) {
		this.trenHorario = trenHorario;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public void setMenuBar(JPanel menuBar) {
		this.menuBar = menuBar;
	}

	public JButton getInicio() {
		return inicio;
	}

	public void setInicio(JButton inicio) {
		this.inicio = inicio;
	}

	public JButton getTren() {
		return tren;
	}

	public void setTren(JButton tren) {
		this.tren = tren;
	}

	public JButton getBus() {
		return bus;
	}

	public void setBus(JButton bus) {
		this.bus = bus;
	}

	public JButton getPerfil() {
		return perfil;
	}

	public void setPerfil(JButton perfil) {
		this.perfil = perfil;
	}

	public JButton getReserva() {
		return reserva;
	}

	public void setReserva(JButton reserva) {
		this.reserva = reserva;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JLabel getMensaje() {
		return mensaje;
	}

	public void setMensaje(JLabel mensaje) {
		this.mensaje = mensaje;
	}

	public JLabel getlTren() {
		return lTren;
	}

	public void setlTren(JLabel lTren) {
		this.lTren = lTren;
	}

	public JLabel getlBus() {
		return lBus;
	}

	public void setlBus(JLabel lBus) {
		this.lBus = lBus;
	}

	public JLabel getlMiReserva() {
		return lMiReserva;
	}

	public void setlMiReserva(JLabel lMiReserva) {
		this.lMiReserva = lMiReserva;
	}

	public JTextArea gettMensaje() {
		return tMensaje;
	}

	public void settMensaje(JTextArea tMensaje) {
		this.tMensaje = tMensaje;
	}

	public JPanel getPanelSuperior() {
		return panelSuperior;
	}

	public void setPanelSuperior(JPanel panelSuperior) {
		this.panelSuperior = panelSuperior;
	}

	public JPanel getPanelUno() {
		return panelUno;
	}

	public void setPanelUno(JPanel panelUno) {
		this.panelUno = panelUno;
	}

	public JPanel getPanelDos() {
		return panelDos;
	}

	public void setPanelDos(JPanel panelDos) {
		this.panelDos = panelDos;
	}

	public JPanel getPanelTres() {
		return panelTres;
	}

	public void setPanelTres(JPanel panelTres) {
		this.panelTres = panelTres;
	}

	public JPanel getPanelCuatro() {
		return panelCuatro;
	}

	public void setPanelCuatro(JPanel panelCuatro) {
		this.panelCuatro = panelCuatro;
	}

	public JButton getbTren() {
		return bTren;
	}

	public void setbTren(JButton bTren) {
		this.bTren = bTren;
	}

	public JButton getbBus() {
		return bBus;
	}

	public void setbBus(JButton bBus) {
		this.bBus = bBus;
	}

	public JPanel getHorarioIda() {
		return horarioIda;
	}

	public void setHorarioIda(JPanel horarioIda) {
		this.horarioIda = horarioIda;
	}

	public JPanel getHorarioRegreso() {
		return horarioRegreso;
	}

	public void setHorarioRegreso(JPanel horarioRegreso) {
		this.horarioRegreso = horarioRegreso;
	}

	public JButton getFlechaDerechaUno() {
		return flechaDerechaUno;
	}

	public void setFlechaDerechaUno(JButton flechaDerechaUno) {
		this.flechaDerechaUno = flechaDerechaUno;
	}

	public JButton getFlechaIzquierdaUno() {
		return flechaIzquierdaUno;
	}

	public void setFlechaIzquierdaUno(JButton flechaIzquierdaUno) {
		this.flechaIzquierdaUno = flechaIzquierdaUno;
	}

	public JButton getFlechaDerechaDos() {
		return flechaDerechaDos;
	}

	public void setFlechaDerechaDos(JButton flechaDerechaDos) {
		this.flechaDerechaDos = flechaDerechaDos;
	}

	public JButton getFlechaIzquierdaDos() {
		return flechaIzquierdaDos;
	}

	public void setFlechaIzquierdaDos(JButton flechaIzquierdaDos) {
		this.flechaIzquierdaDos = flechaIzquierdaDos;
	}

	public JPanel getHorarioIdaBus() {
		return horarioIdaBus;
	}

	public void setHorarioIdaBus(JPanel horarioIdaBus) {
		this.horarioIdaBus = horarioIdaBus;
	}

	public JPanel getHorarioRegresoBus() {
		return horarioRegresoBus;
	}

	public void setHorarioRegresoBus(JPanel horarioRegresoBus) {
		this.horarioRegresoBus = horarioRegresoBus;
	}

	public JButton getFlechaDerUnoBus() {
		return flechaDerUnoBus;
	}

	public void setFlechaDerUnoBus(JButton flechaDerUnoBus) {
		this.flechaDerUnoBus = flechaDerUnoBus;
	}

	public JButton getFlechaIzqUnoBus() {
		return flechaIzqUnoBus;
	}

	public void setFlechaIzqUnoBus(JButton flechaIzqUnoBus) {
		this.flechaIzqUnoBus = flechaIzqUnoBus;
	}

	public JButton getFlechaDerDosBus() {
		return flechaDerDosBus;
	}

	public void setFlechaDerDosBus(JButton flechaDerDosBus) {
		this.flechaDerDosBus = flechaDerDosBus;
	}

	public JButton getFlechaIzqDosBus() {
		return flechaIzqDosBus;
	}

	public void setFlechaIzqDosBus(JButton flechaIzqDosBus) {
		this.flechaIzqDosBus = flechaIzqDosBus;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JPanel getPanelMiPerfil() {
		return panelMiPerfil;
	}

	public void setPanelMiPerfil(JPanel panelMiPerfil) {
		this.panelMiPerfil = panelMiPerfil;
	}

	public JLabel getDato() {
		return dato;
	}

	public void setDato(JLabel dato) {
		this.dato = dato;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}

	public JLabel getCorreo() {
		return correo;
	}

	public void setCorreo(JLabel correo) {
		this.correo = correo;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getDocumento() {
		return documento;
	}

	public void setDocumento(JLabel documento) {
		this.documento = documento;
	}

	public JLabel getTelefono() {
		return telefono;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

	public JLabel getFacultad() {
		return facultad;
	}

	public void setFacultad(JLabel facultad) {
		this.facultad = facultad;
	}

	public JLabel getCarrera() {
		return carrera;
	}

	public void setCarrera(JLabel carrera) {
		this.carrera = carrera;
	}

	public JLabel getSemestre() {
		return semestre;
	}

	public void setSemestre(JLabel semestre) {
		this.semestre = semestre;
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public void settNombre(JTextField tNombre) {
		this.tNombre = tNombre;
	}

	public JTextField gettApellido() {
		return tApellido;
	}

	public void settApellido(JTextField tApellido) {
		this.tApellido = tApellido;
	}

	public JTextField gettCorreo() {
		return tCorreo;
	}

	public void settCorreo(JTextField tCorreo) {
		this.tCorreo = tCorreo;
	}

	public JTextField gettUsuario() {
		return tUsuario;
	}

	public void settUsuario(JTextField tUsuario) {
		this.tUsuario = tUsuario;
	}

	public JTextField gettDocumento() {
		return tDocumento;
	}

	public void settDocumento(JTextField tDocumento) {
		this.tDocumento = tDocumento;
	}

	public JTextField gettTelefono() {
		return tTelefono;
	}

	public void settTelefono(JTextField tTelefono) {
		this.tTelefono = tTelefono;
	}

	public JTextField gettFacultad() {
		return tFacultad;
	}

	public void settFacultad(JTextField tFacultad) {
		this.tFacultad = tFacultad;
	}

	public JTextField gettCarrera() {
		return tCarrera;
	}

	public void settCarrera(JTextField tCarrera) {
		this.tCarrera = tCarrera;
	}

	public JTextField gettSemestre() {
		return tSemestre;
	}

	public void settSemestre(JTextField tSemestre) {
		this.tSemestre = tSemestre;
	}

	public JPanel getPanelReserva() {
		return panelReserva;
	}

	public void setPanelReserva(JPanel panelReserva) {
		this.panelReserva = panelReserva;
	}

	public JPanel getPanelRuta() {
		return panelRuta;
	}

	public void setPanelRuta(JPanel panelRuta) {
		this.panelRuta = panelRuta;
	}

	public JPanel getInfoCosto() {
		return infoCosto;
	}

	public void setInfoCosto(JPanel infoCosto) {
		this.infoCosto = infoCosto;
	}

	public JLabel getTituloReserva() {
		return tituloReserva;
	}

	public void setTituloReserva(JLabel tituloReserva) {
		this.tituloReserva = tituloReserva;
	}

	public JLabel getFecha() {
		return fecha;
	}

	public void setFecha(JLabel fecha) {
		this.fecha = fecha;
	}

	public JLabel getTransporte() {
		return transporte;
	}

	public void setTransporte(JLabel transporte) {
		this.transporte = transporte;
	}

	public JLabel getRuta() {
		return ruta;
	}

	public void setRuta(JLabel ruta) {
		this.ruta = ruta;
	}

	public JLabel getInfoRuta() {
		return infoRuta;
	}

	public void setInfoRuta(JLabel infoRuta) {
		this.infoRuta = infoRuta;
	}

	public JLabel getCosto() {
		return costo;
	}

	public void setCosto(JLabel costo) {
		this.costo = costo;
	}

	public JRadioButton getrBus() {
		return rBus;
	}

	public void setrBus(JRadioButton rBus) {
		this.rBus = rBus;
	}

	public JRadioButton getrTren() {
		return rTren;
	}

	public void setrTren(JRadioButton rTren) {
		this.rTren = rTren;
	}

	public JRadioButton getrUsaquen() {
		return rUsaquen;
	}

	public void setrUsaquen(JRadioButton rUsaquen) {
		this.rUsaquen = rUsaquen;
	}

	public JRadioButton getrChia() {
		return rChia;
	}

	public void setrChia(JRadioButton rChia) {
		this.rChia = rChia;
	}

	public JButton getPagar() {
		return pagar;
	}

	public void setPagar(JButton pagar) {
		this.pagar = pagar;
	}

	public ButtonGroup getGrupoTransporte() {
		return grupoTransporte;
	}

	public void setGrupoTransporte(ButtonGroup grupoTransporte) {
		this.grupoTransporte = grupoTransporte;
	}

	public ButtonGroup getGrupoRuta() {
		return grupoRuta;
	}

	public void setGrupoRuta(ButtonGroup grupoRuta) {
		this.grupoRuta = grupoRuta;
	}

	public JPanel getCalendario() {
		return calendario;
	}

	public void setCalendario(JPanel calendario) {
		this.calendario = calendario;
	}

	public JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}

	public JDateChooser getCalendar() {
		return calendar;
	}

	public void setCalendar(JDateChooser calendar) {
		this.calendar = calendar;
	}

	public JTextField getPlata() {
		return plata;
	}

	public void setPlata(JTextField plata) {
		this.plata = plata;
	}

	
}

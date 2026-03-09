package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class VentanaDocenteInicio extends JFrame{
	
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
	private JPanel horarioIda;
	private JPanel horarioRegreso;
	private JButton flechaDerechaUno;
	private JButton flechaIzquierdaUno;
	private JButton flechaDerechaDos;
	private JButton flechaIzquierdaDos;
	
	//bus
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
	private JLabel numeroMateria;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tCorreo;
	private JTextField tUsuario;
	private JTextField tDocumento;
	private JTextField tTelefono;
	private JTextField tFacultad;
	private JTextField tNumeroMateria;
	
	
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
	
	public VentanaDocenteInicio() {
		setVisible(false);
		initComp();
	}
	
	public void initComp() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana principal de docente");
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

		titulo = new JLabel("Bienvenido, docente :D");
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
				
		inicio = new JButton("Home");
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
		bBus.setBounds(0, 35, 220, 150);
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

		horarioRegreso = new JPanel();
		horarioRegreso.setLayout(null);
		horarioRegreso.setBounds(175, 140, 772, 485);
		horarioRegreso.setBackground(Color.decode("#f2efe5"));
		horarioRegreso.setVisible(false);
		add(horarioRegreso);
		
		//==IMAGENES==
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
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("flechaatras.png"));
		JLabel labelImagen2 = new JLabel(imagen2);
		flechaIzquierdaUno = new JButton(imagen2);
		flechaIzquierdaUno.setBackground(Color.WHITE);
		flechaIzquierdaUno.setBounds(18, 5, 65, 66);
		flechaIzquierdaUno.setFocusPainted(false);
		flechaIzquierdaUno.setBorderPainted(false);
		horarioIda.add(flechaIzquierdaUno);
		
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("flechaadelante.png"));
		JLabel labelImagen3 = new JLabel(imagen3);
		flechaDerechaDos = new JButton(imagen3);
		flechaDerechaDos.setBackground(Color.WHITE);
		flechaDerechaDos.setBounds(700, 5, 63, 65);
		flechaDerechaDos.setFocusPainted(false);
		flechaDerechaDos.setBorderPainted(false);
		horarioRegreso.add(flechaDerechaDos);
		
		ImageIcon imagen4 = new ImageIcon(getClass().getResource("flechaatras.png"));
		JLabel labelImagen4 = new JLabel(imagen4);
		flechaIzquierdaDos = new JButton(imagen4);
		flechaIzquierdaDos.setBackground(Color.WHITE);
		flechaIzquierdaDos.setBounds(18, 5, 65, 66);
		flechaIzquierdaDos.setFocusPainted(false);
		flechaIzquierdaDos.setBorderPainted(false);
		horarioRegreso.add(flechaIzquierdaDos);

		//==TODO LO DEL BUS==
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
		
		//==IMAGENES==
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
		
		ImageIcon imagen6 = new ImageIcon(getClass().getResource("flechaatras.png"));
		JLabel labelImagen6 = new JLabel(imagen6);
		flechaIzqUnoBus = new JButton(imagen6);
		flechaIzqUnoBus.setBackground(Color.WHITE);
		flechaIzqUnoBus.setBounds(18, 5, 65, 66);
		flechaIzqUnoBus.setFocusPainted(false);
		flechaIzqUnoBus.setBorderPainted(false);
		horarioIdaBus.add(flechaIzqUnoBus);
		
		ImageIcon imagen7 = new ImageIcon(getClass().getResource("flechaadelante.png"));
		JLabel labelImagen7 = new JLabel(imagen7);
		flechaDerDosBus = new JButton(imagen7);
		flechaDerDosBus.setBackground(Color.WHITE);
		flechaDerDosBus.setBounds(700, 5, 63, 65);
		flechaDerDosBus.setFocusPainted(false);
		flechaDerDosBus.setBorderPainted(false);
		horarioRegresoBus.add(flechaDerDosBus);
		
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
		dato.setBounds(95, 20, 250, 35);
		dato.setForeground(Color.BLACK);
		dato.setFont(new Font("Arial", Font.BOLD, 30));
		panelMiPerfil.add(dato);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(30, 90, 150, 25);
		nombre.setFont(new Font("Agency FB", Font.BOLD, 20));
		nombre.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(nombre);

		tNombre = new JTextField();
		tNombre.setBounds(200, 90, 164, 25);
		tNombre.setFont(new Font("Agency FB", Font.BOLD, 20));
		tNombre.setForeground(Color.decode("#111d15"));
		tNombre.setBackground(Color.decode("#e0ebe0"));
		tNombre.setBorder(null);
		panelMiPerfil.add(tNombre);

		apellido = new JLabel("Apellidos:");
		apellido.setBounds(30, 130, 150, 25);
		apellido.setFont(new Font("Agency FB", Font.BOLD, 20));
		apellido.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(apellido);
		
		tApellido = new JTextField();
		tApellido.setBounds(200, 130, 164, 25);
		tApellido.setFont(new Font("Agency FB", Font.BOLD, 20));
		tApellido.setForeground(Color.decode("#111d15"));
		tApellido.setBackground(Color.decode("#e0ebe0"));
		tApellido.setBorder(null);
		panelMiPerfil.add(tApellido);

		correo = new JLabel("Correo Institucional:");
		correo.setBounds(30, 160, 150, 25);
		correo.setFont(new Font("Agency FB", Font.BOLD, 20));
		correo.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(correo);

		tCorreo = new JTextField();
		tCorreo.setBounds(200, 160, 164, 25);
		tCorreo.setFont(new Font("Agency FB", Font.BOLD, 20));
		tCorreo.setForeground(Color.decode("#111d15"));
		tCorreo.setBackground(Color.decode("#e0ebe0"));
		tCorreo.setBorder(null);
		panelMiPerfil.add(tCorreo);
		
		usuario = new JLabel("Usuario Institucional:");
		usuario.setBounds(30, 200, 150, 25);
		usuario.setFont(new Font("Agency FB", Font.BOLD, 20));
		usuario.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(usuario);

		tUsuario = new JTextField();
		tUsuario.setBounds(200, 200, 164, 25);
		tUsuario.setFont(new Font("Agency FB", Font.BOLD, 20));
		tUsuario.setForeground(Color.decode("#111d15"));
		tUsuario.setBackground(Color.decode("#e0ebe0"));
		tUsuario.setBorder(null);
		panelMiPerfil.add(tUsuario);

		documento = new JLabel("Documento de Identidad:");
		documento.setBounds(30, 240, 200, 25);
		documento.setFont(new Font("Agency FB", Font.BOLD, 20));
		documento.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(documento);

		tDocumento = new JTextField();
		tDocumento.setBounds(200, 240, 164, 25);
		tDocumento.setFont(new Font("Agency FB", Font.BOLD, 20));
		tDocumento.setForeground(Color.decode("#111d15"));
		tDocumento.setBackground(Color.decode("#e0ebe0"));
		tDocumento.setBorder(null);
		panelMiPerfil.add(tDocumento);
		
		telefono = new JLabel("Número de teléfono:");
		telefono.setBounds(30, 280, 150, 25);
		telefono.setFont(new Font("Agency FB", Font.BOLD, 20));
		telefono.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(telefono);

		tTelefono = new JTextField();
		tTelefono.setBounds(200, 280, 164, 25);
		tTelefono.setFont(new Font("Agency FB", Font.BOLD, 20));
		tTelefono.setForeground(Color.decode("#111d15"));
		tTelefono.setBackground(Color.decode("#e0ebe0"));
		tTelefono.setBorder(null);
		panelMiPerfil.add(tTelefono);

		facultad = new JLabel("Facultad:");
		facultad.setBounds(30, 320, 150, 25);
		facultad.setFont(new Font("Agency FB", Font.BOLD, 20));
		facultad.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(facultad);
		
		tFacultad = new JTextField();
		tFacultad.setBounds(200, 320, 164, 25);
		tFacultad.setFont(new Font("Agency FB", Font.BOLD, 20));
		tFacultad.setForeground(Color.decode("#111d15"));
		tFacultad.setBackground(Color.decode("#e0ebe0"));
		tFacultad.setBorder(null);
		panelMiPerfil.add(tFacultad);
		
		numeroMateria = new JLabel("Cantidad de materias:");
		numeroMateria.setBounds(30, 360, 150, 25);
		numeroMateria.setFont(new Font("Agency FB", Font.BOLD, 20));
		numeroMateria.setForeground(Color.decode("#111d15"));
		panelMiPerfil.add(numeroMateria);

		tNumeroMateria = new JTextField();
		tNumeroMateria.setBounds(200, 360, 164, 25);
		tNumeroMateria.setFont(new Font("Agency FB", Font.BOLD, 20));
		tNumeroMateria.setForeground(Color.decode("#111d15"));
		tNumeroMateria.setBackground(Color.decode("#e0ebe0"));
		tNumeroMateria.setBorder(null);
		panelMiPerfil.add(tNumeroMateria);

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
		grupoTransporte.add(rUsaquen);
		grupoTransporte.add(rChia);
		
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


}

package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaEstudianteInicio extends JFrame {

	private JLabel titulo;
	private JLabel mensaje;
	private JLabel lTren;
	private JLabel lBus;
	private JLabel lMiReserva;
	
	private JTextArea tMensaje;
	
	private JPanel menuBar;
	private JPanel panelSuperior;
	private JPanel panelUno;
	private JPanel panelDos;
	private JPanel panelTres;
	private JPanel panelCuatro;

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

		panelSuperior = new JPanel();
		panelSuperior.setLayout(null);
		panelSuperior.setBounds(180, 18, 760, 150);
		panelSuperior.setBackground(Color.decode("#6d9a77"));
		// panelSuperior.setBackground(new Color(152, 189, 160, 180));
		// panelSuperior.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(panelSuperior);

		panelUno = new JPanel();
		panelUno.setLayout(null);
		panelUno.setBounds(180, 185, 460, 160);
		panelUno.setBackground(Color.decode("#ffffff"));
		// panelSuperior.setBackground(new Color(152, 189, 160, 180));
		// panelSuperior.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(panelUno);

		panelDos = new JPanel();
		panelDos.setLayout(null);
		panelDos.setBounds(180, 365, 220, 260);
		panelDos.setBackground(Color.decode("#ffffff"));
		// panelSuperior.setBackground(new Color(152, 189, 160, 180));
		// panelSuperior.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(panelDos);
		
		panelTres = new JPanel();
		panelTres.setLayout(null);
		panelTres.setBounds(420, 365, 220, 260);
		panelTres.setBackground(Color.decode("#ffffff"));
		// panelSuperior.setBackground(new Color(152, 189, 160, 180));
		// panelSuperior.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(panelTres);
		
		panelCuatro = new JPanel();
		panelCuatro.setLayout(null);
		panelCuatro.setBounds(660, 185, 274, 440);
		panelCuatro.setBackground(Color.decode("#ffffff"));
		// panelSuperior.setBackground(new Color(152, 189, 160, 180));
		// panelSuperior.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		add(panelCuatro);
		
		//LABELS

		titulo = new JLabel("Bienvenido, estudiante :D");
		titulo.setBounds(20, 20, 650, 55);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		panelSuperior.add(titulo);

		mensaje = new JLabel("Mensajes y alertas");
		mensaje.setBounds(20, 10, 250, 20);
		mensaje.setForeground(Color.BLACK);
		mensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelUno.add(mensaje);
		
		lTren = new JLabel("Horarios del tren");
		lTren.setBounds(45, 235, 250, 20);
		lTren.setForeground(Color.BLACK);
		lTren.setFont(new Font("Arial", Font.BOLD, 16));
		panelDos.add(lTren);
		
		lBus = new JLabel("Horarios de buses");
		lBus.setBounds(40, 235, 250, 20);
		lBus.setForeground(Color.BLACK);
		lBus.setFont(new Font("Arial", Font.BOLD, 16));
		panelTres.add(lBus);
		
		lMiReserva = new JLabel("Mis Reservas");
		lMiReserva.setBounds(90, 10, 250, 20);
		lMiReserva.setForeground(Color.BLACK);
		lMiReserva.setFont(new Font("Arial", Font.BOLD, 16));
		panelCuatro.add(lMiReserva);
		
		tMensaje = new JTextArea();
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

		bTren = new JButton("TREEEN");
		bTren.setBounds(18, 80, 200, 100);
		bTren.setFont(new Font("Agency FB", Font.BOLD, 45));
		bTren.setForeground(Color.decode("#376445"));
		bTren.setBackground(Color.decode("#99bc9f"));
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

		perfil = new JButton("Mi Perfil");
		perfil.setBounds(23, 350, 100, 25);
		perfil.setFont(new Font("Agency FB", Font.BOLD, 20));
		perfil.setForeground(Color.decode("#ffffff"));
		perfil.setBackground(Color.decode("#376445"));
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		menuBar.add(perfil);

		reserva = new JButton("Mis reservas");
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

	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	/*
	 * public JPanel getMenuBar() { return menuBar; }
	 */

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

}

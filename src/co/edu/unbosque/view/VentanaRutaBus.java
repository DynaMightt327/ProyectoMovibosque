package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaRutaBus extends JFrame {

	private JPanel menuBar;
	private JButton inicio;
	private JButton tren;
	private JButton bus;
	private JButton perfil;
	private JButton reserva;
	private JButton salir;

	public VentanaRutaBus() {
		setVisible(false);
		initComps();
	}

	public void initComps() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana horarios del tren");
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

		// ==BOTONES==

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

	/*public JPanel getMenuBar() {
		return menuBar;
	}*/

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

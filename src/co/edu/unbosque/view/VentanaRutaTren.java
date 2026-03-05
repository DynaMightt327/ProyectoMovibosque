package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaRutaTren extends JFrame {

	private JPanel menuBar;
	private JPanel horarioIda;
	private JPanel horarioRegreso;
	
	private JButton inicio;
	private JButton tren;
	private JButton bus;
	private JButton perfil;
	private JButton reserva;
	private JButton salir;
	
	private JButton flechaDerechaUno;
	private JButton flechaIzquierdaUno;
	private JButton flechaDerechaDos;
	private JButton flechaIzquierdaDos;

	public VentanaRutaTren() {
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
		
		horarioIda = new JPanel();
		horarioIda.setLayout(null);
		horarioIda.setBounds(175, 140, 772, 485);
		horarioIda.setBackground(Color.decode("#f2efe5"));
		horarioIda.setVisible(true);
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
		
		//==BOTONES==
		
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

	}

/*	public JPanel getMenuBar() {
		return menuBar;
	}
*/
	public void setMenuBar(JPanel menuBar) {
		this.menuBar = menuBar;
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

}

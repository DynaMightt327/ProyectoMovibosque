package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaIngreso extends JFrame {

	private JLabel titulo;
	private JLabel usuario;
	private JLabel contrasena;
	private JLabel background;

	private JTextField tUsuario;
	private JPasswordField tContrasena;

	private JButton iniciar;
	private JButton volver;
	

	public VentanaIngreso() {
		setVisible(false);
		initComp();
	}

	public void initComp() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana Inicio de sesion");
		this.setBounds(250, 30, 980, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#1d5f3b"));

		// --------- IMAGEN DE FONDO ---------
		ImageIcon backgroundImage = new ImageIcon(getClass().getResource("iniciotita.png"));
		background = new JLabel(backgroundImage);
		background.setBounds(0, 0, 980, 680);
		background.setLayout(null);
		add(background);

		titulo = new JLabel("¡Bienvenido de nuevo!");
		titulo.setBounds(480, 70, 500, 65);
		titulo.setForeground(Color.decode("#FFFFFF"));
		titulo.setFont(new Font("Agency FB", Font.BOLD, 60));
		background.add(titulo);

		usuario = new JLabel("Usuario Institucional:");
		usuario.setBounds(650, 240, 190, 30);
		usuario.setFont(new Font("Agency FB", Font.BOLD, 24));
		usuario.setForeground(Color.decode("#FFFFFF"));
		background.add(usuario);

		contrasena = new JLabel("Contraseña:");
		contrasena.setBounds(650, 340, 150, 30);
		contrasena.setFont(new Font("Agency FB", Font.BOLD, 24));
		contrasena.setForeground(Color.decode("#FFFFFF"));
		background.add(contrasena);

		tUsuario = new JTextField();
		tUsuario.setBounds(650, 280, 180, 35);
		tUsuario.setFont(new Font("Agency FB", Font.BOLD, 15));
		tUsuario.setForeground(Color.decode("#18093E"));
		tUsuario.setBackground(Color.decode("#f2f7f3"));
		tUsuario.setBorder(null);
		background.add(tUsuario);

		tContrasena = new JPasswordField();
		tContrasena.setBounds(650, 380, 180, 35);
		tContrasena.setFont(new Font("Agency FB", Font.BOLD, 15));
		tContrasena.setForeground(Color.decode("#18093E"));
		tContrasena.setBackground(Color.decode("#f2f7f3"));
		tContrasena.setBorder(null);
		background.add(tContrasena);

		// ==BOTONES==
		iniciar = new JButton("INICIAR SESION");
		iniciar.setBounds(652, 470, 168, 45);
		iniciar.setFont(new Font("Agency FB", Font.BOLD, 22));
		iniciar.setForeground(Color.decode("#ffffff"));
		iniciar.setBackground(Color.decode("#376445"));
		iniciar.setBorderPainted(false);
		iniciar.setFocusPainted(false);
		background.add(iniciar);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("flechavolver.JPG"));
		JLabel labelImagen1 = new JLabel(imagen1);
		volver = new JButton(imagen1);
		volver.setBackground(Color.WHITE);
		volver.setBounds(20, 40, 63, 65);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);
		background.add(volver);

	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getContrasena() {
		return contrasena;
	}

	public void setContrasena(JLabel contrasena) {
		this.contrasena = contrasena;
	}

	public JTextField gettUsuario() {
		return tUsuario;
	}

	public void settUsuario(JTextField tUsuario) {
		this.tUsuario = tUsuario;
	}

	public JPasswordField gettContrasena() {
		return tContrasena;
	}

	public void settContrasena(JPasswordField tContrasena) {
		this.tContrasena = tContrasena;
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

}

package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInicial extends JFrame {

	private JLabel titulo;
	private JButton iniciarSesion;
	private JButton registrar;
	
	public VentanaInicial() {
		initComp();
		setVisible(true);
	}

	public void initComp() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana Inicial");
		this.setBounds(250, 30, 980, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#1D7486"));
		
		titulo = new JLabel("MOVIBOSQUE");
		titulo.setBounds(80, 230, 590, 125);
		titulo.setForeground(Color.decode("#FFFFFF"));
		titulo.setFont(new Font("Agency FB", Font.BOLD, 120));
		add(titulo);
		
		iniciarSesion = new JButton("REGISTRARSE");
		iniciarSesion.setBounds(155, 440, 170, 50);
		iniciarSesion.setFont(new Font("Agency FB", Font.BOLD, 22));
		iniciarSesion.setBackground(Color.decode("#8DC1CE"));
		iniciarSesion.setForeground(Color.decode("#152C32"));
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		add(iniciarSesion);
		
		registrar = new JButton("INICIAR SESION");
		registrar.setBounds(360, 440, 170, 50);
		registrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		registrar.setBackground(Color.decode("#8DC1CE"));
		registrar.setForeground(Color.decode("#152C32"));
		registrar.setBorderPainted(false);
		registrar.setFocusPainted(false);
		add(registrar);
		
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JButton getIniciarSesion() {
		return iniciarSesion;
	}

	public void setIniciarSesion(JButton iniciarSesion) {
		this.iniciarSesion = iniciarSesion;
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}

	
}

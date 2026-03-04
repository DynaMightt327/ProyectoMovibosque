package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInicial extends JFrame {

	private JLabel titulo;
	private JButton iniciarSesion;
	private JButton registrar;
	
	private JLabel tita;
	
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
		this.getContentPane().setBackground(Color.decode("#99bc9f"));
		//this.getContentPane().setBackground(Color.decode("#FFFFFF"));
		
		ImageIcon titaImage = new ImageIcon(getClass().getResource("movibosque.png"));
		tita = new JLabel(titaImage);
		tita.setBounds(0,-60, 980, 680);
		tita.setLayout(null);
		add(tita);
		
		titulo = new JLabel("sistema de transporte universitario");
		titulo.setBounds(250, 500, 500, 45);
		titulo.setForeground(Color.decode("#f1fcf5"));
		titulo.setFont(new Font("Agency FB", Font.BOLD, 40));
		tita.add(titulo);
		
		iniciarSesion = new JButton("INICIAR SESIÓN");
		iniciarSesion.setBounds(300, 565, 170, 50);
		iniciarSesion.setFont(new Font("Agency FB", Font.BOLD, 22));
		iniciarSesion.setForeground(Color.decode("#ffffff"));
		iniciarSesion.setBackground(Color.decode("#376445"));
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		tita.add(iniciarSesion);
		
		registrar = new JButton("REGISTRAR");
		registrar.setBounds(520, 565, 170, 50);
		registrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		registrar.setForeground(Color.decode("#ffffff"));
		registrar.setBackground(Color.decode("#376445"));
		registrar.setBorderPainted(false);
		registrar.setFocusPainted(false);
		tita.add(registrar);
		
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

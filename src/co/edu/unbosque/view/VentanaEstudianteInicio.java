package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEstudianteInicio extends JFrame {
	
	private JLabel titulo;

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
		this.getContentPane().setBackground(Color.decode("#1d5f3b"));
		
		
		titulo = new JLabel("Estudiante");
		titulo.setBounds(100, 100, 500, 55);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		add(titulo);
		

	}
}

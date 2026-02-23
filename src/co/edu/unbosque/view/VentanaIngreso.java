package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaIngreso extends JFrame{

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
				this.getContentPane().setBackground(Color.decode("#1D7486"));
	}
}

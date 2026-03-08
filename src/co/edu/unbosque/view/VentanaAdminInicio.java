package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaAdminInicio extends JFrame {

	public VentanaAdminInicio() {
		setVisible(false);
		initComps();
	}

	public void initComps() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana principal de administrativo");
		this.setBounds(250, 30, 980, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#99bc9f"));
	}

}

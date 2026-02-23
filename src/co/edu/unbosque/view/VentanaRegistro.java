package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {
	
	private JPanel panelCentral;
	
	private JLabel titulo;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel correo;
	private JLabel usuario;
	private JLabel documento;
	private JLabel telefono;
	private JLabel contrasena;
	private JLabel rol;
	
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tCorreo;
	private JTextField tUsuario;
	private JTextField tDocumento;
	private JTextField tTelefono;
	private JTextField tContrasena;
	private JTextField tRol;
	
	private JButton bVolver;
	private JButton bRegistrar;
	

	public VentanaRegistro() {
		setVisible(false);
		initComp();
	}

	public void initComp() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("MoviBosque - Ventana registro usuario");
		this.setBounds(250, 30, 980, 680);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#1D7486"));
		
		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(20, 20, 490, 600);
		panelCentral.setBackground(Color.decode("#FFFFFF"));
		add(panelCentral);
		
		//==LABELS==
		
		titulo = new JLabel("¡Crea tu cuenta aquí!");
		titulo.setBounds(26, 20, 500, 65);
		titulo.setForeground(Color.decode("#000000"));
		titulo.setFont(new Font("Agency FB", Font.BOLD, 60));
		panelCentral.add(titulo);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(30, 100, 150, 30);
		nombre.setFont(new Font("Agency FB", Font.BOLD, 22));
		nombre.setForeground(Color.decode("#18093E"));
		panelCentral.add(nombre);
		
		apellido = new JLabel("Apellidos:");
		apellido.setBounds(270, 100, 150, 30);
		apellido.setFont(new Font("Agency FB", Font.BOLD, 22));
		apellido.setForeground(Color.decode("#18093E"));
		panelCentral.add(apellido);
		
		correo = new JLabel("Correo Institucional:");
		correo.setBounds(30, 180, 150, 30);
		correo.setFont(new Font("Agency FB", Font.BOLD, 22));
		correo.setForeground(Color.decode("#18093E"));
		panelCentral.add(correo);
		
		usuario = new JLabel("Usuario Institucional:");
		usuario.setBounds(270, 180, 150, 30);
		usuario.setFont(new Font("Agency FB", Font.BOLD, 22));
		usuario.setForeground(Color.decode("#18093E"));
		panelCentral.add(usuario);

		documento = new JLabel("Documento de Identidad:");
		documento.setBounds(30, 260, 200, 30);
		documento.setFont(new Font("Agency FB", Font.BOLD, 22));
		documento.setForeground(Color.decode("#18093E"));
		panelCentral.add(documento);
		
		telefono = new JLabel("Número de teléfono:");
		telefono.setBounds(270, 260, 150, 30);
		telefono.setFont(new Font("Agency FB", Font.BOLD, 22));
		telefono.setForeground(Color.decode("#18093E"));
		panelCentral.add(telefono);
		
		contrasena = new JLabel("Contraseña:");
		contrasena.setBounds(30, 340, 150, 30);
		contrasena.setFont(new Font("Agency FB", Font.BOLD, 22));
		contrasena.setForeground(Color.decode("#18093E"));
		panelCentral.add(contrasena);
		
		rol = new JLabel("Rol Institucional:");
		rol.setBounds(270, 340, 150, 30);
		rol.setFont(new Font("Agency FB", Font.BOLD, 22));
		rol.setForeground(Color.decode("#18093E"));
		panelCentral.add(rol);
		
		//==CAMPOS DE TEXTO==
		tNombre = new JTextField();
		tNombre.setBounds(30, 130, 164, 25);
		tNombre.setFont(new Font("Agency FB", Font.BOLD, 15));
		tNombre.setForeground(Color.decode("#18093E"));
		//tNombre.setBorder(null);
		panelCentral.add(tNombre);
		
		tApellido = new JTextField();
		tApellido.setBounds(270, 130, 164, 28);
		tApellido.setFont(new Font("Agency FB", Font.BOLD, 15));
		tApellido.setForeground(Color.decode("#18093E"));
		//tApellido.setBorder(null);
		panelCentral.add(tApellido);
		
		tCorreo = new JTextField();
		tCorreo.setBounds(30, 210, 164, 28);
		tCorreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		tCorreo.setForeground(Color.decode("#18093E"));
		//tCorreo.setBorder(null);
		panelCentral.add(tCorreo);
		
		tUsuario = new JTextField();
		tUsuario.setBounds(270, 210, 164, 28);
		tUsuario.setFont(new Font("Agency FB", Font.BOLD, 15));
		tUsuario.setForeground(Color.decode("#18093E"));
		//tUsuario.setBorder(null);
		panelCentral.add(tUsuario);
		
		tDocumento = new JTextField();
		tDocumento.setBounds(30, 290, 164, 28);
		tDocumento.setFont(new Font("Agency FB", Font.BOLD, 15));
		tDocumento.setForeground(Color.decode("#18093E"));
		//tDocumento.setBorder(null);
		panelCentral.add(tDocumento);
		
		tTelefono = new JTextField();
		tTelefono.setBounds(270, 290, 164, 28);
		tTelefono.setFont(new Font("Agency FB", Font.BOLD, 15));
		tTelefono.setForeground(Color.decode("#18093E"));
		//tTelefono.setBorder(null);
		panelCentral.add(tTelefono);
		
		tContrasena = new JTextField();
		tContrasena.setBounds(30, 370, 164, 28);
		tContrasena.setFont(new Font("Agency FB", Font.BOLD, 15));
		tContrasena.setForeground(Color.decode("#18093E"));
		//tContrasena.setBorder(null);
		panelCentral.add(tContrasena);
		
		tRol = new JTextField();
		tRol.setBounds(270, 370, 164, 28);
		tRol.setFont(new Font("Agency FB", Font.BOLD, 15));
		tRol.setForeground(Color.decode("#18093E"));
		//tRol.setBorder(null);
		panelCentral.add(tRol);
		
		//==BOTONES==
		bVolver = new JButton("VOLVER");
		bVolver.setBounds(60, 450, 130, 40);
		bVolver.setFont(new Font("Agency FB", Font.BOLD, 22));
		bVolver.setBackground(Color.decode("#130344"));
		bVolver.setForeground(Color.decode("#ECE7FE"));
		bVolver.setBorderPainted(false);
		bVolver.setFocusPainted(false);
		panelCentral.add(bVolver);
		
		bRegistrar = new JButton("GUARDAR");
		bRegistrar.setBounds(280, 450, 130, 40);
		bRegistrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		bRegistrar.setBackground(Color.decode("#130344"));
		bRegistrar.setForeground(Color.decode("#ECE7FE"));
		bRegistrar.setBorderPainted(false);
		bRegistrar.setFocusPainted(false);
		panelCentral.add(bRegistrar);


	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}

	public JLabel getCorreo() {
		return correo;
	}

	public void setCorreo(JLabel correo) {
		this.correo = correo;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getDocumento() {
		return documento;
	}

	public void setDocumento(JLabel documento) {
		this.documento = documento;
	}

	public JLabel getTelefono() {
		return telefono;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

	public JLabel getContrasena() {
		return contrasena;
	}

	public void setContrasena(JLabel contrasena) {
		this.contrasena = contrasena;
	}

	public JLabel getRol() {
		return rol;
	}

	public void setRol(JLabel rol) {
		this.rol = rol;
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public void settNombre(JTextField tNombre) {
		this.tNombre = tNombre;
	}

	public JTextField gettApellido() {
		return tApellido;
	}

	public void settApellido(JTextField tApellido) {
		this.tApellido = tApellido;
	}

	public JTextField gettCorreo() {
		return tCorreo;
	}

	public void settCorreo(JTextField tCorreo) {
		this.tCorreo = tCorreo;
	}

	public JTextField gettUsuario() {
		return tUsuario;
	}

	public void settUsuario(JTextField tUsuario) {
		this.tUsuario = tUsuario;
	}

	public JTextField gettDocumento() {
		return tDocumento;
	}

	public void settDocumento(JTextField tDocumento) {
		this.tDocumento = tDocumento;
	}

	public JTextField gettTelefono() {
		return tTelefono;
	}

	public void settTelefono(JTextField tTelefono) {
		this.tTelefono = tTelefono;
	}

	public JTextField gettContrasena() {
		return tContrasena;
	}

	public void settContrasena(JTextField tContrasena) {
		this.tContrasena = tContrasena;
	}

	public JTextField gettRol() {
		return tRol;
	}

	public void settRol(JTextField tRol) {
		this.tRol = tRol;
	}

	public JButton getbVolver() {
		return bVolver;
	}

	public void setbVolver(JButton bVolver) {
		this.bVolver = bVolver;
	}

	public JButton getbRegistrar() {
		return bRegistrar;
	}

	public void setbRegistrar(JButton bRegistrar) {
		this.bRegistrar = bRegistrar;
	}

}

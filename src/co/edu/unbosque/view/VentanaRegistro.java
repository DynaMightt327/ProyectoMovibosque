package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
	private JLabel facultad;
	private JLabel rol;
	private JLabel carrera;
	private JLabel semestre;
	private JLabel numMateria;
	private JLabel annoServicio;
	
	private JLabel background;

	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tCorreo;
	private JTextField tUsuario;
	private JTextField tDocumento;
	private JTextField tTelefono;
	private JPasswordField tContrasena;
	private JComboBox<String> tFacultad;
	private JComboBox<String> tRol;
	private JTextField tCarrera;
	private JTextField tSemestre;
	private JTextField tNumMateria;
	private JTextField tAnnoServicio;

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
		this.getContentPane().setBackground(Color.decode("#1d5f3b"));

		// --------- IMAGEN DE FONDO ---------
		ImageIcon backgroundImage = new ImageIcon(getClass().getResource("trenueb.png"));
		background = new JLabel(backgroundImage);
		background.setBounds(0, 0, 980, 680);
		background.setLayout(null);
		add(background);
		
		//==PANEL==
		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(20, 20, 490, 600);
		// panelCentral.setBackground(Color.decode("#98bda0"));
		panelCentral.setBackground(new Color(152, 189, 160, 150));
		// panelCentral.setOpaque(false); -> por alguna razón, no me funciona bien? :|
		background.add(panelCentral);


		// ==LABELS==

		titulo = new JLabel("¡Crea tu cuenta aquí!");
		titulo.setBounds(26, 20, 500, 65);
		titulo.setForeground(Color.decode("#111d15"));
		titulo.setFont(new Font("Agency FB", Font.BOLD, 60));
		panelCentral.add(titulo);

		nombre = new JLabel("Nombre:");
		nombre.setBounds(30, 100, 150, 30);
		nombre.setFont(new Font("Agency FB", Font.BOLD, 22));
		nombre.setForeground(Color.decode("#111d15"));
		panelCentral.add(nombre);

		apellido = new JLabel("Apellidos:");
		apellido.setBounds(270, 100, 150, 30);
		apellido.setFont(new Font("Agency FB", Font.BOLD, 22));
		apellido.setForeground(Color.decode("#111d15"));
		panelCentral.add(apellido);

		correo = new JLabel("Correo Institucional:");
		correo.setBounds(30, 180, 150, 30);
		correo.setFont(new Font("Agency FB", Font.BOLD, 22));
		correo.setForeground(Color.decode("#111d15"));
		panelCentral.add(correo);

		usuario = new JLabel("Usuario Institucional:");
		usuario.setBounds(270, 180, 150, 30);
		usuario.setFont(new Font("Agency FB", Font.BOLD, 22));
		usuario.setForeground(Color.decode("#111d15"));
		panelCentral.add(usuario);

		documento = new JLabel("Documento de Identidad:");
		documento.setBounds(30, 260, 200, 30);
		documento.setFont(new Font("Agency FB", Font.BOLD, 22));
		documento.setForeground(Color.decode("#111d15"));
		panelCentral.add(documento);

		telefono = new JLabel("Número de teléfono:");
		telefono.setBounds(270, 260, 150, 30);
		telefono.setFont(new Font("Agency FB", Font.BOLD, 22));
		telefono.setForeground(Color.decode("#111d15"));
		panelCentral.add(telefono);

		contrasena = new JLabel("Contraseña:");
		contrasena.setBounds(30, 340, 150, 30);
		contrasena.setFont(new Font("Agency FB", Font.BOLD, 22));
		contrasena.setForeground(Color.decode("#111d15"));
		panelCentral.add(contrasena);

		facultad = new JLabel("Facultad:");
		facultad.setBounds(270, 340, 150, 30);
		facultad.setFont(new Font("Agency FB", Font.BOLD, 22));
		facultad.setForeground(Color.decode("#111d15"));
		panelCentral.add(facultad);

		rol = new JLabel("Rol Institucional:");
		rol.setBounds(30, 420, 150, 30);
		rol.setFont(new Font("Agency FB", Font.BOLD, 22));
		rol.setForeground(Color.decode("#111d15"));
		panelCentral.add(rol);

		carrera = new JLabel("Carrera:");
		carrera.setBounds(270, 420, 150, 30);
		carrera.setFont(new Font("Agency FB", Font.BOLD, 22));
		carrera.setForeground(Color.decode("#111d15"));
		panelCentral.add(carrera);
		
		numMateria = new JLabel("Número de materias:");
		numMateria.setBounds(270, 420, 150, 30);
		numMateria.setFont(new Font("Agency FB", Font.BOLD, 22));
		numMateria.setForeground(Color.decode("#111d15"));
		panelCentral.add(numMateria);

		semestre = new JLabel("Semestre:");
		semestre.setBounds(30, 500, 150, 30);
		semestre.setFont(new Font("Agency FB", Font.BOLD, 22));
		semestre.setForeground(Color.decode("#111d15"));
		panelCentral.add(semestre);

		annoServicio = new JLabel("Años de servicio:");
		annoServicio.setBounds(30, 500, 150, 30);
		annoServicio.setFont(new Font("Agency FB", Font.BOLD, 22));
		annoServicio.setForeground(Color.decode("#111d15"));
		panelCentral.add(annoServicio);

		// ==CAMPOS DE TEXTO==
		tNombre = new JTextField();
		tNombre.setBounds(30, 130, 164, 32);
		tNombre.setFont(new Font("Agency FB", Font.BOLD, 18));
		tNombre.setForeground(Color.decode("#111d15"));
		tNombre.setBackground(Color.decode("#376445"));
		tNombre.setBorder(null);
		panelCentral.add(tNombre);

		tApellido = new JTextField();
		tApellido.setBounds(270, 130, 164, 32);
		tApellido.setFont(new Font("Agency FB", Font.BOLD, 18));
		tApellido.setForeground(Color.decode("#111d15"));
		tApellido.setBackground(Color.decode("#376445"));
		tApellido.setBorder(null);
		panelCentral.add(tApellido);

		tCorreo = new JTextField();
		tCorreo.setBounds(30, 210, 164, 32);
		tCorreo.setFont(new Font("Agency FB", Font.BOLD, 18));
		tCorreo.setForeground(Color.decode("#111d15"));
		tCorreo.setBackground(Color.decode("#376445"));
		tCorreo.setBorder(null);
		panelCentral.add(tCorreo);

		tUsuario = new JTextField();
		tUsuario.setBounds(270, 210, 164, 32);
		tUsuario.setFont(new Font("Agency FB", Font.BOLD, 18));
		tUsuario.setForeground(Color.decode("#111d15"));
		tUsuario.setBackground(Color.decode("#376445"));
		tUsuario.setBorder(null);
		panelCentral.add(tUsuario);

		tDocumento = new JTextField();
		tDocumento.setBounds(30, 290, 164, 32);
		tDocumento.setFont(new Font("Agency FB", Font.BOLD, 18));
		tDocumento.setForeground(Color.decode("#111d15"));
		tDocumento.setBackground(Color.decode("#376445"));
		tDocumento.setBorder(null);
		panelCentral.add(tDocumento);

		tTelefono = new JTextField();
		tTelefono.setBounds(270, 290, 164, 32);
		tTelefono.setFont(new Font("Agency FB", Font.BOLD, 18));
		tTelefono.setForeground(Color.decode("#111d15"));
		tTelefono.setBackground(Color.decode("#376445"));
		tTelefono.setBorder(null);
		panelCentral.add(tTelefono);

		tContrasena = new JPasswordField();
		tContrasena.setBounds(30, 370, 164, 32);
		tContrasena.setFont(new Font("Agency FB", Font.BOLD, 18));
		tContrasena.setForeground(Color.decode("#111d15"));
		tContrasena.setBackground(Color.decode("#376445"));
		tContrasena.setBorder(null);
		panelCentral.add(tContrasena);

		tFacultad = new JComboBox<String>(
				new String[] { "...", "Ingeniería", "Medicina", "Artes", "Matemáticas", "Otra" });
		tFacultad.setBounds(270, 370, 164, 32);
		tFacultad.setFont(new Font("Agency FB", Font.BOLD, 18));
		tFacultad.setForeground(Color.decode("#111d15"));
		tFacultad.setBackground(Color.decode("#376445"));
		tFacultad.setBorder(null);
		panelCentral.add(tFacultad);

		tRol = new JComboBox<String>(new String[] { "...", "Estudiante", "Docente", "Administrativo" });
		tRol.setBounds(30, 450, 164, 32);
		tRol.setFont(new Font("Agency FB", Font.BOLD, 18));
		tRol.setForeground(Color.decode("#111d15"));
		tRol.setBackground(Color.decode("#376445"));
		tRol.setBorder(null);
		panelCentral.add(tRol);

		tCarrera = new JTextField();
		tCarrera.setBounds(270, 450, 164, 32);
		tCarrera.setFont(new Font("Agency FB", Font.BOLD, 18));
		tCarrera.setForeground(Color.decode("#111d15"));
		tCarrera.setBackground(Color.decode("#376445"));
		tCarrera.setBorder(null);
		panelCentral.add(tCarrera);

		tNumMateria = new JTextField();
		tNumMateria.setBounds(270, 450, 164, 32);
		tNumMateria.setFont(new Font("Agency FB", Font.BOLD, 18));
		tNumMateria.setForeground(Color.decode("#111d15"));
		tNumMateria.setBackground(Color.decode("#376445"));
		tNumMateria.setBorder(null);
		panelCentral.add(tNumMateria);

		tSemestre = new JTextField();
		tSemestre.setBounds(30, 530, 164, 32);
		tSemestre.setFont(new Font("Agency FB", Font.BOLD, 18));
		tSemestre.setForeground(Color.decode("#111d15"));
		tSemestre.setBackground(Color.decode("#376445"));
		tSemestre.setBorder(null);
		panelCentral.add(tSemestre);
		
		tAnnoServicio = new JTextField();
		tAnnoServicio.setBounds(30, 530, 164, 32);
		tAnnoServicio.setFont(new Font("Agency FB", Font.BOLD, 18));
		tAnnoServicio.setForeground(Color.decode("#111d15"));
		tAnnoServicio.setBackground(Color.decode("#376445"));
		tAnnoServicio.setBorder(null);
		panelCentral.add(tAnnoServicio);

		// ==BOTONES==
		bVolver = new JButton("VOLVER");
		bVolver.setBounds(580, 580, 130, 40);
		bVolver.setFont(new Font("Agency FB", Font.BOLD, 22));
		bVolver.setBackground(Color.decode("#ECE7FE"));
		bVolver.setForeground(Color.decode("#376445"));
		bVolver.setBorderPainted(false);
		bVolver.setFocusPainted(false);
		background.add(bVolver);

		bRegistrar = new JButton("GUARDAR");
		bRegistrar.setBounds(730, 580, 130, 40);
		bRegistrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		bRegistrar.setBackground(Color.decode("#ECE7FE"));
		bRegistrar.setForeground(Color.decode("#376445"));
		bRegistrar.setBorderPainted(false);
		bRegistrar.setFocusPainted(false);
		background.add(bRegistrar);

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

	public void settContrasena(JPasswordField tContrasena) {
		this.tContrasena = tContrasena;
	}

	public JComboBox<String> gettRol() {
		return tRol;
	}

	public void settRol(JComboBox<String> tRol) {
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

	public JLabel getFacultad() {
		return facultad;
	}

	public void setFacultad(JLabel facultad) {
		this.facultad = facultad;
	}

	public JComboBox<String> gettFacultad() {
		return tFacultad;
	}

	public void settFacultad(JComboBox<String> tFacultad) {
		this.tFacultad = tFacultad;
	}

	public JLabel getCarrera() {
		return carrera;
	}

	public void setCarrera(JLabel carrera) {
		this.carrera = carrera;
	}

	public JLabel getSemestre() {
		return semestre;
	}

	public void setSemestre(JLabel semestre) {
		this.semestre = semestre;
	}

	public JTextField gettCarrera() {
		return tCarrera;
	}

	public void settCarrera(JTextField tCarrera) {
		this.tCarrera = tCarrera;
	}

	public JTextField gettSemestre() {
		return tSemestre;
	}

	public void settSemestre(JTextField tSemestre) {
		this.tSemestre = tSemestre;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JLabel getNumMateria() {
		return numMateria;
	}

	public void setNumMateria(JLabel numMateria) {
		this.numMateria = numMateria;
	}

	public JTextField gettNumMateria() {
		return tNumMateria;
	}

	public void settNumMateria(JTextField tNumMateria) {
		this.tNumMateria = tNumMateria;
	}

	public JLabel getAnnoServicio() {
		return annoServicio;
	}

	public void setAnnoServicio(JLabel annoServicio) {
		this.annoServicio = annoServicio;
	}

	public JTextField gettAnnoServicio() {
		return tAnnoServicio;
	}

	public void settAnnoServicio(JTextField tAnnoServicio) {
		this.tAnnoServicio = tAnnoServicio;
	}

	
}

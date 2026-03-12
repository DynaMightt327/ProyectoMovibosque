package co.edu.unbosque.model;

public class Reserva {
	
	private int id;
	private long idPersona;
	private String rolPersona; // "Estudiante", "Docente", "Administrativo"
	private int idViaje;
	private int cantidad;
	private long costoUnitario;
	private long costoTotal;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(int id, long idPersona, String rolPersona, int idViaje, int cantidad, long costoUnitario,
			long costoTotal) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.rolPersona = rolPersona;
		this.idViaje = idViaje;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.costoTotal = costoTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getRolPersona() {
		return rolPersona;
	}

	public void setRolPersona(String rolPersona) {
		this.rolPersona = rolPersona;
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(long costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public long getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(long costoTotal) {
		this.costoTotal = costoTotal;
	}
	

	@Override
	public String toString() {
		return "Reserva #" + id + " | Persona: " + idPersona + " (" + rolPersona + ")" + " | Viaje: " + idViaje
				+ " | Cantidad: " + cantidad + " | Costo total: " + costoTotal;
	}
}

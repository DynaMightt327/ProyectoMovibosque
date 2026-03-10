package co.edu.unbosque.model;

public class Viaje {
	
	private int id;
	private String tipoTransporte;
	private String tipoRecorrido;
	private String horaSalida;
	
	private final int capacidad = 40;
	private int asientoDisponible;
	
	public Viaje() {
		// TODO Auto-generated constructor stub
	}

	public Viaje(int id, String tipoTransporte, String tipoRecorrido, String horaSalida, int asientoDisponible) {
		super();
		this.id = id;
		this.tipoTransporte = tipoTransporte;
		this.tipoRecorrido = tipoRecorrido;
		this.horaSalida = horaSalida;
		this.asientoDisponible = asientoDisponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getTipoRecorrido() {
		return tipoRecorrido;
	}

	public void setTipoRecorrido(String tipoRecorrido) {
		this.tipoRecorrido = tipoRecorrido;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getAsientoDisponible() {
		return asientoDisponible;
	}

	public void setAsientoDisponible(int asientosDisponibles) {
		this.asientoDisponible = asientosDisponibles;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	public boolean reservaAsiento(int cantidad) {
		if(cantidad <=0) {
			return false;
		}
		if(cantidad > asientoDisponible) {
			return false;
		}
		asientoDisponible -= cantidad;
		return true;
	}

}

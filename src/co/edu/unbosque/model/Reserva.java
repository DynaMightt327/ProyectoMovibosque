package co.edu.unbosque.model;

public class Reserva {
	
	private int idReserva;
	private long idUsuario;
	private String rol;
	private String tipoTransporte;
	private String ruta;
	private String fecha;
	private double costoBase;
	private double descuento;
	private double totalPagar;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(int idReserva, long idUsuario, String rol, String tipoTransporte, String ruta, String fecha,
			double costoBase, double descuento, double totalPagar) {
		super();
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.tipoTransporte = tipoTransporte;
		this.ruta = ruta;
		this.fecha = fecha;
		this.costoBase = costoBase;
		this.descuento = descuento;
		this.totalPagar = totalPagar;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(double costoBase) {
		this.costoBase = costoBase;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	@Override
	public String toString() {
		return "Reserva: id de la reserva: " + idReserva + "\nid del usuario: " + idUsuario + "\nrol: " + rol + "\ntipo de transporte: "
				+ tipoTransporte + "\nruta: " + ruta + "\nfecha=" + fecha + "\ncosto Base: " + costoBase + "\ndescuento: "
				+ descuento + "\ntotal de Pago: " + totalPagar;
	}
	
	

}

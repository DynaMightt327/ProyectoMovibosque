package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Reserva;

public class ReservaDAO implements DAO<Reserva> {

	private ArrayList<Reserva> listaReservas;
	private int contadorId;
	private int cupoBus;
	private int cupoTren;
	
	public ReservaDAO() {
		listaReservas = new ArrayList<>();
		contadorId = 1;
		cupoBus = 40;
		cupoTren = 200;
		
	}
		public int generarId() {
			int idActual = contadorId;
			contadorId = contadorId + 1;
			return idActual;
	}
		
		public boolean hayCupo(String tipo, String ruta, String fechaTexto) {
			
			int usado = 0;
			int limite = 0;
			
			int i = 0;
			while (i < listaReservas.size()) {
				Reserva r = listaReservas.get(i);
				if(r.getTipoTransporte().equalsIgnoreCase(tipo) && r.getRuta().equalsIgnoreCase(ruta) && r.getFecha().equalsIgnoreCase(fechaTexto)) {
					usado = usado + 1;
				}
				i++;
			}
			if(tipo.equalsIgnoreCase("Bus")) {
				limite = cupoBus;
			} else {
				limite = cupoTren;
			}
			if(usado < limite) {
				return true;
			} else {
				return false;
			}
			
		}
		
		public ArrayList<Reserva> listaPorUsuario(long idUsuario) {
			ArrayList<Reserva> resultado = new ArrayList<Reserva>();
			int i = 0;
			while (i < listaReservas.size()) {
				Reserva r = listaReservas.get(i);
				if(r.getIdUsuario() == idUsuario) {
					resultado.add(r);
				}
				i++;
			}
			return resultado;
		}
	
	@Override
	public void crear(Reserva nuevoDato) {
		listaReservas.add(nuevoDato);
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index < 0 || index >= listaReservas.size()) {
			return false;
		}
		listaReservas.remove(index);
		return true;

	}

	@Override
	public boolean actualizar(int index, Reserva datoActualizado) {
		if (index < 0 || index >= listaReservas.size()) {
			return false;
		}
		listaReservas.set(index, datoActualizado);
		return true;
	}

	@Override
	public String mostrar() {
		String texto = "";
		int i = 0;
		while (i < listaReservas.size()) {
			Reserva r = listaReservas.get(i);
			texto = texto + "Reserva #: " + r.getIdReserva() + "/n";
			i++;
		}
		return texto;
	}

	@Override
	public String mostrar(int index) {
		if (index < 0 || index >= listaReservas.size()) {
			return "No existe";
		}
		Reserva r = listaReservas.get(index);
		return "Reserva #: " + r.getIdReserva();
	}

	@Override
	public ArrayList<Reserva> mostrarTodo() {
		return listaReservas;
	}

}

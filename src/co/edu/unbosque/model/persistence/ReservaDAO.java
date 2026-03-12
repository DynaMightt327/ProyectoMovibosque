package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Reserva;

public class ReservaDAO implements DAO<Reserva>{

	private ArrayList<Reserva> listaReservas;
	private long totalRecaudado;
	
	public ReservaDAO() {
		listaReservas = new ArrayList<>();
		totalRecaudado = 0;
	}
	
	
	@Override
	public void crear(Reserva nuevoDato) {
		if (nuevoDato != null) {
			listaReservas.add(nuevoDato);
			totalRecaudado = totalRecaudado + nuevoDato.getCostoTotal();
		}
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaReservas.size()) {
			Reserva r = listaReservas.remove(index);
			if (r != null) {
				totalRecaudado = totalRecaudado - r.getCostoTotal();
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizar(int index, Reserva datoActualizado) {
		if (index >= 0 && index < listaReservas.size() && datoActualizado != null) {
			Reserva anterior = listaReservas.get(index);
			totalRecaudado = totalRecaudado - anterior.getCostoTotal();
			listaReservas.set(index, datoActualizado);
			totalRecaudado = totalRecaudado + datoActualizado.getCostoTotal();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		String texto = "";
		for (int i = 0; i < listaReservas.size(); i++) {
			Reserva r = listaReservas.get(i);
			texto = texto + r.toString() + "\n";
		}
		return texto;
	}

	@Override
	public String mostrar(int index) {
		if (index >= 0 && index < listaReservas.size()) {
			Reserva r = listaReservas.get(index);
			return r.toString();
		}
		return "Índice fuera de rango.";
	}

	@Override
	public ArrayList<Reserva> mostrarTodo() {
		return listaReservas;
	}

}

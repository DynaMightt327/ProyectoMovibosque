package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Viaje;

public class ViajeDAO implements DAO<Viaje>{

	private ArrayList<Viaje> listaViajes;
	
	public ViajeDAO() {
		listaViajes = new ArrayList<>();
		inicializarViaje();
	}
	
	public void inicializarViaje() {
		int id = 1;
		
		/*listaViajes.add(new Viaje(id++, "TREN", "IDA", "07:00"));
		listaViajes.add(new Viaje(id++, "TREN", "IDA", "08:00"));
		listaViajes.add(new Viaje(id++, "TREN", "IDA", "09:00"));

		listaViajes.add(new Viaje(id++, "TREN", "REGRESO", "12:00"));
		listaViajes.add(new Viaje(id++, "TREN", "REGRESO", "14:00"));

		listaViajes.add(new Viaje(id++, "BUS", "IDA", "06:30"));
		listaViajes.add(new Viaje(id++, "BUS", "IDA", "07:30"));

		listaViajes.add(new Viaje(id++, "BUS", "REGRESO", "17:00"));
		listaViajes.add(new Viaje(id++, "BUS", "REGRESO", "18:00"));*/

	}
	
	
	
	@Override
	public void crear(Viaje nuevoDato) {
		listaViajes.add(nuevoDato);
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaViajes.size()) {
			listaViajes.remove(index);
			return true;
		}
		return false;

	}

	@Override
	public boolean actualizar(int index, Viaje datoActualizado) {
		if (index >= 0 && index < listaViajes.size()) {
			listaViajes.set(index, datoActualizado);
			return true;
		}
		return false;

	}

	@Override
	public String mostrar() {
		String texto = "";
		for (int i = 0; i < listaViajes.size(); i++) {
			Viaje v = listaViajes.get(i);
			texto = texto + "ID: " + v.getId() + " | Transporte: " + v.getTipoTransporte() + " | Recorrido: "
					+ v.getTipoRecorrido() + " | Hora: " + v.getHoraSalida() + " | Cupos: " + v.getAsientoDisponible()
					+ "\n";
		}
		return texto;
	}

	@Override
	public String mostrar(int index) {
		if (index >= 0 && index < listaViajes.size()) {
			Viaje v = listaViajes.get(index);
			return "ID: " + v.getId() + " | Transporte: " + v.getTipoTransporte() + " | Recorrido: "
					+ v.getTipoRecorrido() + " | Hora: " + v.getHoraSalida() + " | Cupos: "
					+ v.getAsientoDisponible();
		}
		return "Índice fuera de rango.";
	}

	@Override
	public ArrayList<Viaje> mostrarTodo() {
		return listaViajes;
	}
	
	

}

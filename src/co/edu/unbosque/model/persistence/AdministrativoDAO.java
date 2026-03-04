package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrativo;
import co.edu.unbosque.model.Estudiante;

public class AdministrativoDAO implements DAO<Administrativo>{

	private ArrayList<Administrativo> listaAdmins;
	
	
	@Override
	public void crear(Administrativo nuevoDato) {
		listaAdmins.add(nuevoDato);
		
	}

	@Override
	public boolean eliminar(int index) {
		if(index < 0 || index >= listaAdmins.size()) {
			return false;
		} else {
			listaAdmins.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Administrativo datoActualizado) {
		if(index < 0 || index >= listaAdmins.size()) {
			return false;
		} else {
			listaAdmins.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String dato = "";
		int posicion = 0;
		for (Administrativo administrativo : listaAdmins) {
			dato += posicion + " ";
			dato += administrativo.toString() + "\n";
		}
		return dato;
	}

	@Override
	public String mostrar(int index) {
		return listaAdmins.get(index).toString();
	}

	@Override
	public ArrayList<Administrativo> mostrarTodo() {
		return listaAdmins;
	}

	public ArrayList<Administrativo> getListaAdmins() {
		return listaAdmins;
	}

	public void setListaAdmins(ArrayList<Administrativo> listaAdmins) {
		this.listaAdmins = listaAdmins;
	}

}

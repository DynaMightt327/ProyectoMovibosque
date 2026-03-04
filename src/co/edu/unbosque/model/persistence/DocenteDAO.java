package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.Estudiante;

public class DocenteDAO implements DAO<Docente> {
	
	private ArrayList<Docente> listaDocentes;

	@Override
	public void crear(Docente nuevoDato) {
		listaDocentes.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		if(index < 0 || index >= listaDocentes.size()) {
			return false;
		} else {
			listaDocentes.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Docente datoActualizado) {
		if(index < 0 || index >= listaDocentes.size()) {
			return false;
		} else {
			listaDocentes.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String dato = "";
		int posicion = 0;
		for (Docente docente : listaDocentes) {
			dato += posicion + " ";
			dato += docente.toString() + "\n";
		}
		return dato;
	}

	@Override
	public String mostrar(int index) {
		return listaDocentes.get(index).toString();
	}

	@Override
	public ArrayList<Docente> mostrarTodo() {
		return listaDocentes;
	}

	public ArrayList<Docente> getListaDocente() {
		return listaDocentes;
	}

	public void setListaDocente(ArrayList<Docente> listaDocente) {
		this.listaDocentes = listaDocente;
	};
}

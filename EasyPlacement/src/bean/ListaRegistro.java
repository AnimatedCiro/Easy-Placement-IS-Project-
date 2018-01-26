package bean;

import java.util.ArrayList;

public class ListaRegistro {

	private ArrayList<Registro> listaRegistro;

	public ListaRegistro() {

		this.listaRegistro = new ArrayList<>();
	}

	public ArrayList<Registro> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(ArrayList<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public void addRegistro(Registro registro) {
		listaRegistro.add(registro);
	}
}

package bean;

import java.util.ArrayList;

public class ListaProgettiFormativi {

	private ArrayList<ProgettoFormativo> listaProgettoFormativo;

	public ListaProgettiFormativi() {

		this.listaProgettoFormativo = new ArrayList<>();
	}

	public ArrayList<ProgettoFormativo> getListaProgettoFormativo() {
		return listaProgettoFormativo;
	}

	public void setListaProgettoFormativo(ArrayList<ProgettoFormativo> listaProgettoFormativo) {
		this.listaProgettoFormativo = listaProgettoFormativo;
	}

	public void addProgettoFormativo(ProgettoFormativo progettoFormativo) {
		this.listaProgettoFormativo.add(progettoFormativo);
	}

}

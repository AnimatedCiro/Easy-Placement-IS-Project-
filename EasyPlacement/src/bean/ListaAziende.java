package bean;

import java.util.ArrayList;

public class ListaAziende {

	private ArrayList<Azienda> listaAziende;

	public ListaAziende() {

		this.listaAziende = new ArrayList<>();
	}

	public ArrayList<Azienda> getListaAziende() {
		return listaAziende;
	}

	public void setListaAziende(ArrayList<Azienda> listaAziende) {
		this.listaAziende = listaAziende;
	}

	public void addAzienda(Azienda azienda) {
		listaAziende.add(azienda);
	}

}

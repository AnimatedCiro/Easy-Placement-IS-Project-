package bean;

import java.util.ArrayList;

public class ListaRichieste {
	
	private ArrayList<Richiesta> listaRichieste;

	public ListaRichieste() {

		this.listaRichieste = new ArrayList<>();
	}

	public ArrayList<Richiesta> getListaRichieste() {
		return listaRichieste;
	}

	public void setListaRichieste(ArrayList<Richiesta> listaRichieste) {
		this.listaRichieste = listaRichieste;
	}

	public void addRichiesta(Richiesta richiesta) {
		listaRichieste.add(richiesta);
	}

}

package bean;

import java.util.ArrayList;

import bean.Studente;

public class ListaUtenti {

	private ArrayList<Studente> listaUtenti;

	public ListaUtenti() {

		this.listaUtenti = new ArrayList<>();
	}

	public ArrayList<Studente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(ArrayList<Studente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public void addUtente(Studente utente) {
		listaUtenti.add(utente);
	}
}

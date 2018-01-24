package bean;

import java.util.ArrayList;

public class ListaTirocini {

	private ArrayList<Tirocinio> listaTirocini;

	public ListaTirocini() {
		this.listaTirocini = new ArrayList<>();
	}

	public ArrayList<Tirocinio> getListaTirocini() {
		return listaTirocini;
	}

	public void setListaTirocini(ArrayList<Tirocinio> listaTirocini) {
		this.listaTirocini = listaTirocini;
	}

	public void addTirocinio(Tirocinio tirocinio) {
		this.listaTirocini.add(tirocinio);
	}





}

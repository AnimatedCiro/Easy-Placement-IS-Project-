package bean;

import java.util.GregorianCalendar;

public class Registro {

	private GregorianCalendar data;
	private int isFirmed = 0;
	private int id_progetto_formativo;

	public Registro() {	
	}

	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public int getIsFirmed() {
		return isFirmed;
	}
	public void setIsFirmed(int isFirmed) {
		this.isFirmed = isFirmed;
	}
	public int getId_progetto_formativo() {
		return id_progetto_formativo;
	}
	public void setId_progetto_formativo(int id_progetto_formativo) {
		this.id_progetto_formativo = id_progetto_formativo;
	}








}

package bean;

public class Tirocinio {

	private String dataInizio;
	private String dataFine;
	private String sede;
	private String emailStudente;
	private int id;
	private boolean completato;

	public boolean isCompletato() {
		return completato;
	}

	public void setCompletato(boolean completato) {
		this.completato = completato;
	}

	public Tirocinio() {
		super();
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getEmailStudente() {
		return emailStudente;
	}

	public void setEmailStudente(String emailStudente) {
		this.emailStudente = emailStudente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

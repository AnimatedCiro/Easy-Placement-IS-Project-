package bean;
/**
 * @author gregoriosaggese
 *
 */
public class Richiesta {

	private int idStudente;
	private boolean stato;
	private String nomeStudente;
	private String cognomeStudenteente;
	private String matricola;
	private String nomeUtenteResponsabileAziendale;

	public Richiesta() {
		super();
	}

	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public String getNomeStudente() {
		return nomeStudente;
	}
	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}
	public String getCognomeStudente() {
		return cognomeStudenteente;
	}
	public void setCognomeStudenteente(String cognomeStudenteente) {
		this.cognomeStudenteente = cognomeStudenteente;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNomeUtenteResponsabileAziendale() {
		return nomeUtenteResponsabileAziendale;
	}
	public void setNomeUtenteResponsabileAziendale(String nomeUtenteResponsabileAziendale) {
		this.nomeUtenteResponsabileAziendale = nomeUtenteResponsabileAziendale;
	}

}

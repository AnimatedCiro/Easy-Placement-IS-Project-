package bean;

/**
 * @author gregoriosaggese
 *
 */
public class Azienda {

	private String nome;
	private String sede;
	private String numerotelefono;
	private String progettoofferto;
	private String inizioTirocinio;
	private String fineTirocinio;

	public Azienda() {
		super();
	}
	
	public String getInizioTirocinio() {
		return inizioTirocinio;
	}
	public void setInizioTirocinio(String inizioTirocinio) {
		this.inizioTirocinio = inizioTirocinio;
	}
	public String getFineTirocinio() {
		return fineTirocinio;
	}
	public void setFineTirocinio(String fineTirocinio) {
		this.fineTirocinio = fineTirocinio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getNumerotelefono() {
		return numerotelefono;
	}
	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}
	public String getProgettoofferto() {
		return progettoofferto;
	}
	public void setProgettoofferto(String progettoofferto) {
		this.progettoofferto = progettoofferto;
	}
}



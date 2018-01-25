package bean;

public class ProgettoFormativo {

	private int id;
	private String Nome;
	private String Cognome;
	private String Residenza;
	private String Via;
	private String Natoa;
	private String Natoil;
	private String CodiceFiscale;
	private String Telefono;
	private boolean Firma_Azienda;
	private boolean Firma_Tutor_Aziendale;
	private boolean Firma_Presidente_Consiglio_Didattico;
	private boolean Firma_Tutor_Accademico;
	private boolean Firma_Studente	;
	private String Email_Studente;
	private String Nome_Utente_Responsabile_Aziendale;
	private String Nome_Utente_Tutor_Aziendale;
	private String Nome_Utente_Tutor_Accademico;
	private boolean Opzione;
	private String IscrittoAl;
	private String AnnoCorsoLaurea;
	private String LaureaIn;
	private String Matricola;
	private String AnnoAccademico;
	private int NumeroCFU;
	private boolean TipoLaurea;
	private String DataConseguimentoLaurea;
	private String InpossessodiLaurea;
	private boolean PortatoreHandicap;
	private String DataFirma;
	private String dataInizio;
	private String dataFine;
	private String sede;

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

	public ProgettoFormativo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getResidenza() {
		return Residenza;
	}

	public void setResidenza(String residenza) {
		Residenza = residenza;
	}

	public String getVia() {
		return Via;
	}

	public void setVia(String via) {
		Via = via;
	}

	public String getNatoa() {
		return Natoa;
	}

	public void setNatoa(String natoa) {
		Natoa = natoa;
	}

	public String getNatoil() {
		return Natoil;
	}

	public void setNatoil(String natoil) {
		Natoil = natoil;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public boolean isFirma_Azienda() {
		return Firma_Azienda;
	}

	public void setFirma_Azienda(boolean firma_Azienda) {
		Firma_Azienda = firma_Azienda;
	}

	public boolean isFirma_Tutor_Aziendale() {
		return Firma_Tutor_Aziendale;
	}

	public void setFirma_Tutor_Aziendale(boolean firma_Tutor_Aziendale) {
		Firma_Tutor_Aziendale = firma_Tutor_Aziendale;
	}

	public boolean isFirma_Presidente_Consiglio_Didattico() {
		return Firma_Presidente_Consiglio_Didattico;
	}

	public void setFirma_Presidente_Consiglio_Didattico(boolean firma_Presidente_Consiglio_Didattico) {
		Firma_Presidente_Consiglio_Didattico = firma_Presidente_Consiglio_Didattico;
	}

	public boolean isFirma_Tutor_Accademico() {
		return Firma_Tutor_Accademico;
	}

	public void setFirma_Tutor_Accademico(boolean firma_Tutor_Accademico) {
		Firma_Tutor_Accademico = firma_Tutor_Accademico;
	}

	public boolean isFirma_Studente() {
		return Firma_Studente;
	}

	public void setFirma_Studente(boolean firma_Studente) {
		Firma_Studente = firma_Studente;
	}

	public String getEmail_Studente() {
		return Email_Studente;
	}

	public void setEmail_Studente(String email_Studente) {
		Email_Studente = email_Studente;
	}

	public String getNome_Utente_Responsabile_Aziendale() {
		return Nome_Utente_Responsabile_Aziendale;
	}

	public void setNome_Utente_Responsabile_Aziendale(String nome_Utente_Responsabile_Aziendale) {
		Nome_Utente_Responsabile_Aziendale = nome_Utente_Responsabile_Aziendale;
	}

	public String getNome_Utente_Tutor_Aziendale() {
		return Nome_Utente_Tutor_Aziendale;
	}

	public void setNome_Utente_Tutor_Aziendale(String nome_Utente_Tutor_Aziendale) {
		Nome_Utente_Tutor_Aziendale = nome_Utente_Tutor_Aziendale;
	}

	public String getNome_Utente_Tutor_Accademico() {
		return Nome_Utente_Tutor_Accademico;
	}

	public void setNome_Utente_Tutor_Accademico(String nome_Utente_Tutor_Accademico) {
		Nome_Utente_Tutor_Accademico = nome_Utente_Tutor_Accademico;
	}

	public boolean isOpzione() {
		return Opzione;
	}

	public void setOpzione(boolean opzione) {
		Opzione = opzione;
	}

	public String getIscrittoAl() {
		return IscrittoAl;
	}

	public void setIscrittoAl(String iscrittoAl) {
		IscrittoAl = iscrittoAl;
	}

	public String getAnnoCorsoLaurea() {
		return AnnoCorsoLaurea;
	}

	public void setAnnoCorsoLaurea(String annoCorsoLaurea) {
		AnnoCorsoLaurea = annoCorsoLaurea;
	}

	public String getLaureaIn() {
		return LaureaIn;
	}

	public void setLaureaIn(String laureaIn) {
		LaureaIn = laureaIn;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getAnnoAccademico() {
		return AnnoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico) {
		AnnoAccademico = annoAccademico;
	}

	public int getNumeroCFU() {
		return NumeroCFU;
	}

	public void setNumeroCFU(int numeroCFU) {
		NumeroCFU = numeroCFU;
	}

	public boolean isTipoLaurea() {
		return TipoLaurea;
	}

	public void setTipoLaurea(boolean tipoLaurea) {
		TipoLaurea = tipoLaurea;
	}

	public String getDataConseguimentoLaurea() {
		return DataConseguimentoLaurea;
	}

	public void setDataConseguimentoLaurea(String dataConseguimentoLaurea) {
		DataConseguimentoLaurea = dataConseguimentoLaurea;
	}

	public String getInpossessodiLaurea() {
		return InpossessodiLaurea;
	}

	public void setInpossessodiLaurea(String inpossessodiLaurea) {
		InpossessodiLaurea = inpossessodiLaurea;
	}

	public boolean isPortatoreHandicap() {
		return PortatoreHandicap;
	}

	public void setPortatoreHandicap(boolean portatoreHandicap) {
		PortatoreHandicap = portatoreHandicap;
	}

	public String getDataFirma() {
		return DataFirma;
	}

	public void setDataFirma(String dataFirma) {
		DataFirma = dataFirma;
	}

	


}

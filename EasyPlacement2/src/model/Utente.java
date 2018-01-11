package model;

public class Utente{
	
	public String username;
	public String password;
	public String cognome;

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String nome;

	
	public String getUsername (){
		return username;
	}
	
	public String getCognome (){
		return cognome;
	}
	public String getNome (){
		return nome;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}

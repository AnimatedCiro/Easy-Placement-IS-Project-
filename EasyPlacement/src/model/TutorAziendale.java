package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindUser;

public class TutorAziendale extends Utente implements FindUser{

	private Connection c;
	private String nomeUtente;
	private String numeroTelefonico;
	private String email;
	private String nomeAzienda;


	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String username) throws ClassNotFoundException, SQLException {
		this.nomeUtente = findUser(username);
	}

	@Override
	public String findUser(String username) throws ClassNotFoundException, SQLException {
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `TUTOR AZIENDALE`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}



}

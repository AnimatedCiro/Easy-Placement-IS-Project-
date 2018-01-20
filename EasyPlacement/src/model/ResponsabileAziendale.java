package model;

import java.sql.*;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindUser;

public class ResponsabileAziendale extends Utente implements FindUser{

	private	Connection c;
	private String nomeUtente;
	private String nomeAzienda;

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) throws ClassNotFoundException, SQLException {
		this.nomeUtente = findUser(nomeUtente);
	}

	@Override
	public String findUser(String username) throws ClassNotFoundException, SQLException {
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `RESPONSABILE AZIENDALE`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}
}

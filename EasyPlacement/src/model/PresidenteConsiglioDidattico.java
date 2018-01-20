package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindUser;

public class PresidenteConsiglioDidattico extends Utente implements FindUser{

	private Connection c;
	private String nomeUtente;


	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String username) throws ClassNotFoundException, SQLException {
		this.nomeUtente = findUser(username);
	}

	@Override
	public String findUser(String username) throws ClassNotFoundException, SQLException {
		String sqlGetUserId = "SELECT  `Nome_Utente` FROM  `PRESIDENTE CONSIGLIO DIDATTICO`";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		nomeUtente = executeQuery.getString("Nome_Utente");
		return nomeUtente;
	}

}

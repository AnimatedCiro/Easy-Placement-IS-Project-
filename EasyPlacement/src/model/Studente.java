package model;

import java.sql.*;

import bean.Utente;
import database.ConnessioneDB;
import interfaces.FindStudente;

public class Studente extends Utente implements FindStudente{

	Connection c;

	public String email;
	public String numeroTelefono;
	public int userId = 0;

	public void setUserId (String username) throws ClassNotFoundException, SQLException{
		this.userId = findUserId(username);     
	}

	public String getUserEmail (){
		return email;
	}
	public int getUserId (){
		return userId;
	}
	public String getNumeroTelefono (){
		return numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public int findUserId (String username) throws SQLException, ClassNotFoundException{

		String sqlGetUserId = "SELECT  `studente_id` FROM  `STUDENTE` WHERE  `Username` =  ?";
		c=  new ConnessioneDB().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		psmt.setString(1, username);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		userId = executeQuery.getInt("studente_id");
		return userId;
	}




}
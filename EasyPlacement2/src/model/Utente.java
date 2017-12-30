package model;

import database.DB_Conn;
import java.sql.*;

public class Utente {
	
	public String email;
	public int userId = 0;
	public String username;
	public String password;
	public String numeroTelefono;
	public String cognome;
	public String nome;

	Connection c;

	public void setUserEmail (String email) throws SQLException, ClassNotFoundException{
		this.userId = findUserId(email);
		this.email = email;        
	}

	public String getUserEmail (){
		return email;
	}
	public int getUserId (){
		return userId;
	}
	public String getUsername (){
		return username;
	}
	public String getNumeroTelefono (){
		return numeroTelefono;
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

	public int findUserId (String email) throws SQLException, ClassNotFoundException{
		String sqlGetUserId = "SELECT  `studente_id` FROM  `STUDENTE` WHERE  `Email` =  ?";
		c= new DB_Conn().getConnection();
		PreparedStatement psmt  = c.prepareStatement(sqlGetUserId);
		psmt.setString(1, email);
		ResultSet executeQuery = psmt.executeQuery();
		executeQuery.next();
		userId = executeQuery.getInt("studente_id");
		return userId;
	}

}

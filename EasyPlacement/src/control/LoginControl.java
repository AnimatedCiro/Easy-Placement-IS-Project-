package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


import bean.Azienda;
import bean.ListaAziende;
import database.ConnessioneDB;
import model.PresidenteConsiglioDidattico;
import model.ResponsabileAziendale;
import model.Studente;
import model.TutorAccademico;
import model.TutorAziendale;
import model.UfficioStageTirocini;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username, pass;

		String db_username, db_pass;

		boolean isLoggedIn = false;

		HttpSession userSession = request.getSession();

		username = request.getParameter("usernameLogin");

		pass = request.getParameter("passwordLogin");

		String message, messageDetail;

		message = "Email non Esistente";
		messageDetail = "Effettua la registrazione";


		try {
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();
			String sqlAzienda = "SELECT * FROM  `AZIENDA`; ";

			Statement st = c.createStatement();
			ResultSet rsAzienda = st.executeQuery(sqlAzienda);
			String nomeAzienda = null,sede = null,numeroTelefono = null,progettoOfferto,inizioTirocinio,fineTirocinio;

			ListaAziende listaAziende = new ListaAziende(null);

			while (rsAzienda.next()) {

				nomeAzienda = rsAzienda.getString("Nome");
				sede = rsAzienda.getString("Sede");
				inizioTirocinio = rsAzienda.getString("InizioTirocinio");
				fineTirocinio = rsAzienda.getString("FineTirocinio");
				numeroTelefono=	rsAzienda.getString("Numero_Telefonico");
				progettoOfferto=	rsAzienda.getString("Progetto_Offerto");


				Azienda azienda = new Azienda();
				azienda.setNome(nomeAzienda);
				azienda.setSede(sede);
				azienda.setNumerotelefono(numeroTelefono);
				azienda.setProgettoofferto(progettoOfferto);
				azienda.setInizioTirocinio(inizioTirocinio);
				azienda.setFineTirocinio(fineTirocinio);
				listaAziende.addAzienda(azienda);

			}
			userSession.setAttribute("listaAziende", listaAziende);
			st.close();
			rsAzienda.close();
			c.close();



		}catch (Exception e) {
			// TODO: handle exception
		}

		
		try {


			if(username.contains("responsabileAziendale")) {

				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `RESPONSABILE AZIENDALE`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
							responsabileAziendale.setUsername(username);
							responsabileAziendale.setNomeUtente(username);
							responsabileAziendale.setNome(nome);
							responsabileAziendale.setCognome(cognome);
							userSession.setAttribute("user", responsabileAziendale);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
			}

			else if (username.contains("tutorAccademico")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `TUTOR ACCADEMICO`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							TutorAccademico tutorAccademico = new TutorAccademico();
							tutorAccademico.setUsername(username);
							tutorAccademico.setNomeUtente(username);
							tutorAccademico.setNome(nome);
							tutorAccademico.setCognome(cognome);
							userSession.setAttribute("user", tutorAccademico);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
			}

			else if (username.contains("tutorAziendale")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome`,`Numero_Telefonico`,`Email`,`Nome_Azienda` FROM  `TUTOR AZIENDALE`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					String nome,cognome,numeroTelefonico,email,nomeAzienda;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					numeroTelefonico = rs.getString("Numero_Telefonico");
					email = rs.getString("Email");
					nomeAzienda = rs.getString("Nome_Azienda");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;

							TutorAziendale tutorAziendale = new TutorAziendale();
							tutorAziendale.setUsername(username);
							tutorAziendale.setNomeUtente(username);
							tutorAziendale.setNome(nome);
							tutorAziendale.setCognome(cognome);
							tutorAziendale.setNumeroTelefonico(numeroTelefonico);
							tutorAziendale.setEmail(email);
							tutorAziendale.setNomeAzienda(nomeAzienda);
							userSession.setAttribute("user", tutorAziendale);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
			}

			else if (username.contains("ufficioStageETirocini")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password` FROM  `UFFICIO STAGE E TIROCINI`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;

							UfficioStageTirocini ufficioStageETirocini = new UfficioStageTirocini();
							ufficioStageETirocini.setUsername(username);
							ufficioStageETirocini.setNomeUtente(username);

							userSession.setAttribute("user", ufficioStageETirocini);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
			}

			else if (username.contains("presidenteConsiglioDidattico")) {
				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				System.out.println("SONO NEL CAMPO PCD");

				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `PRESIDENTE CONSIGLIO DIDATTICO`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					String nome,cognome;
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;

							PresidenteConsiglioDidattico presidenteConsiglioDidattico = new PresidenteConsiglioDidattico();
							presidenteConsiglioDidattico.setUsername(username);
							presidenteConsiglioDidattico.setNomeUtente(username);
							presidenteConsiglioDidattico.setNome(nome);
							presidenteConsiglioDidattico.setCognome(cognome);
							userSession.setAttribute("user", presidenteConsiglioDidattico);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}
				}
			}

			else {

				ConnessioneDB con = new ConnessioneDB();
				Connection c = con.getConnection();
				String sqlGetUsers;

				sqlGetUsers = "SELECT  `Username` ,  "
						+ "`Password`,`Nome`,`Cognome`,`Email`,`Numero_Telefonico` FROM  `STUDENTE`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);

				ResultSet rs = st.executeQuery();

				String nome,cognome,email,numeroTelefono;
				Studente studente = null;
				while (rs.next()) {
					db_username = rs.getString("Username");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					email = rs.getString("Email");
					numeroTelefono = rs.getString("Numero_Telefonico");
					
					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							studente = new Studente();
							studente.setUsername(username);
							studente.setUserId(username);
							studente.setNome(nome);
							studente.setCognome(cognome);
							studente.setEmail(email);
							studente.setNumeroTelefono(numeroTelefono);
							userSession.setAttribute("user", studente);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
							break;
						}
						else {
							isLoggedIn = false;
							message = "Password Sbagliata";
							messageDetail = "Rieffettua l'accesso";
							break;
						}
					}
					else {
						message = "Username non esistente";
						messageDetail = "Effettua la registrazione";
						isLoggedIn = false;
					}

				}

				if (isLoggedIn == false){
					userSession.setAttribute("message", message);
					userSession.setAttribute("messageDetail", messageDetail);
					response.sendRedirect(request.getContextPath()+"/message.jsp");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();        
		} catch (Exception e) {
			e.printStackTrace();        
		}
	}
}

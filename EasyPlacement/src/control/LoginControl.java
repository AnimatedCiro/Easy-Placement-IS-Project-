package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import database.DB_Conn;
import model.ResponsabileAziendale;
import model.Studente;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	/**
	 * 
	 */
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

		String messageUrl = "/index.jsp";
		RequestDispatcher dispatchMessage =
				request.getServletContext().getRequestDispatcher(messageUrl);

		try {

			DB_Conn con = new DB_Conn();
			Connection c = con.getConnection();
			String sqlGetUsers;

			if(username.contains("responsabileAziendale")) {
				sqlGetUsers = "SELECT  `Nome_Utente` ,  "
						+ "`Password` FROM  `RESPONSABILE AZIENDALE`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					db_username = rs.getString("Nome_Utente");
					db_pass = rs.getString("Password");

					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
							responsabileAziendale.setUsername(username);
							responsabileAziendale.setNomeUtente(username);
							userSession.setAttribute("user", responsabileAziendale);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
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
					request.setAttribute("message", message);
					request.setAttribute("messageDetail", messageDetail);
					dispatchMessage.forward(request, response);
				}



			}else {
				sqlGetUsers = "SELECT  `Username` ,  "
						+ "`Password`,`Nome`,`Cognome` FROM  `STUDENTE`; ";

				PreparedStatement st = c.prepareStatement(sqlGetUsers);
				ResultSet rs = st.executeQuery();
				String nome,cognome;
				while (rs.next()) {
					db_username = rs.getString("Username");
					db_pass = rs.getString("Password");
					nome = rs.getString("Nome");
					cognome = rs.getString("Cognome");
					
					if (username.equals(db_username)) {

						if (pass.equals(db_pass)) {
							isLoggedIn = true;
							Studente studente = new Studente();
							studente.setUsername(username);
							studente.setUserId(username);
							studente.setNome(nome);
							studente.setCognome(cognome);
							userSession.setAttribute("user", studente);
							response.sendRedirect(request.getContextPath()+"/index.jsp");
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
					request.setAttribute("message", message);
					request.setAttribute("messageDetail", messageDetail);
					dispatchMessage.forward(request, response);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();        
		} catch (Exception e) {
			e.printStackTrace();        
		}
	}
}

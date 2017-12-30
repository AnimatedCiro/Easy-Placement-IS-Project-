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
import model.Utente;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username, pass,email;

		String db_username, db_pass;

		boolean isLoggedIn = false;

		HttpSession userSession = request.getSession();

		username = request.getParameter("usernameLogin");

		pass = request.getParameter("passwordLogin");

		email = request.getParameter("Email");
		
		String message, messageDetail;

		message = "Email non Esistente";
		messageDetail = "Effettua la registrazione";

		String messageUrl = "/index.jsp";
		RequestDispatcher dispatchMessage =
				request.getServletContext().getRequestDispatcher(messageUrl);

		try {

			DB_Conn con = new DB_Conn();
			Connection c = con.getConnection();
			String sqlGetUsers = "SELECT  `Username` ,  "
					+ "`Password` FROM  `STUDENTE`; ";

			PreparedStatement st = c.prepareStatement(sqlGetUsers);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				db_username = rs.getString("Username");
				db_pass = rs.getString("Password");

				if (username.equals(db_username)) {

					if (pass.equals(db_pass)) {
						isLoggedIn = true;
						Utente utente = new Utente();
						utente.setUserEmail(email);
						userSession.setAttribute("user", utente);
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
					message = "Email non esistente";
					messageDetail = "Effettua la registrazione";
					isLoggedIn = false;
				}
			}
			if (isLoggedIn == false){
				request.setAttribute("message", message);
				request.setAttribute("messageDetail", messageDetail);
				dispatchMessage.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();        
		} catch (Exception e) {
			e.printStackTrace();        
		}
	}
}

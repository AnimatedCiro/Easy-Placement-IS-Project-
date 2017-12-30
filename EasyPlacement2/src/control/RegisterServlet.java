package control;

import database.DB_Conn;
import model.Utente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.RequestDispatcher;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {


	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message;
		message = null;
		String email, pass,nome,cognome,username,numTelefono;

		String messageUrl = "/message.jsp";
		RequestDispatcher dispatchMessage =
				request.getServletContext().getRequestDispatcher(messageUrl);

		email = request.getParameter("emailRegistrazione");
		pass = request.getParameter("passwordRegistrazione");
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		username = request.getParameter("username");
		numTelefono = request.getParameter("numTelefono");


		HttpSession userSession = request.getSession();

		try {
			DB_Conn con = new DB_Conn();
			Connection c = con.getConnection();
			if ((request.getParameter("emailRegistrazione") != null) || (request.getParameter("emailRegistrazione") != null)){

				String sql = "INSERT INTO  `EPDatabase`.`STUDENTE` "
						+ "(`studente_id` ,`Email` ,`Nome`,`Cognome`,`Username`,`Password`,`Numero_Telefonico` ) "
						+ "VALUES (NULL ,  ? ,  ?,?,?,?,? ); ";


				PreparedStatement psmt = c.prepareStatement(sql);

				psmt.setString(1, email);

				psmt.setString(2, nome);

				psmt.setString(3, cognome);

				psmt.setString(4, username);

				psmt.setString(5, pass);

				psmt.setString(6, numTelefono);



				int i = psmt.executeUpdate();



				if (i == 1) {
					Utente utente = new Utente();
					utente.setUserEmail(email);
					System.out.println("sono qui");
					userSession.setAttribute("user", utente);
					response.sendRedirect(request.getContextPath());
				}

			}
		} catch (SQLIntegrityConstraintViolationException ex) {
			String messageDetail = "Effettua di nuovo la registrazione";
			message = "Account Utente Esistente";
			request.setAttribute("message", message);
			request.setAttribute("messageDetail", messageDetail);
			dispatchMessage.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

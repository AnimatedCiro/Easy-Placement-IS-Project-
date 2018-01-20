package control;

import database.ConnessioneDB;
import model.Studente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Azienda;
import bean.ListaAziende;

import java.sql.*;


@WebServlet("/RegistraControl")
public class RegistraControl extends HttpServlet {


	public RegistraControl() {
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

		email = request.getParameter("emailRegistrazione");
		pass = request.getParameter("passwordRegistrazione");
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		username = request.getParameter("username");
		numTelefono = request.getParameter("numTelefono");


		HttpSession userSession = request.getSession();
		Studente studente = null;

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

			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();



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
				studente = new Studente();
				studente.setUserId(username);
				studente.setUsername(username);
				studente.setNome(nome);
				studente.setCognome(cognome);
				studente.setEmail(email);
				studente.setNumeroTelefono(numTelefono);
				userSession.setAttribute("user", studente);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}

		} catch (SQLIntegrityConstraintViolationException ex) {

			String messageDetail;

			if(ex.getMessage().equals("Duplicate entry '"+email+"' for key 'Email'")) {
				System.out.println("sonoqui");
				messageDetail = "Effettua di nuovo la registrazione";
				message = "Email Utente Esistente";
				userSession.setAttribute("message", message);
				userSession.setAttribute("messageDetail", messageDetail);
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}else {
				messageDetail = "Effettua di nuovo la registrazione";
				message = "Username Esistente";
				userSession.setAttribute("message", message);
				userSession.setAttribute("messageDetail", messageDetail);
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

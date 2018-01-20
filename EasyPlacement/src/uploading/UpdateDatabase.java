package uploading;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

import bean.ListaAziende;
import database.ConnessioneDB;


public class UpdateDatabase {


	public void updateAzienda(ListaAziende lista) {


		try {   
			ConnessioneDB con = new ConnessioneDB();
			Connection c = con.getConnection();





			String updateSQL = "UPDATE  `AZIENDA` "
					+ "SET " +
					"`InizioTirocinio` =  ?," +
					"`FineTirocinio` =  ?" +
					" WHERE `Nome` =  ?;" ;

			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			String dataStr1 = null;
			String dataStr2 = null;

			int anno = 2018, mese,giorno;

			Random u = new Random();


			for(int i=0; i<lista.getListaAziende().size(); i++) {

				mese = u.nextInt(12);
				giorno = u.nextInt(31);

				dataStr1 = sdf2.format(new GregorianCalendar(anno,mese,giorno).getTime());
				dataStr2 = sdf2.format(new GregorianCalendar(anno,mese+6,giorno+1).getTime());

				PreparedStatement psmt = c.prepareStatement(updateSQL);

				psmt.setString(1, dataStr1);

				psmt.setString(2, dataStr2);

				psmt.setString(3, lista.getListaAziende().get(i).getNome());

				
				System.out.println(updateSQL);


				psmt.executeUpdate();

			}




			System.out.println("fatto");



		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	





}

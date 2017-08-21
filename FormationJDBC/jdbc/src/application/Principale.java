package application;

import java.sql.*;

public class Principale {

	public static void main (String[] args){
		Connection cnx = null;

		try {
			//Chargement de la classe du pilote
			String driver = "oracle.jdbc.driver.OracleDriver";
			//String driver = "com.mysql.jdbc.Driver"; //Avec MySQL
			Class.forName(driver);
			System.out.println("Le démarrage du driver à réussi");

			//Chargement du pilote et connexion à la base
			String url ="jdbc:oracle:thin:@localhost:1521:XE";
			cnx = DriverManager.getConnection(url,"papyrus","afpa");
			System.out.println("Connexion établie");
		} catch(ClassNotFoundException e){
			System.err.println("Le démarrage du driver à échoué");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("La connexion a échoué");
			e.printStackTrace();
		}

		Statement stm = null;
		try {
			stm = cnx.createStatement();
		} catch (SQLException e) {
			System.err.println("Le statement a échoué à la création");
			e.printStackTrace();
		}

		ResultSet resultat;

		try {
			resultat = stm.executeQuery("SELECT * FROM FOURNIS");
			while (resultat.next()) {
				int NUMFOU = resultat.getInt("NUMFOU");
				String NOMFOU = resultat.getString("NOMFOU");
				String RUEFOU = resultat.getString("RUEFOU");
				String POSFOU = resultat.getString("POSFOU");
				String VILFOU = resultat.getString("VILFOU");
				String CONFOU = resultat.getString("CONFOU");
				int SATISF = resultat.getInt("SATISF");
				System.out.println(NUMFOU + " - " + NOMFOU 
						+ " - Adresse : " + RUEFOU + " - " + POSFOU + " - " + VILFOU 
						+ " - Contact : " + CONFOU 
						+ " - Satisf : " + SATISF);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de recupération");
			e.printStackTrace();
		}
		
		try {
			stm.close();
			cnx.close();
		} catch (SQLException e) {
			System.err.println("Erreur de fermeture");
			e.printStackTrace();
		}
	}
}

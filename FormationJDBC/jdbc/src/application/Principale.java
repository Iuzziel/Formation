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

		//Insertion de données
		try {
			int update = stm.executeUpdate("INSERT INTO FOURNIS (NUMFOU, NOMFOU, RUEFOU, POSFOU, VILFOU, CONFOU, SATISF) "
					+ "VALUES (1001001, 'Test jdbc', 'Rue du connecteur', 14000, 'Caen', 'M Oracle', 9)");
			System.out.println(update + " nombre de ligne(s) insérée(s)");
		} catch (Exception e){
			System.err.println("Erreur d'insertion");
			e.printStackTrace();
		}

		//Creation de la preparedStatement
		PreparedStatement pstm = null;
		try {
			pstm = cnx.prepareStatement("UPDATE FOURNIS SET POSFOU = 12345, VILFOU = 'PrepStatement' WHERE NUMFOU = ?");
		} catch (Exception e) {
			System.err.println("Erreur dans la PreparedStatement");
		}
		//Setting de la pstm
		try {
			pstm.setInt(1, 1001001);
		} catch (SQLException e) {
			System.err.println("Erreur dans le setting de pstm");
			e.printStackTrace();
		}
		try {
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur dans l'execution de pstm");
			e.printStackTrace();
		}
		
		try {
			int update = stm.executeUpdate("Insert into FOURNIS (NOMFOU,RUEFOU,POSFOU,VILFOU,CONFOU,SATISF) "
					+ "values ('TEST3','TRIGSEQ','50505','Testcity','P.Plop','6')");
			System.out.println(update + " nombre de ligne(s) insérée(s)");
		} catch (SQLException e) {
			System.err.println("Erreur d'insert par seq");
			e.printStackTrace();
		}

		//Affichage des resultats de la table FOURNIS
		ResultSet resultat;
		try {
			resultat = stm.executeQuery("SELECT * FROM FOURNIS WHERE NUMFOU >= 1");
			while (resultat.next()) {
				int NUMFOU = resultat.getInt("NUMFOU");
				String NOMFOU = resultat.getString("NOMFOU");
				String RUEFOU = resultat.getString("RUEFOU");
				String POSFOU = resultat.getString("POSFOU");
				String VILFOU = resultat.getString("VILFOU");
				int SATISF = resultat.getInt("SATISF");
				System.out.println(NUMFOU + " - " + NOMFOU 
						+ " - Adresse : " + RUEFOU + " - " + POSFOU + " - " + VILFOU 
						+ " - Satisf : " + SATISF);
			}
		} catch (SQLException e) {
			System.err.println("Erreur de recupération");
			e.printStackTrace();
		}
		
		
		try {
			int update = stm.executeUpdate("DELETE FROM FOURNIS WHERE FOURNIS.NUMFOU < 100");
			System.out.println(update + " nombre de ligne(s) suprimée(s)");
		} catch (Exception e){
			System.err.println("Erreur de Delete");
			e.printStackTrace();
		}
		
		try {
			int update = stm.executeUpdate("DROP SEQUENCE SEQ_NUMFOU");
			System.out.println(update + " séquence(s) suprimée(s)");
			update = stm.executeUpdate("CREATE SEQUENCE SEQ_NUMFOU INCREMENT BY 1 MAXVALUE 10000 MINVALUE 1 NOCACHE");
			System.out.println(update + " séquence(s) crée(s)");
		} catch (Exception e){
			System.err.println("Erreur de Delete de séquence");
			e.printStackTrace();
		}
		//Fermeture
		try {
			pstm.close();
			stm.close();
			cnx.close();
		} catch (SQLException e) {
			System.err.println("Erreur de fermeture");
			e.printStackTrace();
		}
	}
}

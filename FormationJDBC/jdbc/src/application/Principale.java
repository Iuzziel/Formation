package application;

import java.sql.*;
import oracle.jdbc.*;

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
			//Test de recuperation num sequence
			String sql = "INSERT INTO FOURNIS (NOMFOU, RUEFOU, POSFOU, VILFOU, CONFOU) VALUES (?, ?, ?, ?, ?) ";
			// Créer une requête prédéfinie sur la connexion con
			// Passer en 2em paramètre (tableau de String) la colonne dont
			// on veut récupérer la valeur
			PreparedStatement pstm2;
			pstm2 = cnx.prepareStatement (sql, new String[] {"NUMFOU"});
			// donner la valeur des paramètres pour l'exécution de la requête
			pstm2.setString (1,"Bonjour");
			pstm2.setInt (2, 123);
			pstm2.setString(3, "12345");
			pstm2.setString(4, "Villetest");
			pstm2.setString(5, "M.Test");
			// exécution de la requête et récupération du nbre d’enreg MAJ
			int enregMaj = pstm2.executeUpdate();
			// Récupération de la valeur demandée
			long id = 0;
			ResultSet generatedKeys = pstm2.getGeneratedKeys();
			if (generatedKeys.next())
				id = generatedKeys.getLong(1) ; // N° de la colonne du tab de String
			System.out.println("Récupération id séquence : " + id + " - " + enregMaj);		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		/* A faire dans Oracle
		 * Injecter le fichier gavagepapyrus.sql
		 * */
		
		CallableStatement cs;
		try {
			cs = cnx.prepareCall("begin ? := bonjour(?); end;");
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, "Philippe");
			cs.execute();
			String result = cs.getNString(1);
			System.out.println("Fonction stockée : " + result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			cs = cnx.prepareCall("{call LST_FOURNIS(?, ?)}");
			cs.setString(1, "10");
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet result = (ResultSet) cs.getObject(2);
			while (result.next()) {
				System.out.println("Procédure stockée : " + result.getString("NUMFOU") + " - " + result.getString("NOMFOU"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
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

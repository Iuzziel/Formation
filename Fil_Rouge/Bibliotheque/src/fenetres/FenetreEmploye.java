package fenetres;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class FenetreEmploye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6154275497867212254L;

	public FenetreEmploye() {
		this.setTitle("Bienvenu dans le logiciel de la bibliothèque");
		this.getContentPane().setLayout(new BorderLayout(5, 5));
		this.getContentPane().add(new Header("Espace employé de la bibliothèque"), BorderLayout.NORTH);
		
		//Création du tabbedPane
		JTabbedPane tabEspaceEmploye = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabEspaceEmploye, BorderLayout.CENTER);
		
		//Création des onglets
		JPanel tabGestEmprunt = new JPanel();
		tabEspaceEmploye.addTab("Gestion des emprunts", null, tabGestEmprunt, null);
		JPanel tabGestStock = new JPanel();
		tabEspaceEmploye.addTab("Gestion du stock", null, tabGestStock, null);
		JPanel tabGestFond = new JPanel();
		tabEspaceEmploye.addTab("Gestion du fond", null, tabGestFond, null);
		JPanel tabAdmin = new JPanel();
		tabEspaceEmploye.addTab("Gestion des comptes employ\u00E9s", null, tabAdmin, null);
		tabGestEmprunt.setLayout(new GridLayout(2, 2, 5, 5));
		
		///////////////////////////////////////////////TODO Remplissage des onglets///////////////////////////////////////////////
		//Tab gestion des emprunts
		tabGestEmprunt.add(new RechercherUnLivre());
		tabGestEmprunt.add(new InformationLivre());
		tabGestEmprunt.add(new RechercherUnAdherent());
		
		//Tab gestion du fond
		tabGestFond.add(new RechercherUnLivre());
		tabGestFond.add(new InformationLivre());
	}
}

package fenetres;

import panneaux.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class FenetreEmploye extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6154275497867212254L;

	public FenetreEmploye() {
		this.setTitle("Bienvenu dans le logiciel de la bibliothèque");
		this.setMinimumSize(new Dimension(800, 600));
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.getContentPane().setLayout(new BorderLayout(5, 5));
		this.getContentPane().add(new Header("Espace employé de la bibliothèque"), BorderLayout.NORTH);

		//Création du tabbedPane
		JTabbedPane tabEspaceEmploye = new JTabbedPane(JTabbedPane.TOP);
		tabEspaceEmploye.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		getContentPane().add(tabEspaceEmploye, BorderLayout.CENTER);

		//Création des onglets
		//Création des onglets/tabGestEmprunt
		JPanel tabGestEmprunt = new JPanel();
		tabGestEmprunt.setLayout(new GridLayout(2, 2, 5, 5));
		tabEspaceEmploye.addTab("Gestion des emprunts", null, tabGestEmprunt, null);

		//Création des onglets/tabGestFond
		JPanel tabGestFond = new JPanel();
		tabGestFond.setLayout(new GridLayout(1, 2, 5, 5));
		tabEspaceEmploye.addTab("Gestion du fond", null, tabGestFond, null);

		//Création des onglets/tabGestStock
		JPanel tabGestStock = new JPanel();
		tabEspaceEmploye.addTab("Gestion du stock", null, tabGestStock, null);

		//Création des onglets/tabAdmin
		JPanel tabAdmin = new JPanel();
		tabAdmin.setLayout(new GridLayout(2, 2, 5, 5));
		tabEspaceEmploye.addTab("Gestion des comptes employ\u00E9s", null, tabAdmin, null);

		///////////////////////////////////////////////TODO Remplissage des onglets///////////////////////////////////////////////
		//Tab gestion des emprunts
		tabGestEmprunt.add(new RechercherUnLivre());
		tabGestEmprunt.add(new InformationLivre());
		tabGestEmprunt.add(new RechercherUnAdherent());
		tabGestEmprunt.add(new EmpruntRetour());

		//Tab gestion du fond
		tabGestFond.add(new RechercherUnLivre());
		tabGestFond.add(new InformationLivre());

		//Tab gestion du stock
		tabGestStock.setLayout(new BorderLayout(5, 5));
		tabGestStock.add(new GestionStock(), BorderLayout.WEST);
		tabGestStock.add(new GestionStockResultAffich(), BorderLayout.CENTER);

		//Tab Admin
		tabAdmin.setLayout(new BorderLayout(5, 5));
		tabAdmin.add(new GestionEmployes(), BorderLayout.WEST);
		tabAdmin.add(new GestionEmployesResultAffich(), BorderLayout.CENTER);

	}
}

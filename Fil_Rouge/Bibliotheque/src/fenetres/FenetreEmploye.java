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

	//Constructeur de la fenetre
	public FenetreEmploye() {
		this.setTitle("Bienvenu dans le logiciel de la bibliothèque");
		this.setMinimumSize(new Dimension(800, 600));
		this.setSize(1024, 768);
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
		tabGestEmprunt.setLayout(new GridLayout(0, 1, 5, 5));
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
		//*********************************************Tab gestion des emprunts*************************************************//
		//Création Panel du haut
		JPanel panTabGestEmpruntHaut = new JPanel();
		tabGestEmprunt.add(panTabGestEmpruntHaut);
		panTabGestEmpruntHaut.setLayout(new BorderLayout(0, 0));

		//PanHaut Ajout du module recherche
		RechercherUnLivre rechercherUnLivre = new RechercherUnLivre();
		panTabGestEmpruntHaut.add(rechercherUnLivre, BorderLayout.WEST);
		//PanHaut Ajout du module Information Livre
		InformationLivre gestEmpruntInformationLivre = new InformationLivre();
		gestEmpruntInformationLivre.setPreferredSize(new Dimension(300, 300));
		gestEmpruntInformationLivre.setMinimumSize(new Dimension(300, 300));
		panTabGestEmpruntHaut.add(gestEmpruntInformationLivre, BorderLayout.CENTER);
		gestEmpruntInformationLivre.setCommentaireEditable(true);

		//Création Panel du bas
		JPanel panTabGestEmpruntBas = new JPanel();
		tabGestEmprunt.add(panTabGestEmpruntBas);
		panTabGestEmpruntBas.setLayout(new BorderLayout(0, 0));
		//PanBas Ajout du module recherche adhérent
		RechercherUnAdherent rechercherUnAdherent = new RechercherUnAdherent();
		panTabGestEmpruntBas.add(rechercherUnAdherent, BorderLayout.CENTER);
		//PanBas Ajout du module Emprunt/Retour
		EmpruntRetour empruntRetour = new EmpruntRetour();
		panTabGestEmpruntBas.add(empruntRetour, BorderLayout.EAST);

		//*********************************************Tab gestion du fond*************************************************//
		//Création Panel
		RechercherUnLivre gestFondRechercherUnLivre = new RechercherUnLivre();
		gestFondRechercherUnLivre.addBoutonCreerLivre();
		tabGestFond.add(gestFondRechercherUnLivre);
		InformationLivre gestFondInformationLivre = new InformationLivre();
		gestFondInformationLivre.setCommentaireEditable(true);
		tabGestFond.add(gestFondInformationLivre);

		//*********************************************Tab gestion du stock*************************************************//
		//Création Panel
		tabGestStock.setLayout(new BorderLayout(5, 5));
		tabGestStock.add(new GestionStock(), BorderLayout.WEST);
		tabGestStock.add(new GestionStockResultAffich(), BorderLayout.CENTER);

		//*********************************************Tab Admin*************************************************//
		//Création Panel
		tabAdmin.setLayout(new BorderLayout(5, 5));
		tabAdmin.add(new GestionEmployes(), BorderLayout.WEST);
		tabAdmin.add(new GestionEmployesResultAffich(), BorderLayout.CENTER);

	}
}

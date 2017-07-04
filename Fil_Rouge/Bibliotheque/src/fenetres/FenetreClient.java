package fenetres;

import javax.swing.JFrame;

import panneaux.Header;
import panneaux.InformationLivre;
import panneaux.RechercherUnLivre;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class FenetreClient extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -629171735000729382L;

	public FenetreClient() {
		this.setMinimumSize(new Dimension(800, 600));
		this.setSize(800, 600);
		this.setTitle("Bienvenu dans le logiciel de la bibliothèque");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.getContentPane().setLayout(new BorderLayout(5, 5));
		
		//Création des modules composant cette Frame
		RechercherUnLivre moduleRechercheLivre = new RechercherUnLivre();
		moduleRechercheLivre.setMaximumSize(new Dimension(500, 2147483647));
		moduleRechercheLivre.setPreferredSize(new Dimension(250, 200));
		moduleRechercheLivre.setMinimumSize(new Dimension(150, 200));
		InformationLivre moduleInformationLivre = new InformationLivre();
		Header moduleHeader = new Header("Espace visiteurs");
		
		this.getContentPane().add(moduleHeader, BorderLayout.NORTH);
		this.getContentPane().add(moduleRechercheLivre, BorderLayout.WEST);
		this.getContentPane().add(moduleInformationLivre, BorderLayout.CENTER);

	}

}

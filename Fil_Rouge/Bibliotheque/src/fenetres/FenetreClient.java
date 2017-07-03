package fenetres;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class FenetreClient extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -629171735000729382L;

	public FenetreClient() {
		setMinimumSize(new Dimension(800, 600));
		this.setSize(800, 600);
		this.setTitle("Bienvenu dans le logiciel de la bibliothèque");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.getContentPane().setLayout(new BorderLayout(5, 5));
		RechercherUnLivre moduleRecherche = new RechercherUnLivre();
		InformationLivre moduleInformation = new InformationLivre();
		Header moduleHeader = new Header();
		this.getContentPane().add(moduleHeader, BorderLayout.NORTH);
		this.getContentPane().add(moduleRecherche, BorderLayout.WEST);
		this.getContentPane().add(moduleInformation, BorderLayout.CENTER);

	}

}

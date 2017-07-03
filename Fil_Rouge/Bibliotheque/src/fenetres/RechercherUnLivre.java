package fenetres;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class RechercherUnLivre extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;
	
	//Données membre //TODO Penser à changer avec getter et setter dans le code final
	private JTextField textFieldTitre;
	private JTextField textFieldAuteur;
	private JTextField textFieldTheme;
	private JTable tabRenvoiResultatsLivre;
	
	//Constructeur
	public RechercherUnLivre() {
		setBorder(new TitledBorder(null, "Rechercher un ouvrage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panRechercheResultats = new JPanel();
		add(panRechercheResultats);
		panRechercheResultats.setLayout(new GridLayout(2, 1, 5, 5));
		
		//////////////////////////////////////Panel de la recherche de livre//////////////////////////////////////
		JPanel panRecherche = new JPanel();
		panRechercheResultats.add(panRecherche);
		panRecherche.setLayout(new GridLayout(4, 1, 5, 5));
		
		//panRechercheLabel
		JPanel panRechercheTitre = new JPanel();
		panRecherche.add(panRechercheTitre);
		panRechercheTitre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblTitre = new JLabel("Titre");
		panRechercheTitre.add(lblTitre);
		textFieldTitre = new JTextField();
		panRechercheTitre.add(textFieldTitre);
		textFieldTitre.setColumns(10);
		
		JPanel panRechercheAuteur = new JPanel();
		panRechercheAuteur.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheAuteur);
		panRechercheAuteur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblAuteur = new JLabel("Auteur");
		panRechercheAuteur.add(lblAuteur);
		textFieldAuteur = new JTextField();
		panRechercheAuteur.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);
		
		JPanel panRechercheTheme = new JPanel();
		panRecherche.add(panRechercheTheme);
		panRechercheTheme.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblTheme = new JLabel("Theme");
		panRechercheTheme.add(lblTheme);
		textFieldTheme = new JTextField();
		panRechercheTheme.add(textFieldTheme);
		textFieldTheme.setColumns(10);
		
		JPanel panRechercheBoutton = new JPanel();
		panRecherche.add(panRechercheBoutton);
		JButton btnRechercherLivre = new JButton("Rechercher");
		panRechercheBoutton.add(btnRechercherLivre);
		
		//////////////////////////////////////Panel des resultats//////////////////////////////////////
		JPanel panResultats = new JPanel();
		panRechercheResultats.add(panResultats);
		panResultats.setLayout(new BorderLayout(5, 5));
		
		//TODO Remplir la JTable
		tabRenvoiResultatsLivre = new JTable();
		tabRenvoiResultatsLivre.setPreferredSize(new Dimension(60, 100));
		panResultats.add(tabRenvoiResultatsLivre, BorderLayout.CENTER);
		
		JButton btnResultatsPlusInfos = new JButton("+ d'infos");
		panResultats.add(btnResultatsPlusInfos, BorderLayout.SOUTH);
		
		JLabel lblRenvoiResultatsTitre = new JLabel("Livre(s) correspondant(s) :");
		panResultats.add(lblRenvoiResultatsTitre, BorderLayout.NORTH);

	}
}

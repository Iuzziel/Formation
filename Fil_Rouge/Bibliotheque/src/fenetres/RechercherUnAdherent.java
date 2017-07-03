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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.BoxLayout;

public class RechercherUnAdherent extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;
	
	//Données membre //TODO Penser à changer avec getter et setter dans le code final
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTable tabRenvoiResultatsAdherent;
	private JTable tabAdherentLivreEmprunte;
	
	//Constructeur
	public RechercherUnAdherent() {
		setMinimumSize(new Dimension(200, 200));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rechercher un adh\u00E9rent", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panRechercheResultats = new JPanel();
		add(panRechercheResultats);
		panRechercheResultats.setLayout(new GridLayout(2, 1, 5, 5));
		
		//////////////////////////////////////Panel de la recherche d'un adhérent//////////////////////////////////////
		JPanel panRechercheAdherent = new JPanel();
		panRechercheResultats.add(panRechercheAdherent);
		panRechercheAdherent.setLayout(new GridLayout(4, 1, 5, 5));
		
		//panRechercheNom
		JPanel panRechercheNom = new JPanel();
		panRechercheAdherent.add(panRechercheNom);
		panRechercheNom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblNom = new JLabel("Nom");
		panRechercheNom.add(lblNom);
		textFieldNom = new JTextField();
		panRechercheNom.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JPanel panRecherchePrenom = new JPanel();
		panRecherchePrenom.setMaximumSize(new Dimension(600, 35));
		panRechercheAdherent.add(panRecherchePrenom);
		panRecherchePrenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		panRecherchePrenom.add(lblPrenom);
		textFieldPrenom = new JTextField();
		panRecherchePrenom.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JPanel panRechercheBoutton = new JPanel();
		panRechercheAdherent.add(panRechercheBoutton);
		JButton btnRechercherLivre = new JButton("Rechercher");
		panRechercheBoutton.add(btnRechercherLivre);
		
		//////////////////////////////////////Panel des resultats//////////////////////////////////////
		JPanel panResultats = new JPanel();
		panRechercheResultats.add(panResultats);
		panResultats.setLayout(new BorderLayout(5, 5));
		
		//TODO Remplir la JTable
		tabRenvoiResultatsAdherent = new JTable();
		tabRenvoiResultatsAdherent.setPreferredSize(new Dimension(60, 100));
		panResultats.add(tabRenvoiResultatsAdherent, BorderLayout.CENTER);
		
		JButton btnResultatsValider = new JButton("Valider");
		panResultats.add(btnResultatsValider, BorderLayout.SOUTH);
		
		JLabel lblRenvoiResultatsTitre = new JLabel("Adh\u00E9rent(s) correspondant(s) :");
		panResultats.add(lblRenvoiResultatsTitre, BorderLayout.NORTH);
		
		JPanel panInformationAdherent = new JPanel();
		panInformationAdherent.setBorder(new TitledBorder(null, "Information sur l'adh\u00E9rent", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panInformationAdherent);
		panInformationAdherent.setLayout(new BorderLayout(0, 0));
		
		JPanel panInformationPerso = new JPanel();
		panInformationAdherent.add(panInformationPerso, BorderLayout.NORTH);
		panInformationPerso.setLayout(new BoxLayout(panInformationPerso, BoxLayout.Y_AXIS));
		
		JLabel lblRetourNom = new JLabel("Nom : ");
		panInformationPerso.add(lblRetourNom);
		
		JLabel lblRetourPrenom = new JLabel("Pr\u00E9nom : ");
		panInformationPerso.add(lblRetourPrenom);
		
		JLabel lblRetourAdresse = new JLabel("Adresse : ");
		panInformationPerso.add(lblRetourAdresse);
		
		JLabel lblRetourDateCotisation = new JLabel("Date du dernier paiement de cotisation : ");
		panInformationPerso.add(lblRetourDateCotisation);
		
		JLabel lblRetourCotisationOk = new JLabel("A jour dans sa cotisation ? : ");
		panInformationPerso.add(lblRetourCotisationOk);
		
		JButton btnEditerCetAdhrent = new JButton("Editer cet Adh\u00E9rent ?");
		panInformationPerso.add(btnEditerCetAdhrent);
		
		JPanel panInformationEmprunt = new JPanel();
		panInformationAdherent.add(panInformationEmprunt, BorderLayout.CENTER);
		
		JLabel lblLivresEmprunts = new JLabel("Livre(s) emprunt\u00E9(s) : ");
		panInformationEmprunt.add(lblLivresEmprunts);
		
		tabAdherentLivreEmprunte = new JTable();
		tabAdherentLivreEmprunte.setPreferredSize(new Dimension(50, 50));
		tabAdherentLivreEmprunte.setMinimumSize(new Dimension(50, 50));
		panInformationEmprunt.add(tabAdherentLivreEmprunte);

	}
}

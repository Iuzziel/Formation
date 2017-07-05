package panneaux;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

public class RechercherUnLivre extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;

	//Données membre 
	//TODO Penser à changer avec getter et setter dans le code final
	private JTextField textFieldTitre;
	private JTextField textFieldAuteur;
	private JTextField textFieldTheme;
	private JTextField textFieldExemplaire;
	private JTable tabRenvoiResultatsLivre;
	private JPanel panRechercheBoutton = new JPanel();

	//Constructeur
	public RechercherUnLivre() {
		setBorder(new TitledBorder(null, "Rechercher un ouvrage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panRechercheResultats = new JPanel();
		add(panRechercheResultats);
		panRechercheResultats.setLayout(new BoxLayout(panRechercheResultats, BoxLayout.Y_AXIS));

		//////////////////////////////////////Panel de la recherche de livre//////////////////////////////////////
		JPanel panRecherche = new JPanel();
		panRechercheResultats.add(panRecherche);
		panRecherche.setLayout(new BoxLayout(panRecherche, BoxLayout.Y_AXIS));

		//panRecherche rangé par label associé
		//Titre
		JPanel panRechercheTitre = new JPanel();
		panRechercheTitre.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheTitre.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheTitre);
		panRechercheTitre.setLayout(new BoxLayout(panRechercheTitre, BoxLayout.X_AXIS));
		JLabel lblTitre = new JLabel("Titre : ");
		panRechercheTitre.add(lblTitre);
		textFieldTitre = new JTextField();
		panRechercheTitre.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		//Auteur
		JPanel panRechercheAuteur = new JPanel();
		panRechercheAuteur.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheAuteur.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheAuteur);
		panRechercheAuteur.setLayout(new BoxLayout(panRechercheAuteur, BoxLayout.X_AXIS));
		JLabel lblAuteur = new JLabel("Auteur : ");
		panRechercheAuteur.add(lblAuteur);
		textFieldAuteur = new JTextField();
		panRechercheAuteur.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);

		//Theme
		JPanel panRechercheTheme = new JPanel();
		panRechercheTheme.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheTheme.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheTheme);
		panRechercheTheme.setLayout(new BoxLayout(panRechercheTheme, BoxLayout.X_AXIS));
		JLabel lblTheme = new JLabel("Th\u00E8me : ");
		panRechercheTheme.add(lblTheme);
		textFieldTheme = new JTextField();
		panRechercheTheme.add(textFieldTheme);
		textFieldTheme.setColumns(10);

		//Numéro exemplaire
		JPanel panRechercheExemplaire = new JPanel();
		panRechercheExemplaire.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheExemplaire.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheExemplaire);
		panRechercheExemplaire.setLayout(new BoxLayout(panRechercheExemplaire, BoxLayout.X_AXIS));
		JLabel lblExemplaire = new JLabel("Code exemplaire : ");
		panRechercheExemplaire.add(lblExemplaire);
		textFieldExemplaire = new JTextField();
		panRechercheExemplaire.add(textFieldExemplaire);
		textFieldExemplaire.setColumns(10);

		//Bouton Rechercher
		panRechercheBoutton.setBorder(new EmptyBorder(2, 0, 2, 0));
		panRecherche.add(panRechercheBoutton);
		panRechercheBoutton.setLayout(new BoxLayout(panRechercheBoutton, BoxLayout.X_AXIS));
		JButton btnRechercherLivre = new JButton("Rechercher");
		panRechercheBoutton.add(btnRechercherLivre);

		//////////////////////////////////////Panel des resultats//////////////////////////////////////
		JPanel panResultats = new JPanel();
		panRechercheResultats.add(panResultats);
		panResultats.setLayout(new BorderLayout(5, 5));

		JLabel lblRenvoiResultatsTitre = new JLabel("Livre(s) correspondant(s) :");
		panResultats.add(lblRenvoiResultatsTitre, BorderLayout.NORTH);

		//TODO Remplir la JTable avec 2 vectors
		tabRenvoiResultatsLivre = new JTable();
		tabRenvoiResultatsLivre.setPreferredSize(new Dimension(250, 150));
		panResultats.add(tabRenvoiResultatsLivre, BorderLayout.CENTER);

		JScrollPane srlTabRenvoiResultatsLivre = new JScrollPane(tabRenvoiResultatsLivre);
		panResultats.add(srlTabRenvoiResultatsLivre, BorderLayout.CENTER);

		//Bouton +d'info et son panel
		JPanel panResultatsBtnPlusInfos = new JPanel();
		panResultats.add(panResultatsBtnPlusInfos, BorderLayout.SOUTH);
		JButton btnResultatsPlusInfos = new JButton("+ d'infos");
		panResultatsBtnPlusInfos.add(btnResultatsPlusInfos);

	}


	//**********************************Accesseurs**********************************//
	public JTextField getTextFieldTitre() {
		return textFieldTitre;
	}

	public void setTextFieldTitre(JTextField textFieldTitre) {
		this.textFieldTitre = textFieldTitre;
	}

	public JTextField getTextFieldAuteur() {
		return textFieldAuteur;
	}

	public void setTextFieldAuteur(JTextField textFieldAuteur) {
		this.textFieldAuteur = textFieldAuteur;
	}

	public JTextField getTextFieldTheme() {
		return textFieldTheme;
	}

	public void setTextFieldTheme(JTextField textFieldTheme) {
		this.textFieldTheme = textFieldTheme;
	}

	public JTextField getTextFieldExemplaire() {
		return textFieldExemplaire;
	}

	public void setTextFieldExemplaire(JTextField textFieldExemplaire) {
		this.textFieldExemplaire = textFieldExemplaire;
	}

	public JTable getTabRenvoiResultatsLivre() {
		return tabRenvoiResultatsLivre;
	}

	public void setTabRenvoiResultatsLivre(JTable tabRenvoiResultatsLivre) {
		this.tabRenvoiResultatsLivre = tabRenvoiResultatsLivre;
	}

	public JPanel getPanRechercheBoutton() {
		return panRechercheBoutton;
	}

	public void setPanRechercheBoutton(JPanel panRechercheBoutton) {
		this.panRechercheBoutton = panRechercheBoutton;
	}

	//**********************************Méthodes**********************************//
	public void addBoutonCreerLivre() {
		JButton ajouterLivre = new JButton("Ajouter un livre ");
		panRechercheBoutton.add(ajouterLivre);
	}
}

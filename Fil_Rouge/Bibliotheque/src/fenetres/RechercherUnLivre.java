package fenetres;

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
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panRechercheResultats = new JPanel();
		add(panRechercheResultats);
		panRechercheResultats.setLayout(new BoxLayout(panRechercheResultats, BoxLayout.Y_AXIS));

		//////////////////////////////////////Panel de la recherche de livre//////////////////////////////////////
		JPanel panRecherche = new JPanel();
		panRechercheResultats.add(panRecherche);
		panRecherche.setLayout(new BoxLayout(panRecherche, BoxLayout.Y_AXIS));

		//panRechercheLabel
		JPanel panRechercheTitre = new JPanel();
		panRecherche.add(panRechercheTitre);
		panRechercheTitre.setLayout(new BoxLayout(panRechercheTitre, BoxLayout.X_AXIS));
		JLabel lblTitre = new JLabel("Titre : ");
		panRechercheTitre.add(lblTitre);
		textFieldTitre = new JTextField();
		panRechercheTitre.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		JPanel panRechercheAuteur = new JPanel();
		panRechercheAuteur.setMaximumSize(new Dimension(600, 35));
		panRecherche.add(panRechercheAuteur);
		panRechercheAuteur.setLayout(new BoxLayout(panRechercheAuteur, BoxLayout.X_AXIS));
		JLabel lblAuteur = new JLabel("Auteur : ");
		panRechercheAuteur.add(lblAuteur);
		textFieldAuteur = new JTextField();
		panRechercheAuteur.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);

		JPanel panRechercheTheme = new JPanel();
		panRecherche.add(panRechercheTheme);
		panRechercheTheme.setLayout(new BoxLayout(panRechercheTheme, BoxLayout.X_AXIS));
		JLabel lblTheme = new JLabel("Th\u00E8me : ");
		panRechercheTheme.add(lblTheme);
		textFieldTheme = new JTextField();
		panRechercheTheme.add(textFieldTheme);
		textFieldTheme.setColumns(10);

		JPanel panRechercheBoutton = new JPanel();
		panRecherche.add(panRechercheBoutton);
		panRechercheBoutton.setLayout(new BoxLayout(panRechercheBoutton, BoxLayout.X_AXIS));
		JButton btnRechercherLivre = new JButton("Rechercher");
		panRechercheBoutton.add(btnRechercherLivre);

		//////////////////////////////////////Panel des resultats//////////////////////////////////////
		JPanel panResultats = new JPanel();
		panRechercheResultats.add(panResultats);
		panResultats.setLayout(new BorderLayout(5, 5));

		JButton btnResultatsPlusInfos = new JButton("+ d'infos");
		panResultats.add(btnResultatsPlusInfos, BorderLayout.SOUTH);

		JLabel lblRenvoiResultatsTitre = new JLabel("Livre(s) correspondant(s) :");
		panResultats.add(lblRenvoiResultatsTitre, BorderLayout.NORTH);


		//TODO Remplir la JTable avec 2 vectors
		tabRenvoiResultatsLivre = new JTable();
		tabRenvoiResultatsLivre.setPreferredSize(new Dimension(250, 150));
		panResultats.add(tabRenvoiResultatsLivre, BorderLayout.CENTER);

		JScrollPane srlTabRenvoiResultatsLivre = new JScrollPane(tabRenvoiResultatsLivre);
		panResultats.add(srlTabRenvoiResultatsLivre, BorderLayout.WEST);

	}
}

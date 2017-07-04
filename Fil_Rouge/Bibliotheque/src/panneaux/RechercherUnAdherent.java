package panneaux;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class RechercherUnAdherent extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;

	//Données membre //TODO Penser à changer avec getter et setter dans le code final
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldNumeroAdherent;
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
		panRechercheAdherent.setLayout(new BoxLayout(panRechercheAdherent, BoxLayout.Y_AXIS));

		//panRechercheNom
		JPanel panRechercheNom = new JPanel();
		panRechercheNom.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheNom.setMaximumSize(new Dimension(600, 35));
		panRechercheAdherent.add(panRechercheNom);
		panRechercheNom.setLayout(new BoxLayout(panRechercheNom, BoxLayout.X_AXIS));
		JLabel lblNom = new JLabel("Nom : ");
		panRechercheNom.add(lblNom);
		textFieldNom = new JTextField();
		panRechercheNom.add(textFieldNom);
		textFieldNom.setColumns(10);

		//panRecherchePrenom
		JPanel panRecherchePrenom = new JPanel();
		panRecherchePrenom.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRecherchePrenom.setMaximumSize(new Dimension(600, 35));
		panRechercheAdherent.add(panRecherchePrenom);
		panRecherchePrenom.setLayout(new BoxLayout(panRecherchePrenom, BoxLayout.X_AXIS));
		JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
		panRecherchePrenom.add(lblPrenom);
		textFieldPrenom = new JTextField();
		panRecherchePrenom.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);

		//panRechercheCodeAdhérent
		JPanel panRechercheNumeroAdherent = new JPanel();
		panRechercheNumeroAdherent.setBorder(new EmptyBorder(2, 2, 2, 2));
		panRechercheNumeroAdherent.setMaximumSize(new Dimension(600, 35));
		panRechercheAdherent.add(panRechercheNumeroAdherent);
		panRechercheNumeroAdherent.setLayout(new BoxLayout(panRechercheNumeroAdherent, BoxLayout.X_AXIS));
		JLabel lblNumeroAdherent = new JLabel("Num\u00E9ro adh\u00E9rent : ");
		panRechercheNumeroAdherent.add(lblNumeroAdherent);
		textFieldNumeroAdherent = new JTextField();
		panRechercheNumeroAdherent.add(textFieldNumeroAdherent);
		textFieldNumeroAdherent.setColumns(10);

		//panRechercheBoutton
		JPanel panRechercheBoutton = new JPanel();
		panRechercheAdherent.add(panRechercheBoutton);
		JButton btnRechercherLivre = new JButton("Rechercher");
		panRechercheBoutton.add(btnRechercherLivre);

		//////////////////////////////////////Panel des resultats//////////////////////////////////////
		JPanel panResultats = new JPanel();
		panRechercheResultats.add(panResultats);
		panResultats.setLayout(new BorderLayout(5, 5));

		//Création de la Jtable, association à la JScrollPane, puis ajout dans le panel/ ensuite bouton, puis label
		//TODO Remplir la JTable
		tabRenvoiResultatsAdherent = new JTable();
		tabRenvoiResultatsAdherent.setPreferredSize(new Dimension(60, 100));

		JScrollPane srlTabRenvoiResultatsAdherent = new JScrollPane(tabRenvoiResultatsAdherent);
		panResultats.add(srlTabRenvoiResultatsAdherent, BorderLayout.CENTER);

		JButton btnResultatsValider = new JButton("Valider");
		panResultats.add(btnResultatsValider, BorderLayout.SOUTH);

		JLabel lblRenvoiResultatsTitre = new JLabel("Adh\u00E9rent(s) correspondant(s) :");
		panResultats.add(lblRenvoiResultatsTitre, BorderLayout.NORTH);

		//////////////////////////////////////Panel des infos adhérent renvoyé après la recherche//////////////////////////////////////
		//Renvoie de tout les label TODO Ajouter les textfields liés aux infos
		JPanel panInformationAdherent = new JPanel();
		panInformationAdherent.setBorder(new TitledBorder(null, "Information sur l'adh\u00E9rent", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panInformationAdherent);
		panInformationAdherent.setLayout(new BorderLayout(5, 5));
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
		panInformationEmprunt.setLayout(new BorderLayout(5, 5));
		JLabel lblLivresEmprunts = new JLabel("Livre(s) emprunt\u00E9(s) : ");
		panInformationEmprunt.add(lblLivresEmprunts, BorderLayout.NORTH);

		//Création de la Jtable, association à la JScrollPane, puis ajout dans le panel
		//TODO Remplir la JTable
		tabAdherentLivreEmprunte = new JTable();
		tabAdherentLivreEmprunte.setPreferredSize(new Dimension(50, 50));

		JScrollPane srlTabAdherentLivreEmprunte = new JScrollPane(tabAdherentLivreEmprunte);
		panInformationEmprunt.add(srlTabAdherentLivreEmprunte, BorderLayout.CENTER);


	}
}

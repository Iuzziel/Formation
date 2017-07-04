package panneaux;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class InformationLivre extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;

	//Données membre
	private JTextField textFieldTitre;
	private JTextField textFieldAuteur;
	private JTextField textFieldTheme;
	private JTextField textFieldEmplacement;
	private JTextField textFieldISBN;
	private JTextField textFieldISSN;
	private JTextField textFieldNbExemplaireDispo;
	private JTextField textFieldNbExemplaireDispoBiblio;

	public InformationLivre() {
		setBorder(new TitledBorder(null, "Information sur le livre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		/////////////////////Regroupement des Infos + TextField/////////////////////
		JPanel panInfoNord = new JPanel();
		panInfoNord.setBorder(new EmptyBorder(0, 2, 5, 2));
		add(panInfoNord, BorderLayout.NORTH);
		panInfoNord.setLayout(new GridLayout(0, 2, 5, 5));

		/////////////////////Création des Infos & TextField/////////////////////
		//Titre
		JPanel panInfoNordTitre = new JPanel();
		panInfoNord.add(panInfoNordTitre);
		panInfoNordTitre.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblTitre = new JLabel("Titre :");
		panInfoNordTitre.add(lblTitre);
		textFieldTitre = new JTextField();
		panInfoNordTitre.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		//Nombre d'exemplaire dispo
		JPanel panInfoNordNbExemplaireDispo = new JPanel();
		panInfoNord.add(panInfoNordNbExemplaireDispo);
		panInfoNordNbExemplaireDispo.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblNbExemplaireDispo = new JLabel("Nombre d'exemplaire disponible :");
		panInfoNordNbExemplaireDispo.add(lblNbExemplaireDispo);
		textFieldNbExemplaireDispo = new JTextField();
		panInfoNordNbExemplaireDispo.add(textFieldNbExemplaireDispo);
		textFieldNbExemplaireDispo.setColumns(5);

		//Auteur
		JPanel panInfoNordAuteur = new JPanel();
		panInfoNord.add(panInfoNordAuteur);
		panInfoNordAuteur.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblAuteur = new JLabel("Auteur :");
		panInfoNordAuteur.add(lblAuteur);
		textFieldAuteur = new JTextField();
		panInfoNordAuteur.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);

		//Nombre d'exemplaire dispo dans CETTE bibliothèque
		JPanel panInfoNordNbExemplaireDispoBiblio = new JPanel();
		panInfoNord.add(panInfoNordNbExemplaireDispoBiblio);
		panInfoNordNbExemplaireDispoBiblio.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblNbExemplaireDispoBiblio = new JLabel("Nb d'exemplaire dispo dans cette biblioth\u00E8que :");
		panInfoNordNbExemplaireDispoBiblio.add(lblNbExemplaireDispoBiblio);
		textFieldNbExemplaireDispoBiblio = new JTextField();
		panInfoNordNbExemplaireDispoBiblio.add(textFieldNbExemplaireDispoBiblio);
		textFieldNbExemplaireDispoBiblio.setColumns(5);

		//Theme
		JPanel panInfoNordTheme = new JPanel();
		panInfoNord.add(panInfoNordTheme);
		panInfoNordTheme.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblTheme = new JLabel("Th\u00E8me :");
		panInfoNordTheme.add(lblTheme);
		textFieldTheme = new JTextField();
		panInfoNordTheme.add(textFieldTheme);
		textFieldTheme.setColumns(10);

		//Emplacement
		JPanel panInfoNordEmplacement = new JPanel();
		panInfoNord.add(panInfoNordEmplacement);
		panInfoNordEmplacement.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblEmplacement = new JLabel("Emplacement :");
		panInfoNordEmplacement.add(lblEmplacement);
		textFieldEmplacement = new JTextField();
		panInfoNordEmplacement.add(textFieldEmplacement);
		textFieldEmplacement.setColumns(10);

		//ISBN
		JPanel panInfoNordISBN = new JPanel();
		panInfoNord.add(panInfoNordISBN);
		panInfoNordISBN.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblIsbn = new JLabel("ISBN :");
		panInfoNordISBN.add(lblIsbn);
		textFieldISBN = new JTextField();
		panInfoNordISBN.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		//ISSN
		JPanel panInfoNordISSN = new JPanel();
		panInfoNord.add(panInfoNordISSN);
		panInfoNordISSN.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblIssn = new JLabel("ISSN :");
		panInfoNordISSN.add(lblIssn);
		textFieldISSN = new JTextField();
		panInfoNordISSN.add(textFieldISSN);
		textFieldISSN.setColumns(10);

		/////////////////////Zone Centre, commentaire/////////////////////
		JPanel panInfoCentre = new JPanel();
		add(panInfoCentre, BorderLayout.CENTER);
		panInfoCentre.setLayout(new BoxLayout(panInfoCentre, BoxLayout.X_AXIS));

		JTextArea txtrCommentaire = new JTextArea();
		txtrCommentaire.setPreferredSize(new Dimension(150, 150));
		txtrCommentaire.setMinimumSize(new Dimension(150, 150));
		txtrCommentaire.setEditable(false);
		txtrCommentaire.setLineWrap(true);
		txtrCommentaire.setWrapStyleWord(true);
		txtrCommentaire.setText("Commentaire : ");
		panInfoCentre.add(txtrCommentaire);

		/////////////////////Zone Sud, bouton quitter/////////////////////
		JPanel panInfoSud = new JPanel();
		add(panInfoSud, BorderLayout.SOUTH);

		JButton btnQuitterLaRecherche = new JButton("Quitter la Recherche");
		panInfoSud.add(btnQuitterLaRecherche);

	}
}

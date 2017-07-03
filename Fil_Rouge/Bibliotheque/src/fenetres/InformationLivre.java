package fenetres;

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
import java.awt.FlowLayout;

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
		add(panInfoNord, BorderLayout.NORTH);
		panInfoNord.setLayout(new GridLayout(4, 2, 0, 0));

		JPanel panInfoNordTitre = new JPanel();
		FlowLayout fl_panInfoNordTitre = (FlowLayout) panInfoNordTitre.getLayout();
		fl_panInfoNordTitre.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordTitre);

		JPanel panInfoNordNbExemplaireDispo = new JPanel();
		FlowLayout fl_panInfoNordNbExemplaireDispo = (FlowLayout) panInfoNordNbExemplaireDispo.getLayout();
		fl_panInfoNordNbExemplaireDispo.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordNbExemplaireDispo);

		JPanel panInfoNordAuteur = new JPanel();
		FlowLayout fl_panInfoNordAuteur = (FlowLayout) panInfoNordAuteur.getLayout();
		fl_panInfoNordAuteur.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordAuteur);

		JPanel panInfoNordNbExemplaireDispoBiblio = new JPanel();
		FlowLayout fl_panInfoNordNbExemplaireDispoBiblio = (FlowLayout) panInfoNordNbExemplaireDispoBiblio.getLayout();
		fl_panInfoNordNbExemplaireDispoBiblio.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordNbExemplaireDispoBiblio);

		JPanel panInfoNordTheme = new JPanel();
		FlowLayout fl_panInfoNordTheme = (FlowLayout) panInfoNordTheme.getLayout();
		fl_panInfoNordTheme.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordTheme);

		JPanel panInfoNordEmplacement = new JPanel();
		FlowLayout fl_panInfoNordEmplacement = (FlowLayout) panInfoNordEmplacement.getLayout();
		fl_panInfoNordEmplacement.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordEmplacement);

		JPanel panInfoNordISBN = new JPanel();
		FlowLayout fl_panInfoNordISBN = (FlowLayout) panInfoNordISBN.getLayout();
		fl_panInfoNordISBN.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordISBN);

		JPanel panInfoNordISSN = new JPanel();
		FlowLayout fl_panInfoNordISSN = (FlowLayout) panInfoNordISSN.getLayout();
		fl_panInfoNordISSN.setAlignment(FlowLayout.LEFT);
		panInfoNord.add(panInfoNordISSN);

		/////////////////////Création des Infos & TextField/////////////////////
		//Titre
		JLabel lblTitre = new JLabel("Titre :");
		panInfoNordTitre.add(lblTitre);
		textFieldTitre = new JTextField();
		panInfoNordTitre.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		//Auteur
		JLabel lblAuteur = new JLabel("Auteur :");
		panInfoNordAuteur.add(lblAuteur);
		textFieldAuteur = new JTextField();
		panInfoNordAuteur.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);

		//Theme
		JLabel lblTheme = new JLabel("Th\u00E8me :");
		panInfoNordTheme.add(lblTheme);
		textFieldTheme = new JTextField();
		panInfoNordTheme.add(textFieldTheme);
		textFieldTheme.setColumns(10);

		//Emplacement
		JLabel lblEmplacement = new JLabel("Emplacement :");
		panInfoNordEmplacement.add(lblEmplacement);
		textFieldEmplacement = new JTextField();
		panInfoNordEmplacement.add(textFieldEmplacement);
		textFieldEmplacement.setColumns(10);

		//ISBN
		JLabel lblIsbn = new JLabel("ISBN :");
		panInfoNordISBN.add(lblIsbn);
		textFieldISBN = new JTextField();
		panInfoNordISBN.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		//ISSN
		JLabel lblIssn = new JLabel("ISSN :");
		panInfoNordISSN.add(lblIssn);
		textFieldISSN = new JTextField();
		panInfoNordISSN.add(textFieldISSN);
		textFieldISSN.setColumns(10);

		//Nombre d'exemplaire dispo
		JLabel lblNbExemplaireDispo = new JLabel("Nombre d'exemplaire disponible :");
		panInfoNordNbExemplaireDispo.add(lblNbExemplaireDispo);
		textFieldNbExemplaireDispo = new JTextField();
		panInfoNordNbExemplaireDispo.add(textFieldNbExemplaireDispo);
		textFieldNbExemplaireDispo.setColumns(5);

		//Nombre d'exemplaire dispo dans CETTE bibliothèque
		JLabel lblNbExemplaireDispoBiblio = new JLabel("Nombre d'exemplaire disponible dans cette biblioth\u00E8que :");
		panInfoNordNbExemplaireDispoBiblio.add(lblNbExemplaireDispoBiblio);
		textFieldNbExemplaireDispoBiblio = new JTextField();
		panInfoNordNbExemplaireDispoBiblio.add(textFieldNbExemplaireDispoBiblio);
		textFieldNbExemplaireDispoBiblio.setColumns(5);

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

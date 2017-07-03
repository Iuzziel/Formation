package fenetres;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class InformationLivre extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3793794312904965025L;
	
	public InformationLivre() {
		setBorder(new TitledBorder(null, "Information sur le livre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panInfoNord = new JPanel();
		add(panInfoNord, BorderLayout.NORTH);
		panInfoNord.setLayout(new BoxLayout(panInfoNord, BoxLayout.Y_AXIS));
		
		JLabel lblTitre = new JLabel("Titre :");
		panInfoNord.add(lblTitre);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		panInfoNord.add(lblAuteur);
		
		JLabel lblTheme = new JLabel("Th\u00E8me :");
		panInfoNord.add(lblTheme);
		
		JLabel lblEmplacement = new JLabel("Emplacement :");
		panInfoNord.add(lblEmplacement);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		panInfoNord.add(lblIsbn);
		
		JLabel lblIssn = new JLabel("ISSN :");
		panInfoNord.add(lblIssn);
		
		JLabel lblNbExemplaireDispo = new JLabel("Nombre d'exemplaire disponible :");
		panInfoNord.add(lblNbExemplaireDispo);
		
		JLabel lblNbExemplaireDispoBiblio = new JLabel("Nombre d'exemplaire disponible dans cette biblioth\u00E8que :");
		panInfoNord.add(lblNbExemplaireDispoBiblio);
		
		JPanel panInfoCentre = new JPanel();
		add(panInfoCentre, BorderLayout.CENTER);
		
		JTextArea txtrCommentaire = new JTextArea();
		txtrCommentaire.setEditable(false);
		txtrCommentaire.setLineWrap(true);
		txtrCommentaire.setWrapStyleWord(true);
		txtrCommentaire.setText("Commentaire : ");
		panInfoCentre.add(txtrCommentaire);
		
		JPanel panInfoSud = new JPanel();
		add(panInfoSud, BorderLayout.SOUTH);
		
		JButton btnQuitterLaRecherche = new JButton("Quitter la Recherche");
		panInfoSud.add(btnQuitterLaRecherche);
		
		

	}
}

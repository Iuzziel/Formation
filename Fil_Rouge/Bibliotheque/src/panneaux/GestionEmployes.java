package panneaux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar.Separator;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class GestionEmployes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5357891521398913524L;
	private JTextField txtFieldNom;
	private JTextField txtFieldPrenom;
	private JTextField txtFieldId;

	public GestionEmployes() {
		setMinimumSize(new Dimension(200, 400));
		setPreferredSize(new Dimension(250, 500));
		setLayout(new BorderLayout(5, 5));

		// Creation du panel principal
		JPanel panGestionEmployes = new JPanel();
		panGestionEmployes.setBorder(
				new TitledBorder(null, "Gestion du role des employes", TitledBorder.LEADING, TitledBorder.TOP));
		panGestionEmployes.setLayout(new BoxLayout(panGestionEmployes, BoxLayout.Y_AXIS));
		add(panGestionEmployes);

		// Creations du panneau des conditions
		// Creations des donnees du panneau/titre
		JLabel lblTitre = new JLabel("Conditions pour apparaitre sur la liste : ");
		panGestionEmployes.add(lblTitre);

		// Creations du panneau des conditions/Bouton Radio groupe Tous&Filtrer
		JRadioButton rdoTous = new JRadioButton("Tous");
		panGestionEmployes.add(rdoTous);
		JRadioButton rdoFiltrer = new JRadioButton("Filtrer");
		panGestionEmployes.add(rdoFiltrer);
		ButtonGroup grpTousFiltrer = new ButtonGroup();
		grpTousFiltrer.add(rdoTous);
		grpTousFiltrer.add(rdoFiltrer);

		// Creations du panneau des conditions/Checkbox des 4 filtres
		JCheckBox chkBiblio = new JCheckBox("Bibliothecaire");
		panGestionEmployes.add(chkBiblio);
		JCheckBox chkRespons = new JCheckBox("Responsable");
		panGestionEmployes.add(chkRespons);
		JCheckBox chkGestionnaire = new JCheckBox("Gestionnaire de fond");
		panGestionEmployes.add(chkGestionnaire);
		JCheckBox chkAdmin = new JCheckBox("Administrateur");
		panGestionEmployes.add(chkAdmin);

		panGestionEmployes.add(new Separator());

		// Creations du panneau des conditions/Paneau des champs de recherche
		// Principale
		JPanel panRecherche = new JPanel();
		panGestionEmployes.add(panRecherche);
		panRecherche.setLayout(new BorderLayout(0, 0));
		// Principale/Panneaux DES champs
		JPanel panRechercheChamps = new JPanel();
		panRecherche.add(panRechercheChamps, BorderLayout.NORTH);
		panRechercheChamps.setLayout(new BoxLayout(panRechercheChamps, BoxLayout.Y_AXIS));

		// Creations du panneau des conditions/Paneau des champs de recherche/panneau +
		// label + champ nom
		JPanel panRechercheChampsNom = new JPanel();
		panRechercheChamps.add(panRechercheChampsNom);

		JLabel lblNom = new JLabel("Nom : ");
		panRechercheChampsNom.add(lblNom);

		txtFieldNom = new JTextField();
		panRechercheChampsNom.add(txtFieldNom);
		txtFieldNom.setColumns(10);

		// Creations du panneau des conditions/Paneau des champs de recherche/panneau +
		// label + champ prenom
		JPanel panRechercheChampsPrenom = new JPanel();
		panRechercheChamps.add(panRechercheChampsPrenom);

		JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
		panRechercheChampsPrenom.add(lblPrenom);

		txtFieldPrenom = new JTextField();
		panRechercheChampsPrenom.add(txtFieldPrenom);
		txtFieldPrenom.setColumns(10);

		// Creations du panneau des conditions/Paneau des champs de recherche/panneau +
		// label + champ identifiant
		JPanel panRechercheChampsId = new JPanel();
		panRechercheChamps.add(panRechercheChampsId);

		JLabel lblIdentifiant = new JLabel("Identifiant : ");
		panRechercheChampsId.add(lblIdentifiant);

		txtFieldId = new JTextField();
		panRechercheChampsId.add(txtFieldId);
		txtFieldId.setColumns(10);

	}

	// Accesseurs
	public JTextField getTxtFieldNom() {
		return txtFieldNom;
	}

	public void setTxtFieldNom(JTextField txtFieldNom) {
		this.txtFieldNom = txtFieldNom;
	}

	public JTextField getTxtFieldPrenom() {
		return txtFieldPrenom;
	}

	public void setTxtFieldPrenom(JTextField txtFieldPrenom) {
		this.txtFieldPrenom = txtFieldPrenom;
	}

	public JTextField getTxtFieldId() {
		return txtFieldId;
	}

	public void setTxtFieldId(JTextField txtFieldId) {
		this.txtFieldId = txtFieldId;
	}
}

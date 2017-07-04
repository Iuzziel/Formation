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
/*********************sgsdrfhwdtjhsrwtjwr*********************************/
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

		//Création du panel principal
		JPanel panGestionEmployes = new JPanel();
		panGestionEmployes.setBorder(new TitledBorder(null, "Gestion du rôle des employés", TitledBorder.LEADING, TitledBorder.TOP));
		panGestionEmployes.setLayout(new BoxLayout(panGestionEmployes, BoxLayout.Y_AXIS));
		add(panGestionEmployes);

		//Créations des données du paneau
		JLabel lblTitre = new JLabel("Conditions pour apparaître sur la liste : ");
		panGestionEmployes.add(lblTitre);

		//Bouton Radio groupé Tous/Filtrer
		JRadioButton rdoTous = new JRadioButton("Tous");
		panGestionEmployes.add(rdoTous);
		JRadioButton rdoFiltrer = new JRadioButton("Filtrer");
		panGestionEmployes.add(rdoFiltrer);
		ButtonGroup grpTousFiltrer = new ButtonGroup();
		grpTousFiltrer.add(rdoTous);
		grpTousFiltrer.add(rdoFiltrer);

		//Ajout des 4 checkbox du filtre
		JCheckBox chkBiblio = new JCheckBox("Bibliothécaire");
		panGestionEmployes.add(chkBiblio);		
		JCheckBox chkRespons = new JCheckBox("Responsable");
		panGestionEmployes.add(chkRespons);		
		JCheckBox chkGestionnaire = new JCheckBox("Gestionnaire de fond");
		panGestionEmployes.add(chkGestionnaire);		
		JCheckBox chkAdmin = new JCheckBox("Administrateur");
		panGestionEmployes.add(chkAdmin);

		panGestionEmployes.add(new Separator());
		
		JPanel panRecherche = new JPanel();
		panGestionEmployes.add(panRecherche);
		panRecherche.setLayout(new BorderLayout(0, 0));
		
		JPanel panRechercheChamps = new JPanel();
		panRecherche.add(panRechercheChamps, BorderLayout.NORTH);
		panRechercheChamps.setLayout(new BoxLayout(panRechercheChamps, BoxLayout.Y_AXIS));
		
		JPanel panRechercheChampsNom = new JPanel();
		panRechercheChamps.add(panRechercheChampsNom);
		
		JLabel lblNom = new JLabel("Nom : ");
		panRechercheChampsNom.add(lblNom);
		
		txtFieldNom = new JTextField();
		panRechercheChampsNom.add(txtFieldNom);
		txtFieldNom.setColumns(10);
		
		JPanel panRechercheChampsPrenom = new JPanel();
		panRechercheChamps.add(panRechercheChampsPrenom);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
		panRechercheChampsPrenom.add(lblPrenom);
		
		txtFieldPrenom = new JTextField();
		panRechercheChampsPrenom.add(txtFieldPrenom);
		txtFieldPrenom.setColumns(10);
		
		JPanel panRechercheChampsId = new JPanel();
		panRechercheChamps.add(panRechercheChampsId);
		
		JLabel lblIdentifiant = new JLabel("Identifiant : ");
		panRechercheChampsId.add(lblIdentifiant);
		
		txtFieldId = new JTextField();
		panRechercheChampsId.add(txtFieldId);
		txtFieldId.setColumns(10);
		
		//Champs de recherche
		

	}
}

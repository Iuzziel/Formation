package panneaux;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class GestionEmployesEdition extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2902920964663284927L;

	public GestionEmployesEdition() {
		this.setPreferredSize(new Dimension(250, 150));
		this.setBorder(new TitledBorder(null, "Affichage des informations détaillées de l'employé sélectionné", TitledBorder.LEADING, TitledBorder.TOP));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//Création d'un panel pour les label infos
		JPanel panLblInfo = new JPanel();
		add(panLblInfo);
		panLblInfo.setLayout(new GridLayout(0, 1, 0, 0));
		//Affichage des information de l'employé
		JLabel lblNom = new JLabel("Nom : ");
		panLblInfo.add(lblNom);
		JLabel lblPrenom = new JLabel("Prénom : ");
		panLblInfo.add(lblPrenom);
		JLabel lblAdresse = new JLabel("Adresse : ");
		panLblInfo.add(lblAdresse);
		JLabel lblTelephone = new JLabel("Téléphone : ");
		panLblInfo.add(lblTelephone);
		JLabel lblService = new JLabel("Service : ");
		panLblInfo.add(lblService);
		JLabel lblRoleOccupe = new JLabel("Rôle occupé : ");
		panLblInfo.add(lblRoleOccupe);

		//Ajout des boutons
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
		JButton btnEditer = new JButton("Editer cet employé");
		JButton btnSupprimer = new JButton("Supprimer cet employé");
		panBtn.add(btnEditer);
		panBtn.add(btnSupprimer);
		this.add(panBtn);
	}
}

package panneaux;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class EmpruntRetour extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2734805873664823251L;

	public EmpruntRetour() {
		setMinimumSize(new Dimension(200, 200));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sélection Emprunt/Retour", TitledBorder.LEADING, TitledBorder.TOP));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		//tabEmpruntRetour
		JTabbedPane tabEmpruntRetour = new JTabbedPane(JTabbedPane.TOP);
		add(tabEmpruntRetour);

		//tabEmpruntRetour/panEmprunt
		JPanel panEmprunt = new JPanel();
		tabEmpruntRetour.addTab("Emprunt", panEmprunt);
		panEmprunt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//tabEmpruntRetour/panEmprunt/*
		JLabel lblEmpruntTitre = new JLabel("Emprunt");
		panEmprunt.add(lblEmpruntTitre);
		JProgressBar pgsBarEmprunt = new JProgressBar();
		panEmprunt.add(pgsBarEmprunt);
		JButton btnEmpruntEnregistrerFinal = new JButton("Valider Emprunt");
		panEmprunt.add(btnEmpruntEnregistrerFinal);

		//tabEmpruntRetour/panRetour
		JPanel panRetour = new JPanel();
		tabEmpruntRetour.addTab("Retour", panRetour);
		panRetour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//tabEmpruntRetour/panRetour/*
		JLabel lblRetour = new JLabel("Retour");
		panRetour.add(lblRetour);
		JProgressBar pgsBarRetour = new JProgressBar();
		panRetour.add(pgsBarRetour);
		JButton btnValiderRetour = new JButton("Valider Retour");
		panRetour.add(btnValiderRetour);
	}
}

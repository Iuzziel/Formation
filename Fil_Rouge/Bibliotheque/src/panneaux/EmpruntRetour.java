package panneaux;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Vector;

public class EmpruntRetour extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2734805873664823251L;

	//Données membres
	private Vector<String> vctLivreScan = new Vector<String>();
	private JList<String> lstLivreScan = new JList<String>(vctLivreScan);
	private JScrollPane srlLivreScanne = new JScrollPane(lstLivreScan);

	//Constructeur
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
		panEmprunt.setLayout(new BoxLayout(panEmprunt, BoxLayout.Y_AXIS));
		panEmprunt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		//tabEmpruntRetour/panEmprunt/*
		JLabel lblEmpruntTitre = new JLabel("Emprunt");
		panEmprunt.add(lblEmpruntTitre);
		remplirListeLivreScan("blabla");
		srlLivreScanne.setPreferredSize(new Dimension(70, 150));
		panEmprunt.add(srlLivreScanne);
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

	//Méthodes
	public void remplirListeLivreScan (String codeExemplaire) {
		//TODO Lier la Liste
		vctLivreScan.addElement(codeExemplaire);
		lstLivreScan.setMinimumSize(new Dimension(70, 150));
		lstLivreScan.setPreferredSize(new Dimension(70, 150));
		lstLivreScan.setListData(vctLivreScan);
		srlLivreScanne.add(lstLivreScan);
		this.repaint();
		return;
	}
}

package fenetres;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class Header extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6494265312863046861L;
	
	public Header(String titre) {//TODO Rendre la création de la fenêtre conditionné par l'état de la session
		setLayout(new BorderLayout(5, 5));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		//Titre
		JLabel lblHeaderTitrePage = new JLabel(titre);
		lblHeaderTitrePage.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblHeaderTitrePage);
		
		//Panneau de connextion
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Fonction avanc\u00E9e", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.EAST);
		
		//TODO Insérer l'icone de connextion & ajouter le mouselistener pour se connecter
		JLabel lblIconeConnexion = new JLabel("Icone");
		panel_1.add(lblIconeConnexion);
		
		JLabel lblHeaderSeConnecter = new JLabel("Se connecter");
		lblHeaderSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHeaderSeConnecter.setForeground(Color.BLUE);
		panel_1.add(lblHeaderSeConnecter);
	}
	

}

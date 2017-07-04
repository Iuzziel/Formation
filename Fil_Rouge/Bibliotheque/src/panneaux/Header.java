package panneaux;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import fenetres.FenetreConnexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class Header extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6494265312863046861L;

	//Données membre
	private JLabel lblHeaderSeConnecter = new JLabel("Se connecter");

	/**Création du module Header. Commun à toutes les fenêtres du logiciel. Reçoit le titre de la fenêtre en string en argument.
	 *  
	 *	@param titre
	 */
	public Header(String titre) {//TODO Rendre la création de la fenêtre conditionné par l'état de la session
		setLayout(new BorderLayout(5, 5));
		JPanel panHeaderTitre = new JPanel();
		add(panHeaderTitre, BorderLayout.CENTER);

		//Titre
		JLabel lblHeaderTitrePage = new JLabel(titre);
		lblHeaderTitrePage.setFont(new Font("Tahoma", Font.BOLD, 16));
		panHeaderTitre.add(lblHeaderTitrePage);

		//Panneau de connexion
		JPanel panHeaderConnexion = new JPanel();
		panHeaderConnexion.setBorder(new TitledBorder(null, "Fonction avanc\u00E9e", TitledBorder.LEADING, TitledBorder.TOP));
		add(panHeaderConnexion, BorderLayout.EAST);

		//
		JLabel lblIconeConnexion = new JLabel("");
		lblIconeConnexion.setIcon(new ImageIcon(Header.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		panHeaderConnexion.add(lblIconeConnexion);

		lblHeaderSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHeaderSeConnecter.setForeground(Color.BLUE);
		lblHeaderSeConnecter.addMouseListener(new AppMouseListener());
		panHeaderConnexion.add(lblHeaderSeConnecter);
	}

	class AppMouseListener implements MouseListener {
		//***********************************************Listerners*****************************************//
		@Override
		public void mouseClicked(MouseEvent e) {
			// Auto-generated method stub
			if(e.getSource() == lblHeaderSeConnecter) {
				FenetreConnexion fenetreConnexion = new FenetreConnexion();
				fenetreConnexion.setLocationRelativeTo(null);
				fenetreConnexion.setVisible(true);
				fenetreConnexion.setAlwaysOnTop(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// Auto-generated method stub

		}

	}
}

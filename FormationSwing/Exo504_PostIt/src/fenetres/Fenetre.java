package fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Fenetre extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3235788767692331731L;

	//données de la fenetre
	private Vector<String> tabListe = new Vector<String>();
	private JList<String> txtListe = new JList<String>(tabListe);
	private JTextField txtSaisie = new JTextField();
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnPurger = new JButton("Purger");

	//Création de la fenetre, et appel de initControles()
	public Fenetre()
	{
		this.setSize(500, 450);
		this.setTitle("Post It");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

		initControles();
	}

	////////////////////////////////////Initialisation de la fenêtre////////////////////////////////////
	private void initControles()
	{
		JPanel zoneClient = (JPanel) this.getContentPane();
		zoneClient.setLayout(null);

		//« Votre message » (10, 10, 150, 20)
		JLabel lblVotreMess = new JLabel("Votre message :");
		lblVotreMess.setBounds(10, 10, 150, 20);
		zoneClient.add(lblVotreMess);

		//Champ de saisie (10, 30, 300, 20)
		txtSaisie.setBounds(10, 30, 300, 20);
		zoneClient.add(txtSaisie);

		//Bouton Ajouter (350, 30, 120, 20)
		btnAjouter.setBounds(350, 30, 120, 20);
		zoneClient.add(btnAjouter);

		//Bouton Purger (350, 100, 120, 20)
		btnPurger.setBounds(350, 100, 120, 20);
		zoneClient.add(btnPurger);

		//Bouton Supprimer (350, 200, 120, 20)
		btnSupprimer.setBounds(350, 200, 120, 20);
		zoneClient.add(btnSupprimer);

		//Liste (10,80,300,300)
		//txtListe.setLayoutOrientation(JList.VERTICAL_WRAP);
		txtListe.setLayout(new BoxLayout(txtListe, BoxLayout.Y_AXIS));
		JScrollPane scrListe = new JScrollPane(txtListe);
		scrListe.setBounds(10,80,300,300);
		zoneClient.add(scrListe);

		//Ajout des Listener
		btnAjouter.addActionListener(new AppActionListener());
		btnSupprimer.addActionListener(new AppActionListener());
		btnPurger.addActionListener(new AppActionListener());
		txtSaisie.addFocusListener(new AppFocusListener());
		txtSaisie.addKeyListener(new AppKeyListener());
	}

	////////////////////////////////////Méthodes////////////////////////////////////
	private void ajouterUneEntree(){
		java.util.Date dh = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String strDG = sdf.format(dh);
		//Contrôle de la saisie dans le textfield
		if(txtSaisie.getText().isEmpty() || txtSaisie.getText().equals("Entrez un message")) {
			txtSaisie.setText("Entrez un message");
		}else{
			tabListe.add(strDG+ " - " + txtSaisie.getText());
			actualiserListe();
			txtSaisie.setText(null);
			txtSaisie.grabFocus();
		}
	}
	private void actualiserListe(){
		txtListe.setListData(tabListe);
	}
	private void supprimerTout() {
		tabListe.removeAllElements();
		actualiserListe();
	}
	private void purgerDixDerniers() {
		if(tabListe.size() > 10){
			int maxTab = tabListe.size();
			for (int i = 0; i < (maxTab-10); i++) {
				tabListe.remove(0);
			}
			actualiserListe();
		}

	}
	//*********************************Listener*********************************//
	class AppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAjouter) ajouterUneEntree();
			if(e.getSource() == btnSupprimer) supprimerTout();
			if(e.getSource() == btnPurger) purgerDixDerniers();
		}


	}
	class AppFocusListener implements FocusListener {
		public void focusGained(FocusEvent e) {
			if(e.getSource() == txtSaisie){
				ajouterUneEntree();
			}
		}
		public void focusLost(FocusEvent e) {
			//Void
		}
	}
	class AppKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// Touche entrée pour ajouter
			if(e.getKeyCode() == KeyEvent.VK_ENTER && txtSaisie.hasFocus()) ajouterUneEntree();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// Auto-generated method stub
			
		}
		
	}
}

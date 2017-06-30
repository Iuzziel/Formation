package fenetres;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.Timer;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;


public class FenetrePrincipale extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3235788767692331731L;

	//Données de la fenetre
	private JPanel tabIsoler = new JPanel();
	private JPanel tabTour = new JPanel();
	private JButton btnIsolerDemarrer = new JButton("D\u00E9marrer");
	private JButton btnTourDemarrer = new JButton("D\u00E9marrer");
	private JButton btnIsolerArreter = new JButton("Arreter");
	private JButton btnTourArreter = new JButton("Arreter");
	private JButton btnRedemarrer = new JButton("Redemarrer");
	private JButton btnReinitialiser = new JButton("Reinitialiser");
	private JButton btnIsoler = new JButton("Isoler");
	private JButton btnTour = new JButton("Tour");
	private Vector<String> vecLstTour = new Vector<String>();
	private Vector<String> vecLstIsoler = new Vector<String>();
	private JList<String> lstIsoler = new JList<String>(vecLstIsoler);
	private JList<String> lstTour = new JList<String>(vecLstTour);
	private JScrollPane srlIsolerList = new JScrollPane(lstIsoler);
	private JScrollPane srlTourList = new JScrollPane(lstTour);
	private Timer timeIsoler = new Timer(10, new AppActionListener());
	private Timer timeTour = new Timer(10, new AppActionListener());
	private JLabel txtIsolerChrono = new JLabel("00:00:00");
	private JLabel txtTourChrono = new JLabel("00:00:00");
	private int tempIsolerChrono = 0;
	private int tempTourChrono = 0;
	private int nbIsoler = 0;
	private int nbTour = 0;

	//Création de la fenetre, et appel de initControles()
	public FenetrePrincipale()
	{
		this.setSize(270, 400);
		this.setTitle("Chronomètre");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

		initControles();
	}

	//////////////////////////////////////////////////////////Initialisation de la fenêtre////////////////////////////////////////////////////////////
	private void initControles()
	{
		//Initialisation et construction de la fenetre principale
		JPanel zoneClient = (JPanel) this.getContentPane();
		zoneClient.setLayout(new GridLayout(1, 1));
		JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		zoneClient.add(tabPanel);

		//Création des onglets initiaux
		ongletIsolerDemarrer();
		ongletTourDemarrer();

		//Ajout des onlet au TabbedPanel
		tabPanel.addTab("Isoler", new ImageIcon("boulerouge.png"), tabIsoler, "Isole le temps, sans remettre à zéro le chrono.");
		tabPanel.addTab("Tour", new ImageIcon("boulerouge.png"), tabTour, "Remet à zéro à chaque tour, et enregistre le temps au tour.");
	}

	///////////////////////////////////////////////////////////////////Méthodes//////////////////////////////////////////////////////////////////////
	//TODO Créer les méthodes pour initialiser les chronos, et les stopper/reinitialiser
	//TODO Créer les versions de fenetres apres avoir démarrer

	//Onglet Isoler
	private void ongletIsolerDemarrer(){
		tabIsoler.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabIsoler.setLayout(new BorderLayout(5, 5));
		txtIsolerChrono.setOpaque(true);
		txtIsolerChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIsolerChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtIsolerChrono.setBackground(Color.WHITE);
		tabIsoler.add(txtIsolerChrono, BorderLayout.NORTH);
		tabIsoler.add(btnIsolerDemarrer, BorderLayout.SOUTH);
		tabIsoler.add(srlIsolerList, BorderLayout.CENTER);
		btnIsolerDemarrer.addActionListener(new AppActionListener());
		btnIsolerDemarrer.addKeyListener(new AppKeyListener());
	}
	private void ongletIsolerLance(){
		tabIsoler.remove(btnIsolerDemarrer);
		tabIsoler.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabIsoler.setLayout(new BorderLayout(5, 5));
		txtIsolerChrono.setOpaque(true);
		txtIsolerChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIsolerChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtIsolerChrono.setBackground(Color.WHITE);
		tabIsoler.add(txtIsolerChrono, BorderLayout.NORTH);
		JPanel ongletIsolerLanceSud = new JPanel(new GridLayout(1, 2));
		tabIsoler.add(ongletIsolerLanceSud, BorderLayout.SOUTH);
		ongletIsolerLanceSud.add(btnIsoler);
		ongletIsolerLanceSud.add(btnIsolerArreter);
		tabIsoler.add(srlIsolerList, BorderLayout.CENTER);
		btnIsoler.addActionListener(new AppActionListener());
		btnIsoler.addKeyListener(new AppKeyListener());
		btnIsolerArreter.addActionListener(new AppActionListener());
	}
	private void ongletIsolerRepartir(){
		tabIsoler.remove(btnIsoler);
		tabIsoler.remove(btnIsolerArreter);
		tabIsoler.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabIsoler.setLayout(new BorderLayout(5, 5));
		txtIsolerChrono.setOpaque(true);
		txtIsolerChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIsolerChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtIsolerChrono.setBackground(Color.WHITE);
		tabIsoler.add(txtIsolerChrono, BorderLayout.NORTH);
		JPanel ongletIsolerLanceSud = new JPanel(new GridLayout(1, 2));
		tabIsoler.add(ongletIsolerLanceSud, BorderLayout.SOUTH);
		ongletIsolerLanceSud.add(btnReinitialiser);
		ongletIsolerLanceSud.add(btnRedemarrer);
		tabIsoler.add(srlIsolerList, BorderLayout.CENTER);
		btnReinitialiser.addActionListener(new AppActionListener());
		btnRedemarrer.addKeyListener(new AppKeyListener());
		btnRedemarrer.addActionListener(new AppActionListener());
	}

	//Onglet Tour
	private void ongletTourDemarrer(){
		tabTour.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabTour.setLayout(new BorderLayout(5, 5));
		txtTourChrono.setOpaque(true);
		txtTourChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTourChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTourChrono.setBackground(Color.WHITE);
		tabTour.add(txtTourChrono, BorderLayout.NORTH);
		tabTour.add(btnTourDemarrer, BorderLayout.SOUTH);
		tabTour.add(srlTourList, BorderLayout.CENTER);
		btnTourDemarrer.addActionListener(new AppActionListener());
		btnTourDemarrer.addKeyListener(new AppKeyListener());
	}
	private void ongletTourLance(){
		tabTour.remove(btnTourDemarrer);
		tabTour.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabTour.setLayout(new BorderLayout(5, 5));
		txtTourChrono.setOpaque(true);
		txtTourChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTourChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTourChrono.setBackground(Color.WHITE);
		tabTour.add(txtTourChrono, BorderLayout.NORTH);
		JPanel ongletTourLanceSud = new JPanel(new GridLayout(1, 2));
		tabTour.add(ongletTourLanceSud, BorderLayout.SOUTH);
		ongletTourLanceSud.add(btnTour);
		ongletTourLanceSud.add(btnTourArreter);
		tabTour.add(srlTourList, BorderLayout.CENTER);
		btnTour.addActionListener(new AppActionListener());
		btnTour.addKeyListener(new AppKeyListener());
		btnTourArreter.addActionListener(new AppActionListener());
	}

	//*************************************************************Listener**********************************************************//
	class AppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//TODO Finir les listeners
			//*********************************Onglet Isoler*********************************//
			if(e.getSource() == btnIsolerDemarrer) {
				timeIsoler.start();
				ongletIsolerLance();
				System.out.println("btnIsolerDemarrer" + " " + timeIsoler.getDelay() + "milisecondes de tick");
			}
			if(e.getSource() == timeIsoler){
				//TODO Listener timeIsoler, à changer par les méthodes
				tempIsolerChrono++; 
				txtIsolerChrono.setText(String.valueOf(tempIsolerChrono));

			}
			if(e.getSource() == btnIsoler) {
				nbIsoler++;
				vecLstIsoler.add(nbIsoler + " - " + String.valueOf(tempIsolerChrono));
				lstIsoler.setListData(vecLstIsoler);
			}
			if(e.getSource() == btnIsolerArreter) {
				timeIsoler.stop();
				ongletIsolerRepartir();
			}

			//*********************************Onglet Tour*********************************//
			if(e.getSource() == btnTourDemarrer) {
				timeTour.start();
				ongletTourLance();
				System.out.println("btnTourDemarrer"  + " " + timeTour.getDelay() + "milisecondes de tick");
			}
			if(e.getSource() == timeTour){
				//TODO Listener timeTour, à changer par les méthodes
				tempTourChrono++;
				txtTourChrono.setText(String.valueOf(tempTourChrono));

			}
			if(e.getSource() == btnTour) {
				//TODO reinitialiser le chrono à chaque Tour
				nbTour++;
				vecLstTour.add(nbTour + " - " + String.valueOf(tempTourChrono));
				lstTour.setListData(vecLstTour);
			}
			if(e.getSource() == btnTourArreter) timeTour.stop();

		}


	}
	class AppKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Touche VK_SPACE pour le tour
			if(e.getKeyCode() == KeyEvent.VK_SPACE && tabIsoler.isEnabled()) {
				System.out.println("KeyEvent.VK_SPACE && tabIsoler.hasFocus()");
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE && tabTour.isEnabled()) {
				System.out.println("KeyEvent.VK_SPACE && tabTour.hasFocus()");
			}
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

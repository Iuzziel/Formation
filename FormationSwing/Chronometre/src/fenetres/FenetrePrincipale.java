package fenetres;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.Color;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
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
	private JPanel ongletIsolerLanceSud = new JPanel(new GridLayout(1, 2));
	private JPanel tabTour = new JPanel();
	private JPanel ongletTourLanceSud = new JPanel(new GridLayout(1, 2));
	private JButton btnIsolerDemarrer = new JButton("D\u00E9marrer");
	private JButton btnTourDemarrer = new JButton("D\u00E9marrer");
	private JButton btnIsolerArreter = new JButton("Arreter");
	private JButton btnTourArreter = new JButton("Arreter");
	private JButton btnIsolerRedemarrer = new JButton("Redemarrer");
	private JButton btnTourRedemarrer = new JButton("Redemarrer");
	private JButton btnIsolerReinitialiser = new JButton("Reinitialiser");
	private JButton btnTourReinitialiser = new JButton("Reinitialiser");
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
	private JLabel txtIsolerChrono = new JLabel("00:00:00:00");
	private JLabel txtTourChrono = new JLabel("00:00:00:00");
	private int tempIsolerChrono = 0;
	private int tempTourChrono = 0;
	private int tempsIsolerStart = 0;
	private int tempsTourStart = 0;
	private int nbIsoler = 0;
	private int nbTour = 0;
	private DecimalFormat df = new DecimalFormat("00");

	//Création de la fenetre, et appel de initControles()
	public FenetrePrincipale()
	{
		this.setSize(270, 400);
		this.setTitle("Chronomètre");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

		initControles();
		abonnementListener();
	}

	//////////////////////////////////////////////////////////Initialisation de la fenêtre////////////////////////////////////////////////////////////
	private void initControles()
	{
		//Initialisation et construction de la fenetre principale
		JPanel zoneClient = (JPanel) this.getContentPane();
		zoneClient.setLayout(new GridLayout(1, 1));
		JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		zoneClient.add(tabPanel);

		//Création du squelette des onglets
		tabIsoler.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabIsoler.setLayout(new BorderLayout(5, 5));
		txtIsolerChrono.setOpaque(true);
		txtIsolerChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIsolerChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtIsolerChrono.setBackground(Color.WHITE);
		tabIsoler.add(txtIsolerChrono, BorderLayout.NORTH);
		tabIsoler.add(ongletIsolerLanceSud, BorderLayout.SOUTH);
		tabIsoler.add(srlIsolerList, BorderLayout.CENTER);

		tabTour.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabTour.setLayout(new BorderLayout(5, 5));
		txtTourChrono.setOpaque(true);
		txtTourChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTourChrono.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTourChrono.setBackground(Color.WHITE);
		tabTour.add(txtTourChrono, BorderLayout.NORTH);
		tabTour.add(ongletTourLanceSud, BorderLayout.SOUTH);
		tabTour.add(srlTourList, BorderLayout.CENTER);

		//Création des onglets initiaux
		ongletIsolerDemarrer();
		ongletTourDemarrer();
		this.repaint();

		//Ajout des onlet au TabbedPanel
		tabPanel.addTab("Isoler", new ImageIcon("boulerouge.png"), tabIsoler, "Isole le temps, sans remettre à zéro le chrono.");
		tabPanel.addTab("Tour", new ImageIcon("boulerouge.png"), tabTour, "Remet à zéro à chaque tour, et enregistre le temps au tour.");
	}

	///////////////////////////////////////////////////////////////////Méthodes//////////////////////////////////////////////////////////////////////
	//Onglet Isoler
	private void ongletIsolerDemarrer(){
		ongletIsolerLanceSud.remove(btnIsolerReinitialiser);
		ongletIsolerLanceSud.remove(btnIsolerRedemarrer);
		ongletIsolerLanceSud.add(btnIsolerDemarrer);
		txtIsolerChrono.setText("00:00:00:00");
		tabIsoler.validate();
		tabIsoler.repaint();
	}
	private void ongletIsolerLance(){
		ongletIsolerLanceSud.remove(btnIsolerDemarrer);
		ongletIsolerLanceSud.add(btnIsoler);
		ongletIsolerLanceSud.add(btnIsolerArreter);
		tabIsoler.validate();
		tabIsoler.repaint();
	}
	private void ongletIsolerRepartir(){
		ongletIsolerLanceSud.remove(btnIsoler);
		ongletIsolerLanceSud.remove(btnIsolerArreter);
		ongletIsolerLanceSud.add(btnIsolerReinitialiser);
		ongletIsolerLanceSud.add(btnIsolerRedemarrer);
		tabIsoler.validate();
		tabIsoler.repaint();
	}

	//Onglet Tour
	private void ongletTourDemarrer(){
		ongletTourLanceSud.remove(btnTourReinitialiser);
		ongletTourLanceSud.remove(btnTourRedemarrer);
		ongletTourLanceSud.add(btnTourDemarrer);
		txtTourChrono.setText("00:00:00:00");
		tabTour.validate();
		tabTour.repaint();
	}
	private void ongletTourLance(){
		ongletTourLanceSud.remove(btnTourDemarrer);
		ongletTourLanceSud.add(btnTour);
		ongletTourLanceSud.add(btnTourArreter);
		tabTour.validate();
		tabTour.repaint();
	}
	private void ongletTourRepartir(){
		ongletTourLanceSud.remove(btnTour);
		ongletTourLanceSud.remove(btnTourArreter);
		ongletTourLanceSud.add(btnTourReinitialiser);
		ongletTourLanceSud.add(btnTourRedemarrer);
		tabTour.validate();
		tabTour.repaint();
	}

	////////////////////////Ajout des listeners
	private void abonnementListener(){
		btnIsoler.addActionListener(new AppActionListener());
		btnIsolerDemarrer.addActionListener(new AppActionListener());
		btnIsolerArreter.addActionListener(new AppActionListener());
		btnIsolerRedemarrer.addActionListener(new AppActionListener());
		btnIsolerReinitialiser.addActionListener(new AppActionListener());
		btnTour.addActionListener(new AppActionListener());
		btnTourDemarrer.addActionListener(new AppActionListener());
		btnTourArreter.addActionListener(new AppActionListener());
		btnTourRedemarrer.addActionListener(new AppActionListener());
		btnTourReinitialiser.addActionListener(new AppActionListener());
		tabIsoler.addKeyListener(new AppKeyListener());
		tabTour.addKeyListener(new AppKeyListener());

	}

	//*************************************************************Listener**********************************************************//
	class AppActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//*********************************Onglet Isoler*********************************//
			if(e.getSource() == btnIsolerDemarrer) {
				timeIsoler.start();
				tempsIsolerStart = (int) System.currentTimeMillis() / 10;
				ongletIsolerLance();
			}
			if(e.getSource() == timeIsoler){
				tempIsolerChrono = (int) System.currentTimeMillis() / 10 - tempsIsolerStart;
				int nHeu = (int) ((tempIsolerChrono / 100) / 3600);
				int nMin = (int) (((tempIsolerChrono / 100) / 60) % 60);
				int nSec = (int) ((tempIsolerChrono / 100) % 60);
				int nCen = (int) (tempIsolerChrono % 100);
				txtIsolerChrono.setText(df.format(nHeu) + ":" + df.format(nMin) + ":" + df.format(nSec) + ":" + df.format(nCen));

			}
			if(e.getSource() == btnIsoler) {
				nbIsoler++;
				int nHeu = (int) ((tempIsolerChrono / 100) / 3600);
				int nMin = (int) (((tempIsolerChrono / 100) / 60) % 60);
				int nSec = (int) ((tempIsolerChrono / 100) % 60);
				int nCen = (int) (tempIsolerChrono % 100);
				vecLstIsoler.add(nbIsoler + " - " + df.format(nHeu) + ":" + df.format(nMin) + ":" + df.format(nSec) + ":" + df.format(nCen));
				lstIsoler.setListData(vecLstIsoler);
			}
			if(e.getSource() == btnIsolerArreter) {
				timeIsoler.stop();
				ongletIsolerRepartir();
			}
			if(e.getSource() == btnIsolerRedemarrer) {
				ongletIsolerDemarrer();
			}
			if(e.getSource() == btnIsolerReinitialiser) {
				vecLstIsoler.removeAllElements();
				lstIsoler.setListData(vecLstIsoler);
				tempIsolerChrono = (int) System.currentTimeMillis() / 10 - tempsIsolerStart;
				ongletIsolerDemarrer();
			}

			//*********************************Onglet Tour*********************************//
			if(e.getSource() == btnTourDemarrer) {
				timeTour.start();
				tempsTourStart = (int) System.currentTimeMillis() / 10;
				ongletTourLance();
			}
			if(e.getSource() == timeTour){
				tempTourChrono = (int) System.currentTimeMillis() / 10 - tempsTourStart;
				int nHeu = (int) ((tempTourChrono / 100) / 3600);
				int nMin = (int) (((tempTourChrono / 100) / 60) % 60);
				int nSec = (int) ((tempTourChrono / 100) % 60);
				int nCen = (int) (tempTourChrono % 100);
				txtTourChrono.setText(df.format(nHeu) + ":" + df.format(nMin) + ":" + df.format(nSec) + ":" + df.format(nCen));

			}
			if(e.getSource() == btnTour) {
				nbTour++;
				tempsTourStart = (int) System.currentTimeMillis() / 10;
				int nHeu = (int) ((tempTourChrono / 100) / 3600);
				int nMin = (int) (((tempTourChrono / 100) / 60) % 60);
				int nSec = (int) ((tempTourChrono / 100) % 60);
				int nCen = (int) (tempTourChrono % 100);
				vecLstTour.add(nbTour + " - " + df.format(nHeu) + ":" + df.format(nMin) + ":" + df.format(nSec) + ":" + df.format(nCen));
				lstTour.setListData(vecLstTour);
			}
			if(e.getSource() == btnTourArreter) {
				timeTour.stop();
				ongletTourRepartir();
			}
			if(e.getSource() == btnTourRedemarrer) {
				ongletTourDemarrer();
			}
			if(e.getSource() == btnTourReinitialiser) {
				vecLstTour.removeAllElements();
				lstTour.setListData(vecLstTour);
				tempTourChrono = (int) System.currentTimeMillis() / 10 - tempsTourStart;
				ongletIsolerDemarrer();
			}
		}
	}
}

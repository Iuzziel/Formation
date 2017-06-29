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
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class FenetrePrincipale extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3235788767692331731L;

	//données de la fenetre
	private JPanel tabIsoler = new JPanel();
	private JPanel tabTour = new JPanel();
	private JTextField txtIsolerChrono = new JTextField();
	private JTextField textTourChrono = new JTextField();
	private JButton btnIsolerDemarrer = new JButton("D\u00E9marrer");
	private JButton btnTourDemarrer = new JButton("D\u00E9marrer");
	private JList<String> lstIsoler = new JList<String>();
	private JList<String> lstTour = new JList<String>();
	private JScrollPane srlIsolerList = new JScrollPane(lstIsoler);
	private JScrollPane srlTourList = new JScrollPane(lstTour);
	private Timer timeIsoler = new Timer(10, new AppActionListener());
	private Timer timeTour = new Timer(10, new AppActionListener());


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

	////////////////////////////////////Initialisation de la fenêtre////////////////////////////////////
	private void initControles()
	{
		textTourChrono.setColumns(10);
		textTourChrono.setEditable(false);
		txtIsolerChrono.setEditable(false);
		txtIsolerChrono.setColumns(10);
		//Initialisation et construction de la fenetre principale
		JPanel zoneClient = (JPanel) this.getContentPane();
		zoneClient.setLayout(new GridLayout(1, 1));
		JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		zoneClient.add(tabPanel);

		//Onglet Isoler
		tabIsoler.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabIsoler.setLayout(new BorderLayout(5, 5));
		tabIsoler.add(txtIsolerChrono, BorderLayout.NORTH);
		tabIsoler.add(btnIsolerDemarrer, BorderLayout.SOUTH);
		tabIsoler.add(srlIsolerList, BorderLayout.CENTER);

		//Onglet Tour
		tabTour.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabTour.setLayout(new BorderLayout(5, 5));
		tabTour.add(textTourChrono, BorderLayout.NORTH);
		tabTour.add(btnTourDemarrer, BorderLayout.SOUTH);
		tabTour.add(srlTourList, BorderLayout.CENTER);

		//Ajout des onlet au TabbedPanel
		tabPanel.addTab("Isoler", new ImageIcon("boulerouge.png"), tabIsoler, "Isole le temps, sans remettre à zéro le chrono.");
		tabPanel.addTab("Tour", new ImageIcon("boulerouge.png"), tabTour, "Remet à zéro à chaque tour, et enregistre le temps au tour.");

		//Abonnement des objets aux listeners
		//TODO Abonnement des objets aux listeners
		btnIsolerDemarrer.addActionListener(new AppActionListener());
		btnIsolerDemarrer.addKeyListener(new AppKeyListener());
		btnTourDemarrer.addActionListener(new AppActionListener());
		btnTourDemarrer.addKeyListener(new AppKeyListener());

	}

	////////////////////////////////////Méthodes////////////////////////////////////

	//*********************************Listener*********************************//
	class AppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//TODO Finir les listeners
			if(e.getSource() == btnIsolerDemarrer) {
				timeIsoler.start();
				System.out.println("btnIsolerDemarrer" + timeIsoler.getDelay());
			}
			if(e.getSource() == btnTourDemarrer) {
				timeTour.start();
				System.out.println("btnTourDemarrer");
			}
		}


	}
	class AppKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Touche VK_SPACE pour le tour
			if(e.getKeyCode() == KeyEvent.VK_SPACE && tabIsoler.hasFocus()) {
				System.out.println("KeyEvent.VK_SPACE && tabIsoler.hasFocus()");
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE && tabTour.hasFocus()) {
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

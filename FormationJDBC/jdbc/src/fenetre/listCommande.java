package fenetre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import dao.*;

public class listCommande extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4203726597788592163L;

	final String INIT_LBLDATCOM = "jj/mm/aaaa";
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	private JTextField jtfNumcom = new JTextField();
	private JLabel lblDatcom = new JLabel(INIT_LBLDATCOM);
	private JLabel barreStatut = new JLabel();
	private String [] cols = {"NUMCOM", "DATCOM", "NUMFOU", "OBSCOM"};
	private DefaultTableModel listData = new DefaultTableModel(cols, 0);
	private JTable jtEntcom = new JTable(listData);
	private JScrollPane panEntcom = new JScrollPane(jtEntcom);

	//Afficher la table ENTCOM : NUMCOM DATCOM NUMFOU OBSCOM sur la recherche du numero de commande
	public listCommande() {
		// Initialisation de la fenêtre
		this.setSize(500,250);
		this.setTitle("Les commandes de Papyrus");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initControles();
	}

	private void initControles(){
		JPanel zoneClient = (JPanel) this.getContentPane(); // BorderLayout par défaut
		JPanel zoneEntcom = new JPanel(); // FlowLayout par défaut
		zoneEntcom.add(new JLabel("N° Cde :"));
		jtfNumcom.setColumns(10);
		jtfNumcom.setToolTipText("Entrez un numéro de commande pour afficher la liste des commandes du même fournisseur");
		jtfNumcom.addKeyListener(new AppKeyListener());
		jtfNumcom.addActionListener(new AppActionListener());
		zoneEntcom.add(jtfNumcom);
		zoneEntcom.add(new JLabel("Du"));
		zoneEntcom.add(lblDatcom);
		jtEntcom.getColumnModel().getColumn(0).setMinWidth(65);
		jtEntcom.getColumnModel().getColumn(0).setMaxWidth(65);
		jtEntcom.getColumnModel().getColumn(0).setPreferredWidth(65);
		jtEntcom.getColumnModel().getColumn(1).setMinWidth(80);
		jtEntcom.getColumnModel().getColumn(1).setMaxWidth(80);
		jtEntcom.getColumnModel().getColumn(1).setPreferredWidth(80);
		jtEntcom.getColumnModel().getColumn(2).setMinWidth(80);
		jtEntcom.getColumnModel().getColumn(2).setMaxWidth(80);
		jtEntcom.getColumnModel().getColumn(2).setPreferredWidth(80);
		panEntcom.setPreferredSize(new Dimension(450,150));
		zoneEntcom.add(panEntcom);
		zoneClient.add(zoneEntcom); // au centre par défaut
		barreStatut.setForeground(Color.RED);
		barreStatut.setHorizontalAlignment(JLabel.CENTER);
		zoneClient.add(barreStatut, BorderLayout.SOUTH);
	}

	class AppKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			barreStatut.setText("");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}

	class AppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jtfNumcom) jtfNumcom_click();
		}
	}
	private void jtfNumcom_click(){
		try {
			EntCom tempEntCom = EntComManager.getEntCom(new EntCom(Integer.valueOf(jtfNumcom.getText())));
			lblDatcom.setText(sdf.format(tempEntCom.datcom));
			Vector<EntCom> tempVec = EntComManager.getEntComFournis(new Fournis(tempEntCom.numfou));
			for (EntCom entCom : tempVec) {
				listData.addRow(entCom.toVector());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			barreStatut.setText("Pas de commande avec ce numéro");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			barreStatut.setText("Pas numéro entrée");
		}
	}

	// DEBUT DE LA MAIN

	public static void main(String[] args) {
		listCommande fenetre = new listCommande();
		fenetre.setVisible(true);
	}
}

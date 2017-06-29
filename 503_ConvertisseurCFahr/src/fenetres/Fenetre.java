package fenetres;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3235788767692331731L;

	private JTextField txtCelsius = new JTextField(10);
	private JTextField txtFahrenheit = new JTextField(10);
	private JButton btnCelFar = new JButton("Cel->Far"); 
	private JButton btnFarCel = new JButton("Far->Cel"); 

	public Fenetre()
	{
		this.setSize(240, 120);
		this.setTitle("Convertisseur");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		initControles();
	}

	private void initControles()
	{
		JPanel zoneClient = (JPanel) this.getContentPane();
		zoneClient.setLayout (new FlowLayout());
		zoneClient.add (new JLabel("Celsius : "));
		zoneClient.add (txtCelsius);
		zoneClient.add (new JLabel("Fahrenheit : "));
		zoneClient.add (txtFahrenheit);
		txtCelsius.addFocusListener(new AppFocusListener());
		txtFahrenheit.addFocusListener(new AppFocusListener());
		zoneClient.add (btnCelFar);
		zoneClient.add (btnFarCel);
		btnCelFar.addActionListener(new AppActionListener());
		btnFarCel.addActionListener(new AppActionListener());

	}

	private void btnCelFar_click() {
		NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		Double tmpCelsius = null;
		try {
			tmpCelsius = Double.parseDouble(txtCelsius.getText());
			tmpCelsius = (tmpCelsius*9/5)+32;
			txtFahrenheit.setText(nf.format(tmpCelsius));
		} catch (Exception e) {
			System.out.println("Erreur de saisie");
		}
	}
	private void btnFarCel_click() {
		Double tmpFahrenheit = null;
		NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		try {
			tmpFahrenheit = Double.parseDouble(txtFahrenheit.getText());		
			tmpFahrenheit = (tmpFahrenheit-32)*5/9;
			txtCelsius.setText(nf.format(tmpFahrenheit));
		} catch (Exception e) {
			System.out.println("Erreur de saisie");
		}
	}

	//*********************************Listener*********************************//
	class AppActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCelFar)btnCelFar_click();
			if(e.getSource() == btnFarCel)btnFarCel_click();
		}
	}

	class AppFocusListener implements FocusListener {
		public void focusGained(FocusEvent e) {
			if(e.getSource() == txtCelsius) txtFahrenheit.setText(null);
			if(e.getSource() == txtFahrenheit) txtCelsius.setText(null);
		}
		public void focusLost(FocusEvent e) {
			//Void
		}
	}
}

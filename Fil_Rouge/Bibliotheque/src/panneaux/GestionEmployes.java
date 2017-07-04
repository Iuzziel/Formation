package panneaux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GestionEmployes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5357891521398913524L;
	
	public GestionEmployes() {
		setMinimumSize(new Dimension(200, 400));
		setPreferredSize(new Dimension(250, 500));
		setLayout(new BorderLayout(5, 5));

		//Création du panel principal
		JPanel panGestionEmployes = new JPanel();
		panGestionEmployes.setBorder(new TitledBorder(null, "Gestion du rôle des employés", TitledBorder.LEADING, TitledBorder.TOP));
		panGestionEmployes.setLayout(new BoxLayout(panGestionEmployes, BoxLayout.Y_AXIS));
		add(panGestionEmployes);

	}
}

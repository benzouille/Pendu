package Fr.Banane.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanneauRegles extends JPanel {
	private JTextArea regles = new JTextArea(),
			points =new JTextArea();
	private Font police = new Font("Tahoma", Font.BOLD, 30),
			police2 = new Font("Tahoma", Font.BOLD, 35);

	public PanneauRegles() {


		regles.setBorder(BorderFactory.createEmptyBorder(100, 10, 100, 10));
		regles.setFont(police);
		regles.setText("Vous avez 7 essais pour trouver le mot mystère. \n Si vous réussissez, on repart pour un tour. \n Essayer d'atteindre les top scores.");

		points.setBorder(BorderFactory.createEmptyBorder(0, 10, 100, 10));
		points.setFont(police2);
		points.setText("Compte des points :"
				+ " \n vous avez trouvé sans erreurs ____100pts"
				+ " \n vous avez trouvé avec 1 erreur ____50pts"
				+ " \n vous avez trouvé avec 2 erreurs ___35pts"
				+ " \n vous avez trouvé avec 3 erreurs ___25pts"
				+ " \n vous avez trouvé avec 4 erreurs ___15pts"
				+ " \n vous avez trouvé avec 5 erreurs ___10pts"
				+ " \n vous avez trouvé avec 6 erreurs ____5pts");

		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add(regles, BorderLayout.NORTH);
		this.add(points, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(900,900));


	}
}

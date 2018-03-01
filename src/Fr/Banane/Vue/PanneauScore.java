package Fr.Banane.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanneauScore extends JPanel {
	private JTextArea regles = new JTextArea(),
			points =new JTextArea();
	private Font police = new Font("Tahoma", Font.BOLD, 25),
			police2 = new Font("Tahoma", Font.BOLD, 30);

	public PanneauScore() {


		regles.setBorder(BorderFactory.createEmptyBorder(100, 10, 100, 10));
		regles.setFont(police);
		regles.setText("TOP SCORE");

		points.setBorder(BorderFactory.createEmptyBorder(0, 10, 100, 10));
		points.setFont(police2);
		points.setText("Classement :"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS"
				+ " \n n°NUM NOM NBREDEPOINTS");

		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add(regles, BorderLayout.NORTH);
		this.add(points, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(900,900));
}
}
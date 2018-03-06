package Fr.Banane.Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fr.Banane.Modele.Model;

public class PanneauImage extends JPanel {
	
	private CardLayout cl = new CardLayout();
	private JPanel content = new JPanel();
	private String [] listImages = {"icon_1", "icon_2", "icon_3", "icon_4", "icon_5", "icon_6", "icon_7", "icon_8"};
	private JLabel icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8;

	public PanneauImage() {

		//Icône
		icon1 = new JLabel(new ImageIcon("ressources/images/pendu1.jpg"));
		icon2 = new JLabel(new ImageIcon("ressources/images/pendu2.jpg"));
		icon3 = new JLabel(new ImageIcon("ressources/images/pendu3.jpg"));
		icon4 = new JLabel(new ImageIcon("ressources/images/pendu4.jpg"));
		icon5 = new JLabel(new ImageIcon("ressources/images/pendu5.jpg"));
		icon6 = new JLabel(new ImageIcon("ressources/images/pendu6.jpg"));
		icon7 = new JLabel(new ImageIcon("ressources/images/pendu7.jpg"));
		icon8 = new JLabel(new ImageIcon("ressources/images/pendu8.jpg"));

		content.setBackground(Color.white);
		content.setLayout(cl);
		content.add(icon1, listImages[0]);
		content.add(icon2, listImages[1]);
		content.add(icon3, listImages[2]);
		content.add(icon4, listImages[3]);
		content.add(icon5, listImages[4]);
		content.add(icon6, listImages[5]);
		content.add(icon7, listImages[6]);
		content.add(icon8, listImages[7]);
		this.setLayout(new BorderLayout());
		this.add(content);

	}


	public void setImg(int nbre) {
		if (nbre > 7) {
			nbre = 7;
		}
		        cl.show(content, listImages[nbre]);
		}	
}	

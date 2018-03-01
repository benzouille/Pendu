package Fr.Banane.Vue;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Fr.Banane.Modele.*;

public class FenetrePendu extends JFrame {
	
	private CardLayout cl = new CardLayout();
	
	private JPanel container = new JPanel();
	private PanneauJeu jeu;
	private PanneauAccueil home = new PanneauAccueil();
	
	private PanneauRegles regle = new PanneauRegles();
	private PanneauScore topScore = new PanneauScore();
	
	private String [] listPan = {"CARD_HOME","CARD_JEU","CARD_REGLE","CARD_SCORE"};

	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"),
			aProp = new JMenu("A propos");

	private JMenuItem nouveau = new JMenuItem("Nouveau"),
			quitter = new JMenuItem("Quitter"),
			score = new JMenuItem("Scores"),
			regles = new JMenuItem("Règles"),
					aProposItem = new JMenuItem("?");

	public FenetrePendu() {
		this.jeu = new PanneauJeu();
		this.setTitle("Pendu");
		this.setSize(1024, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(cl);
		container.add(home, listPan[0]);
		container.add(jeu, listPan[1]);
		container.add(regle, listPan[2]);
		container.add(topScore, listPan[3]);
		
		this.setContentPane(container);
		this.initMenu();
		this.setVisible(true);
	}

	public void initMenu() {
		//Menu Fichier
		fichier.add(nouveau);
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, listPan[1]);
		        jeu.reset();
			}
		});
		
		fichier.add(score);
		score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//changer de panneau et afficher le panneauScore
		        cl.show(container, listPan[3]);
			}
		});

		fichier.add(regles);
		regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//changer de panneau et afficher le panneauRegle
		        cl.show(container, listPan[2]);
			}
		});

		quitter.setEnabled(true);
		fichier.add(quitter);
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		//Pour quitter l'application
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		
		//Menu A Propos
		aProp.add(aProposItem);
		aProposItem.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		          JOptionPane jop = new JOptionPane();
		          ImageIcon img = new ImageIcon("ressources/images/banane.gif");        
		          String mess = "Crée par la Banane \n Amusez vous bien !\n";
		          mess += "Pour toute remaque ou suggestion concerant le jeu, contatez moi à :\n";
		          mess += "\n banane@banane.ba";        
		          jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE, img);        
		        }            
		      });

		//Ajout des menus dans la navbar
		fichier.setMnemonic('F');
		menuBar.add(fichier);
		aProp.setMnemonic('P');
		menuBar.add(aProp);

		this.setJMenuBar(menuBar); 
	}
	
	public static void main(String[] args) {
		FenetrePendu fen = new FenetrePendu();
	}

}

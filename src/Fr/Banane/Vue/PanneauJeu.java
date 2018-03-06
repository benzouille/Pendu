package Fr.Banane.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Fr.Banane.Modele.*;
import Fr.Banane.Observer.Observateur;

public class PanneauJeu extends JPanel implements Observateur {

	private String[] listLettre = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	public char charac;

	private Dimension dim1 = new Dimension(20,20);

	private Font police, police2;

	private JPanel jpJeu, jpTexte, jPBoutons;

	private int nbreError;

	protected JLabel jLAffichage = new JLabel("Nombre de mot trouvé : 0");
	protected JLabel jLAffichage2 = new JLabel("Votre Score est de : 0");
	protected JLabel motMyst ;
	protected Model ml;
	protected PanneauImage jPImages;
	protected String realMotMyst;

	public PanneauJeu() {
		this.init();
		this.setVisible(true);

	}	

	public void init() {
		police = new Font("Tahoma", Font.BOLD, 30);
		police2 = new Font("Tahoma", Font.BOLD, 16);

		jpJeu = new JPanel();
		jpTexte = new JPanel();
		jPBoutons = new JPanel();
		nbreError = 0;
		jPImages = new PanneauImage();
		setBackground(Color.white);
		setLayout(new BorderLayout());
		add(jpJeu, BorderLayout.WEST);
		add(jPImages, BorderLayout.CENTER);
		setPreferredSize(new Dimension(450,900));
		motMyst = new JLabel();
		realMotMyst = new RecupMot().getMotMyst();
		ml = new Model();

		//Configuration du JPanel jPBoutons
		jPBoutons.setLayout(new GridLayout(4,7,3,3));
		jPBoutons.setBackground(Color.WHITE);
		jPBoutons.setFont(police);
		jPBoutons.setBorder(BorderFactory.createEmptyBorder(100, 10, 200, 10));
		JButton[] butNum = new JButton[listLettre.length];
		for(int i =0; i<listLettre.length;i++) {
			butNum[i] = new JButton(listLettre[i]);
			butNum[i].setPreferredSize(dim1);
			butNum[i].addActionListener(new LettreListener());
			//butNum[i].setAccelerator(KeyStroke.getKeyStroke(KeyEvent)); // a demander comment mettre [i] en key event
			jPBoutons.add(butNum[i]);
		}

		//Panneau du texte
		jLAffichage.setHorizontalAlignment(JLabel.RIGHT);
		jLAffichage.setVerticalAlignment(JLabel.CENTER);
		jLAffichage.setPreferredSize(new Dimension(450,100));
		jLAffichage.setFont(police2);
		jLAffichage.setText("Nombre de mot trouvé : " + ml.getNbreMot() );
		jLAffichage2.setHorizontalAlignment(JLabel.RIGHT);
		jLAffichage2.setVerticalAlignment(JLabel.CENTER);
		jLAffichage2.setPreferredSize(new Dimension(450,100));
		jLAffichage2.setFont(police2);
		//jLAffichage2.setText("Nombre de points " + ml.score.getPtsTotal()); //Fait planter ml.win()
		this.motMyst.setHorizontalAlignment(JLabel.CENTER);
		this.motMyst.setVerticalAlignment(JLabel.CENTER);
		this.motMyst.setPreferredSize(new Dimension(450,100));
		this.motMyst.setFont(police);
		jpTexte.setBackground(Color.WHITE);
		jpTexte.setPreferredSize(new Dimension (450,300));
		jpTexte.setLayout(new BoxLayout(jpTexte, BoxLayout.PAGE_AXIS));
		jpTexte.add(jLAffichage);
		jpTexte.add(jLAffichage2);
		jpTexte.add(motMyst);

		//Configuration du JPanel jPJeu
		jpJeu.setBackground(Color.white);
		jpJeu.setLayout(new BorderLayout());
		jpJeu.add(jPBoutons, BorderLayout.CENTER);
		jpJeu.add(jpTexte, BorderLayout.NORTH);
		this.motMyst.setText(ml.getDisplayString());
		//this.ml.score.initTotalScore(nbreError);
	}

	public void reset() {
		this.removeAll();
		this.init();
		this.ml.score.initTotalScore(nbreError);
		this.revalidate();

		
	}

	public void update() {
		ml.resolve(charac);
		motMyst.setText(ml.getDisplayString());
			nbreError = ml.getErrorCount();
			System.out.println(nbreError);
			jPImages.setImg(nbreError);
			//TODO à modifier pour tout mettre dans le model
			System.out.println(ml.win());
		
	}

	//les boutons lettres 
	class LettreListener implements ActionListener{
		public void actionPerformed(ActionEvent x) {
			String str = ((JButton)x.getSource()).getText();
			charac = str.charAt(0);
			((JButton)x.getSource()).setEnabled(false);
			//System.out.println(charac); //DEBUG*****************************************************************
			update();

		}
	}

	public void update(String win, int nbreMot, int nbreErr, int pts, int ptsTotal, String mot, String motCrypt) {
		
		
	}
}


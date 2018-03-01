package Fr.Banane.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Fr.Banane.Modele.*;

public class PanneauJeu extends JPanel {

	private String[] listLettre = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	public char charac;

	private Dimension dim1 = new Dimension(20,20);

	private Font police, police2;

	private JPanel jpJeu, jpTexte, jPBoutons;

	private int nbreError, nbreTrouve;

	private JLabel jLAffichage = new JLabel("Nombre de mot trouvé : 0");
	private JLabel jLAffichage2 = new JLabel("Votre Score est de : 0");
	private JLabel motMyst ;
	private Model ml;
	private PanneauImage jPImages;
	private String realMotMyst;
	private Score score = new Score();

	public PanneauJeu() {
		this.init();
		this.setVisible(true);
		
	}	

	public void init() {
		this.police = new Font("Tahoma", Font.BOLD, 30);
		this.police2 = new Font("Tahoma", Font.BOLD, 16);

		this.jpJeu = new JPanel();
		this.jpTexte = new JPanel();
		this.jPBoutons = new JPanel();
		this.nbreError = 0;
		this.jPImages = new PanneauImage();
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add(jpJeu, BorderLayout.WEST);
		this.add(jPImages, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(450,900));
		this.motMyst = new JLabel();
		this.realMotMyst = new RecupMot().getMotMyst();
		this.ml = new Model(this.realMotMyst);

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
			jPBoutons.add(butNum[i]);
		}

		//Panneau du texte
		jLAffichage.setHorizontalAlignment(JLabel.RIGHT);
		jLAffichage.setVerticalAlignment(JLabel.CENTER);
		jLAffichage.setPreferredSize(new Dimension(450,100));
		jLAffichage.setFont(police2);
		jLAffichage.setText("Nombre de mot trouvé : " + nbreTrouve );
		jLAffichage2.setHorizontalAlignment(JLabel.RIGHT);
		jLAffichage2.setVerticalAlignment(JLabel.CENTER);
		jLAffichage2.setPreferredSize(new Dimension(450,100));
		jLAffichage2.setFont(police2);
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
		this.score.initTotalScore(nbreError);
	}

	public void reset() {
		this.removeAll();
		this.init();
		this.revalidate();
	}

	public void update() {
		ml.resolve(charac);
		motMyst.setText(ml.getDisplayString());
		if (ml.getErrorCount() != nbreError) {
			nbreError = ml.getErrorCount();
			System.out.println(nbreError);
			jPImages.setImg(nbreError);
			System.out.println(ml.win());
			if (ml.win() == "gagné") {
				nbreTrouve++;
				reset();
			}
			else if (ml.win() == "perdu") {
				JOptionPane.showMessageDialog(null, "Le mot �tait :\n\t" + String.valueOf(ml.motMystDisplay),"Vous avez perdu", JOptionPane.NO_OPTION);
				//TODO ajouter les conditions pour 
			}
		}
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
}


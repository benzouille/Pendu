package Fr.Banane.Modele;

import java.text.Normalizer;
import java.util.ArrayList;



import Fr.Banane.Observer.Observable;
import Fr.Banane.Observer.Observateur;

public class Model implements Observable {

	protected int nbreErr = 0, nbreMot = 0;

	protected String displayString;
	protected char[] displayTab, motMystDisplay, motMystCompare ;

	public Score score;
	public StreamScore ss;

	protected ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();

	public Model() {
		initNewString(new RecupMot().getMotMyst());
		score = new Score();
		ss = new StreamScore();
		System.out.println(displayTab);
		System.out.println(motMystDisplay);
	}

	//METHODE________________________________________________________________________________________________

	public String resolve(char charact)
	{	
		boolean found = false;
		for (int y = 0; y < motMystCompare.length ; ++y)  {
			if (motMystCompare[y] == charact) {
				this.displayTab[y] = this.motMystDisplay[y];
				found = true;
				 this.updateObservateur();
			}	
		}
		if (found == false)
			this.nbreErr++;
		displayString = String.valueOf(displayTab);
		//System.out.println(displayString); //DEBUG**********************************************************************
		 this.updateObservateur();
		return this.displayString;
		
	}

	/**
	 * Retourne un tableau de characteres avec des **** à la place des lettres mais conserve les '-'
	 * @return diplayTab
	 */
	public char[] encryptage() {
		//encryptage
		for(int i = 0; i < displayTab.length; i++) {
			if (displayTab[i] == '-') {
				displayTab[i] = '-';
			}
			else
				displayTab[i] = '*';
		}
		return displayTab;
	}

	/**
	 * Prend un String en parametre, enlève les accents et le crypte en appelant encryptage() 
	 * @param mot
	 */
	public void initNewString(String mot) {
		nbreErr = 0;
		motMystDisplay = mot.toCharArray();
		motMystCompare = Normalizer
				.normalize(mot, Normalizer.Form.NFD)
				.replaceAll("[\u0300-\u036F]", "").toCharArray();
		displayTab = new String(this.motMystDisplay).toCharArray();
		encryptage();
	}

	/**
	 * Methode de verification des conditions de victoire/defaite
	 * @return
	 */
	public String win() {
		if (displayTab == motMystCompare)  {
			String str = "gagné";
			nbreMot ++;
			updateObservateur();
			return str ;
		}
		else if (score.getPtsTotal() != 0 &&nbreErr >= 7) {
			String str = "perdu";
			updateObservateur();
			return str ;
		}
		else if (score.getPtsTotal() == 0 && nbreErr >= 7) {
			String str = "tout perdu";
			updateObservateur();
			return str;
		}
		else  {
			String str = "pas encore gagné";
			return str;
		}	
	}

	//GETTER SETTER________________________________________________________________________________________________

	public String getDisplayString() {
		return String.valueOf(displayTab);
	}

	public char[] getMotMystDisplay() {
		return motMystDisplay;	
	}

	public int getErrorCount() {
		return nbreErr;
	}

	public int getNbreMot() {
		return nbreMot;
	}

	public void addObservateur(Observateur obs) {
		listObservateur.add(obs);
		this.updateObservateur();
	}

	public void updateObservateur() {
		for(Observateur obs : listObservateur)
			obs.update(win(), getNbreMot(), getErrorCount(), score.getPts(), score.getPtsTotal(), 
					String.valueOf(motMystCompare), String.valueOf(getMotMystDisplay()));

	}

	public void delObservateur() {
		listObservateur = new ArrayList<Observateur>();
	}
	public static void main(String[] args) {
		Model fen = new Model();
	}
}

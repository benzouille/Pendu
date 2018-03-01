package Fr.Banane.Modele;

import java.text.Normalizer;
import java.util.ArrayList;

import Fr.Banane.Observer.Observable;
import Fr.Banane.Observer.Observateur;
import Fr.Banane.Vue.PanneauJeu;

public class Model implements Observable {

	protected int nbreErr = 0, nbreMot = 0;

	public String displayString;
	public char[] displayTab, motMystDisplay, motMystCompare ;

	protected Score score;
	protected StreamScore ss;

	protected ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();

	public Model(String word) {
		this.initNewString(word);
		this.score = new Score();
		this.ss = new StreamScore();
	}

	public String resolve(char charact)
	{	
		boolean found = false;
		for (int y = 0; y < motMystCompare.length ; ++y)  {
			if (motMystCompare[y] == charact) {
				this.displayTab[y] = this.motMystDisplay[y];
				found = true;
			}	
		}
		if (found == false)
			this.nbreErr++;
		displayString = String.valueOf(displayTab);
		System.out.println(displayString); //DEBUG**********************************************************************
		return this.displayString;
	}

	public int getErrorCount()
	{
		return this.nbreErr;
	}

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

	public void initNewString(String mot) {
		this.nbreErr = 0;
		this.motMystDisplay = mot.toCharArray();
		this.motMystCompare = Normalizer
				.normalize(mot, Normalizer.Form.NFD)
				.replaceAll("[\u0300-\u036F]", "").toCharArray();
		this.displayTab = new String(this.motMystDisplay).toCharArray();
		this.encryptage();
	}

	public String getDisplayString()
	{
		return String.valueOf(this.displayTab);
	}
	
	public String win() {
		if (this.displayString.equals(String.valueOf(motMystCompare))) {
			String str = "gagné";
			return str ;
		}
		else if  (nbreErr >= 7) {
			String str = "perdu";
			return str ;
		}
		else {
			String str = "pas encore gagné";
			return str;
		}	
	}

	public void addObservateur(Observateur obs) {
		// TODO Auto-generated method stub

	}

	public void updateObservateur() {
		// TODO Auto-generated method stub

	}

	public void delObservateur() {
		// TODO Auto-generated method stub

	}
}

package Fr.Banane.Modele;

import java.io.Serializable;

public class Score implements Serializable {
	
private int pts, ptsTotal, nbreMot;
private String nom;

public Score() {
	nom = "none";
	ptsTotal = 0;
	nbreMot = 0;
}

public Score(String nom, int ptsTotal, int nbreMot) {
	this.nom = nom;
	this.ptsTotal = ptsTotal;
	this.nbreMot = nbreMot;
}

public void initTotalScore(int fautes) {
	switch (fautes) {
	case 0:
		pts = 100;
		ptsTotal += 100;
		nbreMot += 1;
		break;
	case 1:
		pts = 50;
		ptsTotal += 50;
		nbreMot += 1;
		break;
		
	case 2:
		pts = 35;
		ptsTotal += 35;
		nbreMot += 1;
		break;
		
	case 3:
		pts = 25;
		ptsTotal += 25;
		nbreMot += 1;
		break;
		
	case 4:
		pts = 15;
		ptsTotal += 15;
		nbreMot += 1;
		break;
		
	case 5:
		pts = 10;
		ptsTotal += 10;
		nbreMot += 1;
		break;
		
	case 6:
		pts = 5;
		ptsTotal += 5;
		nbreMot += 1;
		break;
		
	default :
		this.pts = 0;
		
	}
}

public int getPts() {
	return pts;
}

public void setPts(int pts) {
	this.pts = pts;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int getPtsTotal() {
	return ptsTotal;
}

public void setPtsTotal(int ptsTotal) {
	this.ptsTotal = ptsTotal;
}

public int getNbreMot() {
	return nbreMot;
}

public void setNbreMot(int nbreMot) {
	this.nbreMot = nbreMot;
}

	public String toString() {
		String str = nom + " --> "+ ptsTotal + " ("+ nbreMot + " mots )";
		return str;
	}
	public static void main(String[] args) {
		Score scr = new Score("nom ?", 1100, 11);
		System.out.println(scr.toString());
	}
}

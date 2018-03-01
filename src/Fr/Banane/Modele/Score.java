package Fr.Banane.Modele;

import java.io.Serializable;

public class Score implements Serializable {
	
private int pts, ptsTotal, nbreMot;
private String nom;

public Score() {
	this.nom = "______";
	this.ptsTotal = 0;
	this.nbreMot = 0;
}

public Score(String nom, int ptsTotal, int nbreMot) {
	this.nom = nom;
	this.ptsTotal = ptsTotal;
	this.nbreMot = nbreMot;
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

public void initTotalScore(int fautes) {
	switch (fautes) {
	case 0:
		this.pts = 100;
		this.ptsTotal += 100;
		this.nbreMot += 1;
		break;
	case 1:
		this.pts = 50;
		this.ptsTotal += 50;
		this.nbreMot += 1;
		break;
		
	case 2:
		this.pts = 35;
		this.ptsTotal += 35;
		this.nbreMot += 1;
		break;
		
	case 3:
		this.pts = 25;
		this.ptsTotal += 25;
		this.nbreMot += 1;
		break;
		
	case 4:
		this.pts = 15;
		this.ptsTotal += 15;
		this.nbreMot += 1;
		break;
		
	case 5:
		this.pts = 10;
		this.ptsTotal += 10;
		this.nbreMot += 1;
		break;
		
	case 6:
		this.pts = 5;
		this.ptsTotal += 5;
		this.nbreMot += 1;
		break;
		
	default :
		this.pts = 0;
		
	}
}
	public String toString() {
		String str = nom + " --> "+ ptsTotal + " ("+ nbreMot + " mots )";
		return str;
	}

}

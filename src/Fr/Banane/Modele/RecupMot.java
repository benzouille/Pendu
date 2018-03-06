package Fr.Banane.Modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

public class RecupMot {

	private int nbre = (int)(Math.random()*336529);

	private String file = "ressources/dictionnaire.txt";

	protected String motMyst, motMystSA;

	protected ArrayList<String> listDico = new ArrayList<String>();

	public RecupMot() {
		//Recuperation et mise en ArrayList du dictionnaire
		System.out.println(nbre); //DEBUG**********************************************************************
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				listDico.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Recuperation de la ligne random
		System.out.println(listDico.get(nbre)); //DEBUG********************************************************
		motMyst = listDico.get(nbre);

		motMystSA = unaccent(motMyst);
		//System.out.println(motMystSA); //DEBUG*****************************************************************

	}
	//METHODE______________________________________________________________________________________________________
	//enlever les accents 
	public static String unaccent(String src) {
		return Normalizer
				.normalize(src, Normalizer.Form.NFD)
				.replaceAll("[\u0300-\u036F]", "");
	}

	//GETTER SETTER________________________________________________________________________________________________
	public String getMotMyst(){
		return motMyst;
	}

	public void setMotMyst(String mot) {
		motMyst =  mot;
	}

	public String getMotMystSA(){
		return motMystSA;
	}

	public void setMotMystSA(String motSA) {
		motMystSA =  motSA;
	}


	public static void main(String[] args) {
		RecupMot fen = new RecupMot();
	}
}

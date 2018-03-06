package Fr.Banane.Modele;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StreamScore {
	
private Score[] listScore = new Score[10];
protected ObjectInputStream ois;
protected ObjectOutputStream oos;
File fichier = new File("ressources/score.txt");

public StreamScore() {
	lireFichier();
}

public void lireFichier() {
	//tester si le fichier existe
	if(fichier.exists() == true) {
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("ressources/score.txt"))));

			try {
				System.out.println(((Score)ois.readObject()).toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("le fichier n'existe pas");
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public void scoreCompare() {
	//TODO comparer le score dans listScore si +grand que le 10eme trier et enlever la valeur à index[10]
}

public void ecrireFichier(Score score) {
	try {
		oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(
								new File("ressources/score.txt"))));

		oos.writeObject(score);
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			oos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}




public Score[] getListScore(){
	return listScore;
}

}

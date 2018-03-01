import Fr.Banane.Vue.PanneauJeu;

public class Test {

	String motMyst = "abaisse-langue";
	boolean lettrePresente = true;

	char test[] = motMyst.toCharArray();
	char motVisible[] = motMyst.toCharArray();
	char charact = 'a';

	PanneauJeu pj = new PanneauJeu();

	public Test() {
		//encryptage
		for(int i = 0; i < test.length; i++) {
			if (test[i] == '-') {
				test[i] = '-';
			}
			else
				test[i] = '*';
			System.out.println(test[i]);
		}
		//mise en place des lettres trouvées
		for (int y = 0; y < test.length ; ++y)  {
			if (motVisible[y] == charact) {
				test[y] = charact;
				lettrePresente = true;
			}
			else {
				this.lettrePresente = false;
			}
		}
		System.out.println(test);
		//Si motVisible == motInvisible alors gagné
	}


	public static void main(String[] args) {
		Test t2 = new Test();

	}

}

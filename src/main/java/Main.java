import java.util.ArrayList;

import Jeu.Jeu;
import Jeu.Mode;
import Jeu.Partie;
import Jeu.Recherche;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serial s = new Serial("resources","config.properties");
		
		
		
		
		
		//Jeu recherche= new Recherche(Mode.Duel);
		//recherche.DemarrerJeu();
		
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		int essai=5;
		int nbCase=3;
		int chiffre=4;

		
		//s.Ecriture(essai);
		//s.Ecriture(nbCase);
		//s.Ecriture(chiffre);
		
		s.Lecture();
		
		
	}

}

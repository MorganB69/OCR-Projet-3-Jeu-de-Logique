import java.util.ArrayList;

import IHM.IHM;
import Jeu.Jeu;
import Jeu.Mode;
import Jeu.Partie;
import Jeu.Recherche;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		Jeu recherche= new Recherche(Mode.Challenger);
		
		IHM i=new IHM();
		i.AfficherAccueil();
		recherche.addObserver(i);	
		
		

		
		while(recherche.statut!=6) {


		recherche.DemarrerJeu();
		}
		
		



	

		
		
	}

}




import Jeu.Jeu;
import Jeu.Mastermind;
import Jeu.Mode;

import Jeu.Recherche;
import Jeu.Statut;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Jeu recherche= new Mastermind(Mode.Duel);
		
		try {
			if (args[0].equals("d")) {
				recherche.dev=true;
				System.out.println("mode dév activé");
			}
			else System.out.println(args[0]);
		} catch (Exception e) {
			System.out.println("mode normal");
		}

		
		
		while(recherche.statut!=Statut.Fin) {


		recherche.DemarrerJeu();
		}
		
		



	

		
		
	}

}

import java.util.ArrayList;

import Jeu.Jeu;
import Jeu.Mode;
import Jeu.Partie;
import Jeu.Recherche;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Bonjour, veuillez choisir un jeu");
		System.out.println("--------------------------------");
		System.out.println("1- Jeu Recherche");
		System.out.println("2- Jeu Mastermind");
		System.out.println("--------------------------------");
		System.out.println();
		
		
		
		Jeu recherche= new Recherche(Mode.Defenseur);
		
		while(recherche.statut!=6) {
		
		Interface i=new Interface(recherche);
		recherche.DemarrerJeu();
		}
		
		



	

		
		
	}

}

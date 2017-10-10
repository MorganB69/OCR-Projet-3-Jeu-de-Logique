package IHM;
import java.util.Scanner;

import Combinaison.Combinaison;
import Jeu.Jeu;

public class IHM {
	
	
	
	public IHM(){
		
	}
	

	public void AfficherAccueil(){
		System.out.println();
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println("|                         JEU DE LOGIQUE                                       |");
		System.out.println("|              Recherche de combinaison et MasterMind                          |");
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println();
	}
	
	public void cls(){
		  for(int i=0; i<50; i++)
		    System.out.println();
		}
	
	public void AfficherComb(Combinaison c) {
		System.out.println("La combinaison est :" + c);
	}
	
	public void AfficherVerif(String s) {
		System.out.println("Vérification de la combinaison : " + s);
	}
	
	public void SaisirComb(Combinaison c) {
		System.out.println("Veuillez saisir une combinaison");
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		for (int i = 0; i < c.getNbCase(); i++) {
			int a = Character.getNumericValue(essai.charAt(i));
			if (a < 0 || a > 9)
				System.out.println("Erreur dans la combinaison");
			else
				c.getComb().set(i, a);
	}
	}
		
	public void AfficherNbEssai(int e) {
		System.out.println("Nombre d'essai restants : "+ e);
	}

		
	public void AfficherFinPartie(String s) {
		System.out.println("La partie est : " + s);
	}
	
	
}		
		

		
		
		
		
		/*
		switch (jeu.statut) {
		case 0:
			System.out.println("La partie commence");
			System.out.println("Le défenseur choisit la combinaison secrète");
			System.out.println();
			
			
			break;
		
		case 1:
			System.out.println();
			System.out.println("Premier Tour");
			System.out.println("La cible est "+jeu.target);
			System.out.println("nombre d'essai restants :" + jeu.essai);
			
			
			break;
			
		case 2 :
			System.out.println();
			System.out.println("La partie continue");
			System.out.println("nombre d'essai restants :" + jeu.essai);
			
			break;

		case 3:
			System.out.println("Fin du tour");
			
			
			break;
			
		case 4:
			System.out.println();
			System.out.println("La partie est perdue...");
			
			break;		
		
		case 5 :
			System.out.println();
			System.out.println("La partie est gagnée!");
			
			break;

		case 6:
			System.out.println();
			System.out.println("Fin de la partie");
			break;
			
			
		default:
			break;
		}
		*/


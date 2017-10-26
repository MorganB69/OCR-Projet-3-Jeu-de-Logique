


import IHM.IHM;
import Jeu.Jeu;
import Jeu.Mastermind;
import Jeu.Mode;

import Jeu.Recherche;
import Jeu.Statut;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boolean lancementjeu=true;
		Boolean continuer=false;
		int ChoixJeu = 0;
		int ChoixMode = 0;
		IHM i = new IHM();
		i.AfficherAccueil();
		
		while (lancementjeu==true) {
			
		//CREATION DE L'INTERFACE
		if(continuer==false) {
		ChoixJeu=i.ChoixJeu();
		ChoixMode=i.ChoixMode();
		}
		
		//CREATION DU JEU EN FONCTION DU CHOIX EFFECTUE
		Jeu jeu = null;
		
		
		
		switch (ChoixJeu) {
		case 1:
			switch (ChoixMode) {
			case 1:
				jeu= new Recherche(Mode.Challenger,i);
				break;

			case 2:
				jeu= new Recherche(Mode.Defenseur,i);
				break;
				
			case 3:
				jeu= new Recherche(Mode.Duel,i);
				break;
			}
			break;

		case 2:
			switch (ChoixMode) {
			case 1:
				jeu= new Mastermind(Mode.Challenger,i);
				break;

			case 2:
				jeu= new Mastermind(Mode.Defenseur,i);
				break;
				
			case 3:
				jeu= new Mastermind(Mode.Duel,i);
				break;
			}
			break;
		}
		
		
		//VERIFICATION DU MODE DEVELOPPEUR
		try {
			if (args[0].equals("d")) {
				jeu.dev=true;
				System.out.println("mode dév activé");
			}
			else System.out.println(args[0]);
		} catch (Exception e) {
			if (jeu.dev==true) System.out.println("mode dév activé");
			else System.out.println("mode normal");
		}

		
		
		while(jeu.statut!=Statut.Fin) {
		jeu.DemarrerJeu();
		}
		
	
		if (jeu.statut==Statut.Fin) {
			int ChoixFin=i.ChoixFin();
			switch (ChoixFin) {
			case 1:
				continuer=true;
	
				break;

			case 2:
				continuer=false;
				break;
				
			case 3:
				lancementjeu=false;
				break;
			}
		}
		
	
		
	}
		
	}
}

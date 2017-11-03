
import IHM.IHM;
import Jeu.Jeu;
import Jeu.Mastermind;
import Jeu.Mode;

import Jeu.Recherche;
import Jeu.Statut;

/**
 * Classe Main
 * 
 * @author Morgan
 *
 */
public class Main {

	/**
	 * Méthode main qui instancie une nouvelle IHM et un nouveau jeu
	 * 
	 * @param args
	 *            Définit si mode développeur activé ou non
	 */
	public static void main(String[] args) {
		//Si false, quitte le jeu
		Boolean lancementjeu = true;
		//Si true, relance le même jeu et même mode
		Boolean continuer = false;
		//Variable pour le choix du jeu
		int ChoixJeu = 0;
		//Variable pour le choix du mode
		int ChoixMode = 0;
		
		//Instanciation de l'IHM
		IHM i = new IHM();
		i.AfficherAccueil();

		while (lancementjeu == true) {

			// Affichage du choix du jeu et du choix du mode
			if (continuer == false) {
				ChoixJeu = i.ChoixJeu();
				ChoixMode = i.ChoixMode();
			}

			// CREATION DU JEU EN FONCTION DU CHOIX EFFECTUE
			Jeu jeu = null;

			switch (ChoixJeu) {
			case 1:
				switch (ChoixMode) {
				case 1:
					jeu = new Recherche(Mode.Challenger, i);
					break;

				case 2:
					jeu = new Recherche(Mode.Defenseur, i);
					break;

				case 3:
					jeu = new Recherche(Mode.Duel, i);
					break;
				}
				break;

			case 2:
				switch (ChoixMode) {
				case 1:
					jeu = new Mastermind(Mode.Challenger, i);
					break;

				case 2:
					jeu = new Mastermind(Mode.Defenseur, i);
					break;

				case 3:
					jeu = new Mastermind(Mode.Duel, i);
					break;
				}
				break;
			}

			// VERIFICATION DU MODE DEVELOPPEUR
			try {
				if (args[0].equals("d")) {
					jeu.dev = true;
					System.out.println("mode dév activé");
				} else
					System.out.println(args[0]);
			} catch (Exception e) {
				if (jeu.dev == true)
					System.out.println("mode dév activé");
				else
					System.out.println("mode normal");
			}
			
			//Fin de la partie, choix de l'utilisateur
			while (jeu.statut != Statut.Fin) {
				jeu.DemarrerJeu();
			}

			if (jeu.statut == Statut.Fin) {
				int ChoixFin = i.ChoixFin();
				switch (ChoixFin) {
				//Continuer le même jeu et le même mode
				case 1:
					continuer = true;

					break;
				//Changer de jeu ou de mode
				case 2:
					continuer = false;
					break;
				//Arrêter le jeu
				case 3:
					lancementjeu = false;
					break;
				}
			}

		}

	}
}

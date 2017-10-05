package Jeu;

import Combinaison.Combinaison;
import Combinaison.CombinaisonR;
import Joueur.Ordinateur;
import Joueur.User;

public class Recherche extends Jeu {

	public Recherche(Mode mode) {
		super(mode);
		this.target = new CombinaisonR();
		this.reponse = new CombinaisonR();

		if (this.mode == Mode.Challenger) {
			this.attaquant = new User();
			System.out.println(attaquant.getClass().getName());
			this.defenseur = new Ordinateur();
		} else {
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
		}
		System.out.println(target);

	}

	public void Verification(Combinaison target, Combinaison reponse) {
		for (int i = 0; i < target.getNbCase(); i++) {

			if (target.getComb().get(i) == reponse.getComb().get(i)) {
				System.out.print("=");
			} else {
				if (target.getComb().get(i) < reponse.getComb().get(i)) {
					System.out.print("+");
				} else
					System.out.print("-");
			}
		}

	}

	public void DemarrerJeu() {
		//Si on est au lancement du jeu, le défenseur définit la combinaison à chercher.
		if (this.statut == 0) {
			this.target.ReSet(this.defenseur);
		//Une fois défini, la partie est considéré comme "en-cours".	
			this.statut = 1;
			
		} else {
		//Si la partie est cours, l'attaquant va donner une combinaison et elle sera vérifiée
			while (this.essai > 0 && this.statut == 1) {

				System.out.println("la cible est" + this.target);//A afficher qu'en mode développeur
				this.reponse.ReSet(this.attaquant);
				System.out.println(this.reponse);
				this.Verification(this.target, this.reponse);
				if (this.reponse.getComb().equals(this.target.getComb()))
					break;
				else {
					this.essai--;
					System.out.println("nombre d'essai restants :" + this.essai);

					this.statut = 2;//on est en fin de tour
				}
			}

			if (this.essai == 0 && this.statut == 1) {
				System.out.println("Perdu...");
				this.statut = 4;//Partie terminée
			} else if (this.statut != 2) {
				System.out.println("Gagné!");
				this.statut = 3;//Partie terminée
			}

		}

	}
}

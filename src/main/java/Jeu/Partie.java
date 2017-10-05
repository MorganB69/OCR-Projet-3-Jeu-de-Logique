package Jeu;

public class Partie {

	Jeu jeu;
	Jeu jeu2;//un deuxième jeu doit être instancié en cas de mode duel
	Mode mode;
	//L'utilisateur devra taper un numéro pour choisir le jeu et le mode
	int m;//permettra de choisir le mode
	int j;//permettra de choisir le jeu

	public Partie(int j, int m) {
		this.m = m;
		this.j = j;

		switch (j) {

		case 1://Jeu RECHERCHE
			if (this.m == 1)//Mode CHALLENGER
				this.jeu = new Recherche(Mode.Challenger);
			else if (this.m == 2)//Mode DEFENSEUR
				this.jeu = new Recherche(Mode.Defenseur);
			else {//Mode Duel, on instancie deux jeux, un en mode challenger et l'autre en défenseur.
				this.jeu = new Recherche(Mode.Challenger);
				this.jeu2 = new Recherche(Mode.Defenseur);
			}

			break;

		case 2://Jeu MASTERMIND
			/*
			 * if (m==1) this.jeu = new Master(Mode.Challenger); else if(m==2) this.jeu =
			 * new Master(Mode.Defenseur); else { this.jeu= new Master(Mode.Challenger);
			 * this.jeu2= new Master(Mode.Defenseur);
			 * 
			 * 
			 * break; }
			 */
		}

	}
	//Méthode de gestion de la partie en fonction si on est en mode duel ou non.
	public void Commencer() {

		if (this.m == 3) {//Mode Duel
			while (true) {
				this.jeu.DemarrerJeu();
				this.jeu2.DemarrerJeu();
				if (this.jeu.statut == 3 || this.jeu.statut == 4 || this.jeu2.statut == 3 || this.jeu2.statut == 4)
					break;
				else {
					this.jeu.statut = 1;
					this.jeu.statut = 1;

				}
			}

		} else {
			while (true) {//Mode Challenger ou défenseur
				this.jeu.DemarrerJeu();
				if (this.jeu.statut == 3 || this.jeu.statut == 4)
					break;
				else
					this.jeu.statut = 1;
			}
		}

	}

}

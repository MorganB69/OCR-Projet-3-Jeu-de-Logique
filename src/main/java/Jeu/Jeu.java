package Jeu;

import Combinaison.Combinaison;
import Joueur.Joueur;

public abstract class Jeu {
	String nomJeu;
	int essai;
	Combinaison target;
	Combinaison reponse;
	Joueur attaquant;
	Joueur defenseur;
	int statut;
	Mode mode;

	public Jeu(Mode mode) {

		nomJeu = "defaut";
		this.mode = mode;
		this.essai = 8;// A FIXER DANS LE FICHIER DE PARAMETRE
		this.statut = 0;// A CHANGER VIA UNE ENUMERATION
	}

	public void Verification(Combinaison target, Combinaison reponse) {

	}

	public void DemarrerJeu() {

	}

}

package Jeu;

import Combinaison.Combinaison;
import Config.JeuConfig;
import Joueur.Joueur;

public abstract class Jeu {
	String nomJeu;
	JeuConfig p;
	int essai;
	Combinaison target;
	Combinaison target2;
	Combinaison reponse;
	Combinaison reponse2;
	Joueur attaquant;
	Joueur attaquant2;
	Joueur defenseur;
	Joueur defenseur2;
	
	
	int statut;
	Mode mode;

	public Jeu(Mode mode) {

		nomJeu = "defaut";
		this.p= new JeuConfig();
		this.mode = mode;
		this.essai = p.essai;// A FIXER DANS LE FICHIER DE PARAMETRE
		this.statut = 0;// A CHANGER VIA UNE ENUMERATION
	}

	public void Verification(Combinaison target, Combinaison reponse) {

	}

	public void DemarrerJeu() {

	}

}

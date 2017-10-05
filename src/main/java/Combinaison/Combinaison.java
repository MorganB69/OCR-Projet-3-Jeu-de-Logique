package Combinaison;

import java.util.ArrayList;

import Joueur.Joueur;

public abstract class Combinaison {

	ArrayList<Integer> comb;
	int nbCase;

	public Combinaison() {
		// TODO Auto-generated constructor stub
		this.comb = new ArrayList<Integer>();
		this.nbCase = 3;// A MODIFIER APRES INTEGRATION DU FICHIER CONFIG

		// En fonction du nombre de cases d�finies dans le fichier on cr�e une
		// combinaison al�atoire par d�faut
		for (int i = 0; i < nbCase; i++) {
			comb.add(i, (int) (Math.random() * (9 - 0) + 0));
		}

	}

	// M�thode abstraite qui aura pour r�le de changer une combinaison
	public void ReSet(Joueur j) {

	}
	
	public void ReSet(Joueur j,ArrayList<String> l) {

	}
	
	

	public String toString() {
		String str = "";

		for (int i = 0; i < nbCase; i++) {
			str = str + (comb.get(i));
		}
		return str;
	}

	public ArrayList<Integer> getComb() {
		return comb;
	}

	public void setComb(ArrayList<Integer> comb) {
		this.comb = comb;
	}

	public int getNbCase() {
		return nbCase;
	}

	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}

}

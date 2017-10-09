package Combinaison;

import java.util.ArrayList;

import Config.JeuConfig;
import Joueur.Joueur;

public abstract class Combinaison {

	ArrayList<Integer> comb;
	JeuConfig p;
	int nbCase;
	public int[]max;
	public int[]min;
	

	public Combinaison() {
		// TODO Auto-generated constructor stub
		this.p= new JeuConfig();
		this.comb = new ArrayList<Integer>();
		
		this.nbCase = p.nbCase;// A MODIFIER APRES INTEGRATION DU FICHIER CONFIG

		// En fonction du nombre de cases définies dans le fichier on crée une
		// combinaison aléatoire par défaut
		for (int i = 0; i < nbCase; i++) {
			comb.add(i, (int) (Math.random() * (9 - 0) + 0));
		}
		
		this.max= new int[nbCase];
		this.min=new int[nbCase];
		
		
		for (int i=0;i<nbCase;i++) {
			this.max[i]=9;
			this.min[i]=0;
		}

	}

	// Méthode abstraite qui aura pour rôle de changer une combinaison
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

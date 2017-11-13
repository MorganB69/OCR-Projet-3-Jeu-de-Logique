package Combinaison;

import java.util.ArrayList;

import Config.JeuConfig;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;
import Joueur.Joueur;

/**
 * Classe abstraite représentant une combinaison
 * @author Morgan
 *
 */
public abstract class Combinaison {

	/**
	 * ArrayList de la combinaison
	 */
	public ArrayList<Integer> comb;
	/**
	 * Attribut qui permet de récupérer les paramètres de la combinaison
	 */
	JeuConfig p;
	/**
	 * Nombre de case de la combinaison 
	 */
	int nbCase;
	/**
	 * Permet d'enregistrer la valeur maximale pour l'IA Recherche
	 */
	public int[]max;
	/**
	 * Permet d'enregistrer la valeur minimale pour l'IA Recherche
	 */
	public int[]min;
	/**
	 * Nombre de chiffre/couleur pour le MasterMind 
	 */
	public int chiffre;
	

	/**
	 * Constructeur par défaut d'une combinaison 
	 */
	public Combinaison(JeuConfig p) {
		
		
		
		this.comb = new ArrayList<Integer>();
		this.chiffre=p.chiffre;
		
		this.nbCase = p.nbCase;

		// En fonction du nombre de cases définies dans le fichier on crée une
		// combinaison aléatoire par défaut
		for (int i = 0; i < nbCase; i++) {
			comb.add(i, (int) (Math.random() * (9 - 0) + 0));
		}
		
		this.max= new int[nbCase];
		this.min=new int[nbCase];
		
		
		for (int i=0;i<nbCase;i++) {
			this.max[i]=9;//Par défaut le maximum est 9
			this.min[i]=0;//Par défaut le minimum est 0
		}

	}

	
	/**
	 * Méthode abstraite qui aura pour rôle de changer une combinaison
	 * @param j
	 * 		Le joueur dont on doit changer la combinaison
	 */
	public void ReSet(Joueur j) {

	}
	
	/**
	 * @param j
	 * 		Le joueur dont on doit changer la combinaison
	 * @param i
	 * 		L'IHM qui sera utilisée pour la saisie des combinaisons
	 */
	public void ReSet(Joueur j,IHM i) {

	}
	
	/**
	 * @param j
	 * 		Le joueur dont on doit changer la combinaison
	 * @param i
	 * 		L'IHM qui sera utilisée pour la saisie des combinaisons
	 * @param m
	 * 		Le mode du jeu, utile pour le changement de combinaison de l'IA du Mastermind
	 * @param s
	 * 		Le statut du jeu, utile pour le changement de combinaison de l'IA du Mastermind
	 */
	public void ReSet(Joueur j,IHM i,Mode m,Statut s) {

	}
	
	/**
	 * @param j
	 * 		Le joueur dont on doit changer la combinaison
	 * @param l
	 * 		ArrayList comprenant le résultat d'une précédente combinaison pour l'IA
	 * @param i
	 * 		L'IHM qui sera utilisée pour la saisie des combinaisons
	 */
	public void ReSet(Joueur j,ArrayList<String> l, IHM i) {

	}
	
	


	public String toString() {
		String str = "";

		for (int i = 0; i < nbCase; i++) {
			str = str + (comb.get(i));
		}
		return str;
	}

	/**
	 * @return
	 * 		retourne une combinaison
	 */
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

package Combinaison;

import java.util.ArrayList;

import Combinaison.ReSet.ReSetOrdi;
import Combinaison.ReSet.ReSetUser;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;
import Joueur.Joueur;

/**
 * Classe héritée de Combinaison pour générer une combinaison Recherche
 * 
 * @author Morgan
 *
 */
public class CombinaisonR extends Combinaison {
	/**
	 * Utilisation de l'interface ReSet pour changer la combinaison de l'utilisateur
	 */
	ReSetUser reset;
	/**
	 * Utilisation de l'interface ReSet pour changer la combinaison de l'ordinateur
	 */
	ReSetOrdi reset2;
	/**
	 * Constructeur pour la combinaison Recherche
	 * Instanciation de ReSetUser et ReSetOrdi
	 */
	public CombinaisonR() {
		super();
		this.reset = new ReSetUser();
		this.reset2 = new ReSetOrdi();

	}

	public void ReSet(Joueur j, ArrayList<String> l, IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this, i);
		} else
			reset2.SetComb(this, l, i);
	}

	public void ReSet(Joueur j, IHM i, Mode m, Statut statut) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this, i);
		} else
			reset2.SetComb(this, i, m, statut);
	}

	public String toString() {
		return super.toString();
	}

}

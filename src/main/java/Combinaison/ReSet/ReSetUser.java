package Combinaison.ReSet;

import java.util.Scanner;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

/**
 * Classe permettant de changer la combinaison de l'utilisateur
 * 
 * @author Morgan
 *
 */
public class ReSetUser implements ReSet {

	/**
	 * Change la combinaison
	 * 
	 * @param c
	 *            Combinaison à changer
	 * @param i
	 *            Interface à utilisée
	 */
	public void SetComb(Combinaison c, IHM i) {
		i.SaisirComb(c);
	}

	/**
	 * Change la combinaison
	 * 
	 * @param c
	 *            Combinaison à changer
	 * @param i
	 *            Interface à utilisée
	 */
	public void SetComb(Combinaison c, IHM i, Mode m, Statut statut) {
		i.SaisirComb(c);

	}

	/**
	 * Change la combinaison
	 * 
	 * @param c
	 *            Combinaison à changer
	 * @param i
	 *            Interface à utilisée
	 */
	public void SetCombM(Combinaison c, IHM i) {
		i.SaisirCombM(c);

	}

}

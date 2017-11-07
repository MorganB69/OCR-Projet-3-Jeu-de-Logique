package Combinaison.ReSet;

import java.util.ArrayList;



import Combinaison.Combinaison;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

/**
 * Interface ReSet avec la méthode SetComb à implémenter dans les classes ReSet
 * @author Morgan
 *
 */
public interface ReSet {
	//void SetComb(Combinaison c, IHM i);
	/**
	 * Méthode permettant de changer la combinaison
	 * @param c
	 * 		La combinaison à changer
	 * @param i
	 * 		L'interface utilisée
	 * @param m
	 * 		Le mode utilisé
	 * @param statut
	 * 		Le statut de la partie en cours
	 */
	void SetComb(Combinaison c,IHM i,Mode m, Statut statut);
	
	
	

	
	
	
}

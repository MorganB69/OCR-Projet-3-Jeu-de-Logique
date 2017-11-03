package Combinaison.ReSet;

import java.util.ArrayList;



import Combinaison.Combinaison;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

/**
 * Interface ReSet avec la m�thode SetComb � impl�menter dans les classes ReSet
 * @author Morgan
 *
 */
public interface ReSet {
	//void SetComb(Combinaison c, IHM i);
	/**
	 * M�thode permettant de changer la combinaison
	 * @param c
	 * 		La combinaison � changer
	 * @param i
	 * 		L'interface utilis�e
	 * @param m
	 * 		Le mode utilis�
	 * @param statut
	 * 		Le statut de la partie en cours
	 */
	void SetComb(Combinaison c,IHM i,Mode m, Statut statut);
	
	
	

	
	
	
}

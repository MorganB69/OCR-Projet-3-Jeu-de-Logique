package Combinaison.ReSet;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Combinaison.Combinaison;
import IAMaster.IAMaster;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

/**
 * Classe impl�mentant les m�thodes ReSet de l'ordinateur pour le jeu Recherche
 * @author Morgan
 *
 */
public class ReSetOrdi implements ReSet {
	private static final Logger logger = LogManager.getLogger(IAMaster.class);
	/* (non-Javadoc)
	 * Par d�faut g�n�re une combinaison al�atoire
	 * @see Combinaison.ReSet.ReSet#SetComb(Combinaison.Combinaison, IHM.IHM, Jeu.Mode, Jeu.Statut)
	 */
	public void SetComb(Combinaison c,IHM k, Mode m, Statut statut) {
		
		for (int i = 0; i < c.getNbCase(); i++) {
			c.getComb().set(i, (int) (Math.random() * (9 - 0 + 1) + 0));
		}
	}
	
	
	
	/**
	 * En fonction du r�sultat pr�c�dent, adapte la combinaison en fixant un nouveau max et min
	 * @param c
	 * 		La combinaison � changer
	 * @param j
	 * 		Le joueur qui doit changer sa combinaison
	 * @param k
	 * 		L'interface utilis�e
	 */
	public void SetComb(Combinaison c,ArrayList<String> j, IHM k) {
		
		
		for (int i = 0; i < c.getNbCase(); i++) {
			
			logger.debug("IA : Max position "+i+" : "+c.getMax()[i]);
			logger.debug("IA : Min position "+i+" : "+c.getMin()[i]);
			if (j.get(i)=="=") {
				c.getComb().set(i,c.getComb().get(i));
			}
			else if (j.get(i)=="-") {
				c.getMax()[i]=c.getComb().get(i)-1;
				c.getComb().set(i, (int) (Math.random() * (c.getMax()[i] - c.getMin()[i] + 1 ) + c.getMin()[i]));

			}
			else {
				c.getMin()[i]=c.getComb().get(i)+1;
				c.getComb().set(i, (int) (Math.random() * (c.getMax()[i] - c.getMin()[i] + 1) + c.getMin()[i]));

			}
			
		}
	}
	
	/**
	 * Par d�faut, donne une combinaison al�atoire
	 * @param c
	 * 		La combinaison � changer
	 * @param k
	 * 		L'interface utilis�e
	 */
	public void SetCombM(Combinaison c, IHM k) {
		
				for (int i = 0; i < c.getNbCase(); i++) {
					c.getComb().set(i, (int) (Math.random() * (c.getChiffre() - 0 + 1) + 0));
				}
	}
	


}



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
 * Classe implémentant les méthodes ReSet de l'ordinateur pour le jeu Recherche
 * @author Morgan
 *
 */
public class ReSetOrdi implements ReSet {
	private static final Logger logger = LogManager.getLogger(IAMaster.class);
	/* (non-Javadoc)
	 * Par défaut génère une combinaison aléatoire
	 * @see Combinaison.ReSet.ReSet#SetComb(Combinaison.Combinaison, IHM.IHM, Jeu.Mode, Jeu.Statut)
	 */
	public void SetComb(Combinaison c,IHM k, Mode m, Statut statut) {
		
		for (int i = 0; i < c.getNbCase(); i++) {
			c.getComb().set(i, (int) (Math.random() * (9 - 0 + 1) + 0));
		}
	}
	
	
	
	/**
	 * En fonction du résultat précédent, adapte la combinaison en fixant un nouveau max et min
	 * @param c
	 * 		La combinaison à changer
	 * @param j
	 * 		Le joueur qui doit changer sa combinaison
	 * @param k
	 * 		L'interface utilisée
	 */
	public void SetComb(Combinaison c,ArrayList<String> j, IHM k) {
		
		
		for (int i = 0; i < c.getNbCase(); i++) {
			
			logger.debug("IA : Max position "+i+" : "+c.max[i]);
			logger.debug("IA : Min position "+i+" : "+c.min[i]);
			if (j.get(i)=="=") {
				c.getComb().set(i,c.getComb().get(i));
			}
			else if (j.get(i)=="-") {
				c.max[i]=c.getComb().get(i)-1;
				c.getComb().set(i, (int) (Math.random() * (c.max[i] - c.min[i] + 1 ) + c.min[i]));

			}
			else {
				c.min[i]=c.getComb().get(i)+1;
				c.getComb().set(i, (int) (Math.random() * (c.max[i] - c.min[i] + 1) + c.min[i]));

			}
			
		}
	}
	
	/**
	 * Par défaut, donne une combinaison aléatoire
	 * @param c
	 * 		La combinaison à changer
	 * @param k
	 * 		L'interface utilisée
	 */
	public void SetCombM(Combinaison c, IHM k) {
		
				for (int i = 0; i < c.getNbCase(); i++) {
					c.getComb().set(i, (int) (Math.random() * (c.chiffre - 0 + 1) + 0));
				}
	}
	


}



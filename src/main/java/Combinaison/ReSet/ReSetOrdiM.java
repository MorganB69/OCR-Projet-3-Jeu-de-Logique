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
 * La classe permettant de changer la combinaison de l'ordinateur pour le
 * Mastermind
 * 
 * @author Morgan
 *
 */
public class ReSetOrdiM implements ReSet {
	private static final Logger logger = LogManager.getLogger(ReSetOrdiM.class);
	/**
	 * L'IA du Mastermind qui sera utilisée
	 */
	IAMaster IA;

	/**
	 * Constructeur du ReSetOrdi
	 * 
	 * @param chiffre
	 *            Nombre de chiffre/couleur du jeu
	 * @param nbcase
	 *            Nombre de case pour chaque combinaison
	 */
	public ReSetOrdiM(int chiffre, int nbcase) {
		this.IA = new IAMaster(chiffre, nbcase);
	}

	public void SetComb(Combinaison c, IHM i, Mode m, Statut statut) {

		if (m == Mode.Challenger || m == Mode.Duel && statut == Statut.Start) {
			for (int j = 0; j < c.getNbCase(); j++) {
				c.getComb().set(j, (int) (Math.random() * (c.chiffre - 0 + 1) + 0));
			}
		} else {
			this.IA.Combi();
			c.setComb(this.IA.combRecherche);
		}

	}

	
	/**
	 * Méthode utilisant les fonctions de l'IA Mastermind pour changer la combinaison
	 * @param c
	 * 		La combinaison à changer
	 * @param l
	 * 		Le résultat de la précédente combinaison (nombre bien placés et mal placés)
	 * @param i
	 * 		L'interface utilisée
	 */
	public void SetComb(Combinaison c, ArrayList<Integer> l, IHM i) {

		this.IA.CalculNbc();

		if (this.IA.existe.size() + this.IA.confirme.size() != this.IA.nbcase) {

			//Vérifie si une couleur existe
			this.IA.VerifCouleur(l.get(0), l.get(1));


			//Vérifie si une couleur déjà existante est confirmée à la bonne place
			this.IA.VerifConfirme(l.get(0), l.get(1));


			//Vérifie si une couleur utilisée existe
			this.IA.VerifExiste(l.get(0), l.get(1));


			//Vérifie si un existant est mal placé
			this.IA.VerifMalp(l.get(0), l.get(1));

		}

		else {
			//Permet de trouver la combinaison finale lorsque toutes les couleurs sont découvertes
			this.IA.FinalComb(l.get(0), l.get(1));
		}
		//Confirme une couleur lorsque les autres couleurs ne sont pas possibles à une case
		this.IA.Elimination();
		//Confirme une couleur lorsqu'elle existe et ne peut être sur une autre case
		this.IA.Elimination2();

		//Supprime les couleurs sur les positions non possibles
		this.IA.Suppr();


		//Remet à zero les hypothèses de l'IA du Mastermind pour le prochain tour
		this.IA.HypReset();


		//L'IA recherche la meilleure combinaison possible après les traitements précédents
		this.IA.Combi();
		logger.debug("Positions possibles : ");
		for (int j = 0; j < this.IA.position.size(); j++) {
			
			logger.debug(this.IA.position.get(j));
		}
		//Modifie la combinaison à utiliser dans le jeu
		c.setComb(this.IA.combRecherche);

	}
}

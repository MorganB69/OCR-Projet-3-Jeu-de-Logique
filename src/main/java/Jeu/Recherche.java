package Jeu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Combinaison.Combinaison;
import Combinaison.CombinaisonR;
import Config.JeuConfig;
import IHM.IHM;
import Joueur.Joueur;
import Joueur.Ordinateur;
import Joueur.User;

/**
 * Classe implémentant le jeu Recherche
 * 
 * @author Morgan
 *
 */
public class Recherche extends Jeu {
	protected static final Logger logger = LogManager.getLogger(Recherche.class);
	/**
	 * Constructeur de Recherche
	 * 
	 * @param mode
	 *            Mode de jeu choisi
	 * @param ihm
	 *            Interface implémentée dans le jeu
	 */
	@SuppressWarnings("unchecked")
	public Recherche(Mode mode, IHM ihm, JeuConfig p) {
		super(mode, ihm, p);
		this.nomJeu = "Recherche";
		for (int i = 0; i < p.nbCase; i++)
			this.resultat.add(i, "");

		switch (mode) {
		// Instanciation des joueurs et des combinaisons en fonction du mode choisi

		case Challenger:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.target = new CombinaisonR(p);
			this.reponse = new CombinaisonR(p);
			break;

		case Defenseur:
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
			this.target = new CombinaisonR(p);
			this.reponse = new CombinaisonR(p);
			break;

		case Duel:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.attaquant2 = defenseur;
			this.defenseur2 = attaquant;
			this.target = new CombinaisonR(p);
			this.reponse = new CombinaisonR(p);
			this.target2 = new CombinaisonR(p);
			this.reponse2 = new CombinaisonR(p);

			break;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Jeu.Jeu#Verification(Combinaison.Combinaison, Combinaison.Combinaison,
	 * Joueur.Joueur)
	 */
	@SuppressWarnings("unchecked")
	public void Verification(Combinaison target, Combinaison reponse, Joueur j, JeuConfig p) {
		
		logger.trace("Méthode de vérification du Mastermind");
		// Comparaison des deux combinaisons. Si le joueur est l'ordinateur on
		// enregistre le résultat
		this.verif = "";
		for (int i = 0; i < target.getNbCase(); i++) {

			if (target.getComb().get(i) == reponse.getComb().get(i)) {
				this.verif = this.verif + "=";
				if (j.getNom() == "Ordinateur")
					this.resultat.set(i, "=");
			} else {
				if (target.getComb().get(i) < reponse.getComb().get(i)) {
					this.verif = this.verif + "-";
					if (j.getNom() == "Ordinateur")
						this.resultat.set(i, "-");
				} else {
					this.verif = this.verif + "+";
					if (j.getNom() == "Ordinateur")
						this.resultat.set(i, "+");
				}
			}
		}
		System.out.println("Resultat : "+ this.resultat);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Jeu.Jeu#DemarrerJeu()
	 */
	public void DemarrerJeu() {
		super.DemarrerJeu();

	}

}

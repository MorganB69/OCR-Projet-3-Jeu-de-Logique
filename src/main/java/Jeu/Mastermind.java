package Jeu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;
import Config.JeuConfig;
import IHM.IHM;
import Joueur.Joueur;
import Joueur.Ordinateur;
import Joueur.User;

/**
 * Classe implémentant le jeu Mastermind
 * 
 * @author Morgan
 *
 */
public class Mastermind extends Jeu {
	
	protected static final Logger logger = LogManager.getLogger(Mastermind.class);
	/**
	 * Nombre de pions biens placés
	 */
	int bienPlace;
	/**
	 * Nombre de pions mal placés
	 */
	int malPlace;

	/**
	 * Constructeur du Mastermind
	 * 
	 * @param mode
	 *            Mode de jeu choisi
	 * @param ihm
	 *            IHM utilisée
	 */
	@SuppressWarnings("unchecked")
	public Mastermind(Mode mode, IHM ihm, JeuConfig p) {
		super(mode, ihm, p);
		// TODO Auto-generated constructor stub

		this.nomJeu = "MasterMind";
		for (int i = 0; i < p.getNbCase(); i++)
			this.resultat.add(i, "");
		this.bienPlace = 0;
		this.malPlace = 0;

		switch (mode) {
		// Instanciation des joueurs et des combinaisons en fonction du mode choisi

		case Challenger:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.target = new CombinaisonM(p);
			this.reponse = new CombinaisonM(p);
			break;

		case Defenseur:
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
			this.target = new CombinaisonM(p);
			this.reponse = new CombinaisonM(p);
			break;

		case Duel:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.attaquant2 = defenseur;
			this.defenseur2 = attaquant;
			this.target = new CombinaisonM(p);
			this.reponse = new CombinaisonM(p);
			this.target2 = new CombinaisonM(p);
			this.reponse2 = new CombinaisonM(p);

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
		this.bienPlace = 0;
		this.malPlace = 0;

		Combinaison doublon = new CombinaisonM(p);
		for (int i = 0; i < target.getNbCase(); i++) {
			doublon.getComb().set(i, -1);
		}

		for (int i = 0; i < target.getNbCase(); i++) {

			if (reponse.getComb().get(i) == target.getComb().get(i)) {
				this.bienPlace++;
				doublon.getComb().set(i, reponse.getComb().get(i));

			} else {
				for (int k = 0; k < target.getNbCase(); k++) {
					if (reponse.getComb().get(k) == target.getComb().get(i)
							&& reponse.getComb().get(k) != doublon.getComb().get(k)) {
						this.malPlace++;
						doublon.getComb().set(k, reponse.getComb().get(k));
						break;

					}
				}

			}
		}
		this.verif = this.bienPlace + " à la bonne place + " + this.malPlace + " à une autre place";
		if (j.getClass().getName() == "Joueur.Ordinateur") {
			this.resultat.set(0, this.bienPlace);
			this.resultat.set(1, this.malPlace);
		}
		

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

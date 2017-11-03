package Jeu;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;
import IHM.IHM;
import Joueur.Joueur;
import Joueur.Ordinateur;
import Joueur.User;

/**
 * Classe impl�mentant le jeu Mastermind
 * 
 * @author Morgan
 *
 */
public class Mastermind extends Jeu {

	/**
	 * Nombre de pions biens plac�s
	 */
	int bienPlace;
	/**
	 * Nombre de pions mal plac�s
	 */
	int malPlace;

	/**
	 * Constructeur du Mastermind
	 * 
	 * @param mode
	 *            Mode de jeu choisi
	 * @param ihm
	 *            IHM utilis�e
	 */
	@SuppressWarnings("unchecked")
	public Mastermind(Mode mode, IHM ihm) {
		super(mode, ihm);
		// TODO Auto-generated constructor stub

		this.nomJeu = "MasterMind";
		for (int i = 0; i < p.nbCase; i++)
			this.resultat.add(i, "");
		this.bienPlace = 0;
		this.malPlace = 0;

		switch (mode) {
		// Instanciation des joueurs et des combinaisons en fonction du mode choisi

		case Challenger:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			break;

		case Defenseur:
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			break;

		case Duel:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.attaquant2 = defenseur;
			this.defenseur2 = attaquant;
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			this.target2 = new CombinaisonM();
			this.reponse2 = new CombinaisonM();

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
	public void Verification(Combinaison target, Combinaison reponse, Joueur j) {

		// Comparaison des deux combinaisons. Si le joueur est l'ordinateur on
		// enregistre le r�sultat
		this.verif = "";
		this.bienPlace = 0;
		this.malPlace = 0;

		Combinaison doublon = new CombinaisonM();
		for (int i = 0; i < target.getNbCase(); i++) {
			doublon.comb.set(i, -1);
		}

		for (int i = 0; i < target.getNbCase(); i++) {

			if (reponse.getComb().get(i) == target.getComb().get(i)) {
				this.bienPlace++;
				doublon.comb.set(i, reponse.getComb().get(i));

			} else {
				for (int k = 0; k < target.getNbCase(); k++) {
					if (reponse.getComb().get(k) == target.getComb().get(i)
							&& reponse.getComb().get(k) != doublon.getComb().get(k)) {
						this.malPlace++;
						doublon.comb.set(k, reponse.getComb().get(k));
						break;

					}
				}

			}
		}
		this.verif = this.bienPlace + " � la bonne place + " + this.malPlace + " � une autre place";
		if (j.getClass().getName() == "Joueur.Ordinateur") {
			this.resultat.set(0, this.bienPlace);
			this.resultat.set(1, this.malPlace);
		}
		System.out.println();

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

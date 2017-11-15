package Jeu;

import java.util.ArrayList;
import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Combinaison.Combinaison;
import Config.JeuConfig;
import IHM.IHM;
import Joueur.Joueur;

/**
 * Classe abstraite d'un jeu et implémentant un observable pour l'IHM
 * @author Morgan
 *
 */
/**
 * @author Morgan
 *
 */
public abstract class Jeu extends Observable {
	
	protected static final Logger logger = LogManager.getLogger(Jeu.class);
	
	/**
	 * Nom du Jeu
	 */
	protected String nomJeu;
	/**
	 * Classe des paramètres du jeu
	 */
	protected JeuConfig p;
	/**
	 * Nombre d'essai
	 */
	protected int essai;
	/**
	 * Mode développeur
	 */
	protected Boolean dev;
	/**
	 * Combinaison à trouver pour le joueur 1
	 */
	protected Combinaison target;
	/**
	 * Combinaison à trouver pour le joueur 2 (Mode duel)
	 */
	protected Combinaison target2;
	/**
	 * Combinaison donnée par le joueur 1
	 */
	protected Combinaison reponse;
	/**
	 * Combinaison donnée par le joueur 2 (Mode duel)
	 */
	protected Combinaison reponse2;
	/**
	 * Joueur attaquant 1
	 */
	protected Joueur attaquant;
	/**
	 * Joueur attaquant 2 (Mode duel)
	 */
	protected Joueur attaquant2;
	/**
	 * Joueur défenseur 1
	 */
	protected Joueur defenseur;
	/**
	 * Joueur défenseur 2 (Mode duel)
	 */
	protected Joueur defenseur2;
	/**
	 * IHM implémentée dans le jeu
	 */
	protected IHM i;

	/**
	 * Définit le statut du déroulement la partie
	 */
	protected Statut statut;
	/**
	 * Mode de jeu
	 */
	protected Mode mode;
	/**
	 * Résultat après vérification de la combinaison
	 */
	@SuppressWarnings("rawtypes")
	protected ArrayList resultat;

	/**
	 * Utilisée pour la vérification de la combinaison
	 */
	protected String verif;

	/**
	 * Constructeur du jeu
	 * 
	 * @param mode
	 *            mode choisi
	 * @param ihm
	 *            implémentation de l'IHM
	 */
	public Jeu(Mode mode, IHM ihm, JeuConfig p) {

		nomJeu = "defaut";
		
		this.p=p;
		this.mode = mode;
		this.essai = p.getEssai();// A FIXER DANS LE FICHIER DE PARAMETRE
		this.dev = p.getDev();
		this.statut = Statut.Start;
		// A CHANGER VIA UNE ENUMERATION
		this.resultat = new ArrayList<>();
		this.i = ihm;

		this.addObserver(i);
		logger.info("Instanciation d'un jeu");
	}

	/**
	 * Vérifie la combinaison donnée par le joueur
	 * 
	 * @param target
	 *            Combinaison à trouver
	 * @param reponse
	 *            Combinaison donnée par le joueur
	 * @param attaquant
	 *            Le joueur qui a donné la combinaison
	 */
	public void Verification(Combinaison target, Combinaison reponse, Joueur attaquant, JeuConfig p) {
		
	}

	/**
	 * Méthode permettant à l'observer d'obtenir les changements d'état du jeu
	 */
	public void notifierObservateur() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Lancement de la partie en fonction du mode Le statut de la partie évolue et
	 * au fur et à mesure de la partie L'observer est tenu au courant des
	 * changements d'état
	 */
	@SuppressWarnings("unchecked")
	public void DemarrerJeu() {
		logger.traceEntry("Méthode DemarrerJeu : Partie en cours");
		logger.traceExit("Méthode DemarrerJeu : Changement de statut");
		if (this.mode == Mode.Challenger || this.mode == Mode.Defenseur) {

			// MODE CHALLENGER OU DEFENSEUR
			switch (this.statut) {
			case Start:
				// Lancement de la partie
				// Le défenseur choisit la combinaison secrète
				this.target.ReSet(this.defenseur, this.i, this.mode, this.statut);

				notifierObservateur();
				this.statut = Statut.Tour1;
				break;

			case Tour1:

				// Premier tour, l'attaquant donne une combinaison
				this.reponse.ReSet(attaquant, this.i, this.mode, this.statut);

				// Cette combinaison est vérifiée

				this.Verification(this.target, this.reponse, this.attaquant, this.p);

				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb()))
					this.statut = Statut.Gagné;
				// Si la combinaison est bonne, la partie est gagnée sinon fin du tour

				else
					this.statut = Statut.FinTour;
				break;

			case EnCours:
				// Autres tours
				// L'attaquant change sa combinaison, en prenant en paramètre le résultat
				// précédent
				// pour adapter sa future combinaison (Utile pour l'ordinateur)

				this.reponse.ReSet(this.attaquant, this.resultat, this.i);

				this.Verification(this.target, this.reponse, this.attaquant, this.p);

				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = Statut.Gagné;

				} else
					this.statut = Statut.FinTour;
				break;

			case FinTour:
				// Fin du tour, on décrémente essai. Si on arrive à 0, la partie est perdue
				// sinon autre tour
				this.essai--;
				notifierObservateur();

				if (this.essai == 0)
					this.statut = Statut.Perdu;
				else
					this.statut = Statut.EnCours;
				break;

			case Perdu:
				// La partie est perdue. Fin de la partie.

				notifierObservateur();
				this.statut = Statut.Fin;

				break;

			case Gagné:
				// La partie est gagnée. Fin de la partie.

				notifierObservateur();
				this.statut = Statut.Fin;

				break;

			}
		}

		else {
			// MODE DUEL
			switch (this.statut) {

			case Start:
				// Lancement de la partie, les deux joueurs donnent une combinaison secrète
				this.target.ReSet(this.defenseur, this.i, this.mode, this.statut);
				this.target2.ReSet(this.defenseur2, this.i, this.mode, this.statut);
				notifierObservateur();
				this.statut = Statut.Tour1;
				break;

			case Tour1:
				// Premier tour
				// Au premier joueur de jouer.
				this.reponse.ReSet(attaquant, this.i, this.mode, this.statut);

				this.Verification(this.target, this.reponse, this.attaquant, this.p);

				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb()))
					this.statut = Statut.Gagné;

				else
					this.statut = Statut.Tour1J2;

				break;

			case EnCours:
				// Autres tours

				// Premier joueur de jouer
				this.reponse.ReSet(this.attaquant, this.i, this.mode, this.statut);

				this.Verification(this.target, this.reponse, this.attaquant, this.p);

				notifierObservateur();
				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = Statut.Gagné;

				}

				else
					this.statut = Statut.EnCoursJ2;

				break;

			case FinTour:
				// Fin du tour, on décrémente essai
				this.essai--;

				notifierObservateur();
				if (this.essai == 0)
					this.statut = Statut.Perdu;
				else {

					this.statut = Statut.EnCours;
				}
				break;

			case Perdu:
				// La partie est perdue

				notifierObservateur();
				this.statut = Statut.Fin;

				break;

			case Gagné:
				// La partie est gagnée.

				notifierObservateur();
				this.statut = Statut.Fin;

				break;

			case Tour1J2:
				// Au deuxième joueur de jouer
				this.reponse2.ReSet(attaquant2, this.i, this.mode, this.statut);

				this.Verification(this.target2, this.reponse2, this.attaquant2, this.p);

				notifierObservateur();
				if (this.reponse2.getComb().equals(this.target2.getComb()))
					this.statut = Statut.Gagné;

				else

					this.statut = Statut.FinTour;

				break;

			case EnCoursJ2:
				// Deuxième joueur de jouer.
				this.reponse2.ReSet(this.attaquant2, this.resultat, this.i);

				this.Verification(this.target2, this.reponse2, this.attaquant2, this.p);

				notifierObservateur();
				if (this.reponse2.getComb().equals(this.target2.getComb())) {
					this.statut = Statut.Gagné;
				} else
					this.statut = Statut.FinTour;

				break;
			}
		}
		// }

	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	public JeuConfig getP() {
		return p;
	}

	public void setP(JeuConfig p) {
		this.p = p;
	}

	public int getEssai() {
		return essai;
	}

	public void setEssai(int essai) {
		this.essai = essai;
	}

	public Boolean getDev() {
		return dev;
	}

	public void setDev(Boolean dev) {
		this.dev = dev;
	}

	public Combinaison getTarget() {
		return target;
	}

	public void setTarget(Combinaison target) {
		this.target = target;
	}

	public Combinaison getTarget2() {
		return target2;
	}

	public void setTarget2(Combinaison target2) {
		this.target2 = target2;
	}

	public Combinaison getReponse() {
		return reponse;
	}

	public void setReponse(Combinaison reponse) {
		this.reponse = reponse;
	}

	public Combinaison getReponse2() {
		return reponse2;
	}

	public void setReponse2(Combinaison reponse2) {
		this.reponse2 = reponse2;
	}

	public Joueur getAttaquant() {
		return attaquant;
	}

	public void setAttaquant(Joueur attaquant) {
		this.attaquant = attaquant;
	}

	public Joueur getAttaquant2() {
		return attaquant2;
	}

	public void setAttaquant2(Joueur attaquant2) {
		this.attaquant2 = attaquant2;
	}

	public Joueur getDefenseur() {
		return defenseur;
	}

	public void setDefenseur(Joueur defenseur) {
		this.defenseur = defenseur;
	}

	public Joueur getDefenseur2() {
		return defenseur2;
	}

	public void setDefenseur2(Joueur defenseur2) {
		this.defenseur2 = defenseur2;
	}

	public IHM getI() {
		return i;
	}

	public void setI(IHM i) {
		this.i = i;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public ArrayList getResultat() {
		return resultat;
	}

	public void setResultat(ArrayList resultat) {
		this.resultat = resultat;
	}

	public String getVerif() {
		return verif;
	}

	public void setVerif(String verif) {
		this.verif = verif;
	}
	
	
}

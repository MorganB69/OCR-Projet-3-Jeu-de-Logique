package IHM;

import Config.JeuConfig;

/**
 * Classe g�rant les input de l'utilisateur
 * 
 * @author Morgan
 *
 */
public class InputControl {
	/**
	 * Param�tre du jeu
	 */
	JeuConfig p;

	/**
	 * Constructeur par d�faut
	 */
	public InputControl(JeuConfig p) {
		this.p = p;
	}

	/**
	 * V�rifie la saisie du choix du jeu
	 * 
	 * @param s
	 *            Saisie du choix de l'utilisateur
	 * @return True si la saisie est correcte
	 */
	public Boolean VerifJeu(String s) {
		int a = Character.getNumericValue(s.charAt(0));
		if (a == 1 || a == 2) {
			return true;
		}

		else
			return false;
	}

	/**
	 * V�rifie la saisie du choix du mode
	 * 
	 * @param s
	 *            Saisie du choix de l'utilisateur
	 * @return True si la saisie est correcte
	 */
	public Boolean VerifMode(String s) {
		int a = Character.getNumericValue(s.charAt(0));
		if (a == 1 || a == 2 || a == 3) {
			return true;
		}

		else
			return false;
	}

	/**
	 * V�rifie la saisie d'une combinaison de Recherche
	 * 
	 * @param s
	 *            Saisie du choix de l'utilisateur
	 * @return True si la saisie est correcte
	 */
	public Boolean VerifCombR(String s) {
		for (int i = 0; i < s.length(); i++) {
			int a = Character.getNumericValue(s.charAt(i));
			if (a < 0 || a > 9) {
				System.out.println("Chiffres non compris entre 0 et 9 ou caract�re invalide");
				return false;
			}

		}

		if (s.length() != p.getNbCase()) {
			System.out.println("Pas le bon nombre de case");
			return false;
		}

		else
			return true;
	}

	/**
	 * V�rifie la saisie d'une combinaison de Mastermind
	 * 
	 * @param s
	 *            Saisie du choix de l'utilisateur
	 * @return True si la saisie est correcte
	 */
	public Boolean VerifCombM(String s) {
		for (int i = 0; i < s.length(); i++) {
			int a = Character.getNumericValue(s.charAt(i));
			if (a < 0 || a >= p.getChiffre()) {
				System.out.println("Chiffres non compris entre 0 et " + (p.getChiffre() - 1) + " ou caract�re invalide");
				return false;
			}

		}

		if (s.length() != p.getNbCase()) {
			System.out.println("Pas le bon nombre de case");
			return false;
		}

		else
			return true;
	}
}

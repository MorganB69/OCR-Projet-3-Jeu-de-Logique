package Jeu;

/**
 * Enum�ration des diff�rents �tats de la partie en cours
 * @author Morgan
 *
 */
public enum Statut {
	/**
	 * La partie commence
	 */
	Start,
	/**
	 * Premier tour
	 */
	Tour1,
	/**
	 * Partie en cours
	 */
	EnCours,
	/**
	 * Fin du tour
	 */
	FinTour,
	/**
	 * La partie est perdue et se termine
	 */
	Perdu,
	/**
	 * La partie est gagn�e et se termine
	 */
	Gagn�,
	/**
	 * La partie est finie
	 */
	Fin,
	/**
	 * Premier tour joueur 2 (mode duel)
	 */
	Tour1J2,
	/**
	 * Partie en cours joueur 2 (mode duel)
	 */
	EnCoursJ2;
}

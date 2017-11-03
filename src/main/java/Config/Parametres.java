package Config;

import java.io.Serializable;

/**
 * Classe de param�tre utilis�e pour �tre stock�e dans un fichier
 * 
 * @author Morgan
 *
 */
public class Parametres implements Serializable {
	/**
	 * Nombre d'essai
	 */
	public int essai;
	/**
	 * Nombre de case
	 */
	public int nbCase;
	/**
	 * Nombre de chiffre
	 */
	public int chiffre;
	/**
	 * Mode d�veloppeur
	 */
	public Boolean dev;

	public Parametres(int essai, int nbCase, int chiffre, Boolean dev) {
		this.essai = essai;
		this.nbCase = nbCase;
		this.chiffre = chiffre;
		this.dev = dev;
	}
}

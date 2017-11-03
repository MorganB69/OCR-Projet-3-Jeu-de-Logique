package Joueur;

/**
 * Classe abstraite de joueur
 * @author Morgan
 *
 */
public abstract class Joueur {
	/**
	 * Nom du joueur
	 */
	String nom;

	/**
	 * Constructeur d'un joueur
	 */
	public Joueur() {
		nom="Joueur";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}

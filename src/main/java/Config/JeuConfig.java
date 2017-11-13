package Config;

import java.util.ArrayList;

/**
 * Classe utilisée par le jeu pour obtenir les paramètres de jeu
 * 
 * @author Morgan
 *
 */
public class JeuConfig {
	/**
	 * Nombre d'essai
	 */
	public int essai;
	/**
	 * Nombre de cases
	 */
	public int nbCase;
	/**
	 * Nombre de chiffres
	 */
	public int chiffre;
	/**
	 * Mode développeur
	 */
	public Boolean dev;

	/**
	 * Constructeur par défaut allant récupérer les paramètres dans
	 * config.properties Instancie la Classe Serial pour la récupération des données
	 * dans un fichier
	 */
	public JeuConfig() {

		Serial s = new Serial("src/main/resources", "/config.properties");

		ArrayList<Parametres> list = new ArrayList<Parametres>();
		list.add(new Parametres(12, 5, 5, false));
		s.Ecriture(list);

		ArrayList<Parametres> listrecup = new ArrayList<Parametres>();
		listrecup = s.LectureTest();
		this.essai = listrecup.get(0).essai;
		this.nbCase = listrecup.get(0).nbCase;
		this.chiffre = listrecup.get(0).chiffre;
		this.dev = listrecup.get(0).dev;
	}

}

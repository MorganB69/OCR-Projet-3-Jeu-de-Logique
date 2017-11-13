package Config;

import java.util.ArrayList;

/**
 * Classe utilis�e par le jeu pour obtenir les param�tres de jeu
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
	 * Mode d�veloppeur
	 */
	public Boolean dev;

	/**
	 * Constructeur par d�faut allant r�cup�rer les param�tres dans
	 * config.properties Instancie la Classe Serial pour la r�cup�ration des donn�es
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

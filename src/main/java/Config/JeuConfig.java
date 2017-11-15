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
	protected int essai;
	/**
	 * Nombre de cases
	 */
	protected int nbCase;
	/**
	 * Nombre de chiffres
	 */
	protected int chiffre;
	/**
	 * Mode développeur
	 */
	protected Boolean dev;

	/**
	 * Constructeur par défaut allant récupérer les paramètres dans
	 * config.properties Instancie la Classe Serial pour la récupération des données
	 * dans un fichier
	 */
	public JeuConfig() {

		Serial s = new Serial("src/main/resources", "/config.properties");

		//ArrayList<Parametres> list = new ArrayList<Parametres>();
		//list.add(new Parametres(12, 5, 5, false));
		//s.Ecriture(list);
		
		ArrayList<Integer> listrecup = new ArrayList<Integer>();
		listrecup=s.LectureTest();

		this.essai=listrecup.get(2);
		this.nbCase=listrecup.get(3);
		this.chiffre=listrecup.get(4);
		if(listrecup.get(5)==1)
			this.dev=true;
		else this.dev=false;
		
		
		/*
		ArrayList<Parametres> listrecup = new ArrayList<Parametres>();
		listrecup = s.LectureTest();
		this.essai = listrecup.get(0).essai;
		this.nbCase = listrecup.get(0).nbCase;
		this.chiffre = listrecup.get(0).chiffre;
		this.dev = listrecup.get(0).dev;*/
	}

	public int getEssai() {
		return essai;
	}

	public void setEssai(int essai) {
		this.essai = essai;
	}

	public int getNbCase() {
		return nbCase;
	}

	public void setNbCase(int nbCase) {
		this.nbCase = nbCase;
	}

	public int getChiffre() {
		return chiffre;
	}

	public void setChiffre(int chiffre) {
		this.chiffre = chiffre;
	}

	public Boolean getDev() {
		return dev;
	}

	public void setDev(Boolean dev) {
		this.dev = dev;
	}

}

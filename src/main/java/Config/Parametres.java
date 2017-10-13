package Config;

import java.io.Serializable;

public class Parametres implements Serializable{
	public int essai;
	public int nbCase;
	public int chiffre;
	public  Boolean dev;
	
	public Parametres(int essai,int nbCase,int chiffre, Boolean dev) {
		this.essai=essai;
		this.nbCase=nbCase;
		this.chiffre=chiffre;
		this.dev=dev;
	}
}

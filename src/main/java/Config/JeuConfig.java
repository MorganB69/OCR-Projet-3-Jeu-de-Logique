package Config;

import java.util.ArrayList;

public class JeuConfig {
	public int essai;
	public int nbCase;
	public int chiffre;
	public  Boolean dev;
	
		public JeuConfig(){
		
		
		Serial s = new Serial("resources","config.properties");
		
		
		//ArrayList<Parametres> list= new ArrayList<Parametres>();
		//list.add(new Parametres(5,3,4,false));
		//s.Ecriture(list);

		
		
		ArrayList<Parametres> listrecup = new ArrayList<Parametres>();
		listrecup=s.Lecture();
		this.essai=listrecup.get(0).essai;
		this.nbCase=listrecup.get(0).nbCase;
		this.chiffre=listrecup.get(0).chiffre;
		this.dev=listrecup.get(0).dev;
		}
		

}

package Config;

import java.util.ArrayList;

public class JeuConfig {
	public int essai;
	public int nbCase;
	public int chiffre;
	public Boolean dev;
	
		public JeuConfig(){
		
		
		Serial s = new Serial("src/main/resources","/config.properties");
		
		
		ArrayList<Parametres> list= new ArrayList<Parametres>();
		list.add(new Parametres(12,5,5,true));
		s.Ecriture(list);
		

		
		
		ArrayList<Parametres> listrecup = new ArrayList<Parametres>();
		listrecup=s.LectureTest();
		this.essai=listrecup.get(0).essai;
		this.nbCase=listrecup.get(0).nbCase;
		this.chiffre=listrecup.get(0).chiffre;
		this.dev=listrecup.get(0).dev;
		}
		

}

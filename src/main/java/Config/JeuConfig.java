package Config;

import java.util.ArrayList;

public class JeuConfig {
	public int essai;
	public int nbCase;
	public int chiffre;
	
		public JeuConfig(){
	
		
		Serial s = new Serial("resources","config.properties");
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		//ArrayList<Integer> listserial= new ArrayList<Integer>();
		//int essai=5;
		//int nbCase=3;
		//int chiffre=4;
		//listserial.add(0,essai);
		//listserial.add(1,nbCase);
		//listserial.add(2,chiffre);
		
		//s.Ecriture(listserial);
		
		
		list=s.Recuperation();
		this.essai=list.get(0);
		this.nbCase=list.get(1);
		this.chiffre=list.get(2);
		
		}
		

}

package IHM;

import Config.JeuConfig;

public class InputControl {
	JeuConfig p;
	public InputControl() {
		this.p=new JeuConfig();
	}
	
	public Boolean VerifJeu(String s) {
		int a=Character.getNumericValue(s.charAt(0));
		if (a==1||a==2) {
			return true;
		}
		
		else return false;
	}
	
	public Boolean VerifMode(String s) {
		int a=Character.getNumericValue(s.charAt(0));
		if (a==1||a==2||a==3) {
			return true;
		}
		
		else return false;
	}
	
	public Boolean VerifCombR(String s) {
		for (int i = 0; i < s.length(); i++) {
			int a = Character.getNumericValue(s.charAt(i));
			if (a<0||a>9) {
			System.out.println("Chiffres non compris entre 0 et 9 ou caract�re invalide");
			return false;
			}	
			
		}
		
		if (s.length()!=p.nbCase) {
			System.out.println("Pas le bon nombre de case");
			return false;
		}
		
		else return true;
	}
	
	public Boolean VerifCombM(String s) {
		for (int i = 0; i < s.length(); i++) {
			int a = Character.getNumericValue(s.charAt(i));
			if (a<0||a>=p.chiffre) {System.out.println("Chiffres non compris entre 0 et "+(p.chiffre-1)+" ou caract�re invalide");
			return false;}	
			
		}
		
		if (s.length()!=p.nbCase) {
			System.out.println("Pas le bon nombre de case");
			return false;
		}
		
		else return true;
	}
}

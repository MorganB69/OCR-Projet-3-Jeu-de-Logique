package Combinaison;

import java.util.ArrayList;

import Combinaison.ReSet.ReSetOrdi;
import Combinaison.ReSet.ReSetUser;
import IHM.IHM;
import Joueur.Joueur;

public class CombinaisonM extends Combinaison {

	ReSetUser reset;
	ReSetOrdi reset2;
	public int chiffre;
	
	public CombinaisonM() {
		super();
		this.reset = new ReSetUser();
		this.reset2 = new ReSetOrdi();
		
		
		for (int i = 0; i < nbCase; i++) {
			comb.set(i, (int) (Math.random() * (this.chiffre - 0) + 0));
		}
	}

	public void ReSet(Joueur j,ArrayList l, IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetCombM(this,i);
		} else
			reset2.SetCombM(this,l,i);
	}
	
	public void ReSet(Joueur j,IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetCombM(this,i);
		} else
			reset2.SetCombM(this,i);
	}

	public String toString() {
		return super.toString();
	}
	
}

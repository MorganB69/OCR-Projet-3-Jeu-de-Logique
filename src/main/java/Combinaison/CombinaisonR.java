package Combinaison;

import java.util.ArrayList;

import Combinaison.ReSet.ReSetOrdi;
import Combinaison.ReSet.ReSetUser;
import IHM.IHM;
import Joueur.Joueur;

public class CombinaisonR extends Combinaison {

	ReSetUser reset;
	ReSetOrdi reset2;
	int[]max;
	int[]min;

	public CombinaisonR() {
		super();
		this.reset = new ReSetUser();
		this.reset2 = new ReSetOrdi();
		

	}

/*
	public void ReSet(Joueur j) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this);
		} else
			reset2.SetComb(this);
	}*/
	
	public void ReSet(Joueur j,ArrayList<String> l, IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this,i);
		} else
			reset2.SetComb(this,l,i);
	}
	
	public void ReSet(Joueur j,IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this,i);
		} else
			reset2.SetComb(this,i);
	}

	public String toString() {
		return super.toString();
	}
	
	
}

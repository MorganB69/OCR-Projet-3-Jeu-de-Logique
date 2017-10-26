package Combinaison;

import java.util.ArrayList;

import Combinaison.ReSet.ReSetOrdiM;
import Combinaison.ReSet.ReSetUser;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;
import Joueur.Joueur;

public class CombinaisonM extends Combinaison {

	ReSetUser reset;
	ReSetOrdiM reset2;
	
	ArrayList<Combinaison>liste = new ArrayList<Combinaison>();
	
	public CombinaisonM() {
		super();
		
		this.reset = new ReSetUser();
		this.reset2 = new ReSetOrdiM(this.chiffre,this.nbCase);
		
		
		for (int i = 0; i < nbCase; i++) {
			comb.set(i, (int) (Math.random() * (this.chiffre - 0) + 0));
		}
		
		
		
	}

	public void ReSet(Joueur j,ArrayList l, IHM i) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetCombM(this,i);
		} else
			reset2.SetComb(this,l,i);
	}
	
	
	
	public void ReSet(Joueur j,IHM i, Mode m, Statut statut) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetCombM(this,i);
		} else
			reset2.SetComb(this,i,m,statut);
	}

	public String toString() {
		return super.toString();
	}
	
}

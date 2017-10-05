package Combinaison;

import Combinaison.ReSet.ReSetOrdi;
import Combinaison.ReSet.ReSetUser;
import Joueur.Joueur;

public class CombinaisonR extends Combinaison {

	ReSetUser reset;
	ReSetOrdi reset2;

	public CombinaisonR() {
		super();
		this.reset = new ReSetUser();
		this.reset2 = new ReSetOrdi();

	}

	public void ReSet(Joueur j) {
		if (j.getClass().getName() == "Joueur.User") {
			reset.SetComb(this);
		} else
			reset2.SetComb(this);
	}

	public String toString() {
		return super.toString();
	}
	
	
}

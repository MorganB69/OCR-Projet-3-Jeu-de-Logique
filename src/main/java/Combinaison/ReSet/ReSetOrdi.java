package Combinaison.ReSet;

import Combinaison.Combinaison;

public class ReSetOrdi implements ReSet {

	public void SetComb(Combinaison c) {
		for (int i = 0; i < c.getNbCase(); i++) {
			c.getComb().set(i, (int) (Math.random() * (9 - 0) + 0));
		}
	}

}

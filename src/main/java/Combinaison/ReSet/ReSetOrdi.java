package Combinaison.ReSet;

import java.util.ArrayList;

import Combinaison.Combinaison;
import IHM.IHM;

public class ReSetOrdi implements ReSet {
	
	public void SetComb(Combinaison c,IHM k) {
		//Par défaut, donne une combinaison aléatoire
		for (int i = 0; i < c.getNbCase(); i++) {
			c.getComb().set(i, (int) (Math.random() * (9 - 0 + 1) + 0));
		}
	}
	
	
	
	public void SetComb(Combinaison c,ArrayList<String> j, IHM k) {
		
		//En fonction du résultat précédent, adapte la combinaison en fixant un nouveau max et min.
		for (int i = 0; i < c.getNbCase(); i++) {
			
			
			if (j.get(i)=="=") {
				c.getComb().set(i,c.getComb().get(i));
			}
			else if (j.get(i)=="-") {
				c.max[i]=c.getComb().get(i)-1;
				c.getComb().set(i, (int) (Math.random() * (c.max[i] - c.min[i] + 1 ) + c.min[i]));

			}
			else {
				c.min[i]=c.getComb().get(i)+1;
				c.getComb().set(i, (int) (Math.random() * (c.max[i] - c.min[i] + 1) + c.min[i]));

			}
			
		}
	}

}



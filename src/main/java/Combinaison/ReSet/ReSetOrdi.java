package Combinaison.ReSet;

import java.util.ArrayList;

import Combinaison.Combinaison;

public class ReSetOrdi implements ReSet {
	

	

	
	public void SetComb(Combinaison c) {
		for (int i = 0; i < c.getNbCase(); i++) {
			c.getComb().set(i, (int) (Math.random() * (9 - 0 + 1) + 0));
		}
	}
	
	public void SetComb(Combinaison c,ArrayList<String> j) {
		for (int i = 0; i < c.getNbCase(); i++) {
			
			int[] max = new int[c.getNbCase()];
			int[] min = new int[c.getNbCase()];
			for (int k = 0; k < c.getNbCase(); k++) {
				max[k]=9;
				min[k]=0;
			}
			
		
			
			if (j.get(i)=="=") {
				c.getComb().set(i,c.getComb().get(i));
			}
			else if (j.get(i)=="+") {
				max[i]=c.getComb().get(i);
				c.getComb().set(i, (int) (Math.random() * (max[i] - min[i] + 1 ) + min[i]));
				for (int k = 0; k < c.getNbCase(); k++) {
					max[k]=c.getComb().get(i);
					
				}
			}
			else {
				min[i]=c.getComb().get(i);
				c.getComb().set(i, (int) (Math.random() * (max[i] - min[i] + 1) + min[i]));
				for (int k = 0; k < c.getNbCase(); k++) {
					
					min[k]=c.getComb().get(i);
				}
			}
			
		}
	}

}



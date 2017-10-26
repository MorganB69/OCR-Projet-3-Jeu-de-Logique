package Combinaison.ReSet;

import java.util.Scanner;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

public class ReSetUser implements ReSet {

	

	public void SetComb(Combinaison c, IHM i) {
		i.SaisirComb(c);
		}
	
	public void SetComb(Combinaison c, IHM i, Mode m, Statut statut) {
		i.SaisirComb(c);
		
		
		}
	
	public void SetCombM(Combinaison c, IHM i) {
		i.SaisirCombM(c);
		
		
		}


	

}

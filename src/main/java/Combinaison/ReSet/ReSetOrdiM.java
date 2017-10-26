package Combinaison.ReSet;

import java.util.ArrayList;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;
import IAMaster.IAMaster;
import IHM.IHM;
import Jeu.Mode;
import Jeu.Statut;

public class ReSetOrdiM implements ReSet {
	
	
	
	IAMaster IA;
	
	
	public ReSetOrdiM(int chiffre, int nbcase) {
		this.IA=new IAMaster(chiffre,nbcase);
	}
	
	public void SetComb(Combinaison c, IHM i,Mode m, Statut statut) {
		
		if(m==Mode.Challenger||m==Mode.Duel&&statut==Statut.Start) {
			for (int j = 0; j < c.getNbCase(); j++) {
				c.getComb().set(j, (int) (Math.random() * (c.chiffre - 0 + 1) + 0));
			}
		}
		else {
			this.IA.Combi();
			c.setComb(this.IA.cs);
		}
		
	}
	
	public void SetComb(Combinaison c,  ArrayList<Integer> l, IHM i) {
			
		this.IA.CalculNbc();
		
		this.IA.VerifCouleur(l.get(0), l.get(1));
		System.out.println("Verif couleur");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		
		this.IA.VerifConfirme(l.get(0), l.get(1));
		System.out.println("Verif Confirme");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		this.IA.VerifExiste(l.get(0), l.get(1));
		System.out.println("Verif existe");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		this.IA.VerifMalp(l.get(0), l.get(1));
		System.out.println("VerifMalp");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		this.IA.Suppr();
		System.out.println("Suppr");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		this.IA.HypReset();
		System.out.println("Reset");
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		System.out.println();
		
		for (int j = 0; j < this.IA.existe.size(); j++) {
			System.out.println(this.IA.existe.get(j));
		}
		
		this.IA.Combi();
		
		for (int j = 0; j < this.IA.position2.size(); j++) {
			System.out.println(this.IA.position2.get(j));
		}
		
		
		c.setComb(this.IA.cs);
		
	}
}

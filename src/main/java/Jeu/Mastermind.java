package Jeu;

import java.util.ArrayList;

import Combinaison.Combinaison;
import Combinaison.CombinaisonM;

import Joueur.Joueur;
import Joueur.Ordinateur;
import Joueur.User;

public class Mastermind extends Jeu {

	int bienPlace;
	int malPlace;
	
	public Mastermind(Mode mode) {
		super(mode);
		// TODO Auto-generated constructor stub
		
		this.nomJeu="MasterMind";
		for(int i=0;i<p.nbCase;i++) this.resultat.add(i,"");
		this.bienPlace=0;
		this.malPlace=0;
		
		switch (mode) {
		//Instanciation des joueurs et des combinaisons en fonction du mode choisi
		
		case Challenger:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			break;
			
		case Defenseur:
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			break;

		case Duel:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.attaquant2 = defenseur;
			this.defenseur2 = attaquant;
			this.target = new CombinaisonM();
			this.reponse = new CombinaisonM();
			this.target2 = new CombinaisonM();
			this.reponse2 = new CombinaisonM();
			
			break;
		}


	}

	public void Verification(Combinaison target, Combinaison reponse, Joueur j) {
		
		//Comparaison des deux combinaisons. Si le joueur est l'ordinateur on enregistre le résultat
		this.verif="";
		this.bienPlace=0;
		this.malPlace=0;
		ArrayList<Integer> control=new ArrayList<Integer>();
		for (int i = 0; i < target.getNbCase(); i++) {
			
			if (target.getComb().get(i) == reponse.getComb().get(i)) {
				this.bienPlace++;
				control.add(reponse.getComb().get(i));
			} else {
				for (int k = 0; k < target.getNbCase(); k++) {
					if (target.getComb().get(k) == reponse.getComb().get(i) && 
						target.getComb().get(i) != reponse.getComb().get(i)&&
						target.getComb().get(k) != reponse.getComb().get(k)&&
						control.contains(reponse.getComb().get(i))==false)
					{
						this.malPlace++;
						control.add(reponse.getComb().get(i));
						break;
					}
				}
				
			}
		}
		this.verif=this.bienPlace+ " à la bonne place + " +this.malPlace + " à une autre place";
		
		System.out.println();

	}

	public void DemarrerJeu() {
		super.DemarrerJeu();

		}
	

}

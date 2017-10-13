package Jeu;



import Combinaison.Combinaison;
import Combinaison.CombinaisonR;
import Joueur.Joueur;
import Joueur.Ordinateur;
import Joueur.User;

public class Recherche extends Jeu {


	public Recherche(Mode mode) {
		super(mode);
		this.nomJeu="Recherche";
		for(int i=0;i<p.nbCase;i++) this.resultat.add(i,"");
		
		
		switch (mode) {
		//Instanciation des joueurs et des combinaisons en fonction du mode choisi
		
		case Challenger:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.target = new CombinaisonR();
			this.reponse = new CombinaisonR();
			break;
			
		case Defenseur:
			this.defenseur = new User();
			this.attaquant = new Ordinateur();
			this.target = new CombinaisonR();
			this.reponse = new CombinaisonR();
			break;

		case Duel:
			this.attaquant = new User();
			this.defenseur = new Ordinateur();
			this.attaquant2 = defenseur;
			this.defenseur2 = attaquant;
			this.target = new CombinaisonR();
			this.reponse = new CombinaisonR();
			this.target2 = new CombinaisonR();
			this.reponse2 = new CombinaisonR();
			
			break;
		}


	}

	public void Verification(Combinaison target, Combinaison reponse, Joueur j) {
		
		//Comparaison des deux combinaisons. Si le joueur est l'ordinateur on enregistre le résultat
		this.verif="";
		for (int i = 0; i < target.getNbCase(); i++) {
			
			if (target.getComb().get(i) == reponse.getComb().get(i)) {
				this.verif= this.verif +"=";
				if(j.getNom()=="Ordinateur")
				this.resultat.set(i,"=");
			} else {
				if (target.getComb().get(i) < reponse.getComb().get(i)) {
					this.verif= this.verif +"-";
					if(j.getNom()=="Ordinateur")
					this.resultat.set(i, "-");
				} else {
					this.verif= this.verif +"+";
					if(j.getNom()=="Ordinateur")
					this.resultat.set(i, "+");
				}
			}
		}
		System.out.println();

	}

	public void DemarrerJeu() {
		super.DemarrerJeu();

		}

}

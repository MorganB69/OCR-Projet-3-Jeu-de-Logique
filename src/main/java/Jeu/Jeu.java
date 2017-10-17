package Jeu;

import java.util.ArrayList;
import java.util.Observable;

import Combinaison.Combinaison;
import Config.JeuConfig;
import IHM.IHM;
import Joueur.Joueur;

public abstract class Jeu extends Observable {
	String nomJeu;
	JeuConfig p;
	public int essai;
	public Boolean dev;
	public Combinaison target;
	public Combinaison target2;
	public Combinaison reponse;
	public Combinaison reponse2;
	public Joueur attaquant;
	public Joueur attaquant2;
	public Joueur defenseur;
	public Joueur defenseur2;
	public IHM i;
	
	
	public Statut statut;
	public Mode mode;
	public ArrayList resultat;
	
	public String verif;
	//ArrayList<String> resultat2 = new ArrayList<String>();

	public Jeu(Mode mode) {

		nomJeu = "defaut";
		this.p= new JeuConfig();
		this.mode = mode;
		this.essai = p.essai;// A FIXER DANS LE FICHIER DE PARAMETRE
		this.dev=p.dev;
		this.statut = Statut.Start;
		// A CHANGER VIA UNE ENUMERATION
		this.resultat = new ArrayList<>();
		this.i= new IHM();
		i.AfficherAccueil();
		this.addObserver(i);
		
	}

	public void Verification(Combinaison target, Combinaison reponse, Joueur attaquant) {

	}
	
	public void notifierObservateur() {
		setChanged();
		notifyObservers();
	}

	public void DemarrerJeu() {
		
			
			
		
			if (this.mode==Mode.Challenger||this.mode==Mode.Defenseur) {
				
			//MODE CHALLENGER OU DEFENSEUR
			switch (this.statut) {
			case Start:
				//Lancement de la partie
				//Le défenseur choisit la combinaison secrète
				this.target.ReSet(this.defenseur,this.i);
				
				notifierObservateur();
				this.statut = Statut.Tour1;
				break;
				

			case Tour1:
				
				//Premier tour, l'attaquant donne une combinaison
				this.reponse.ReSet(attaquant,this.i);
				
				//Cette combinaison est vérifiée

				this.Verification(this.target, this.reponse, this.attaquant);

				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb())) this.statut = Statut.Gagné;
				//Si la combinaison est bonne, la partie est gagnée sinon fin du tour
				
						
				else this.statut = Statut.FinTour;
				break;
						
					
				
			case EnCours:
				//Autres tours
				//L'attaquant change sa combinaison, en prenant en paramètre le résultat précédent
				//pour adapter sa future combinaison (Utile pour l'ordinateur)
				
				this.reponse.ReSet(this.attaquant, this.resultat, this.i);

				this.Verification(this.target, this.reponse, this.attaquant);

				
				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = Statut.Gagné;
					
				}
				else 
					this.statut = Statut.FinTour;
				break;
						
					
				
			case FinTour:
				//Fin du tour, on décrémente essai. Si on arrive à 0, la partie est perdue sinon autre tour
				this.essai--;
				notifierObservateur();

				if(this.essai == 0) this.statut = Statut.Perdu;
				else
				 this.statut=Statut.EnCours;
				break;
				
			case Perdu:
				//La partie est perdue. Fin de la partie.

				notifierObservateur();
				this.statut=Statut.Fin;
				
				break;
				
			case Gagné:
				//La partie est gagnée. Fin de la partie.

				notifierObservateur();
				this.statut=Statut.Fin;
				
				break;
				
			}
			}
			
			else {
				//MODE DUEL
				switch (this.statut) {
				
				case Start:
					//Lancement de la partie, les deux joueurs donnent une combinaison secrète
					this.target.ReSet(this.defenseur,this.i);
					this.target2.ReSet(this.defenseur2,this.i);
					notifierObservateur();
					this.statut = Statut.Tour1;
					break;
					

				case Tour1:
					//Premier tour
					//Au premier joueur de jouer.
					this.reponse.ReSet(attaquant,this.i);

					
					this.Verification(this.target, this.reponse,this.attaquant);

					notifierObservateur();


					if (this.reponse.getComb().equals(this.target.getComb())) this.statut = Statut.Gagné;
					
					
							
					else this.statut = Statut.Tour1J2;
					
					break;
					

							
						
					
				case EnCours:
					//Autres tours
					
					//Premier joueur de jouer
					this.reponse.ReSet(this.attaquant,this.i);

					this.Verification(this.target, this.reponse, this.attaquant);

					notifierObservateur();
					if (this.reponse.getComb().equals(this.target.getComb())) {
						this.statut = Statut.Gagné;
						
					}
					
							else this.statut=Statut.EnCoursJ2;
								
					break;
										
				case FinTour:
				//	Fin du tour, on décrémente essai
					this.essai--;

					notifierObservateur();
					if(this.essai == 0)
						this.statut = Statut.Perdu;
					else {
				
					this.statut=Statut.EnCours;}
					break;
					
				case Perdu:
				//	La partie est perdue

					notifierObservateur();
					this.statut=Statut.Fin;
					
					break;
					
				case Gagné:
				//	La partie est gagnée.

					notifierObservateur();
					this.statut=Statut.Fin;
					
					break;
					
				case Tour1J2:	
					//Au deuxième joueur de jouer
					this.reponse2.ReSet(attaquant2,this.i);

					this.Verification(this.target2, this.reponse2, this.attaquant2);

					notifierObservateur();
					if (this.reponse2.getComb().equals(this.target2.getComb())) this.statut = Statut.Gagné;
					
					else
					
					this.statut = Statut.FinTour;
				
				break;
				
				case EnCoursJ2:
					//Deuxième joueur de jouer.
					this.reponse2.ReSet(this.attaquant2, this.resultat,this.i);

					
					this.Verification(this.target2, this.reponse2, this.attaquant2);

					notifierObservateur();
					if (this.reponse2.getComb().equals(this.target2.getComb())) {
						this.statut = Statut.Gagné;	
					}
					else this.statut = Statut.FinTour;
					
				break;	
				}
			}
	//}

}
}

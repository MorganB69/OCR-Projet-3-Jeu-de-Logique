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
	
	
	public int statut;
	public Mode mode;
	public ArrayList<String> resultat;
	public String verif;
	//ArrayList<String> resultat2 = new ArrayList<String>();

	public Jeu(Mode mode) {

		nomJeu = "defaut";
		this.p= new JeuConfig();
		this.mode = mode;
		this.essai = p.essai;// A FIXER DANS LE FICHIER DE PARAMETRE
		this.dev=p.dev;
		this.statut = 0;// A CHANGER VIA UNE ENUMERATION
		this.resultat = new ArrayList<String>();
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
			case 0:
				//Lancement de la partie
				//Le d�fenseur choisit la combinaison secr�te
				this.target.ReSet(this.defenseur,this.i);
				
				notifierObservateur();
				this.statut = 1;
				break;
				

			case 1:
				
				//Premier tour, l'attaquant donne une combinaison
				this.reponse.ReSet(attaquant,this.i);
				
				//Cette combinaison est v�rifi�e

				this.Verification(this.target, this.reponse, this.attaquant);

				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
				//Si la combinaison est bonne, la partie est gagn�e sinon fin du tour
				
						
				else this.statut = 3;
				break;
						
					
				
			case 2:
				//Autres tours
				//L'attaquant change sa combinaison, en prenant en param�tre le r�sultat pr�c�dent
				//pour adapter sa future combinaison (Utile pour l'ordinateur)
				
				this.reponse.ReSet(this.attaquant, this.resultat, this.i);

				this.Verification(this.target, this.reponse, this.attaquant);

				
				notifierObservateur();

				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = 5;
					
				}
				else 
					this.statut = 3;
				break;
						
					
				
			case 3:
				//Fin du tour, on d�cr�mente essai. Si on arrive � 0, la partie est perdue sinon autre tour
				this.essai--;
				notifierObservateur();

				if(this.essai == 0) this.statut = 4;
				else
				 this.statut=2;
				break;
				
			case 4:
				//La partie est perdue. Fin de la partie.

				notifierObservateur();
				this.statut=6;
				
				break;
				
			case 5:
				//La partie est gagn�e. Fin de la partie.

				notifierObservateur();
				this.statut=6;
				
				break;
				
			}
			}
			
			else {
				//MODE DUEL
				switch (this.statut) {
				
				case 0:
					//Lancement de la partie, les deux joueurs donnent une combinaison secr�te
					this.target.ReSet(this.defenseur,this.i);
					this.target2.ReSet(this.defenseur2,this.i);
					notifierObservateur();
					this.statut = 1;
					break;
					

				case 1:
					//Premier tour
					//Au premier joueur de jouer.
					this.reponse.ReSet(attaquant,this.i);

					
					this.Verification(this.target, this.reponse,this.attaquant);

					notifierObservateur();


					if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
					
					
							
					else this.statut = 7;
					
					break;
					

							
						
					
				case 2:
					//Autres tours
					
					//Premier joueur de jouer
					this.reponse.ReSet(this.attaquant,this.i);

					this.Verification(this.target, this.reponse, this.attaquant);

					notifierObservateur();
					if (this.reponse.getComb().equals(this.target.getComb())) {
						this.statut = 5;
						
					}
					
							else this.statut=8;
								
					break;
										
				case 3:
				//	Fin du tour, on d�cr�mente essai
					this.essai--;

					notifierObservateur();
					if(this.essai == 0)
						this.statut = 4;
					else {
				
					this.statut=2;}
					break;
					
				case 4:
				//	La partie est perdue

					notifierObservateur();
					this.statut=6;
					
					break;
					
				case 5:
				//	La partie est gagn�e.

					notifierObservateur();
					this.statut=6;
					
					break;
					
				case 7:	
					//Au deuxi�me joueur de jouer
					this.reponse2.ReSet(attaquant2,this.i);

					this.Verification(this.target2, this.reponse2, this.attaquant2);

					notifierObservateur();
					if (this.reponse2.getComb().equals(this.target2.getComb())) this.statut = 5;
					
					else
					
					this.statut = 3;
				
				break;
				
				case 8:
					//Deuxi�me joueur de jouer.
					this.reponse2.ReSet(this.attaquant2, this.resultat,this.i);

					
					this.Verification(this.target2, this.reponse2, this.attaquant2);

					notifierObservateur();
					if (this.reponse2.getComb().equals(this.target2.getComb())) {
						this.statut = 5;	
					}
					else this.statut = 3;
					
				break;	
				}
			}
	//}

}
}

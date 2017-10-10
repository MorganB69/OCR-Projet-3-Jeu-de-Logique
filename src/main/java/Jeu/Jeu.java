package Jeu;

import java.util.ArrayList;

import Combinaison.Combinaison;
import Config.JeuConfig;
import Joueur.Joueur;

public abstract class Jeu {
	String nomJeu;
	JeuConfig p;
	public int essai;
	public Combinaison target;
	public Combinaison target2;
	public Combinaison reponse;
	public Combinaison reponse2;
	public Joueur attaquant;
	public Joueur attaquant2;
	public Joueur defenseur;
	public Joueur defenseur2;
	
	
	public int statut;
	Mode mode;
	ArrayList<String> resultat;
	//ArrayList<String> resultat2 = new ArrayList<String>();

	public Jeu(Mode mode) {

		nomJeu = "defaut";
		this.p= new JeuConfig();
		this.mode = mode;
		this.essai = p.essai;// A FIXER DANS LE FICHIER DE PARAMETRE
		this.statut = 0;// A CHANGER VIA UNE ENUMERATION
		this.resultat = new ArrayList<String>();
		
	}

	public void Verification(Combinaison target, Combinaison reponse, Joueur attaquant) {

	}

	public void DemarrerJeu() {
		//while(this.statut!=6) {
			if (this.mode==Mode.Challenger||this.mode==Mode.Defenseur) {
				
			//MODE CHALLENGER OU DEFENSEUR
			switch (this.statut) {
			case 0:
				//Lancement de la partie
				//Le défenseur choisit la combinaison secrète
				this.target.ReSet(this.defenseur);

				this.statut = 1;
				break;
				

			case 1:
				
				//Premier tour, l'attaquant donne une combinaison
				this.reponse.ReSet(attaquant);
				//Cette combinaison est vérifiée
				System.out.println("réponse : " + this.reponse);
				System.out.println("vérification : ");
				this.Verification(this.target, this.reponse, this.attaquant);

				if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
				//Si la combinaison est bonne, la partie est gagnée sinon fin du tour
				
						
				else this.statut = 3;
				break;
						
					
				
			case 2:
				//Autres tours
				//L'attaquant change sa combinaison, en prenant en paramètre le résultat précédent
				//pour adapter sa future combinaison (Utile pour l'ordinateur)
				
				this.reponse.ReSet(this.attaquant, this.resultat);
				System.out.println("réponse : " + this.reponse);
				System.out.println("vérification : ");
				this.Verification(this.target, this.reponse, this.attaquant);
				

				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = 5;
					
				}
				else 
							this.statut = 3;
				break;
						
					
				
			case 3:
				//Fin du tour, on décrémente essai. Si on arrive à 0, la partie est perdue sinon autre tour
				this.essai--;
				if(this.essai == 0) this.statut = 4;
				else
				 this.statut=2;
				break;
				
			case 4:
				//La partie est perdue. Fin de la partie.
				this.statut=6;
				
				break;
				
			case 5:
				//La partie est gagnée. Fin de la partie.
				this.statut=6;
				
				break;
				
			}
			}
			
			else {
				//MODE DUEL
				switch (this.statut) {
				
				case 0:
					//Lancement de la partie, les deux joueurs donnent une combinaison secrète
					this.target.ReSet(this.defenseur);
					this.target2.ReSet(this.defenseur2);
					
					this.statut = 1;
					break;
					

				case 1:
					//Premier tour
					//Au premier joueur de jouer.
					this.reponse.ReSet(attaquant);
					System.out.println("réponse1 : " + this.reponse);
					System.out.println("vérification : ");
					
					this.Verification(this.target, this.reponse,this.attaquant);
					
					System.out.println();

					if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
					
					
							
					else {
						//Au deuxième joueur de jouer
						this.reponse2.ReSet(attaquant2);
						System.out.println("réponse2 : " + this.reponse2);
						System.out.println("vérification : ");
						this.Verification(this.target2, this.reponse2, this.attaquant2);
						
						System.out.println();

						if (this.reponse2.getComb().equals(this.target2.getComb())) this.statut = 5;
						
						else
						
						this.statut = 3;
					}
					break;
							
						
					
				case 2:
					//Autres tours
					
					//Premier joueur de jouer
					this.reponse.ReSet(this.attaquant);
					System.out.println("réponse1 : " + this.reponse);
					System.out.println("vérification : ");
					this.Verification(this.target, this.reponse, this.attaquant);

					if (this.reponse.getComb().equals(this.target.getComb())) {
						this.statut = 5;
						
					}
					
							else {
								//Deuxième joueur de jouer.
								this.reponse2.ReSet(this.attaquant2, this.resultat);
								System.out.println("réponse2 : " + this.reponse2);
								System.out.println("vérification : ");
								;
								this.Verification(this.target2, this.reponse2, this.attaquant2);
								

								if (this.reponse2.getComb().equals(this.target2.getComb())) {
									this.statut = 5;	
								}
								else this.statut = 3;

							}
								
					break;
										
				case 3:
				//	Fin du tour, on décrémente essai
					this.essai--;
					if(this.essai == 0)
						this.statut = 4;
					else {
				
					this.statut=2;}
					break;
					
				case 4:
				//	La partie est perdue
					this.statut=6;
					
					break;
					
				case 5:
				//	La partie est gagnée.
					this.statut=6;
					
					break;
				}
			}
	//}

}
}

package Jeu;

import java.util.ArrayList;

import Combinaison.Combinaison;
import Combinaison.CombinaisonR;
import Joueur.Ordinateur;
import Joueur.User;

public class Recherche extends Jeu {
	ArrayList<String> resultat = new ArrayList<String>();
	ArrayList<String> resultat2 = new ArrayList<String>();

	public Recherche(Mode mode) {
		super(mode);
		switch (mode) {
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

	public void Verification(Combinaison target, Combinaison reponse) {
		for (int i = 0; i < target.getNbCase(); i++) {

			if (target.getComb().get(i) == reponse.getComb().get(i)) {
				System.out.print("=");
				resultat.add(i, "=");
			} else {
				if (target.getComb().get(i) < reponse.getComb().get(i)) {
					System.out.print("-");
					resultat.add(i, "-");
				} else {
					System.out.print("+");
					resultat.add(i, "+");
				}
			}
		}

	}

	public void DemarrerJeu() {
		// Si on est au lancement du jeu, le défenseur définit la combinaison à
		// chercher.
		while(this.statut!=6) {
		if (this.mode==Mode.Challenger||this.mode==Mode.Defenseur) {
			
		
		switch (this.statut) {
		case 0:
			System.out.println("La partie commence!");
			this.target.ReSet(this.defenseur);
			System.out.println(target);
			this.statut = 1;
			break;
			

		case 1:
			System.out.println("Premier tour");
			System.out.println("la cible est : " + this.target);
			this.reponse.ReSet(attaquant);
			System.out.println("réponse : " + this.reponse);
			System.out.println("vérification : ");
			this.Verification(this.target, this.reponse);

			if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
			
			
					
			else this.statut = 3;
			break;
					
				
			
		case 2:
			System.out.println("La partie continue");
			
			this.reponse.ReSet(this.attaquant, this.resultat);
			System.out.println("réponse : " + this.reponse);
			System.out.println("vérification : ");
			this.Verification(this.target, this.reponse);
			

			if (this.reponse.getComb().equals(this.target.getComb())) {
				this.statut = 5;
				
			}
			else 
						this.statut = 3;
			break;
					
				
			
		case 3:
			System.out.println("Fin du tour");
			this.essai--;
			System.out.println("nombre d'essai restants :" + this.essai);
			if(this.essai == 0) this.statut = 4;
			else
			 this.statut=2;
			break;
			
		case 4:
			System.out.println("La partie est perdue...");
			this.statut=6;
			
			break;
			
		case 5:
			System.out.println("La partie est gagnée!");
			this.statut=6;
			
			break;
			
		}
		}
		
		else {
			switch (this.statut) {
			case 0:
				System.out.println("La partie commence!");
				this.target.ReSet(this.defenseur);
				System.out.println("La cible 1 est : " + target);


				this.target2.ReSet(this.defenseur2);
				System.out.println("La cible 2 est : "+ target2);
				this.statut = 1;
				break;
				

			case 1:
				System.out.println("Premier tour");
				this.reponse.ReSet(attaquant);
				System.out.println("réponse1 : " + this.reponse);
				System.out.println("vérification : ");
				this.Verification(this.target, this.reponse);
				System.out.println();


				if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
				
				
						
				else {
					this.reponse.ReSet(attaquant2);
					System.out.println("réponse2 : " + this.reponse2);
					System.out.println("vérification : ");
					this.Verification(this.target2, this.reponse2);
					resultat2=resultat;
					System.out.println();

					if (this.reponse2.getComb().equals(this.target2.getComb())) this.statut = 5;
					
					else
					
					
					this.statut = 3;
				}
				break;
						
					
				
			case 2:
				System.out.println("La partie continue");
				this.reponse.ReSet(this.attaquant, this.resultat);
				System.out.println("réponse1 : " + this.reponse);
				System.out.println("vérification : ");
				this.Verification(this.target, this.reponse);
				

				if (this.reponse.getComb().equals(this.target.getComb())) {
					this.statut = 5;
					
				}
				

						else {
							this.reponse2.ReSet(this.attaquant2, this.resultat2);
							System.out.println("réponse2 : " + this.reponse2);
							System.out.println("vérification : ");
							resultat2=resultat;
							this.Verification(this.target2, this.reponse2);
							

							if (this.reponse2.getComb().equals(this.target2.getComb())) {
								this.statut = 5;	
							}
							else this.statut = 3;

						}
							
				break;
						
					
				
			case 3:
				System.out.println("Fin du tour");
				this.essai--;
				if(this.essai == 0)
					this.statut = 4;
				else {
				System.out.println("nombre d'essai restants :" + this.essai);
				this.statut=2;}
				break;
				
			case 4:
				System.out.println("La partie est perdue...");
				this.statut=6;
				
				break;
				
			case 5:
				System.out.println("La partie est gagnée!");
				this.statut=6;
				
				break;
			}
		}
		}
/*
		if (this.statut == 0) {
			this.target.ReSet(this.defenseur);
			// this.reponse.ReSet(this.attaquant);
			// System.out.println(this.reponse);
			// Une fois défini, la partie est considéré comme "en-cours".
			this.statut = 2;

		} else {
			// Si la partie est cours, l'attaquant va donner une combinaison et elle sera
			// vérifiée
			while (this.essai > 0 && this.statut == 1) {

				System.out.println("la cible est" + this.target);// A afficher qu'en mode développeur
				this.reponse.ReSet(this.attaquant, this.resultat);
				this.Verification(this.target, this.reponse);
				if (this.reponse.getComb().equals(this.target.getComb()))
					break;
				else {
					this.essai--;
					System.out.println("nombre d'essai restants :" + this.essai);
					// this.reponse.ReSet(this.attaquant, this.resultat);
					System.out.println(this.reponse);

					this.statut = 2;// on est en fin de tour
				}
			}

			if (this.essai == 0 && this.statut == 1) {
				System.out.println("Perdu...");
				this.statut = 4;// Partie terminée
			} else if (this.statut != 2) {
				System.out.println("Gagné!");
				this.statut = 3;// Partie terminée
			}

		}
*/
	}
}

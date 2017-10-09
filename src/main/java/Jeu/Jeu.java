package Jeu;

import java.util.ArrayList;

import Combinaison.Combinaison;
import Config.JeuConfig;
import Joueur.Joueur;

public abstract class Jeu {
	String nomJeu;
	JeuConfig p;
	int essai;
	Combinaison target;
	Combinaison target2;
	Combinaison reponse;
	Combinaison reponse2;
	Joueur attaquant;
	Joueur attaquant2;
	Joueur defenseur;
	Joueur defenseur2;
	
	
	int statut;
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
				this.Verification(this.target, this.reponse, this.attaquant);

				if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
				
				
						
				else this.statut = 3;
				break;
						
					
				
			case 2:
				System.out.println("La partie continue");
				
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
					System.out.println(attaquant2.getNom());
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
					
					this.Verification(this.target, this.reponse,this.attaquant);
					
					
					
					for(int i=0;i<p.nbCase;i++) System.out.println(this.resultat.get(i));
					
					System.out.println();


					if (this.reponse.getComb().equals(this.target.getComb())) this.statut = 5;
					
					
							
					else {
						this.reponse2.ReSet(attaquant2);
						System.out.println("réponse2 : " + this.reponse2);
						System.out.println("vérification : ");
						this.Verification(this.target2, this.reponse2, this.attaquant2);
						
						for(int i=0;i<p.nbCase;i++) System.out.println(this.resultat.get(i));
						
						System.out.println();

						if (this.reponse2.getComb().equals(this.target2.getComb())) this.statut = 5;
						
						else
						
						
						this.statut = 3;
					}
					break;
							
						
					
				case 2:
					System.out.println("La partie continue");
					this.reponse.ReSet(this.attaquant);
					System.out.println("réponse1 : " + this.reponse);
					System.out.println("vérification : ");
					this.Verification(this.target, this.reponse, this.attaquant);
					
					for(int i=0;i<p.nbCase;i++) System.out.println(this.resultat.get(i));

					if (this.reponse.getComb().equals(this.target.getComb())) {
						this.statut = 5;
						
					}
					

							else {
								this.reponse2.ReSet(this.attaquant2, this.resultat);
								System.out.println("réponse2 : " + this.reponse2);
								System.out.println("vérification : ");
								;
								this.Verification(this.target2, this.reponse2, this.attaquant2);
								

								for(int i=0;i<p.nbCase;i++) System.out.println(this.resultat.get(i));
								
								
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

}
}

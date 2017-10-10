import Jeu.Jeu;

public class Interface {
	
	Jeu jeu;
	
	public Interface(Jeu jeu){
		
		
		

		
		
		
		switch (jeu.statut) {
		case 0:
			System.out.println("La partie commence");
			System.out.println("Le défenseur choisit la combinaison secrète");
			System.out.println();
			
			
			break;
		
		case 1:
			System.out.println();
			System.out.println("Premier Tour");
			System.out.println("La cible est "+jeu.target);
			System.out.println("nombre d'essai restants :" + jeu.essai);
			
			
			break;
			
		case 2 :
			System.out.println();
			System.out.println("La partie continue");
			System.out.println("nombre d'essai restants :" + jeu.essai);
			
			break;

		case 3:
			System.out.println("Fin du tour");
			
			
			break;
			
		case 4:
			System.out.println();
			System.out.println("La partie est perdue...");
			
			break;		
		
		case 5 :
			System.out.println();
			System.out.println("La partie est gagnée!");
			
			break;

		case 6:
			System.out.println();
			System.out.println("Fin de la partie");
			break;
			
			
		default:
			break;
		}
		}
		
	
}

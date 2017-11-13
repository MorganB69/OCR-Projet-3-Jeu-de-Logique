package IHM;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import Combinaison.Combinaison;
import Config.JeuConfig;
import Jeu.Jeu;

/**
 * Classe g�rant la vue du jeu et impl�mentant un observer sur le jeu
 * 
 * @author Morgan
 *
 */
public class IHM implements Observer {

	InputControl input;

	/**
	 * Constructeur par d�faut
	 */
	public IHM(JeuConfig p) {
		this.input = new InputControl(p);
	}

	/**
	 * Affichage de l'accueil
	 */
	public void AfficherAccueil() {
		System.out.println();
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println("|                         JEU DE LOGIQUE                                       |");
		System.out.println("|              Recherche de combinaison et MasterMind                          |");
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println();
	}

	/**
	 * Affichage du choix du jeu
	 * 
	 * @return retourne le jeu choisi
	 */
	public int ChoixJeu() {
		System.out.println();
		System.out.println(" Veuillez choisir le jeu : ");
		System.out.println("1 - Jeu Recherche de combinaison");
		System.out.println("2 - Jeu Mastermind");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		while (input.VerifJeu(essai) != true) {
			System.out.println("Erreur dans le choix, veuillez r�essayer");
			essai = sc.nextLine();
			input.VerifJeu(essai);
		}
		int a = Character.getNumericValue(essai.charAt(0));
		return a;
	}

	/**
	 * Affichage du choix du mode
	 * 
	 * @return Retourne le mode choisi
	 */
	public int ChoixMode() {
		System.out.println();
		System.out.println(" Veuillez choisir le mode de jeu : ");
		System.out.println("1 - Mode Challenger");
		System.out.println("2 - Mode Defenseur");
		System.out.println("3 - Mode Duel");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		while (input.VerifMode(essai) != true) {
			System.out.println("Erreur dans le choix, veuillez r�essayer");
			essai = sc.nextLine();
			input.VerifMode(essai);
		}
		int a = Character.getNumericValue(essai.charAt(0));
		return a;
	}

	/**
	 * Affichage des choix de fin de jeu
	 * 
	 * @return Retourne le choix de l'utilisateur
	 */
	public int ChoixFin() {
		System.out.println();
		System.out.println(" Voulez-vous : ");
		System.out.println("1 - Recommencer le m�me jeu avec le m�me mode?");
		System.out.println("2 - Choisir un autre jeu ou un autre mode?");
		System.out.println("3 - Arr�ter de jouer?");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		while (input.VerifMode(essai) != true) {
			System.out.println("Erreur dans le choix, veuillez r�essayer");
			essai = sc.nextLine();
			input.VerifMode(essai);
		}
		int a = Character.getNumericValue(essai.charAt(0));
		return a;
	}

	/**
	 * M�thode pour clear la console
	 */
	public void cls() {
		for (int i = 0; i < 650; i++)
			System.out.println();
	}

	/**
	 * M�thode pour clear la console
	 */
	public final static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (final Exception e) {
			System.out.println("Erreur");
		}
	}

	/**
	 * Affichage pour la saisie d'une combinaison pour Recherche
	 * 
	 * @param c
	 *            Combinaison � d�finir
	 */
	public void SaisirComb(Combinaison c) {

		System.out.println("Joueur, veuillez saisir une combinaison");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		while (input.VerifCombR(essai) != true) {
			System.out.println("Erreur dans la combinaison, veuillez r�essayer");
			essai = sc.nextLine();
			input.VerifCombR(essai);
		}
		for (int i = 0; i < c.getNbCase(); i++) {
			int a = Character.getNumericValue(essai.charAt(i));
			c.getComb().set(i, a);
		}
	}

	/**
	 * Affichage pour la saisie d'une combinaison pour Mastermind
	 * 
	 * @param c
	 *            Combinaison � d�finir
	 */
	public void SaisirCombM(Combinaison c) {

		System.out.println("Joueur, veuillez saisir une combinaison");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		while (input.VerifCombM(essai) != true) {
			System.out.println("Erreur dans la combinaison, veuillez r�essayer");
			essai = sc.nextLine();
			input.VerifCombM(essai);
		}
		for (int i = 0; i < c.getNbCase(); i++) {
			int a = Character.getNumericValue(essai.charAt(i));

			c.getComb().set(i, a);
		}
	}

	/*
	 * (non-Javadoc) Mise en place de l'observer et affiche diff�rents �l�ments en
	 * fonction du statut de la partie en cours
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object obj) {
		if (o instanceof Jeu)

		{

			Jeu r = (Jeu) o;
			System.out.println();

			switch (r.statut) {
			case Start:
				System.out.println("Bonjour, la partie commence");
				System.out.println("Le jeu est : " + r.nomJeu);
				System.out.println("Le mode est : " + r.mode.name());
				System.out.println("Vous avez " + r.essai + " essais");
				System.out.println("La combinaison est compos�e de " + r.target.getNbCase() + " chiffres.");
				if (r.dev == true) {
					System.out.println("La cible est : " + r.target);

					if (r.target2 != null)
						System.out.println("La deuxi�me cible est " + r.target2);
				} else
					System.out.print("");
				System.out.println();
				break;

			case Tour1:

				System.out.println("Votre r�ponse est : " + r.reponse);
				System.out.println("V�rification : " + r.verif);
				break;

			case EnCours:

				System.out.println("Votre r�ponse est : " + r.reponse);
				System.out.println("V�rification : " + r.verif);
				break;

			case FinTour:
				System.out.println("Fin du tour");
				System.out.println("Il vous reste " + r.essai + " essais.");
				System.out.println();
				break;

			case Perdu:
				System.out.println("La partie est perdue...");
				break;

			case Gagn�:
				System.out.println("La partie est gagn�e!");
				break;

			default:

				System.out.println(r.attaquant2.getNom() + " � vous de jouer");
				System.out.println("Votre r�ponse est : " + r.reponse2);
				System.out.println("V�rification : " + r.verif);

				break;
			}

		}
	}

}

/*
 * switch (jeu.statut) { case 0: System.out.println("La partie commence");
 * System.out.println("Le d�fenseur choisit la combinaison secr�te");
 * System.out.println();
 * 
 * 
 * break;
 * 
 * case 1: System.out.println(); System.out.println("Premier Tour");
 * System.out.println("La cible est "+jeu.target);
 * System.out.println("nombre d'essai restants :" + jeu.essai);
 * 
 * 
 * break;
 * 
 * case 2 : System.out.println(); System.out.println("La partie continue");
 * System.out.println("nombre d'essai restants :" + jeu.essai);
 * 
 * break;
 * 
 * case 3: System.out.println("Fin du tour");
 * 
 * 
 * break;
 * 
 * case 4: System.out.println(); System.out.println("La partie est perdue...");
 * 
 * break;
 * 
 * case 5 : System.out.println(); System.out.println("La partie est gagn�e!");
 * 
 * break;
 * 
 * case 6: System.out.println(); System.out.println("Fin de la partie"); break;
 * 
 * 
 * default: break; }
 */

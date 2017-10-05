package Combinaison.ReSet;

import java.util.Scanner;

import Combinaison.Combinaison;

public class ReSetUser implements ReSet {

	

	public void SetComb(Combinaison c) {

		System.out.println("Veuillez saisir une combinaison");
		Scanner sc = new Scanner(System.in);
		String essai = new String();
		essai = sc.nextLine();
		for (int i = 0; i < c.getNbCase(); i++) {
			int a = Character.getNumericValue(essai.charAt(i));
			if (a < 0 || a > 9)
				System.out.println("Erreur dans la combinaison");
			else
				c.getComb().set(i, a);
		}
	}

}

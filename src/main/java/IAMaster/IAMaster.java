package IAMaster;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe g�rant l'IA du Mastermind
 * 
 * @author Morgan
 *
 */
public class IAMaster {
	
	private static final Logger logger = LogManager.getLogger(IAMaster.class);
	/**
	 * ArrayList des diff�rentes couleurs/chiffres possibles
	 */
	protected ArrayList<Integer> couleur;

	/**
	 * ArrayList comprenant les couleurs/chiffres existants mais non confirm�s
	 */
	protected ArrayList<Integer> existe;
	/**
	 * ArrayList permettant de chercher la combinaison quand toutes les
	 * couleurs/chiffres sont d�couverts
	 */
	protected ArrayList<Integer> combFinal;
	/**
	 * ArrayList comprenant les couleurs/chiffres confirm�s
	 */
	protected ArrayList<Integer> confirme;
	/**
	 * Double ArrayList comprenant les chiffres possibles � chaque case
	 */
	@SuppressWarnings("rawtypes")
	protected ArrayList<ArrayList> position;
	/**
	 * Utilis� pour supprimer des �l�ments dans chaque ArrayList
	 */
	protected ArrayList<Integer> del;
	/**
	 * Couleur/chiffre test� par l'ordinateur
	 */
	protected int hyp;
	/**
	 * Combinaison utilis�e par l'IA
	 */
	protected ArrayList<Integer> combRecherche;
	/**
	 * Combinaison comprenant les valeurs d�j� confirm�es
	 */
	protected ArrayList<Integer> combConfirm;
	/**
	 * Nombre de chiffre dans la combinaison
	 */
	protected int chiffre;
	/**
	 * Nombre de case
	 */
	protected int nbcase;
	/**
	 * Nombre de couleurs/chiffres diff�rents dans la combinaison test�e
	 */
	protected int nbc = 0;
	/**
	 * Nombre de couleurs/chiffres existants plac�s dans la combinaison test�e
	 */
	protected int existep = 0;
	/**
	 * Nombre d'existants mal plac�s
	 */
	protected int emp = 0;
	/**
	 * Nombre de couleurs/chiffres confirm�s plac�s dans la combinaison test�e
	 */
	protected int confp = 0;

	/**
	 * Nombre de doublons plac�s dans la combinaison test�e
	 */
	protected int doublep = 0;

	/**
	 * Constructeur par d�faut
	 * 
	 * @param chiffre
	 *            Nombre de chiffre dans la combinaison
	 * @param nbcase
	 *            Nombre de case dans la combinaison
	 */
	@SuppressWarnings("rawtypes")
	public IAMaster(int chiffre, int nbcase) {

		this.couleur = new ArrayList<Integer>();
		this.existe = new ArrayList<Integer>();
		this.combFinal = new ArrayList<Integer>();
		this.confirme = new ArrayList<Integer>();
		this.position = new ArrayList<ArrayList>();
		this.del = new ArrayList<Integer>();
		this.hyp = (int) (Math.random() * (position.size() - 0) + 0);
		this.combRecherche = new ArrayList<Integer>();
		this.combConfirm = new ArrayList<Integer>();
		this.chiffre = chiffre;
		this.nbcase = nbcase;

		// Cr�ation des diff�rents chiffres/couleurs
		for (int i = 0; i < this.chiffre; i++)
			couleur.add(i);

		// Cr�ation de position en fonction du nombre de case et chiffre
		for (int i = 0; i < nbcase; i++) {
			ArrayList<Integer> couleur2 = new ArrayList<Integer>();
			for (int i1 = 0; i1 < chiffre; i1++) {

				couleur2.add(i1);

			}
			position.add(i, couleur2);
		}

		// Combinaison de recherche par d�faut avec une seule couleur
		for (int i = 0; i < nbcase; i++) {
			combRecherche.add(i, hyp);
		}

		// Combinaison des confirm�s par d�faut comprenant que des -1
		for (int i = 0; i < nbcase; i++) {
			combConfirm.add(i, -1);
		}

	}

	/**
	 * M�thode permettant de renvoyer le nombre de couleurs utilis�e dans la
	 * combinaison test�e
	 * 
	 * @return Nombre de couleurs test�es
	 */
	public int CalculNbc() {
		ArrayList<Integer> compte = new ArrayList<Integer>();
		ArrayList<Integer> doublon2 = new ArrayList<Integer>();
		doublon2.clear();
		for (int i = 0; i < this.nbcase; i++) {
			int counter = 1;
			// compte.add(counter);

			for (int k = 0; k < this.nbcase; k++) {
				if (combRecherche.get(i) != combRecherche.get(k) && doublon2.contains(combRecherche.get(k)) == false) {
					++counter;
					doublon2.add(combRecherche.get(k));
				}
			}
			compte.add(counter);
		}
		try {
			nbc = Collections.max(compte);
		} catch (Exception e) {
			nbc = compte.get(0);
		}
		return nbc;
	}

	/**
	 * M�thode v�rifiant si couleur existe ou non
	 * 
	 * @param b
	 *            nombre de bien plac�
	 * @param m
	 *            nombre de mal plac�
	 */
	@SuppressWarnings("unchecked")
	public void VerifCouleur(int b, int m) {
		if (b == 0 && m == 0) {
			for (int i = 0; i < position.size(); i++) {
				position.get(i).set(hyp, -1);
			}
			del.add(hyp);
			logger.debug("IA : Couleur existe pas");
		}

		else

		// La couleur existe mais mal plac�e, on supprime la couleur � la position
		if (m >= existep - b && existe.size() > 0 && m > 0 && existep + confp < nbcase) {
			for (int i = 0; i < existe.size(); i++) {
				int index = -1;
				try {
					if (existe.get(i) != combConfirm.get(combRecherche.indexOf(existe.get(i)))) {
						index = combRecherche.indexOf(existe.get(i));
					} else
						index = combRecherche.lastIndexOf(existe.get(i));
					
					if (index != -1) {

						position.get(index).set(existe.get(i), -1);
					}
				} catch (Exception e) {
					logger.error("pas de couleur");
				}

			}
			emp++;
			logger.debug("IA : Existe mal plac�");
		}
	}

	/**
	 * M�thode v�rifiant si un existant est confirm� � sa position
	 * 
	 * @param b
	 *            nombre bien plac�
	 * @param m
	 *            nombre mal plac�
	 */
	@SuppressWarnings("unchecked")
	public void VerifConfirme(int b, int m) {

		if ((b > existep && existe.size() > 0 && b + m <= nbc && emp == 0)
				|| (b >= existep && m < nbc - existep && b != 0 && existep != 0 && emp == 0)) {
			int index = -1;
			try {
				if (existe.get(0) != combConfirm.get(combRecherche.indexOf(existe.get(0)))) {
					index = combRecherche.indexOf(existe.get(0));
				} else
					index = combRecherche.lastIndexOf(existe.get(0));
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			if (index != -1) {
				for (int i1 = 0; i1 < position.size(); i1++) {
					if (i1 == index) {
						
						for (int k = 0; k < position.get(i1).size(); k++) {

							if (position.get(i1).get(k) != (existe.get(0)))
								position.get(i1).set(k, -1);

						}

					}

				}
				int existedouble = 0;
				for (int i = 0; i < existe.size(); i++) {
					if (existe.get(0) == existe.get(i))
						existedouble++;
				}
				for (int i = 0; i < confirme.size(); i++) {
					if (existe.get(0) == confirme.get(i))
						existedouble++;
				}
				if (existedouble == 1) {
					for (int i1 = 0; i1 < position.size(); i1++) {
						if (i1 != index)
							position.get(i1).set(existe.get(0), -1);
					}
				}

				logger.debug("IA : confirm�  " + existe.get(0) + " a la position : " + index);
				combConfirm.set(index, existe.get(0));
				confirme.add(existe.get(0));
				existe.remove(0);
				confp++;
				del.add(hyp);
			}
		}

	}

	/**
	 * V�rifie si une couleur test�e existe et supprime les positions non possibles
	 * 
	 * @param b
	 *            nombre bien plac�
	 * @param m
	 *            nombre mal plac�
	 */
	@SuppressWarnings("unchecked")
	public void VerifExiste(int b, int m) {
		if ((b + m) >= nbc) {
			if (existe.size() + confirme.size() - confp < nbcase)
				for (int i = 0; i <= (b + m) - nbc - doublep; i++)
					existe.add(hyp);
			logger.debug("IA : Couleur Existe " + hyp);
			del.add(hyp);
		}
		// Si n'existe pas on supprime les possibilit�s
		else
			for (int i = 0; i < position.size(); i++) {
				position.get(i).set(hyp, -1);
				del.add(hyp);
				logger.debug("IA Couleur Existe pas  " + hyp);
				if (b >= existe.size() + confirme.size() && existe.size() > 0) {
					for (int i1 = 0; i1 < existe.size(); i1++) {
						int index = combRecherche.indexOf(existe.get(i1));

						// System.out.println("index "+index);
						if (index != -1) {
							for (int i11 = 0; i11 < position.size(); i11++) {
								if (i11 == index) {
									for (int k = 0; k < position.get(i11).size(); k++) {

										if (position.get(i11).get(k).equals(existe.get(i11)) == false)
											position.get(i11).set(k, -1);
									}

								}
								logger.debug("IA : confirm� si autre couleur existe pas  " + existe.get(i11)
										+ " position : " + index);
								combConfirm.set(index, existe.get(i11));
								confirme.add(existe.get(i11));
								existe.remove(i11);
								del.add(hyp);
								break;
							}
						}
					}
				}
			}
	}

	/**
	 * V�rifie si une couleur est mal plac�e et supprime les positions non
	 * applicables
	 * 
	 * @param b
	 *            nombre bien plac�
	 * @param m
	 *            nombre mal plac�
	 */
	@SuppressWarnings("unchecked")
	public void VerifMalp(int b, int m) {
		if (m == (nbc + doublep - confp) && m != 0 && b == confp) {
			for (int i = 0; i < position.size(); i++) {
				if (combRecherche.get(i) != combConfirm.get(i))
					position.get(i).set(combRecherche.get(i), -1);
				logger.debug("IA : Mal plac� supprim� � chaque position");

			}
		}
	}

	/**
	 * Confirme une couleur lorsque les autres couleurs ne sont pas possibles � une
	 * case
	 */
	public void Elimination() {

		for (int i = 0; i < position.size(); i++) {
			int c = 0;
			for (int j = 0; j < position.get(i).size(); j++) {
				if ((int) position.get(i).get(j) != -1)
					c++;
			}
			if (c == 1) {
				for (int j = 0; j < position.get(i).size(); j++) {
					if ((int) position.get(i).get(j) != -1 && (int) position.get(i).get(j) != combConfirm.get(i)) {
						confirme.add((int) position.get(i).get(j));
						combConfirm.set(i, (int) position.get(i).get(j));
						int countremove = 0;

						
						for (int k = 0; k < existe.size(); k++) {
							if ((int) position.get(i).get(j)== existe.get(k) && countremove < 1) {
								existe.remove(k);
								countremove++;
							}
						}
						logger.debug(
								" IA : Confirm� par �limination : " + (int) position.get(i).get(j) + " position : " + i);
					}
				}
			}

		}
	}

	/**
	 * Confirme une couleur lorsqu'elle existe et ne peut �tre sur une autre case
	 */
	public void Elimination2() {

		for (int i = 0; i < position.get(0).size(); i++) {
			int c = 0;
			for (int j = 0; j < position.size(); j++) {
				if ((int) position.get(j).get(i) != -1)
					c++;
			}
			if (c == 1) {
				for (int j = 0; j < position.size(); j++) {
					if ((int) position.get(j).get(i) != -1 && (int) position.get(j).get(i) != combConfirm.get(j)) {
						confirme.add((int) position.get(j).get(i));
						combConfirm.set(j, (int) position.get(j).get(i));
						int countremove = 0;

						
						for (int k = 0; k < existe.size(); k++) {
							if ((int) position.get(j).get(i)== existe.get(k) && countremove < 1) {
								existe.remove(k);
								countremove++;
							}
						}
						logger.debug(
								"IA : Confirm� par �limination 2 : " + (int) position.get(j).get(i) + " position : " + j);
					}
				}
			}

		}
	}

	/**
	 * Supprime les couleurs sur les positions non possibles
	 */
	@SuppressWarnings("unchecked")
	public void Suppr() {
		
		for (int i = 0; i < position.size(); i++) {
			if(combConfirm.get(i)!=-1) {
				for (int j = 0; j < position.get(i).size(); j++) {
					if(position.get(i).get(j)!=combConfirm.get(i))position.get(i).set(j, -1);
				}
			}
			
		}
		

		
		/*int c = 0;
		Object b1 = 0;
		int posi = 0;

		for (int i = 0; i < existe.size(); i++) {
			c = 0;
			for (int k = 0; k < position.size(); k++) {
				if ((int) position.get(k).get(existe.get(i)) != -1) {
					c++;
					b1 = existe.get(i);
					posi = k;
				}
			}

		}
		if (c == 1) {
			for (int i1 = 0; i1 < position.size(); i1++) {
				if (i1 == posi) {
					for (int k = 0; k < position.get(i1).size(); k++) {

						if (position.get(i1).get(k).equals(b1) == false)
							position.get(i1).set(k, -1);
					}

				}
				int existedouble = 0;
				for (int i = 0; i < existe.size(); i++) {
					if (existe.get(0) == existe.get(i))
						existedouble++;
				}
				for (int i = 0; i < confirme.size(); i++) {
					if (existe.get(0) == confirme.get(i))
						existedouble++;
				}
				if (existedouble == 1) {
					for (int i11 = 0; i11 < position.size(); i11++) {
						if (i11 != posi)
							position.get(i11).set((int) b1, -1);
					}
				}
			}
			System.out.println("Un confirm� donc suppressions sur ligne et position");
			System.out.println("confirm�");

			// confirme.add((int) b1);

			// cf.set(posi,(int) b1);
		}*/
	}

	/**
	 * Permet de trouver la combinaison finale lorsque toutes les couleurs sont
	 * d�couvertes
	 * 
	 * @param b
	 *            nombre bien plac�
	 * @param m
	 *            nombre mal plac�
	 */
	@SuppressWarnings("unchecked")
	public void FinalComb(int b, int m) {
		int count = 0;
		if (confirme.size() + existe.size() == nbcase) {
			/*for (int i = 0; i < position.size(); i++) {
				if (combConfirm.get(i) == -1) {
					for (int j = 0; j < position.get(i).size(); j++) {
						for (int j2 = 0; j2 < existe.size(); j2++) {
							if (position.get(i).get(j) == existe.get(j2))
								count++;
						}
						if (count == 0)
							position.get(i).set(j, -1);
						System.out.println("suppr hyp non ds comb final");
					}
				}
			}*/

			if (b - confp >= 2) {
				int index = -1;
				try {
					if (combFinal.get(0) != combConfirm.get(combRecherche.indexOf(combFinal.get(0)))) {
						index = combRecherche.indexOf(combFinal.get(0));
					} else
						index = combRecherche.lastIndexOf(combFinal.get(0));
				} catch (Exception e) {
					logger.error(e);
				}
				

				if (index != -1) {
					for (int i1 = 0; i1 < position.size(); i1++) {
						if (i1 == index) {

							for (int k = 0; k < position.get(i1).size(); k++) {

								if (position.get(i1).get(k) != (combFinal.get(0)))
									position.get(i1).set(k, -1);

							}

						}

					}
					int existedouble = 0;
					for (int i = 0; i < existe.size(); i++) {
						if (combFinal.get(0) == existe.get(i))
							existedouble++;
					}
					for (int i = 0; i < confirme.size(); i++) {
						if (combFinal.get(0) == confirme.get(i))
							existedouble++;
					}
					if (existedouble == 1) {
						for (int i1 = 0; i1 < position.size(); i1++) {
							if (i1 != index)
								position.get(i1).set(combFinal.get(0), -1);
						}
					}

					 logger.debug("IA : confirm� final : "+combFinal.get(0) + " a la position : "+index +"double : "+existedouble);
				}
				combConfirm.set(index, combFinal.get(0));
				confirme.add(combFinal.get(0));
				int countremove = 0;

				
					for (int k = 0; k < existe.size(); k++) {
						if (combFinal.get(0) == existe.get(k) && countremove < 1) {
							existe.remove(k);
							countremove++;
						}
					}
				
				
				confp++;
			}

			else

			if (m >= 2) {
				int index = -1;
				try {
					if (combFinal.get(0) != combConfirm.get(combRecherche.indexOf(combFinal.get(0)))) {
						index = combRecherche.indexOf(combFinal.get(0));
					} else
						index = combRecherche.lastIndexOf(combFinal.get(0));
				} catch (Exception e) {
					// TODO: handle exception
				}
				logger.debug("IA : confirm� final par �limination");
				combConfirm.set(index, hyp);
				confirme.add(hyp);
				int countremove = 0;

				
				for (int k = 0; k < existe.size(); k++) {
					if (hyp == existe.get(k) && countremove < 1) {
						existe.remove(k);
						countremove++;
					}
				}
				
				confp++;
			}

			else
				position.get(combRecherche.indexOf(combFinal.get(0))).set(combFinal.get(0), -1);
				logger.debug("IA : �limination ");
		}

	}

	/**
	 * Remise � zero des hypoth�ses utilis�es pour le prochain tour
	 */
	public void HypReset() {
		int count=0;

		
		
		
		couleur.removeAll(del);
		int countremove = 0;

		/*for (int i = 0; i < confirme.size(); i++) {
			for (int k = 0; k < existe.size(); k++) {
				if (confirme.get(i) == existe.get(k) && countremove < 1) {
					existe.remove(k);
					countremove++;
				}
			}
		}*/
		
		if (confirme.size() + existe.size() == nbcase) {
			for (int i = 0; i < position.size(); i++) {
				if (combConfirm.get(i) == -1) {
					for (int j = 0; j < position.get(i).size(); j++) {
						count=0;
						for (int j2 = 0; j2 < existe.size(); j2++) {
							if ((int)position.get(i).get(j) == (int)existe.get(j2))
								count++;
						}
						if (count == 0) {
							position.get(i).set(j, -1);
							logger.debug("IA suppr hyp non ds comb finale"+i+j);
							count=0;
						}
						
					}
				}
			}
		}
		
		logger.debug("IA couleurs hyp : " + couleur);
		emp = 0;
		nbc = 0;
		existep = 0;
		emp = 0;
		confp = 0;
		doublep = 0;

		combFinal.clear();

		if (couleur.size() > 0 && existe.size() + confirme.size() < nbcase)
			hyp = couleur.get((int) (Math.random() * (couleur.size() - 0) + 0));
		else
			try {
				hyp = existe.get((int) (Math.random() * (existe.size() - 0) + 0));
			} catch (Exception e) {
				hyp = confirme.get((int) (Math.random() * (confirme.size() - 0) + 0));
			}

	}

	/**
	 * Donne une nouvelle combinaison en fonction des r�sultats pr�c�dents
	 */
	public void Combi() {
		int k = 0;
		int res[] = new int[existe.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = existe.get(i);
		}
		int quitter = 0;

		for (int i = 0; i < nbcase; i++) {
			
			

			if (combConfirm.get(i) != -1) {
				combRecherche.set(i, combConfirm.get(i));
				logger.debug("IA placer dans comb un confirm� + position : " + i);
				confp++;
			} else if (existe.size() > k) {
				if (existe.size() + confirme.size() == nbcase) {

					if (quitter == 1) {
						for (int j = 0; j < existe.size(); j++) {
							if (existe.get(j) != combFinal.get(0)) {
								hyp = existe.get(j);
								combRecherche.set(i, hyp);
								logger.debug("IA placer hyp finale");
								existep++;
								break;
							}
						}
					} else {

						for (int j = 0; j < position.get(i).size(); j++) {
							if ((int) position.get(i).get(j) != -1) {
								combRecherche.set(i, (int) position.get(i).get(j));
								logger.debug("IA placer existant si possible final");
								combFinal.add((int) position.get(i).get(j));
								existep++;
								k++;
								for (int i1 = 0; i1 < confirme.size(); i1++) {
									if (combFinal.get(0) == confirme.get(i1))
										doublep++;
								}
								quitter = 1;
								break;
							}
						}

					}

					/*
					 * if(quitter==1) cs.set(i, hyp); else for (int l = 0; l < existe.size(); l++) {
					 * 
					 * if (quitter==1) break; for (int l2 = 0; l2 < position2.get(i).size(); l2++) {
					 * if(existe.get(l).equals(position2.get(i).get(l2))==true&&res[l]!=-1) {
					 * cs.set(i, existe.get(l)); res[l]=-1; k++;
					 * System.out.println("Placer dans comb un existant + position : "+i);
					 * existep++;
					 * 
					 * for (int i1 = 0; i1 < confirme.size(); i1++) { if
					 * (existe.get(l)==confirme.get(i1))doublep++; } int h=l+1; if(h<existe.size())
					 * { for (int j = 0; j < position2.get(i).size(); j++) {
					 * 
					 * if(existe.get(h).equals(position2.get(i).get(j))==true)hyp=h; else
					 * if(h<existe.size()-1)h++; }}
					 * 
					 * quitter=1; break;
					 * 
					 * 
					 * } else cs.set(i, hyp);
					 * 
					 * System.out.println("Placer hyp car pas existant possible+ position : "+i);
					 * 
					 * }
					 * 
					 * }
					 */
				} else {
					for (int l2 = 0; l2 < position.get(i).size(); l2++) {

						if ((int) existe.get(0) == (int) position.get(i).get(l2) && k < 1) {
							combRecherche.set(i, existe.get(0));

							k++;
							logger.debug("IA Placer dans comb un existant + position : " + i);
							existep++;
							for (int i1 = 0; i1 < confirme.size(); i1++) {
								if (existe.get(0) == confirme.get(i1))
									doublep++;
							}
							break;

						} else
							combRecherche.set(i, hyp);
						logger.debug("IA Placer hyp par d�faut + position : " + i);
					}
				}
			} else {
				combRecherche.set(i, hyp);
				logger.debug("IA Placer hyp par d�faut + position : " + i);
			}
			//
			//

		}
		logger.debug("IA : Existe : ");
		for (int j = 0; j < existe.size(); j++) {
			logger.debug(existe.get(j));
			
		}
		logger.debug("IA Confirm� : ");
		for (int j = 0; j < confirme.size(); j++) {
			logger.debug(confirme.get(j));
			
		}

	}

	public ArrayList<Integer> getCouleur() {
		return couleur;
	}

	public void setCouleur(ArrayList<Integer> couleur) {
		this.couleur = couleur;
	}

	public ArrayList<Integer> getExiste() {
		return existe;
	}

	public void setExiste(ArrayList<Integer> existe) {
		this.existe = existe;
	}

	public ArrayList<Integer> getCombFinal() {
		return combFinal;
	}

	public void setCombFinal(ArrayList<Integer> combFinal) {
		this.combFinal = combFinal;
	}

	public ArrayList<Integer> getConfirme() {
		return confirme;
	}

	public void setConfirme(ArrayList<Integer> confirme) {
		this.confirme = confirme;
	}

	public ArrayList<ArrayList> getPosition() {
		return position;
	}

	public void setPosition(ArrayList<ArrayList> position) {
		this.position = position;
	}

	public ArrayList<Integer> getDel() {
		return del;
	}

	public void setDel(ArrayList<Integer> del) {
		this.del = del;
	}

	public int getHyp() {
		return hyp;
	}

	public void setHyp(int hyp) {
		this.hyp = hyp;
	}

	public ArrayList<Integer> getCombRecherche() {
		return combRecherche;
	}

	public void setCombRecherche(ArrayList<Integer> combRecherche) {
		this.combRecherche = combRecherche;
	}

	public ArrayList<Integer> getCombConfirm() {
		return combConfirm;
	}

	public void setCombConfirm(ArrayList<Integer> combConfirm) {
		this.combConfirm = combConfirm;
	}

	public int getChiffre() {
		return chiffre;
	}

	public void setChiffre(int chiffre) {
		this.chiffre = chiffre;
	}

	public int getNbcase() {
		return nbcase;
	}

	public void setNbcase(int nbcase) {
		this.nbcase = nbcase;
	}

	public int getNbc() {
		return nbc;
	}

	public void setNbc(int nbc) {
		this.nbc = nbc;
	}

	public int getExistep() {
		return existep;
	}

	public void setExistep(int existep) {
		this.existep = existep;
	}

	public int getEmp() {
		return emp;
	}

	public void setEmp(int emp) {
		this.emp = emp;
	}

	public int getConfp() {
		return confp;
	}

	public void setConfp(int confp) {
		this.confp = confp;
	}

	public int getDoublep() {
		return doublep;
	}

	public void setDoublep(int doublep) {
		this.doublep = doublep;
	}
	
}

package IAMaster;

import java.util.ArrayList;
import java.util.Collections;

public class IAMaster {
	
	
	public ArrayList<Integer> couleur; 
	 
	public ArrayList<Integer> existe;
	public ArrayList<Integer> confirme;
	public ArrayList<ArrayList> position2;
	public ArrayList<Integer> del;
	public int hyp;
	public ArrayList<Integer> cs;
	public ArrayList<Integer> cf;
	public int chiffre;
	public int nbcase;
	int nbc =0;
	int existep=0;
	int emp =0;
	int confp=0;
	
	
	
	public IAMaster(int chiffre, int nbcase) {
		
		this.couleur = new ArrayList<Integer>();
		this.existe=new ArrayList<Integer>();
		this.confirme=new ArrayList<Integer>();
		this.position2= new ArrayList<ArrayList>();
		this.del=new ArrayList<Integer>();
		this.hyp=(int) (Math.random() * (position2.size() - 0) + 0);
		this.cs=new ArrayList<Integer>();
		this.cf=new ArrayList<Integer>();
		this.chiffre=chiffre;
		this.nbcase=nbcase;
		
		
		
		
		
		for(int i=0;i<this.chiffre;i++)couleur.add(i);
		
		for(int i=0;i<nbcase;i++) {
			ArrayList<Integer> couleur2 = new ArrayList<Integer>();
			for(int i1=0;i1<chiffre;i1++) {
				
				couleur2.add(i1);
				
			}
			position2.add(i,couleur2);
		}
		
		for (int i = 0; i < nbcase; i++) {
			cs.add(i, hyp);
		}
		
		for (int i = 0; i < nbcase; i++) {
			cf.add(i, -1);
		}
			
		
	}
	
	public int CalculNbc() {
		ArrayList<Integer>compte=new ArrayList<Integer>();
		ArrayList<Integer>doublon2=new ArrayList<Integer>();
		doublon2.clear();
		for (int i = 0; i < this.nbcase; i++) {
			int counter=1;
			//compte.add(counter);
		
		for (int k=0;k<this.nbcase;k++) {
			if(cs.get(i)!=cs.get(k)&&doublon2.contains(cs.get(k))==false) {
				++counter;
				doublon2.add(cs.get(k));
			}			
		}
		compte.add(counter);	
	}
		try {
			nbc=Collections.max(compte);
		} catch (Exception e) {
			nbc=compte.get(0);
		}
		return nbc;
	}
	
	
	public void VerifCouleur(int b, int m) {
		if (b==0 && m==0) {
			for (int i = 0; i <position2.size() ; i++) {
				position2.get(i).set(hyp,-1);
			}
			del.add(hyp);
			System.out.println("Couleur existe pas");
		}
		
		else
			
			
			//La couleur existe mais mal placée, on supprime la couleur à la position
			if (m>=existep-b&&existe.size()>0 &&m>0) {
			for (int i = 0; i < existe.size(); i++) {
				int index=cs.indexOf(existe.get(i));
				System.out.println("index "+index);
				if(index!=-1) {
					System.out.println( " index mal placé est true");
					System.out.println("position get index"+ position2.get(index));
				position2.get(index).set(existe.get(i),-1);	
				}
			}
			emp++;
			System.out.println("Existe mal placé");
			}
	}
	
	public void VerifConfirme(int b, int m) {
			
		if ((b>existep&&existe.size()>0&&b+m<=nbc&&emp==0)||(b>=existep&&m<nbc-existep&&b!=0&&existep!=0&&emp==0))	{	
					int index=cs.indexOf(existe.get(0));
				
				
				System.out.println("index "+index);
				if(index!=-1) {
				for (int i1 = 0; i1 <position2.size() ; i1++) {
					if(i1==index) {
						System.out.println("i1=index est true");
					for (int k = 0; k < position2.get(i1).size(); k++) {
						System.out.println("k :" +k);
						System.out.println("position2 i1 k : "+position2.get(i1).get(k));
						System.out.println("existe : "+ existe.get(0));
						System.out.println("position2 get : "+position2.get(i1));
						if( position2.get(i1).get(k)!=(existe.get(0)))
							position2.get(i1).set(k,-1);
							
						}
					
				
				}
					
				}
				int existedouble=0;
				for (int i = 0; i < existe.size(); i++) {
					if (existe.get(0)==existe.get(i))existedouble++;
				}
				if (existedouble==1) {
					for (int i1 = 0; i1 <position2.size() ; i1++) {
						if(i1!=index)position2.get(i1).set(existe.get(0), -1);
					}
				}
				
				System.out.println("confirmé : "+existe.get(0) + " a la position : "+index);
				cf.set(index,existe.get(0));
				confirme.add(existe.get(0));
				confp++;
				del.add(hyp);
			}	
			}
		
	}
	public void VerifExiste(int b, int m) {
		if((b+m)>=nbc) {
			if(existe.size()+confirme.size()-confp<nbcase)for (int i = 0;i<=(b+m)-nbc;i++)existe.add(hyp);
			System.out.println("Couleur Existe :" +hyp);
			del.add(hyp);
			}
			//Si n'existe pas on supprime les possibilités
			else 	for (int i = 0; i <position2.size() ; i++) {
				position2.get(i).set(hyp,-1);
				del.add(hyp);
				System.out.println("Couleur Existe pas : "+hyp);
				if(b>=existe.size()+confirme.size()&&existe.size()>0) {
					for (int i1 = 0; i1 < existe.size(); i1++) {
						int index=cs.indexOf(existe.get(i1));
					
					
					//System.out.println("index "+index);
					if(index!=-1) {
					for (int i11 = 0; i11 <position2.size() ; i11++) {
						if(i11==index) {
						for (int k = 0; k < position2.get(i11).size(); k++) {
							 
							if( position2.get(i11).get(k).equals(existe.get(i11))==false)
								position2.get(i11).set(k,-1);}
						
					
					}System.out.println("confirmé si autre couleur existe pas : "+existe.get(i11)+ " position : "+index);
					cf.set(index,existe.get(i11));
					confirme.add(existe.get(i11));
					del.add(hyp);
					break;
					}
					}
				}
				}
			}
	}
	
	public void VerifMalp(int b, int m) {
		if(m==(nbc-confirme.size()-b) && m!=0 && b==confirme.size()){
			for (int i = 0; i < position2.size(); i++) {
				if(cs.get(i)!=cf.get(i))position2.get(i).set(cs.get(i),-1);
				System.out.println("Mal placé supprimé à chaque position");
				
			}
		}
	}
	
	public void Suppr() {
		int c=0;
		Object b1=0;
		int posi=0;
		
		for (int i = 0; i < existe.size(); i++) {
			c=0;
			for (int k = 0; k < position2.size(); k++) {
				if((int)position2.get(k).get(existe.get(i))!=-1) {
					c++;
					b1=existe.get(i);
					posi=k;
				}
			}
			
			
		}
		if (c==1) {
			for (int i1 = 0; i1 <position2.size() ; i1++) {
				if(i1==posi) {
				for (int k = 0; k < position2.get(i1).size(); k++) {
					
					if( position2.get(i1).get(k).equals(b1)==false)
						position2.get(i1).set(k,-1);
					}
				
			
			}
				int existedouble=0;
				for (int i = 0; i < existe.size(); i++) {
					if (existe.get(0)==existe.get(i))existedouble++;
				}
				if (existedouble==1) {
					for (int i11 = 0; i11 <position2.size() ; i11++) {
						if(i11!=posi)position2.get(i11).set((int) b1, -1);
					}
				}
			}
			System.out.println("Un confirmé donc suppressions sur ligne et position");
			System.out.println("confirmé");
			
			confirme.add((int) b1);
			cf.set(posi,(int) b1);
		}
	}
	
	public void HypReset(){
		
		couleur.removeAll(del);
		int countremove=0;
		for (int i = 0; i < confirme.size(); i++) {
			for (int k = 0; k < existe.size(); k++) {
				if (confirme.get(i)==existe.get(k)&&countremove<1) {
					existe.remove(k);
					countremove++;	
				}
			}
		}
		emp=0;
		nbc =0;
		existep=0;
		emp =0;
		confp=0;
		
		
		if (couleur.size()>0&&existe.size()+confirme.size()<nbcase)hyp=couleur.get((int) (Math.random() * (couleur.size() - 0) + 0));
		else try {
			hyp=existe.get((int) (Math.random() * (existe.size() - 0) + 0));
		}catch (Exception e) {
			hyp=confirme.get((int) (Math.random() * (confirme.size() - 0) + 0));
		}
		
	}
	
	public void Combi() {
		int k=0;
		int res[] = new int[existe.size()];
		for (int i = 0; i < res.length; i++) {
			res[i]=existe.get(i);
		}
		
		
		for(int i=0;i<nbcase;i++) {
			int o=0;
			int s=0;

			if(cf.get(i)!=-1) {
				cs.set(i, cf.get(i));
				System.out.println("placer dans comb un confirmé + position : "+i);
			}
				else 
					if(existe.size()>k) {
						if(existe.size()+confirme.size()==nbcase) {
						int quitter=0;
						for (int l = 0; l < existe.size(); l++) {
							
							if (quitter==1) break;
							for (int l2 = 0; l2 < position2.get(i).size(); l2++) {
								if(existe.get(l).equals(position2.get(i).get(l2))==true&&res[l]!=-1) {
									cs.set(i, existe.get(l));
									res[l]=-1;
									k++;
									System.out.println("Placer dans comb un existant + position : "+i);
									existep++;
									quitter=1;
									break;
									
									
								}
								else cs.set(i, hyp);
								
								System.out.println("Placer hyp car pas existant possible+ position : "+i);
								
							}
							
						}
						}
						else {for (int l2 = 0; l2 < position2.get(i).size(); l2++) {
							System.out.println("existe 0 : "+existe.get(0));
							System.out.println("chiffre sur position : "+ position2.get(i).get(l2));
							System.out.println("k : "+ k);
							if((int)existe.get(0)==(int)position2.get(i).get(l2)&&k<1) {
								cs.set(i, existe.get(0));
								
								k++;
								System.out.println("Placer dans comb un existant + position : "+i);
								existep++;
								break;
								
								
							}
							else cs.set(i, hyp);
							System.out.println(" Placer hyp par défaut + position : "+i);
					}
						}
					}
						else {
							cs.set(i, hyp);
							System.out.println("Placer hyp par défaut + position : "+i);
						}
						//
				//	
					
					
					
		}
	}
}

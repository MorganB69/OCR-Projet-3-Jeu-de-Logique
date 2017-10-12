package Config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serial {

	ObjectInputStream ois;
	ObjectOutputStream oos;
	String p;
	String d;

	public Serial(String d,String p) {

		this.p = p;
		this.d = d;
	}

	public void Ecriture(ArrayList<Parametres> p) {
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(this.d,this.p))));

			
			oos.writeObject(p);
			
			

			oos.close();

		}

		catch (EOFException exc) {
			exc.printStackTrace();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public ArrayList<Parametres> Lecture() {
		ArrayList<Parametres> list = new ArrayList<Parametres>();
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(this.d,this.p))));

			list = (ArrayList<Parametres>) ois.readObject();


		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			// On ferme nos flux de données dans un bloc finally 

			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	public ArrayList<Integer> Recuperation() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(this.d,this.p))));
			
			while(ois.available()>0) {
			list.add(ois.readInt());
			}
			
			


		}

		//catch (ClassNotFoundException e) {
			//e.printStackTrace();
		//}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		
		

		finally {
			// On ferme nos flux de données dans un bloc finally 
			
			try {
				if (ois != null)
					ois.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
		return list;
		
	
		
	}
	public Boolean RecuperationB() {
		Boolean b=false;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(this.d,this.p))));
			
			while(ois.available()>0) {
			b=(ois.readBoolean());
			}
			
			


		}

		//catch (ClassNotFoundException e) {
			//e.printStackTrace();
		//}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		
		

		finally {
			// On ferme nos flux de données dans un bloc finally 
			
			try {
				if (ois != null)
					ois.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
		return b;
		
	
		
	}	
}

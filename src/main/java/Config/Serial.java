package Config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe permettant l'écriture et la récupération de données dans un fichier
 * @author Morgan
 *
 */
/**
 * @author Morgan
 *
 */
public class Serial {
	private static final Logger logger = LogManager.getLogger(Serial.class);
	/**
	 * ObjetInputStream
	 */
	ObjectInputStream ois;
	InputStreamReader reader;
	/**
	 * ObjectOutStream
	 */
	ObjectOutputStream oos;
	/**
	 * Nom du fichier à récupérer
	 */
	String p;
	/**
	 * Chemin d'accès au fichier
	 */
	String d;

	/**
	 * Constructeur par défaut
	 * 
	 * @param d
	 *            Nom du fichier à récupérer
	 * @param p
	 *            Chemin d'accès au fichier
	 */
	public Serial(String d, String p) {

		this.p = p;
		this.d = d;
	}

	/**
	 * Enregistrement dans un fichier des paramètres
	 * 
	 * @param par
	 *            Classe paramètre contenant les paramètres du jeu
	 */
	public void Ecriture(ArrayList<Parametres> par) {
		try {
			logger.info("Ecriture des données dans config.properties");
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(this.d, this.p))));

			oos.writeObject(par);

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

	/**
	 * Méthode utilisée en développement pour la lecture du fichier
	 * 
	 * @return Retourne sour forme de ArrayList un objet Paramètres contenant les
	 *         différents paramètres
	 */
	/*public ArrayList<Parametres> LectureTest() {
		ArrayList<Parametres> list = new ArrayList<Parametres>();
		try {
			logger.info("Lecture des données dans config.properties");
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(this.d, this.p))));

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
	}*/
	
	public ArrayList<Integer> LectureTest() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			logger.info("Lecture des données dans config.properties");
			InputStream is = this.getClass().getResourceAsStream(this.p);
			Reader reader = new InputStreamReader(is);

			StringBuilder builder = new StringBuilder();
		    char[] buffer = new char[512];
		    int nbRead = reader.read(buffer);
		    while(nbRead > 0) {
		      builder.append(buffer, 0, nbRead);
		      nbRead = reader.read(buffer);
		      String s=new String();
		      s=builder.toString();
		      
		      
		   // d pour digit : chiffre. Toute séquence de un ou plusieurs chiffres.
		      Pattern regex = Pattern.compile("\\d+");
		      // Matcher de cette regex sur la String chargée en mémoire
		      Matcher matcher = regex.matcher(s);
		      // boucler
		      while(matcher.find()) {
		        // récupérer le nombre, sous forme de String
		        String sNumber = matcher.group();
		        // convertir le nombre en int
		        int number = Integer.parseInt(sNumber);
		        list.add(number);
		      }
		    }
		}
/*
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			// On ferme nos flux de données dans un bloc finally

			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	/**
	 * Méthode à utiliser une fois le jeu exporté
	 * 
	 * @return Retourne l'objet paramètre contenant les paramètres du jeu
	 */
	public ArrayList<Parametres> Lecture() {
		ArrayList<Parametres> list = new ArrayList<Parametres>();
		try {
			logger.info("Lecture des données dans config.properties");
			InputStream is = this.getClass().getResourceAsStream(this.p);

			ois = new ObjectInputStream(is);

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

}

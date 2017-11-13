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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe permettant l'�criture et la r�cup�ration de donn�es dans un fichier
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
	/**
	 * ObjectOutStream
	 */
	ObjectOutputStream oos;
	/**
	 * Nom du fichier � r�cup�rer
	 */
	String p;
	/**
	 * Chemin d'acc�s au fichier
	 */
	String d;

	/**
	 * Constructeur par d�faut
	 * 
	 * @param d
	 *            Nom du fichier � r�cup�rer
	 * @param p
	 *            Chemin d'acc�s au fichier
	 */
	public Serial(String d, String p) {

		this.p = p;
		this.d = d;
	}

	/**
	 * Enregistrement dans un fichier des param�tres
	 * 
	 * @param par
	 *            Classe param�tre contenant les param�tres du jeu
	 */
	public void Ecriture(ArrayList<Parametres> par) {
		try {
			logger.info("Ecriture des donn�es dans config.properties");
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
	 * M�thode utilis�e en d�veloppement pour la lecture du fichier
	 * 
	 * @return Retourne sour forme de ArrayList un objet Param�tres contenant les
	 *         diff�rents param�tres
	 */
	public ArrayList<Parametres> LectureTest() {
		ArrayList<Parametres> list = new ArrayList<Parametres>();
		try {
			logger.info("Lecture des donn�es dans config.properties");
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
			// On ferme nos flux de donn�es dans un bloc finally

			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	/**
	 * M�thode � utiliser une fois le jeu export�
	 * 
	 * @return Retourne l'objet param�tre contenant les param�tres du jeu
	 */
	public ArrayList<Parametres> Lecture() {
		ArrayList<Parametres> list = new ArrayList<Parametres>();
		try {
			logger.info("Lecture des donn�es dans config.properties");
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
			// On ferme nos flux de donn�es dans un bloc finally

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

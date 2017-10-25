import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Niveau {

	//ATTRIBUTS
	private int numero;					//le numéro du niveau
	private int nbVerrou ;				//le nombre de vérrou et de boutton que le coffre a.
	private Vector<Verrou> verrous;		//la liste des vérrous du niveau
	private Vector<Bouton> boutons;		//la liste des boutons du niveau
	
	//METHODES 
	
	public Niveau(int numero){

		
	
		
		try {
			
			File listeNiveaux = new File("listeNiveau.xml");
			
			niveau.getAttribute("bouton");
			
	    }
		catch (FileNotFoundException fnf) {
			System.err.println("Pas de fichier disponible");
		}
		catch (IOException ioe) {
			System.err.println("lecture impossible");
			ioe.printStackTrace();
		}
		
	}
	
	public void lire(){
		
	}
	
}

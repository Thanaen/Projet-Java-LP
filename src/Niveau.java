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
			
		//	niveau.getAttribute("bouton");
		//	Element nom = (Element) personne.getElementsByTagName("nom").item(0);
		//	nom.getTextContent()
			
//			 /*
//	         * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
//	         */
//	        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//	            	
//	        try {
//	            /*
//	             * Etape 2 : création d'un parseur
//	             */
//	            final DocumentBuilder builder = factory.newDocumentBuilder();
//				
//		    /*
//		     * Etape 3 : création d'un Document
//		     */
//		    final Document document= builder.parse(new File("repertoire.xml"));
//				
//		    //Affichage du prologue
//		    System.out.println("*************PROLOGUE************");
//		    System.out.println("version : " + document.getXmlVersion());
//		    System.out.println("encodage : " + document.getXmlEncoding());		
//	            System.out.println("standalone : " + document.getXmlStandalone());
//						
//		    /*
//		     * Etape 4 : récupération de l'Element racine
//		     */
//		    final Element racine = document.getDocumentElement();
//			
//		    //Affichage de l'élément racine
//		    System.out.println("\n*************RACINE************");
//		    System.out.println(racine.getNodeName());
//			
//		    /*
//		     * Etape 5 : récupération des personnes
//		     */
//		    final NodeList racineNoeuds = racine.getChildNodes();
//		    final int nbRacineNoeuds = racineNoeuds.getLength();
//				
//		    for (int i = 0; i<nbRacineNoeuds; i++) {
//		        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
//		            final Element personne = (Element) racineNoeuds.item(i);
//					
//			    //Affichage d'une personne
//			    System.out.println("\n*************PERSONNE************");
//			    System.out.println("sexe : " + personne.getAttribute("sexe"));
		
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

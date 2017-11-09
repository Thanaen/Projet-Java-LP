import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Niveau {

	//ATTRIBUTS
	
	private int numero;					//le numéro du niveau
	private Vector<Verrou> verrous;		//la liste des vérrous du niveau
	private Vector<Bouton> boutons;		//la liste des boutons du niveau
	final String NOMFICHIER = "listeNiveau.xml";
	
	
	//METHODES 
	
	public Niveau(int numero){

		this.numero = numero;
		verrous = new Vector<Verrou>();
		boutons = new Vector<Bouton>();
		lireFichier(numero);

	}
	
	public void lireFichier(int numero){
		
        // Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
       	
		File listeNiveaux = new File(NOMFICHIER);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            	
        try {
            
            //Etape 2 : création d'un parseur
            
        	DocumentBuilder builder = factory.newDocumentBuilder();
			
		    // Etape 3 : création d'un Document
		    
		    Document document= (Document) builder.parse(listeNiveaux);
		    
		    // Etape 4 : récupération de l'Element racine
		    
		    Element racine = (document).getDocumentElement();

		    // Etape 5 : récupération du niveau
		    	
		    	// dans le fichier racine = levels
		    
		    NodeList level = racine.getChildNodes();
		    int nblevel = level.getLength();
			
		    Element niveauActuel = null; //peut etre une nodelite
		    
		    for (int i = 0; i<nblevel; i++) {
		        if(level.item(i).getNodeType() == Node.ELEMENT_NODE) {
		            niveauActuel = (Element) level.item(i);
					if (Integer.parseInt(niveauActuel.getAttribute("id")) == numero){
						break;
					}else{
						niveauActuel = null;
					}
		        }
		    }
		    
		    //Etape 6 : récupération des verrous et boutons
		    
		    if(niveauActuel != null){
		    	
		    	NodeList verrous =  niveauActuel.getElementsByTagName("verrou");

		     	int nbverrou = verrous.getLength();
		    	for(int i = 0;i<nbverrou;i++){
		    		if(verrous.item(i).getNodeType() == Node.ELEMENT_NODE){
		    			Element verrou = (Element) verrous.item(i);
		    			Verrou unVerrou = new Verrou(Boolean.parseBoolean(verrou.getTextContent()));
		    			this.verrous.add(unVerrou);
		    		}
		    	}
		    	for (int ii = 0; ii<nbverrou; ii++){
			    	NodeList boutonActuel =  niveauActuel.getElementsByTagName("verrou"+(ii+1));
			    	Vector<Verrou> verrouDuBouton = new Vector<Verrou>();
			    	int nbboutons = boutonActuel.getLength();
			    	for(int i = 0;i<nbboutons;i++){
			    		if(boutonActuel.item(i).getNodeType() == Node.ELEMENT_NODE){
			    			Element verrou = (Element) boutonActuel.item(i);
			    			verrouDuBouton.add(this.verrous.elementAt(Integer.parseInt(verrou.getTextContent())));
			    		}
			    	}
			    	Bouton unBouton = new Bouton(verrouDuBouton);
					this.boutons.add(unBouton);
		    	}
		    }
		    
        }
		catch (FileNotFoundException e) {
			System.err.println("Pas de fichier disponible");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("lecture impossible");
			e.printStackTrace();
		} 
        catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
        catch (SAXException e) {
			e.printStackTrace();
		}
	}

	/* TEST DU CONSTRUCTEUR
	public static void main(String[] args) {
		
		Niveau cestletest = new Niveau(1);
		Vector<Verrou> lesVerrous = cestletest.verrous;
		Vector<Bouton> lesBoutons = cestletest.boutons;
		Verrou v1 = lesVerrous.elementAt(0);
		Bouton b1 = lesBoutons.elementAt(0);
		System.out.println(lesVerrous);
		System.out.println(v1);
		System.out.println(lesBoutons);
		System.out.println(b1);
		
		System.out.println();
		
		Niveau test = new Niveau(0);
		Vector<Verrou> lesVerrous2 = test.verrous;
		Vector<Bouton> lesBoutons2 = test.boutons;
		
		System.out.println(lesVerrous2);
		System.out.println(lesBoutons2);
	}*/
}
